package io.github.cafeteru.webflux.products.adapter.api.router;

import io.github.cafeteru.webflux.products.adapter.api.handler.ProductHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
@Slf4j
public class ProductRouter {

    @Bean
    public WebProperties.Resources resources() {
        return new WebProperties.Resources();
    }

    @Bean
    public RouterFunction<ServerResponse> router(ProductHandler productHandler) {
        var path = "product";
        return RouterFunctions.route()
                .GET(path, productHandler::getAll)
                .GET(path + "/{id}", productHandler::getById)
                .POST(path, productHandler::save)
                .PUT(path + "/{id}", productHandler::update)
                .DELETE(path + "/{id}", productHandler::delete)
                .build();
    }
}
