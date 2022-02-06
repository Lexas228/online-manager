package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.dto.ProductInfoDto;
import ru.vsu.online.manager.entity.Base;
import ru.vsu.online.manager.entity.BaseProductInfo;
import ru.vsu.online.manager.entity.Product;
import ru.vsu.online.manager.entity.ProductType;

import java.util.List;

@Repository
public interface BaseRepository extends JpaRepository<Base, Long> {

    @Query("select b from Base b where exists (select s from b.baseProductInfos s where s.product.id=:productId)")
    List<Base> findAllBasesWithProduct(@Param(value = "productId") Long productId);

    @Query("select b from Base b where exists (select s from b.baseProductInfos s where s.product.name=:productName)")
    List<Base> findAllBasesWithProduct(@Param(value = "productName") String productName);

    @Query("select b from Base b where exists (select s from b.baseProductInfos s where s.product.productType=:productType)")
    List<Base> findAllBasesWithProduct(@Param(value = "productType")ProductType productType);

    @Query("select b from Base b where exists " +
            "(select s from b.baseProductInfos s where s.product.productType=:productType and s.count >= :count)")
    List<Base> findAllBasesWithProductAndCount(@Param(value = "productType")ProductType productType, @Param(value = "count") Long count);

    @Query("select b from Base b where exists " +
            "(select s from b.baseProductInfos s where s.product.id=:productId and s.count >= :count)")
    List<Base> findAllBasesWithProductAndCount(@Param(value = "productId") Long productId,@Param(value = "count") Long count);

    @Query("select b from Base b where exists " +
            "(select s from b.baseProductInfos s where s.product.name=:productName and s.count >= :count)")
    List<Base> findAllBasesWithProductAndCount(@Param(value = "productName") String productName,@Param(value = "count") Long count);
}
