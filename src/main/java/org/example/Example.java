package org.example;

import reactor.core.publisher.Mono;

public class Example {
    public void just() {
        // Create a Mono with "Hello World" value
        Mono<String> helloMono = Mono.just("Hello World");

        // Subscribe and print the value
        helloMono.subscribe(message -> System.out.println(message));
    }
    public void defer(){
        // Supplier function to create a Mono with current time
        Mono<Long> currentTimeMono = Mono.defer(() -> Mono.just(System.currentTimeMillis()));

        // Subscribe and print the current time twice (will be different values)
        currentTimeMono.subscribe(time -> System.out.println("Current time 1: " + time));
        currentTimeMono.subscribe(time -> System.out.println("Current time 2: " + time));
    }
    public void flatMap(){
        // Create a Mono emitting a name
        Mono<String> nameMono = Mono.just("John Doe");

        // Use flatMap to transform name to length
        Mono<Integer> lengthMono = nameMono.flatMap(name -> Mono.just(name.length()));

        // Subscribe and print the length
        lengthMono.subscribe(length -> System.out.println("Name length: " + length));
    }
}
