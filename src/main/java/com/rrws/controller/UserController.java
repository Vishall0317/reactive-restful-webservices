package com.rrws.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class UserController {

    private final WebClient webClient;

    public UserController(WebClient webClient) {
        this.webClient = webClient;
    }

    @PostMapping("/user/{id}")
    public String createUser(@PathVariable int id) {
        System.out.println("in the createUser");
        Mono<String> mono = webClient.get()
                .uri("/api/user/{id}", id)
                .retrieve()
                .bodyToMono(String.class);
        mono.subscribe(result-> System.out.println("user id get from webClient: "+ result));
        return "created user of id: "+ id;
    }

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        System.out.println("in the getUserById");
        System.out.println("user id: "+ id);
        return String.valueOf(id);
    }
}
