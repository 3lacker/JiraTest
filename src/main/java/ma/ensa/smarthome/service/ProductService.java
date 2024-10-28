package ma.ensa.smarthome.service;
import ma.ensa.smarthome.model.Product;
import ma.ensa.smarthome.dto.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(Long id);

    Product addProduct(ProductDTO Product);

    Product updateProduct(Long id, ProductDTO ProductDto);

    void deleteProduct(Long id);
}
