package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

    @Query("select s from Shop s where exists (select d from s.departments d where d.id=:departmentId)")
    Shop getByDepartmentId(Long departmentId);
}
