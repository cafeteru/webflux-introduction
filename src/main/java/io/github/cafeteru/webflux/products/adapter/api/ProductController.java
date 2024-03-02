package io.github.cafeteru.webflux.products.adapter.api;

import io.github.cafeteru.webflux.products.adapter.db.model.Product;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/products")

public interface ProductController {
    @GetMapping
    Flux<Product> getAll();

    @GetMapping("/{id}")
    Mono<Product> getById(@PathVariable final Long id);

    @PostMapping
    public Mono<Product> save(@RequestBody final Product product);

    @PutMapping("/{id}")
    Mono<Product> update(@PathVariable final Long id, @RequestBody final Product product);

    @DeleteMapping("/{id}")
    Mono<Void> delete(@PathVariable final Long id);
}
