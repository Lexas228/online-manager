package ru.vsu.online.manager.service;

import org.springframework.stereotype.Service;
import ru.vsu.online.manager.entity.ProductType;
import ru.vsu.online.manager.entity.PurchaseHistory;
import ru.vsu.online.manager.entity.User;

import java.time.LocalDate;
import java.util.List;

@Service
public interface PurchaseHistoryService {
    List<PurchaseHistory> getAll();
    List<PurchaseHistory> getAllInShop(Long shopId);
    List<PurchaseHistory> getAllInDepartment(Long departmentId);
    List<PurchaseHistory> getAllPurchasesByDate(LocalDate localDate);
    List<PurchaseHistory> getAllPurchasesByUserId(Long id);
    List<PurchaseHistory> getAllPurchasesByUserLogin(String login);
    List<PurchaseHistory> getAllWhichBuy(Long productId);
    List<PurchaseHistory> getAllWhichBuy(ProductType productType);
    List<PurchaseHistory> getAllWhichBuy(String productName);
    List<PurchaseHistory> getAllWhichBuyInShopWithProductType(Long shopId, ProductType productType);
}
