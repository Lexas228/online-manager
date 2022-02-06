package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.BaseProductInfo;
import ru.vsu.online.manager.entity.ProductType;

import java.util.List;

@Service
public interface BaseProductInfoService {
    void putSomeProducts(Long baseProductInfoId, Long count);
    void takeSomeProducts(Long baseProductInfoId, Long count);
    List<BaseProductInfo> findAllByBaseId(Long baseId);
    List<BaseProductInfo> findAllProductsByType(ProductType productType);
    List<BaseProductInfo> findAllProductsByTypeAndBaseId(ProductType productType, Long baseId);
    BaseProductInfo getById(Long baseProductInfoId);
    void save(BaseProductInfo baseProductInfo);
}
