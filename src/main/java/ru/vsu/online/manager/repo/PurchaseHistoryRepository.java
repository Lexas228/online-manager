package ru.vsu.online.manager.repo;

import liquibase.pro.packaged.Q;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.entity.ProductType;
import ru.vsu.online.manager.entity.PurchaseHistory;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PurchaseHistoryRepository extends JpaRepository<PurchaseHistory, Long> {

    @Query("select p from PurchaseHistory p where p.department.shop.id = :shopId")
    List<PurchaseHistory> getAllInShop(@Param(value = "shopId") Long shopId);

    @Query("select p from PurchaseHistory p where p.department.id = :departmentId")
    List<PurchaseHistory> getAllInDepartment(@Param(value = "departmentId") Long departmentId);

    List<PurchaseHistory> getAllByDate(LocalDate date);

    @Query("select p from PurchaseHistory p where p.user.id = :userId")
    List<PurchaseHistory> getAllByUserId(@Param(value = "userId") Long userId);

    @Query("select p from PurchaseHistory p where p.user.login = :userLogin")
    List<PurchaseHistory> getAllByUserLogin(@Param(value = "userLogin") String userLogin);

    @Query("select p from PurchaseHistory p where p.product.id = :productId")
    List<PurchaseHistory> getAllByProductId(@Param(value = "productId") Long productId);

    @Query("select p from PurchaseHistory p where p.product.name = :productName")
    List<PurchaseHistory> getAllByProductName(@Param(value = "productName") String productName);

    @Query("select p from PurchaseHistory p where p.product.productType = :productType")
    List<PurchaseHistory> getAllByProductType(@Param(value = "productType") ProductType productType);

    @Query("select p from PurchaseHistory p where p.product.productType = :productType and p.department.shop.id = :shopId")
    List<PurchaseHistory> getAllByProductTypeAndShopId(@Param(value = "shopId") Long shopId, @Param(value = "productType") ProductType productType);
}
