package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.*;
import ru.vsu.online.manager.pojo.Purchase;
import ru.vsu.online.manager.repo.DepartmentRepository;
import ru.vsu.online.manager.repo.DepartmentTypeRepository;
import ru.vsu.online.manager.repo.ProductRepository;
import ru.vsu.online.manager.repo.ShopRepository;
import ru.vsu.online.manager.service.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final DepartmentRepository departmentRepository;
    private final PurchaseHistoryService purchaseHistoryService;
    private final DepartmentService departmentService;
    private final DepartmentProductInfoService departmentProductInfoService;
    private final UserService userService;
    private final ProductService productService;
    private final DepartmentTypeRepository departmentTypeRepository;

    @Override
    public void doPurchase(Purchase purchase) {
        Department department = departmentService.findDepartment(purchase.getDepartmentId());
        User user =  userService.findById(purchase.getUserId());
        PurchaseHistory purchaseHistory = new PurchaseHistory();
        purchaseHistory.setDepartment(department);
        purchaseHistory.setUser(user);
        purchaseHistory.setPurchasePartHistoryList(new ArrayList<>());
        double totalCost = 0;
        for(var l : purchase.getProductsId().entrySet()){
            Long key = l.getKey();
            Long value = l.getValue();
            DepProductInfo depProductInfo = departmentProductInfoService.getByDepartmentIdAndProductId(department.getId(), key);
            if(depProductInfo != null) {
                long actualValue = depProductInfo.getActualCount();
                if(actualValue >= value){
                    PurchasePartHistory purchasePartHistory = new PurchasePartHistory();
                    purchasePartHistory.setPurchaseHistory(purchaseHistory);
                    purchasePartHistory.setProduct(depProductInfo.getProduct());
                    purchasePartHistory.setCount(value);
                    purchaseHistory.getPurchasePartHistoryList().add(purchasePartHistory);
                    totalCost += depProductInfo.getChosenBaseProductInfo().getPrice() * depProductInfo.getPercent();
                }
            }
        }
        purchaseHistory.setTotalCost(totalCost);
        purchaseHistoryService.save(purchaseHistory);
    }

    @Override
    public void closeDepartment(Long departmentId) {
        Department department = departmentService.findDepartment(departmentId);
        if(department != null){
            department.setActive(false);
            departmentService.save(department);
        }
    }

    @Override
    public void closeDepartment(Long shopId, String departmentTypeName) {
        Department department = departmentService.findDepartment(shopId, departmentTypeName);
        if(department != null){
            department.setActive(false);
            departmentService.save(department);
        }
    }

    @Override
    @Transactional
    public void transferProduct(Long departmentIdFrom, Long departmentIdTo, Long departmentProductInfoId) {
        Department from = departmentService.findDepartment(departmentIdFrom);
        Department to = departmentService.findDepartment(departmentIdTo);
        DepProductInfo depProductInfo = departmentProductInfoService.getProduct(departmentProductInfoId);
        if(from != null && to != null && depProductInfo != null){
            from.getDepProductInfos().remove(depProductInfo);
            to.getDepProductInfos().add(depProductInfo);
            depProductInfo.setDepartment(to);
        }
    }


    @Override
    @Transactional
    public void openNewDepartment(Long shopId, String departmentTypeName) {
        Department department = departmentService.findDepartment(shopId, departmentTypeName);
        Optional<DepartmentType> departmentTypeOptional = departmentTypeRepository.findByName(departmentTypeName);

        if(departmentTypeOptional.isPresent()){
            DepartmentType departmentType = departmentTypeOptional.get();
            if(department != null){
                department.setActive(false);
            }

            Shop shop = getShopById(shopId);
            if(shop != null){
                Department newOne = new Department();
                newOne.setActive(true);
                newOne.setShop(shop);
                newOne.setDepartmentType(departmentType);
                newOne.setDepProductInfos(new ArrayList<>());
                departmentRepository.save(newOne);
                if(department != null){
                    department.getDepProductInfos().forEach(depProductInfo -> {
                        transferProduct(department.getId(), newOne.getId(), depProductInfo.getId());
                    });
                }else{
                    departmentType.getProductTypeList().forEach(productType -> {
                        productService.getAllProductsByProductType(productType).forEach(product -> {
                            DepProductInfo depProductInfo = new DepProductInfo();
                            depProductInfo.setProduct(product);

                        });
                    });
                }
            }
        }
        if(department != null)
            departmentService.save(department);
    }

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Shop getShopById(Long id) {
        return shopRepository.getById(id);
    }

    @Override
    public Shop getShopByDepartmentId(Long departmentId) {
        return shopRepository.getByDepartmentId(departmentId);
    }

    @Override
    public void save(Shop shop) {
        shopRepository.save(shop);
    }
}
