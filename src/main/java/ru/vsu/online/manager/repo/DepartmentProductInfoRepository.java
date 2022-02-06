package ru.vsu.online.manager.repo;

import org.springframework.context.annotation.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.entity.DepProductInfo;

import java.util.List;

/*
Слой обращения к таблице информации о продуктах в отделе
 */

@Repository
public interface DepartmentProductInfoRepository extends JpaRepository<DepProductInfo, Long> {

    @Description("Найти всю информацию о продуктах в конкретном отделе")
    @Query("select d from DepProductInfo d where d.department.id = :departmentId")
    List<DepProductInfo> getAllByDepartmentId(@Param(value = "departmentId") Long departmentId);

    @Description("Найти всю информацию о продуктах которые нужно закупить в конкретном отделе")
    @Query("select d from DepProductInfo d where d.actualCount < d.requiredCount and d.department.id = :departmentId")
    List<DepProductInfo> getAllWhichNeedToBuyInDepartment(@Param(value = "departmentId") Long departmentId);

    @Description("Найти всю информацию о продуктах которые нужно закупить в конкретном магазине")
    @Query("select d from DepProductInfo d where d.actualCount < d.requiredCount and d.department.shop.id = :shopId")
    List<DepProductInfo> getAllWhichNeedToBuyInShop(@Param(value = "departmentId") Long shopId);

    @Description("Найти всю информацию о продуктах которые нужно закупить во всех магазинах")
    @Query("select d from DepProductInfo d where d.actualCount < d.requiredCount")
    List<DepProductInfo> getAllWhichNeedToBuy();

    @Description("Найти всю информацию о продуктах которые могут автозакупиться(или нет)  в отделе")
    @Query("select d from DepProductInfo d where " +
            "d.actualCount < d.requiredCount and d.department.id = :departmentId and d.isAutoBuying = :autoBuying " +
            "and ((d.isAutoBuying and d.chosenBaseProductInfo is not null) or (d.isAutoBuying <> true))")
    List<DepProductInfo> getAllWhichNeedToBuyInDepartmentWithAutoBuying(@Param(value = "departmentId") Long departmentId, @Param(value = "autoBuying") boolean autoBuying);

    @Description("Найти всю информацию о продуктах которые могут автозакупиться(или нет) в магазине")
    @Query("select d from DepProductInfo d where " +
            "d.actualCount < d.requiredCount and d.department.shop.id = :shopId and d.isAutoBuying = :autoBuying " +
            "and ((d.isAutoBuying and d.chosenBaseProductInfo is not null) or (d.isAutoBuying <> true))")
    List<DepProductInfo> getAllWhichNeedToBuyInShopWithAutoBuying(@Param(value = "shopId") Long shopId, @Param(value = "autoBuying") boolean autoBuying);
}
