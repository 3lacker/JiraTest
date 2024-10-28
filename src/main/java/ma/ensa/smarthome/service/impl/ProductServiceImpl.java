package ma.ensa.smarthome.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import ma.ensa.smarthome.model.Product;
import ma.ensa.smarthome.repository.ProductRepository;
import ma.ensa.smarthome.service.ProductService;
import ma.ensa.smarthome.dto.ProductDTO;
import ma.ensa.smarthome.mapper.ProductMapper;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        log.info("Fetching all products");
        return  productMapper.toDto(productRepository.findAll());
    }
    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        log.info("Fetching product with id: {}", id);
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Product not found"));

        return Optional.of(productMapper.toDto(product));
    }
    @Override

    public Product addProduct(ProductDTO product) {
        log.info("Adding new product: {}", product.getId());
        return productRepository.save(productMapper.toEntity(product));
    }
    @Override
    public Product updateProduct(Long id, ProductDTO productDto) {
        log.info("Updating productDto with id: {}", id);
        Product product = productRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Product not found"));
/*
    set attribute
*/
        product.setId(productDto.getId());
        return productRepository.save(product);
    }
    @Override
    public void deleteProduct(Long id) {
        log.info("Deleting product with id: {}", id);
        productRepository.deleteById(id);
    }


}

