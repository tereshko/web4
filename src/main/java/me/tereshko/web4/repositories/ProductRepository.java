package me.tereshko.web4.repositories;

import me.tereshko.web4.model.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {
    private List<Product> productList;

    public List<Product> getProductList() {
        return Collections.unmodifiableList(productList);
    }

    public Product addProduct(Product product) {
        productList.add(product);
        return product;
    }

    public Optional<Product> getById(Long id) {
        for (Product product: productList) {
            if (product.getId().equals(id)) {
                return Optional.of(product);
            }
        }
        return null;
    }

    public void removeById(Long id) {
        productList.removeIf(e -> e.getId().equals(id));
    }


/*
    прикольно, падает когда список пустой. Нужно видимо обработку делать


    java.util.ConcurrentModificationException: null
    at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013) ~[na:na]
    at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967) ~[na:na]
    at java.base/java.util.Collections$UnmodifiableCollection$1.next(Collections.java:1049) ~[na:na]
    at me.tereshko.web4.services.ProductService.removeById(ProductService.java:30) ~[classes/:na]
*/

    @PostConstruct
    private void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1L, "Idea", 6.66));
    }
}
