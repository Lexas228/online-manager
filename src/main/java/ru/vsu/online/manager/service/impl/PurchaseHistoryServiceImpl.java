package ru.vsu.online.manager.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.ProductType;
import ru.vsu.online.manager.entity.PurchaseHistory;
import ru.vsu.online.manager.entity.User;
import ru.vsu.online.manager.repo.PurchaseHistoryRepository;
import ru.vsu.online.manager.service.PurchaseHistoryService;

import java.time.LocalDate;
import java.util.List;

/**
 * Самый инетересный, на мой взгляд, сервис - тут будем доставать историю покупок по имени, и т.д.(фсб привет)
 */
@Service
@AllArgsConstructor
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    private final PurchaseHistoryRepository purchaseHistoryRepository;

    @Override
    public List<PurchaseHistory> getAll() {
        return purchaseHistoryRepository.findAll();
    }

    @Override
    public List<PurchaseHistory> getAllInShop(Long shopId) {
        return purchaseHistoryRepository.getAllInShop(shopId);
    }

    @Override
    public List<PurchaseHistory> getAllInDepartment(Long departmentId) {
        return purchaseHistoryRepository.getAllInDepartment(departmentId);
    }

    @Override
    public List<PurchaseHistory> getAllPurchasesByDate(LocalDate localDate) {
        return purchaseHistoryRepository.getAllByDate(localDate);
    }

    @Override
    public List<PurchaseHistory> getAllPurchasesByUserId(Long id) {
        return purchaseHistoryRepository.getAllByUserId(id);
    }

    @Override
    public List<PurchaseHistory> getAllPurchasesByUserLogin(String login) {
        return purchaseHistoryRepository.getAllByUserLogin(login);
    }

    @Override
    public List<PurchaseHistory> getAllWhichBuy(Long productId) {
        return purchaseHistoryRepository.getAllByProductId(productId);
    }

    @Override
    public List<PurchaseHistory> getAllWhichBuy(ProductType productType) {
        return purchaseHistoryRepository.getAllByProductType(productType);
    }

    @Override
    public List<PurchaseHistory> getAllWhichBuy(String productName) {
        return purchaseHistoryRepository.getAllByProductName(productName);
    }

    @Override
    public List<PurchaseHistory> getAllWhichBuyInShopWithProductType(Long shopId, ProductType productType) {
        return purchaseHistoryRepository.getAllByProductTypeAndShopId(shopId, productType);
    }

    @Override
    public void save(PurchaseHistory purchaseHistory) {
        purchaseHistoryRepository.save(purchaseHistory);
    }
}
