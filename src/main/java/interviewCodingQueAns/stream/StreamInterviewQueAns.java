package interviewCodingQueAns.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Q. Find the longest string in a list of strings using Java streams:
Q. Calculate the average age of a list of Person objects using Java streams:
Q. Merge two sorted lists into a single sorted list using Java streams:
Q. Find the intersection of two lists using Java streams:
Q. Remove duplicates from a list while preserving the order using Java streams:
Q. Remove duplicates from a list while preserving the order using Java streams:
Q. Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
*/
public class StreamInterviewQueAns {


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "grapefruit");
        List<Integer> ages = Arrays.asList(123, 456, 101, 10);

        // Find the longest string in a list of strings using Java streams:

        Optional<String> list1 = strings.stream().filter(s -> !s.isEmpty()).max(Comparator.comparingInt(String::length));
        list1.ifPresent(System.out::println);

        Optional<String> list2 = strings.stream().filter(s -> !s.isEmpty()).min(Comparator.comparingInt(String::length));
        list2.ifPresent(System.out::println);

        Optional<Integer> list3 = ages.stream().max(Comparator.comparingInt(Integer::intValue));
        list3.ifPresent(System.out::println);

        Optional<Integer> list4 = ages.stream().min(Comparator.comparingInt(Integer::intValue));
        list4.ifPresent(System.out::println);


        // Calculate the average age of a list of Person objects using Java streams:
        List<Person> persons = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        double avgAge = persons.stream().mapToInt(Person::getAge).average().orElse(0);
        System.out.println("average Age " + avgAge);

        // Q. Check if a list of integers contains a prime number using Java streams:
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 11, 12, 13, 14, 15);
        boolean prime = numbers.stream().anyMatch(StreamInterviewQueAns::isPrime);
        System.out.println("prime " + prime);


        // Merge two sorted lists into a single sorted list using Java streams:
        List<Integer> list5 = Arrays.asList(1, 3, 5, 7, 9);
        List<Integer> list6 = Arrays.asList(2, 4, 6, 8, 10);
        List<Integer> mergedList = Stream.concat(list5.stream(), list6.stream()).sorted().toList();
        System.out.println("merged list " + mergedList);


        // Q. Find the intersection of two lists using Java streams:
        List<Integer> list7 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> list8 = Arrays.asList(3, 4, 5, 6, 7);
        List<Integer> intersectedList = list7.stream().filter(list8::contains).sorted().toList();
        System.out.println("intersected list " + intersectedList);

    // Q. Remove duplicates from a list while preserving the order using Java streams:
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 3, 2, 4, 1, 5, 6, 5);
        List<Integer> resultList = numbersWithDuplicates.stream().distinct().toList();
        System.out.println("resultList " + resultList);

    // Q. Given a list of transactions, find the sum of transaction amounts for each day using Java streams:
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2022-01-01", 100),
                new Transaction("2022-01-01", 200),
                new Transaction("2022-01-02", 300),
                new Transaction("2022-01-02", 400),
                new Transaction("2022-01-03", 500)
        );

        Map<String, Integer> sumByDay =  transactions.stream()
                .collect(Collectors.groupingBy(
                                    Transaction::getTransactionDate,
                                    Collectors.summingInt(Transaction::getTransactionAmount)));

        System.out.println("sumByDay " + sumByDay);

        int totalamount = transactions.stream().mapToInt(Transaction::getTransactionAmount).sum();
        System.out.println("Totalamount " + totalamount);




    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}