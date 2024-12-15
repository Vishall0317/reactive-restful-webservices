package com.rrws.controller;

import reactor.core.CorePublisher;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.function.Function;

public class FluxControllerDemo {

    public static void test() {
        System.out.println("started FluxControllerDemo");
        System.out.println("---------------------------");


//        getFruitFlux().subscribe(System.out::println);
//        getEmptyFlux().subscribe(System.out::println);
//        mapFruitFluxToUpperCase().subscribe(System.out::println);
//        filterFruitFluxOnLength().subscribe(System.out::println);
//        flatMapFruitFlux().subscribe(System.out::println);
//        flatMapFruitFluxWithDelay().subscribe(System.out::println);
//        transformFlux().subscribe(System.out::println);
//        defaultFruitFlux().subscribe(System.out::println);
//        switchFlux().subscribe(System.out::println);
//        concatFlux().subscribe(System.out::println);
//        concatWithFlux().subscribe(System.out::println);
//        mergeFlux().subscribe(System.out::println);
//        mergeSequentialFlux().subscribe(System.out::println);
//        zipFlux().subscribe(data-> System.out.println(data.getT1()+" "+ data.getT2()));
//        zipFluxWithoutTuple().subscribe(System.out::println);
//        sideEffectFlux().subscribe(System.out::println);;

        System.out.println("---------------------------");
        System.out.println("end FluxControllerDemo");
    }

    public static Flux<String> getFruitFlux() {
        return Flux.just("mango", "orange", "lemon", "watermelon");
    }

    public static Flux<String> getEmptyFlux() {
        return Flux.empty();
    }

    public static Flux<String> mapFruitFluxToUpperCase() {
        return getFruitFlux().map(data -> data.toUpperCase());
    }

    public static Flux<String> filterFruitFluxOnLength() {
        return getFruitFlux().filter(data -> data.length() > 5);
    }

    public static Flux<String> flatMapFruitFlux() {
        return getFruitFlux().flatMap(data -> Flux.just("fruit: " + data));
    }

    public static Flux<String> flatMapFruitFluxWithDelay() {
        return getFruitFlux().flatMap(data -> Flux.just("fruit: " + data))
                .delayElements(Duration.ofSeconds(2));
    }

    public static Flux<String> transformFlux() {
        Function<Flux<String>, Flux<String>> function = (data) -> data.map(String::toUpperCase);
        return getFruitFlux().transform(function);
    }

    public static Flux<String> defaultFruitFlux() {
        return getFruitFlux().filter(data -> data.length() > 100)
                .defaultIfEmpty("Required fruit not available");
    }

    public static Flux<String> switchFlux() {
        Flux<String> nameFlux = Flux.just("raju");
        return nameFlux.filter(data -> data.length() > 5)
                .switchIfEmpty(Flux.just("shyamlal"));
    }

    //synchronous
    public static Flux<String> concatFlux(){
        return Flux.concat(getFruitFlux().delayElements(Duration.ofSeconds(2)),
                Flux.just("banana").delayElements(Duration.ofSeconds(2)));
    }

    public static Flux<String> concatWithFlux(){
        return getFruitFlux().concatWith(Flux.just("banana"));
    }

    //asynchronous
    public static Flux<String> mergeFlux(){
        return Flux.merge(getFruitFlux().delayElements(Duration.ofSeconds(2)),
                Flux.just("banana").delayElements(Duration.ofSeconds(2)));
    }

    //synchronous
    public static Flux<String> mergeSequentialFlux(){
        return Flux.mergeSequential(getFruitFlux().delayElements(Duration.ofSeconds(2)),
                Flux.just("banana").delayElements(Duration.ofSeconds(2)));
    }

    public static Flux<Tuple2<String, Integer>> zipFlux(){
        return Flux.zip(getFruitFlux(), Flux.just(1, 2, 3));
    }

    public static Flux<String> zipFluxWithoutTuple(){
        return Flux.zip(getFruitFlux(), Flux.just(1, 2, 3), (a, b)-> a+" "+b);
    }

    public static Flux<String> sideEffectFlux(){
        return getFruitFlux().doOnNext(data -> System.out.println(data +" on next"))
                .doOnSubscribe(data -> System.out.println(data +" on subscribe"))
                .doOnEach(data -> System.out.println(data +" on each"))
                .doOnComplete(() -> System.out.println("completed"))
                .doOnError(error -> System.err.println("error: "+error.getMessage()));
    }


}

