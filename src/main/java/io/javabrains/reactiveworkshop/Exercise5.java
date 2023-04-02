package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(
                number -> System.out.println(number),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed"));


        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.userMono().subscribe(
                user -> System.out.println(user),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed")
        );

//        System.out.println("Press a key to end");
//        System.in.read();
        Thread.sleep(3000);
    }

}