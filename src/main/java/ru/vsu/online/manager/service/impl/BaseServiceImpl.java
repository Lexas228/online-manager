package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.Base;
import ru.vsu.online.manager.repo.BaseRepository;
import ru.vsu.online.manager.service.BaseService;

import java.util.List;

@Service
@AllArgsConstructor
public class BaseServiceImpl implements BaseService {
    private final BaseRepository baseRepository;

    @Override
    public List<Base> getAllBases() {
        return baseRepository.findAll();
    }

    @Override
    public List<Base> findAllBasesWithProduct(Long productId) {
        return baseRepository.findAllBasesWithProduct(productId);
    }

    @Override
    public List<Base> findAllBasesWithProduct(String productName) {
        return baseRepository.findAllBasesWithProduct(productName);
    }

    @Override
    public List<Base> findAllBasesWithProductTypeName(String productTypeName) {
        return baseRepository.findAllBasesWithProductTypeName(productTypeName);
    }

    @Override
    public List<Base> findAllBasesWithProductAndCount(Long productId, Long count) {
        return baseRepository.findAllBasesWithProductAndCount(productId, count);
    }

    @Override
    public List<Base> findAllBasesWithProductAndCount(String productName, Long count) {
        return baseRepository.findAllBasesWithProductAndCount(productName, count);
    }

    @Override
    public List<Base> findAllBasesWithProductTypeNameAndCount(String productTypeName, Long count) {
        return baseRepository.findAllBasesWithProductTypeNameAndCount(productTypeName, count);
    }

    @Override
    public void save(Base base) {
        baseRepository.save(base);
    }
}
