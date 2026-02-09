package Stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class first {

    public static void main(String[] args) {

        List<String> myList = Arrays.asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");


        myList.stream().filter(s -> s.startsWith("S")).map(s -> s.toUpperCase()).sorted()
              .forEach(System.out::println);

        System.out.println("----------");

        myList.stream().map(s -> {
            StringBuilder temp = new StringBuilder(s);
            temp.reverse();
            temp.append(" "+s);
            return temp.toString();
        }).forEach(System.out::println);


    }
}