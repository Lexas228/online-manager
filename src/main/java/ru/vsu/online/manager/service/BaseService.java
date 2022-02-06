package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.Base;
import ru.vsu.online.manager.entity.BaseProductInfo;
import ru.vsu.online.manager.entity.Product;
import ru.vsu.online.manager.entity.ProductType;

import java.util.List;

@Service
public interface BaseService {
    List<Base> getAllBases();
    List<Base> findAllBasesWithProduct(Long productId);
    List<Base> findAllBasesWithProduct(String productName);
    List<Base> findAllBasesWithProduct(ProductType productType);
    List<Base> findAllBasesWithProductAndCount(Long productId, Long count);
    List<Base> findAllBasesWithProductAndCount(String productName, Long count);
    List<Base> findAllBasesWithProductAndCount(ProductType productType, Long count);
    void save(Base base);
}
