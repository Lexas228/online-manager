package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
