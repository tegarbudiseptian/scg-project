package com.antena.router;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class FallbackController {

    @GetMapping("/sampahs-fallback")
    Flux<String> getFallback() {
        return Flux.just("Kayaknya lagi ada yang nggak beres nih."); // or return cache
    }
}
