package ru.vsu.online.manager.service;

import ru.vsu.online.manager.entity.Product;
import ru.vsu.online.manager.entity.ProductType;

import java.util.List;

public interface ProductService {
    List<Product> getAllProductsByProductType(String productType);
    List<Product> getAllProductsByProductType(ProductType productType);
}
