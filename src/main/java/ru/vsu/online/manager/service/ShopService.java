package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.Department;
import ru.vsu.online.manager.entity.DepartmentType;
import ru.vsu.online.manager.entity.Shop;
import ru.vsu.online.manager.pojo.Purchase;

import java.util.List;

@Service
public interface ShopService {
    void doPurchase(Purchase purchase);
    void closeDepartment(Long departmentId);
    void closeDepartment(Long shopId, DepartmentType departmentType);
    void transferProduct(Long departmentIdFrom, Long departmentIdTo, Long departmentProductInfoId);
    void openNewDepartment(Long shopId, DepartmentType departmentType, boolean closeOldDepartment);
    List<Shop> getAllShops();
    Shop getShopById(Long id);
    Shop getShopByDepartmentId(Long departmentId);
    void save(Shop shop);
}
