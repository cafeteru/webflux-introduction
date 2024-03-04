package io.github.cafeteru.webflux.config.exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;

import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAttributes extends DefaultErrorAttributes {

    public Map<String, Object> getErrorAttributes(ServerRequest request, ErrorAttributeOptions options) {
        var throwable = super.getError(request);
        if (throwable instanceof CustomException customException) {
            var errorAttributes = new HashMap<String, Object>();
            errorAttributes.put("status", customException.getHttpStatus().value());
            errorAttributes.put("message", customException.getMessage());
            return errorAttributes;
        }
        return super.getErrorAttributes(request, options);
    }
}
