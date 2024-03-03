package io.github.cafeteru.webflux.products.adapter.db;


import io.github.cafeteru.webflux.products.adapter.db.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository extends ReactiveCrudRepository<Product, Long> {
    Mono<Product> findByName(String name);

    @Query("SELECT * FROM product WHERE id != :id AND name = :name")
    Mono<Product> repeatedName(Long id, String name);
}
