package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.BaseProductInfo;
import ru.vsu.online.manager.repo.BaseProductInfoRepository;
import ru.vsu.online.manager.service.BaseProductInfoService;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BaseProductInfoServiceImpl implements BaseProductInfoService {

    private final BaseProductInfoRepository baseProductInfoRepository;

    @Override
    public List<BaseProductInfo> findAllByBaseId(Long baseId) {
        return baseProductInfoRepository.findAllByBaseId(baseId);
    }

    @Override
    @Transactional
    public void putSomeProducts(Long baseProductInfoId, Long count) {
        Optional<BaseProductInfo> byId = baseProductInfoRepository.findById(baseProductInfoId);
        if(byId.isPresent()){
            BaseProductInfo base = byId.get();
            base.setCount(base.getCount() + count);
        }
    }

    @Override
    @Transactional
    public void takeSomeProducts(Long baseProductInfoId, Long count) {
        Optional<BaseProductInfo> byId = baseProductInfoRepository.findById(baseProductInfoId);
        if(byId.isPresent()){
            BaseProductInfo base = byId.get();
            long res = base.getCount() - count;
            if(res >= 0) {
                base.setCount(base.getCount() + count);
            }
        }
    }

    @Override
    public BaseProductInfo getById(Long baseProductInfoId) {
        return baseProductInfoRepository.getById(baseProductInfoId);
    }


    @Override
    public void save(BaseProductInfo baseProductInfo) {
        baseProductInfoRepository.save(baseProductInfo);
    }

    @Override
    public List<BaseProductInfo> findAllProductsByTypeName(String productTypeName) {
        return baseProductInfoRepository.findAllByProductTypeName(productTypeName);
    }

    @Override
    public List<BaseProductInfo> findAllProductsByTypeId(Long productTypeId) {
        return baseProductInfoRepository.findAllByProductTypeId(productTypeId);
    }

    @Override
    public List<BaseProductInfo> findAllProductsByTypeNameAndBaseId(String productTypeName, Long baseId) {
        return null;
    }

    @Override
    public List<BaseProductInfo> findAllProductsByTypeIdAndBaseId(Long productTypeId, Long baseId) {
        return null;
    }
}
