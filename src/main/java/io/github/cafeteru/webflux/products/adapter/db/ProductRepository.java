package io.github.cafeteru.webflux.products.adapter.db;


import io.github.cafeteru.webflux.products.adapter.db.model.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
}
