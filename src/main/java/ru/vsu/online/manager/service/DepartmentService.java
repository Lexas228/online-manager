package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.DepProductInfo;
import ru.vsu.online.manager.entity.Department;
import ru.vsu.online.manager.entity.DepartmentType;

import java.util.List;

@Service
public interface DepartmentService {
    void buyAllAutoBuyingProducts(Long departmentId);
    Department findDepartment(Long shopId, String departmentTypeName);
    Department findDepartment(Long departmentId);
    void save(Department department);
}
