package az.atl.producms.service.serviceImpl;

import az.atl.producms.dao.entity.ProductEntitye;
import az.atl.producms.dao.repository.ProductRepository;
import az.atl.producms.mapper.ProductMapper;
import az.atl.producms.model.request.SaveProductDto;
import az.atl.producms.model.response.ProductResponseDto;
import az.atl.producms.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public void saveProduct(SaveProductDto dto) {
        var entity = ProductMapper.PRODUCT_MAPPER.buildProductEntity(dto);
        productRepository.save(entity);
    }

    @Override
    public ProductResponseDto getResponseById(Long id) {
        var entity = fetchIfProductExist(id);
        return ProductMapper.PRODUCT_MAPPER.buildProductResponseDto(entity);
    }
    @Override
    public void reduceProductCount(Long id, Integer count) {
        var entity = fetchIfProductExist(id);
        var updatedCount = entity.getCount() - count;
        entity.setCount(updatedCount);
        productRepository.save(entity);
    }

    private ProductEntitye fetchIfProductExist(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("PRODUCT_NOT_FOUND")
        );
    }
}
