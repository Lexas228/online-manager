package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.DepProductInfo;
import ru.vsu.online.manager.service.DepartmentProductInfoService;
import ru.vsu.online.manager.service.DepartmentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentProductInfoService departmentProductInfoService;

    @Override
    @Transactional
    public void buyAllAutoBuyingProducts(Long departmentId) {
        List<DepProductInfo> productWhichNeedToBuyingFromBaseInDepartmentAndAutoBuying = departmentProductInfoService.getProductWhichNeedToBuyingFromBaseInDepartmentAndAutoBuying(departmentId, true);
        productWhichNeedToBuyingFromBaseInDepartmentAndAutoBuying.stream().map(DepProductInfo::getId).forEach(departmentProductInfoService::makeAutoBuyingFromBase);
    }
}
