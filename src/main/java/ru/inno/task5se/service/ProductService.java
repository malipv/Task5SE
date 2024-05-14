package ru.inno.task5se.service;

import ru.inno.task5se.dto.ProductRequest;
import ru.inno.task5se.dto.ProductResponse;

public interface ProductService {
    public ProductResponse addProduct(ProductRequest productRequest);
}
