package interviewCodingQueAns.stream;
/*
1. Partition integers by even and odd



*/

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningExample {

    public static void main(String[] args) {

        // 1. Partition integers by even and odd
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> evenOddUsingStream = numbers.stream().collect(Collectors.partitioningBy(num-> num % 2 == 0));
        System.out.println(numbers);

        // 2. Partition employees by salary greater than 50,000
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 50000),
                new Employee("Bob", 60000),
                new Employee("Charlie", 45000)
        );

        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream().collect(Collectors.partitioningBy(emp-> emp.getSalary() > 50000));
        System.out.println(partitionedBySalary);

        Map<Boolean, List<Employee>> groupBySalary = employees.stream().collect(Collectors.groupingBy(emp-> emp.getSalary() > 50000));
        System.out.println(groupBySalary);

        // 3. Partition strings by whether they are palindrome
        List<String> words = Arrays.asList("madam", "apple", "level", "banana", "civic");
        Map<Boolean, List<String>> partitionedByPalindrome = words.stream().collect(Collectors.partitioningBy(word-> new StringBuilder(word).reverse().toString().equals(word)));
        System.out.println(partitionedByPalindrome);

        // 4. Partition numbers by prime or non-prime
        Map<Boolean, List<Integer>> partitionedByPrime = numbers.stream()
                .collect(Collectors.partitioningBy(StreamInterviewQueAns::isPrime));
        System.out.println(partitionedByPrime);

        // 5. Partition employees by whether they are from IT department
        List<Employee> employees2 = Arrays.asList(
                new Employee("Alice", "HR"),
                new Employee("Bob", "IT"),
                new Employee("Charlie", "Finance")
        );
        Map<Boolean, List<Employee>> partitionedByITDept = employees2.stream().collect(Collectors.partitioningBy(emp-> "IT".equals(emp.getDepartment())));
        System.out.println(partitionedByITDept);
        // 6. Partition students by whether they passed (score > 50)
        // 8. Partition words by whether their length is greater than 4
        // 7. Partition products by whether they are available in stock
    }
}
