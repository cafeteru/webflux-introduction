package io.github.cafeteru.webflux.products.adapter.api.impl;

import io.github.cafeteru.webflux.products.adapter.api.ProductController;
import io.github.cafeteru.webflux.products.adapter.db.model.Product;
import io.github.cafeteru.webflux.products.port.ProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductPort productPort;

    public Flux<Product> getAll() {
        return productPort.getAll();
    }

    public Mono<Product> getById(final Long id) {
        return productPort.getById(id);
    }

    public Mono<Product> save(final Product product) {
        return productPort.save(product);
    }

    public Mono<Product> update(final Long id, final Product product) {
        return productPort.update(id, product);
    }

    public Mono<Void> delete(final Long id) {
        return productPort.delete(id);
    }
}
