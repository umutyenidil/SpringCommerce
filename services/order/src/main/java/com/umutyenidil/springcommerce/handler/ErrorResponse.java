package com.umutyenidil.springcommerce.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
