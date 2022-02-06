package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.online.manager.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
