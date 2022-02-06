package ru.vsu.online.manager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.online.manager.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
}
