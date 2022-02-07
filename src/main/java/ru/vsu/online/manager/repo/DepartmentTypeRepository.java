package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.online.manager.entity.DepartmentType;

import java.util.Optional;

public interface DepartmentTypeRepository extends JpaRepository<DepartmentType, Long> {

    Optional<DepartmentType> findByName(String name);
}
