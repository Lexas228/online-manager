package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.Department;
import ru.vsu.online.manager.entity.DepartmentType;
import ru.vsu.online.manager.pojo.Purchase;

@Service
public interface ShopService {
    void doPurchase(Purchase purchase);
    void closeDepartment(Long departmentId);
    void closeDepartment(Long shopId, DepartmentType departmentType);
    Department findDepartment(Long shopId, DepartmentType departmentType);
    Department findDepartment(Long departmentId);
    void transferProduct(Long departmentIdFrom, Long departmentIdTo, Long departmentProductInfoId);
    void openNewDepartment(Long shopId, DepartmentType departmentType, boolean closeOldDepartment);
}
