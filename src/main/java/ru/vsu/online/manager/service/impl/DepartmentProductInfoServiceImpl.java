package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.BaseProductInfo;
import ru.vsu.online.manager.entity.DepProductInfo;
import ru.vsu.online.manager.repo.DepartmentProductInfoRepository;
import ru.vsu.online.manager.service.BaseProductInfoService;
import ru.vsu.online.manager.service.DepartmentProductInfoService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentProductInfoServiceImpl implements DepartmentProductInfoService {

    private final DepartmentProductInfoRepository departmentProductInfoRepository;
    private final BaseProductInfoService baseProductInfoService;


    /**
     * Метод в котором мы переопределяем базу, из который мы заказываем конкретный товар
     * @param departmentProductInfoId id конкретного товара
     * @param baseProductInfoId id базы
     */
    @Override
    @Transactional
    public void setBaseProductInfo(Long departmentProductInfoId, Long baseProductInfoId) {
        Optional<DepProductInfo> depOpt = departmentProductInfoRepository.findById(departmentProductInfoId);
        BaseProductInfo base = baseProductInfoService.getById(baseProductInfoId);
        if(depOpt.isPresent() && base != null){
            DepProductInfo depProductInfo = depOpt.get();
            depProductInfo.setChosenBaseProductInfo(base);
        }
    }

    /**
     * Сетаем рекомендованное кол-во товара в отделе
     * @param departmentProductInfoId id товара
     * @param newCount  новое рекомендованное значение
     */

    @Override
    @Transactional
    public void setRequiredCountOfProduct(Long departmentProductInfoId, Long newCount) {
        Optional<DepProductInfo> depOpt = departmentProductInfoRepository.findById(departmentProductInfoId);
        if(depOpt.isPresent() && newCount >= 0){
            DepProductInfo depProductInfo = depOpt.get();
            depProductInfo.setRequiredCount(newCount);
        }
    }


    /**
     * осуществляем закупку продукта с базы
     * @param departmentProductInfoId  id товара, которого нужно заказать
     * @param count количество товара
     */

    @Override
    @Transactional
    public void makeBuyingFromBase(Long departmentProductInfoId, Long count) {
        Optional<DepProductInfo> depOpt = departmentProductInfoRepository.findById(departmentProductInfoId);
        if(depOpt.isPresent()){
            DepProductInfo depProductInfo = depOpt.get();
            if(depProductInfo.getChosenBaseProductInfo() != null){
                BaseProductInfo baseProductInfo = depProductInfo.getChosenBaseProductInfo();
                if(baseProductInfo.getCount() >= count) {
                    baseProductInfoService.takeSomeProducts(depProductInfo.getChosenBaseProductInfo().getId(), count);
                    depProductInfo.setActualCount(depProductInfo.getActualCount() + count);
                }
            }
        }
    }

    /**
     * осуществляем автозакупку с базы конкретного товара (без указания количество - высчитается автоматом)
     * @param departmentProductInfoId id товара
     */

    @Override
    @Transactional
    public void makeAutoBuyingFromBase(Long departmentProductInfoId) {
        Optional<DepProductInfo> depOpt = departmentProductInfoRepository.findById(departmentProductInfoId);
        if(depOpt.isPresent()){
            DepProductInfo depProductInfo = depOpt.get();
            if(depProductInfo.getChosenBaseProductInfo() != null){
                BaseProductInfo baseProductInfo = depProductInfo.getChosenBaseProductInfo();
                Long needCount = depProductInfo.getRequiredCount() - depProductInfo.getActualCount();
                if(needCount >= 0 && baseProductInfo.getCount() <= needCount){
                    baseProductInfoService.takeSomeProducts(depProductInfo.getChosenBaseProductInfo().getId(), needCount);
                    depProductInfo.setActualCount(depProductInfo.getRequiredCount());
                }
            }
        }
    }

    /**
     * сетаем автозакупку
     * @param departmentProductInfoId id товара
     * @param isAutoBuying boolean значение закупаем автоматом - или нет
     */

    @Override
    @Transactional
    public void setAutoBuying(Long departmentProductInfoId, boolean isAutoBuying) {
        Optional<DepProductInfo> depOpt = departmentProductInfoRepository.findById(departmentProductInfoId);
        if(depOpt.isPresent()){
            DepProductInfo depProductInfo = depOpt.get();
            depProductInfo.setAutoBuying(isAutoBuying);
        }
    }

    /**
     * Сетаем новое значение увеличения цены по сравнению с ценой из базы
     * @param departmentProductInfoId id товара
     * @param newPercentage новое значение
     */

    @Override
    @Transactional
    public void setNewPercentage(Long departmentProductInfoId, double newPercentage) {
        Optional<DepProductInfo> depOpt = departmentProductInfoRepository.findById(departmentProductInfoId);
        if(depOpt.isPresent()){
            DepProductInfo depProductInfo = depOpt.get();
            depProductInfo.setPercent(newPercentage);
        }
    }

    @Override
    public DepProductInfo getProduct(Long departmentProductInfoId) {
        return departmentProductInfoRepository.getById(departmentProductInfoId);
    }

    @Override
    public List<DepProductInfo> getAllProducts(Long departmentId) {
        return departmentProductInfoRepository.getAllByDepartmentId(departmentId);
    }

    @Override
    public List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInDepartment(Long departmentId) {
        return departmentProductInfoRepository.getAllWhichNeedToBuyInDepartment(departmentId);
    }

    @Override
    public List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInShop(Long shopId) {
        return departmentProductInfoRepository.getAllWhichNeedToBuyInShop(shopId);
    }

    @Override
    public List<DepProductInfo> getProductWhichNeedToBuyingFromBase() {
        return departmentProductInfoRepository.getAllWhichNeedToBuy();
    }

    @Override
    public List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInDepartmentAndAutoBuying(Long departmentId, boolean autoBuying) {
        return departmentProductInfoRepository.getAllWhichNeedToBuyInDepartmentWithAutoBuying(departmentId, autoBuying);
    }

    @Override
    public List<DepProductInfo> getProductWhichNeedToBuyingFromBaseInShopAndAutoBuying(Long shopId, boolean autoBuying) {
        return departmentProductInfoRepository.getAllWhichNeedToBuyInShopWithAutoBuying(shopId, autoBuying);
    }
}
