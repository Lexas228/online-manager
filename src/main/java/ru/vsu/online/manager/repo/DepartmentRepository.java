package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.entity.Department;
import ru.vsu.online.manager.entity.DepartmentType;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    @Query("select d from Department d where d.shop.id = :shopId and d.departmentType=:departmentType")
    Optional<Department> findByShopIdAndDepartmentType(@Param("shopId") Long shopId, @Param("departmentType") DepartmentType departmentType);
}
