package com.rrws.controller;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuple3;

import java.util.Arrays;

public class MonoControllerDemo {

    public static void test(){

//        Mono<String> m1= Mono.just("tech with vishal raj")
//                .log();
//
//        m1.subscribe(System.out::println);
//
//        Mono<String> m2= Mono.just("tech with vishal raj")
//                .log()
//                .then(Mono.error(new RuntimeException("error")));
//
//        m2.subscribe(System.out::println);

//        Mono<String> m1= Mono.just("tech with vishalraj !! ");
//        Mono<String> m2= Mono.just("subscribe youtube channel !!");
//        Mono<Integer> m3= Mono.just(1000);
//
//        Mono<Tuple3<String, String, Integer>> zipMono = Mono.zip(m1, m2, m3);
//        zipMono.subscribe(data-> {
//                    System.out.println(data.getT1());
//                    System.out.println(data.getT2());
//                    System.out.println(data.getT3());
//                }
//        );

//        Mono<String> m1= Mono.just("tech with vishalraj !! ");
//        Mono<Integer> m3= Mono.just(1000);
//
//        Mono<Tuple2<String, Integer>> zipMono = m1.zipWith(m3);
//        zipMono.subscribe(data-> {
//                    System.out.println(data.getT1());
//                    System.out.println(data.getT2());
//                }
//        );

        Mono<String> m1= Mono.just("tech with vishalraj !! ");

//        Mono<String> map = m1.map(data -> data.toUpperCase());
//        map.subscribe(System.out::println);
//
//        Mono<String[]> flatMapResponse = m1.flatMap(data-> Mono.just(data.split(" ")));
//        flatMapResponse.subscribe(data -> Arrays.stream(data).forEach(System.out::println));
//
//        Flux<String> stringFlux = m1.flatMapMany(data-> Flux.just(data.split(" ")));
//        stringFlux.subscribe(System.out::println);

        Flux<String> concatFluxResponse = m1.concatWith(Mono.just("subscribe youtube channel!!"))
                .log();
        concatFluxResponse.subscribe(System.out::println);
    }
}
