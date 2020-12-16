package me.tereshko.web4.services;

import lombok.RequiredArgsConstructor;
import me.tereshko.web4.model.Product;
import me.tereshko.web4.repositories.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAll() {
        return productRepository.getProductList();
    }

    public Product add(Product product) {
        return productRepository.addProduct(product);
    }

    public Optional<Product> getById(Long id) {
        return productRepository.getById(id);
    }

    //немного стремный код:)
    public void removeById(Long id) {
        for (Product product: productRepository.getProductList()) {
            if (product.getId().equals(id)) {
                productRepository.removeById(id);
            }
        }
    }
}
