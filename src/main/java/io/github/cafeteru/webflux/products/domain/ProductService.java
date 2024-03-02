package io.github.cafeteru.webflux.products.domain;

import io.github.cafeteru.webflux.products.adapter.db.ProductRepository;
import io.github.cafeteru.webflux.products.adapter.db.model.Product;
import io.github.cafeteru.webflux.products.port.ProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService implements ProductPort {
    private final ProductRepository productRepository;

    public Flux<Product> getAll() {
        return productRepository.findAll();
    }

    public Mono<Product> getById(final Long id) {
        return productRepository.findById(id);
    }

    public Mono<Product> save(final Product product) {
        return productRepository.save(product);
    }

    public Mono<Void> delete(final Long id) {
        return productRepository.deleteById(id);
    }

    public Mono<Product> update(final Long id, final Product product) {
        return productRepository.findById(id)
                .map(p -> Product.builder()
                        .id(p.getId())
                        .name(p.getName())
                        .price(p.getPrice())
                        .build())
                .flatMap(productRepository::save);
    }
}
