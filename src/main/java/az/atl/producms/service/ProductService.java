package az.atl.producms.service;

import az.atl.producms.model.request.SaveProductDto;
import az.atl.producms.model.response.ProductResponseDto;

public interface ProductService {
    void saveProduct(SaveProductDto dto);

    ProductResponseDto getResponseById(Long id);

    void reduceProductCount(Long id, Integer count);
}
