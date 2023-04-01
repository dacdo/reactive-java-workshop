package io.javabrains.reactiveworkshop;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here
        IntStream.range(1, 9)
                .forEach(System.out::println);


        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        IntStream.range(1, 9)
                .filter(x -> x < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        StreamSources.intNumbersStream()
                .filter(x -> x > 5)
                .skip(1)
                .limit(2)
                .forEach(n -> System.out.println(n));


        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        OptionalInt optionalInt = IntStream.range(1, 99)
                .filter(x -> x > 5)
                .findFirst();
        if (optionalInt.isPresent()) {
            System.out.println(optionalInt.getAsInt());
        } else {
            System.out.println(-1);
        }


        // Print first names of all users in userStream
        // TODO: Write code here
        StreamSources.userStream()
                .forEach(e -> System.out.println(e.getFirstName()));

        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(name -> System.out.println(name));

    }
}
