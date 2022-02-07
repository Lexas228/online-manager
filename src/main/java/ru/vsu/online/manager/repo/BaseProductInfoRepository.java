package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.entity.BaseProductInfo;
import ru.vsu.online.manager.entity.ProductType;

import java.util.List;

@Repository
public interface BaseProductInfoRepository extends JpaRepository<BaseProductInfo, Long> {

    @Query("select p from BaseProductInfo p where p.base.id = :baseId")
    List<BaseProductInfo> findAllByBaseId(@Param(value = "baseId") Long baseId);

    @Query("select p from BaseProductInfo p where p.product.productType.name = :productType")
    List<BaseProductInfo> findAllByProductTypeName(@Param(value = "productType") String productTypeName);

    @Query("select p from BaseProductInfo p where p.product.productType.id = :productType")
    List<BaseProductInfo> findAllByProductTypeId(@Param(value = "productType") Long productTypeId);

    @Query("select p from BaseProductInfo p where p.product.productType = :productType and p.base.id = :baseId")
    List<BaseProductInfo> findAllByProductTypeAndBaseId(@Param(value = "productType") ProductType productType, @Param(value = "baseId") Long baseId);
}
