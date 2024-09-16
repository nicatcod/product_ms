package az.atl.producms.mapper;

import az.atl.producms.dao.entity.ProductEntitye;
import az.atl.producms.model.request.SaveProductDto;
import az.atl.producms.model.response.ProductResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductEntitye buildProductEntity(SaveProductDto dto);

    ProductResponseDto buildProductResponseDto(ProductEntitye entitye);
}
