package com.zto.sxy.reactor;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * @author spilledyear
 * @date 2018/11/22 20:48
 */

public class ReactorSnippets {
    private static List<String> words = Arrays.asList(
            "the",
            "quick",
            "brown",
            "fox",
            "jumped",
            "over",
            "the",
            "lazy",
            "dog"
    );


    public static void main(String[] args) {
    }

    @Test
    public void simpleCreation() {
        Flux<String> fewWords = Flux.just("Hello", "World");
        Flux<String> manyWords = Flux.fromIterable(words);

        fewWords.subscribe(System.out::println);

        System.out.println();

        manyWords.subscribe(System.out::println);
    }


    @Test
    public void findingMissingLetter() {
        Flux<String> manyLetters = Flux
                .fromIterable(words)
                .flatMap(v -> Flux.fromArray(v.split("")))
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE), (str, count) -> String.format("%2d. %s", count, str));

        manyLetters.subscribe(System.out::println);
    }


    /**
     * 通过Mono添加一个字母s
     */
    @Test
    public void restoringMissingLetter() {
        Mono<String> missing = Mono.just("s");
        Flux<String> allLetters = Flux
                .fromIterable(words)
                .flatMap(v -> Flux.fromArray(v.split("")))
                .concatWith(missing)
                .distinct()
                .sort()
                .zipWith(Flux.range(1, Integer.MAX_VALUE), (str, count) -> String.format("%2d. %s", count, str));

        allLetters.subscribe(System.out::println);
    }

    @Test
    public void shortCircuit() {
        Flux<String> hellloPauseWorld = Mono
                .just("hello")
                .concatWith(Mono.just("world")
                        .delaySubscription(Duration.ofMillis(500)));

        hellloPauseWorld.subscribe(System.out::println);
    }


    @Test
    public void blocks() {
        Flux<String> helloPauseWorld =
                Mono.just("hello")
                        .concatWith(Mono.just("world").delaySubscription(Duration.ofMillis(500)));

        helloPauseWorld.toStream()
                .forEach(System.out::println);
    }

    @Test
    public void firstEmitting() {
        Mono<String> a = Mono.just("a").delaySubscription(Duration.ofMillis(500));

        Flux<String> b = Flux.just("b1", "b2", "b3").delaySubscription(Duration.ofMillis(400));

        Flux.first(a, b)
                .toIterable()
                .forEach(System.out::println);
    }


}