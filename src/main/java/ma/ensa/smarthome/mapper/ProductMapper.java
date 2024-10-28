package ma.ensa.smarthome.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import ma.ensa.smarthome.dto.ProductDTO;
import ma.ensa.smarthome.model.Product;

@Component
public class ProductMapper {
    public ProductDTO toDto(Product entity) {
        return ProductDTO.builder()
                .id(entity.getId())
/*              continue */
                .build();
    }

    public Product toEntity(ProductDTO dto) {
        return Product.builder()
                .id(dto.getId())
/*              continue */

                .build();
    }
     public List<Product> toEntity(List<ProductDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }
    public List<ProductDTO> toDto(List<Product> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

}
