package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.DepProductInfo;

import java.util.List;

@Service
public interface DepartmentService {
    void buyAllAutoBuyingProducts(Long departmentId);

}
