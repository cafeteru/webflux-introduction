package io.github.cafeteru.webflux.products.port;

import io.github.cafeteru.webflux.products.adapter.db.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductPort {
    Flux<Product> getAll();

    Mono<Product> getById(final Long id);

    Mono<Product> save(final Product product);

    Mono<Void> delete(final Long id);

    Mono<Product> update(final Long id, final Product product);
}
