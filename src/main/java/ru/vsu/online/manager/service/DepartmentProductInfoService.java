package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.DepProductInfo;

import java.util.List;

@Service
public interface DepartmentProductInfoService {
    void setBaseProductInfo(Long departmentProductInfoId, Long baseProductInfoId);
    void setRequiredCountOfProduct(Long departmentProductInfoId, Long newCount);
    void makeBuyingFromBase(Long departmentProductInfoId, Long count);
    void makeAutoBuyingFromBase(Long departmentProductInfoId);
    void setAutoBuying(Long departmentProductInfoId, boolean isAutoBuying);
    void setNewPercentage(Long departmentProductInfoId, double newPercentage);
    DepProductInfo getProduct(Long departmentProductInfoId);
    List<DepProductInfo> getAllProducts(Long departmentId);
    List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInDepartment(Long departmentId);
    List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInShop(Long shopId);
    List<DepProductInfo> getProductWhichNeedToBuyingFromBase();
    List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInDepartmentAndAutoBuying(Long departmentId, boolean AutoBuying);
    List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInShopAndAutoBuying(Long shopId, boolean AutoBuying);
    DepProductInfo getByDepartmentIdAndProductId(Long departmentId, Long productId);
    void transferProduct(Long departmentProductIdFrom, Long departmentProductIdTo, Long count);
    void save(DepProductInfo depProductInfo);
}
