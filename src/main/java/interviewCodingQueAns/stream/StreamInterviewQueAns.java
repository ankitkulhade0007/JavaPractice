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
Q. Find the kth smallest element in an array using Java streams:
Q. Given a list of strings, find the frequency of each word using Java streams:
Q. Implement a method to partition a list into two groups based on a predicate using Java streams:
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

        Map<String, Integer> sumByDay =
                transactions.stream().collect(
                        Collectors.groupingBy(Transaction::getTransactionDate,
                                Collectors.summingInt(Transaction::getTransactionAmount)));
        System.out.println("sumByDay " + sumByDay);

        int totalamount = transactions.stream().mapToInt(Transaction::getTransactionAmount).sum();
        System.out.println("Totalamount " + totalamount);

        // Q. Find the kth smallest element in an array using Java streams:
        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int n = 3; // // Find the 3rd smallest element
        int nthSmallestNumberFromArr = Arrays.stream(array).sorted().skip(n-1).findFirst().orElse(-1);
        System.out.println("nthSmallestNumberFromArr :- " + nthSmallestNumberFromArr);

        // Q. Given a list of strings, find the frequency of each word using Java streams:
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry","banana", "apple");
        Map<String, Long> wordFrequency = words.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));
        System.out.println("wordFrequency :- "+ wordFrequency);

        // Q. Implement a method to partition a list into two groups based on a predicate using Java streams:
        List<Integer> numbers3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Map<Boolean, List<Integer>> partitionArray = numbers3.stream().collect(Collectors.partitioningBy(l-> l % 2 == 0));
        System.out.println("partitionArray :" + partitionArray);
/*
        1. Find the maximum number in a list using Streams
        2. Find the sum of all numbers in a list using Streams
        3. Find the first element in a stream
        4. Convert a list of strings to uppercase using Streams
        5. Filter even numbers from a list using Streams
        6. Count the number of elements in a list that start with a specific letter
        7. Sort a list of integers using Streams
        8. Sort a list of strings by length using Streams
        13. Concatenate a list of strings using Streams
        17. Find the second largest number in a list using Streams

 */
        List<String> words2 = Arrays.asList( "apple", "banana", "cherry" );
        numbers3.stream().max(Integer::compareTo);
        numbers3.stream().mapToInt(Integer::intValue).sum();
        Optional<Integer> firstElement  =   numbers3.stream().findFirst();
        List<String> uppercaseWords     =   words2.stream().map(String::toUpperCase).toList();
        long countNum                   =   words2.stream().filter(w-> w.startsWith("a")).count();
        List<String> sortedWords        =   words2.stream().sorted().toList();
        //8. Sort a list of strings by length using Streams
        List<String> sortedByLength = words2.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
        System.out.println(sortedByLength);
        // 13. Concatenate a list of strings using Streams
        List<String> words3 = Arrays.asList("Hello", "world", "Stream");
        String result2 = words3.stream()
                .collect(Collectors.joining(" "));
        System.out.println(result2);        // Hello world Stream Will not add to last element.

        numbers3.stream().collect(Collectors.averagingInt(Integer::intValue));
        OptionalDouble average = numbers3.stream().mapToInt(Integer::intValue).average();

        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> minimum = numbers4.stream().min(Integer::compareTo);

        Optional<Integer> secondLargest =  numbers4.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondLargest.orElse(null));

        // Count the number of occurrences of each word in a list
        List<String> words4 = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "banana");
        words4.stream().collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));



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