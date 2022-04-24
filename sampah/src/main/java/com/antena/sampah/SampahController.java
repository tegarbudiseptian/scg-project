package com.antena.sampah;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
class SampahController {
    private static final Logger log = LoggerFactory.getLogger(SampahController.class);

    @GetMapping("sampahs")
    public Flux<Sampah> getSampahs() {
        return Flux.just(
                new Sampah("Kertas"),
                new Sampah("Plastik"),
                new Sampah("Besi"),
                new Sampah("Botol Beling")
        ).doFirst(() -> log.info("Returning all sampah"));
    }
}

@Data
@AllArgsConstructor
class Sampah {
    private String name;
}
