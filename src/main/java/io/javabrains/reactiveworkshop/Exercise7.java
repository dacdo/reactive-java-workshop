package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException, InterruptedException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumberMono()
                .filter(x -> x > 5)
                .subscribe(x -> System.out.println(x));

        // Print 10 times each value from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .map(x -> x * 10)
                .subscribe(x -> System.out.println(x));

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().toStream()
                .filter(x -> x > 5)
                .limit(3)
                .map(x -> x * 10)
                .forEach(System.out::println);


        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);


        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .flatMap(id -> ReactiveSources.userFlux()
                        .filter(user -> user.getId() == id))
                .take(3)
                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);

//        System.out.println("Press a key to end");
//        System.in.read();
        Thread.sleep(10000);

    }

}
