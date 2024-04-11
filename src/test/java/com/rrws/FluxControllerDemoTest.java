package com.rrws;

import com.rrws.controller.FluxControllerDemo;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class FluxControllerDemoTest {

    @Test
    void testTransformFlux(){
        Flux<String> flux = FluxControllerDemo.transformFlux();
        StepVerifier.create(flux)
                .expectNextCount(4)
                .verifyComplete();
    }
}
