package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(e -> System.out.println(e
        ));


        // Get the value from the Mono into an integer variable
        // TODO: Write code here
        Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional();
        if (number.isPresent()) {
            System.out.println(number.get());
        } else {
            System.out.println("Mono not emitting");
        }

//        System.out.println("Press a key to end");
//        System.in.read();

        Thread.sleep(10000);
    }

}
