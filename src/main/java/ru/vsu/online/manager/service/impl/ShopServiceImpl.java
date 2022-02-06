package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.Department;
import ru.vsu.online.manager.entity.DepartmentType;
import ru.vsu.online.manager.pojo.Purchase;
import ru.vsu.online.manager.repo.DepartmentRepository;
import ru.vsu.online.manager.repo.ShopRepository;
import ru.vsu.online.manager.service.DepartmentService;
import ru.vsu.online.manager.service.PurchaseHistoryService;
import ru.vsu.online.manager.service.ShopService;

@Service
@AllArgsConstructor
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;
    private final DepartmentRepository departmentRepository;
    private final PurchaseHistoryService purchaseHistoryService;
    private final DepartmentService departmentService;

    @Override
    public void doPurchase(Purchase purchase) {

    }

    @Override
    public void closeDepartment(Long departmentId) {

    }

    @Override
    public void closeDepartment(Long shopId, DepartmentType departmentType) {

    }

    @Override
    public Department findDepartment(Long shopId, DepartmentType departmentType) {
        return null;
    }

    @Override
    public Department findDepartment(Long departmentId) {
        return null;
    }

    @Override
    public void transferProduct(Long departmentIdFrom, Long departmentIdTo, Long departmentProductInfoId) {

    }

    @Override
    public void openNewDepartment(Long shopId, DepartmentType departmentType, boolean closeOldDepartment) {

    }
}
