package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(i -> System.out.println(i),
                        error -> System.out.println("Error happened: " + error.getMessage()));


        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((e, r) -> System.out.println(e.getMessage()))
                .subscribe(i -> System.out.println(i));

        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorResume(e -> Flux.just(-1, -2, -3))
                .subscribe(i -> System.out.println(i));
        ;

//        System.out.println("Press a key to end");
//        System.in.read();
        Thread.sleep(10000);
    }

}
