package interviewCodingQueAns.stream;


import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
/*
1. Group integers by even and odd
2. Group names by their length
3. Group by first letter of names
4. Group integers by remainder when divided by 3
5. Group employees by department
6. Group and count names by their first letter
7. Group employees by department and calculate average salary
8. Group products by category and find the highest priced product
9. Group students by grade and collect names in a List
10. Group books by genre and count unique authors per genre
11. Group employees by department and then by gender
14. Group sales by year and then by month
15. Group movies by genre and then by rating range
17. Group strings by whether they are palindrome or not
*/

public class GroupingExample {
    public static void main(String[] args) {
        // 1. Group integers by even and odd
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> evenOddMap = numbers.stream().collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("Even Numbers :- " + evenOddMap.get(true));
        System.out.println("Odd Numbers  :- " + evenOddMap.get(false));

        // 2. Group names by their length
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        Map<Integer, List<String>> groupNameByLength = names.stream().collect(Collectors.groupingBy(String::length));
        System.out.println(groupNameByLength);                                  //{3=[Bob, Eve], 5=[Alice, David], 7=[Charlie]}

        // 3. Group by first letter of names
        Map<Character, List<String>> groupNameByFirstLetter = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(groupNameByFirstLetter);                             // {A=[Alice], B=[Bob], C=[Charlie], D=[David], E=[Eve]}

        // 4. Group integers by remainder when divided by 3
        Map<Integer, List<Integer>> groupByRemainderWhenDivideBy3 = numbers.stream().collect(Collectors.groupingBy(n -> n % 3));
        System.out.println(groupByRemainderWhenDivideBy3);                      // {0=[3, 6, 9], 1=[1, 4, 7, 10], 2=[2, 5, 8]}

        // 5. Group employees by department
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "IT", 70000),
                new Employee("Charlie", "HR", 55000),
                new Employee("David", "IT", 80000)
        );

        Map<String, List<Employee>> groupByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("groupByDepartment:- " + groupByDepartment);          // {Finance=[Employee{name='Eve', department='Finance'}],
        // HR=[Employee{name='Alice', department='HR'}, Employee{name='Charlie', department='HR'}],
        // IT=[Employee{name='Bob', department='IT'}, Employee{name='David', department='IT'}]}

        //6. Group and count names by their first letter
        Map<Character, Long> groupCountNameByFirstLetter = names.stream().collect(Collectors.groupingBy(name -> name.charAt(0), Collectors.counting()));
        System.out.println("groupCountNameByFirstLetter:- " + groupCountNameByFirstLetter);                // {A=1, B=1, C=1, D=1, E=1}

        // 7. Group employees by department and calculate average salary
        Map<String, Double> groupDepartmentGetSalaryAvg = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("groupDepartmentGetSalaryAvg:- " + groupDepartmentGetSalaryAvg);         // {HR=52500.0, IT=75000.0}

        // 8. Group products by category and find the highest priced product
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 1200),
                new Product("Phone", "Electronics", 800),
                new Product("Shoes", "Fashion", 100),
                new Product("Jacket", "Fashion", 150)
        );

        Map<String, Optional<Product>> groupByCategoryMaxPriceProduct =
                products.stream().collect(
                        Collectors.groupingBy(Product::getCategory,
                                Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        System.out.println("groupByCategoryMaxPriceProduct:-  " + groupByCategoryMaxPriceProduct);

        Map<String, Optional<Product>> groupByCategoryMinPriceProduct =
                products.stream().collect(
                        Collectors.groupingBy(Product::getCategory,
                                Collectors.minBy(Comparator.comparingDouble(Product::getPrice))));
        System.out.println("groupByCategoryMinPriceProduct:-  " + groupByCategoryMinPriceProduct);


        // 9. Group students by grade and collect names in a List
        List<Student> students = Arrays.asList(
                new Student("Alice", "A"),
                new Student("Bob", "B"),
                new Student("Charlie", "A"),
                new Student("David", "C")
        );

        Map<String, List<String>> studentNames = students.stream().collect(Collectors.groupingBy(Student::getGrade,
                Collectors.mapping(Student::getName, Collectors.toList())));
        System.out.println("studentNames:- " + studentNames);

        Map<String, List<Student>> studentNames2 = students.stream().collect(Collectors.groupingBy(Student::getGrade));
        System.out.println("studentNames2:- " + studentNames2);

        // 10. Group books by genre and count unique authors per genre
        List<Book> books = Arrays.asList(
                new Book("Book1", "Sci-Fi", "Author1"),
                new Book("Book2", "Sci-Fi", "Author2"),
                new Book("Book3", "Fantasy", "Author1"),
                new Book("Book4", "Fantasy", "Author3")
        );

        Map<String, Set<String>> groupBookByGenreGetAuthorName = books.stream().collect(
                Collectors.groupingBy(Book::getGenre,
                        Collectors.mapping(Book::getAuthor, Collectors.toSet())));
        System.out.println("groupBookByGenreGetAuthorName:-  " + groupBookByGenreGetAuthorName);

        Map<String, Integer> groupBookByGenreGetCount =
                groupBookByGenreGetAuthorName.entrySet().stream().collect(
                        Collectors.toMap(Map.Entry::getKey,
                                entry -> entry.getValue().size()));
        System.out.println("groupBookByGenreGetCount:-  " + groupBookByGenreGetCount);

        //11. Group employees by department and then by gender
        List<Employee> employees2 = Arrays.asList(
                new Employee("Alice", "HR", "Female"),
                new Employee("Bob", "IT", "Male"),
                new Employee("Charlie", "HR", "Male"),
                new Employee("David", "IT", "Male"),
                new Employee("Eve", "Finance", "Female"));

        Map<String, Map<String, List<Employee>>> groupDeptThnGrpByGender =
                employees2.stream().collect(
                        Collectors.groupingBy(Employee::getDepartment,
                                Collectors.groupingBy(Employee::getGender)));
        System.out.println("groupDeptThnGrpByGender:-  " + groupDeptThnGrpByGender);

        // 12. Group transactions by city and then by payment method
        List<Transaction> transactions = Arrays.asList(
                new Transaction("New York", "Credit Card"),
                new Transaction("New York", "Cash"),
                new Transaction("LA", "Credit Card"),
                new Transaction("LA", "Debit Card")
        );

        Map<String, Map<String, List<Transaction>>> grpCityThenGrpPymntMthd =
                transactions.stream().collect(Collectors.groupingBy(Transaction::getCity,
                        Collectors.groupingBy(Transaction::getPaymentMethod)));
        System.out.println("grpCityThenGrpPymntMthd:-  " + grpCityThenGrpPymntMthd);


        // 14. Group sales by year and then by month
        List<Sale> sales = Arrays.asList(
                new Sale(LocalDate.of(2022, 1, 10)),
                new Sale(LocalDate.of(2022, 2, 5)),
                new Sale(LocalDate.of(2021, 12, 25)),
                new Sale(LocalDate.of(2021, 11, 11))
        );

        Map<Integer, Map<Month, List<Sale>>> grpSaleByYearThnGrpByMnth =
                sales.stream().collect(Collectors.groupingBy(s -> s.getDate().getYear(),
                        Collectors.groupingBy(m -> m.getDate().getMonth())));
        System.out.println("grpSaleByYearThnGrpByMnth :-  " + grpSaleByYearThnGrpByMnth);
//  grpSaleByYearThnGrpByMnth :-  { 2021={DECEMBER=[Sale{date=2021-12-25}], NOVEMBER=[Sale{date=2021-11-11}]},
//                                  2022={JANUARY=[Sale{date=2022-01-10}], FEBRUARY=[Sale{date=2022-02-05}]}}

        // 15. Group movies by genre and then by rating range
        List<Movie> movies = Arrays.asList(
                new Movie("Sci-Fi", 8.5),
                new Movie("Sci-Fi", 6.2),
                new Movie("Fantasy", 9.1),
                new Movie("Fantasy", 7.8)
        );

        Map<String, Map<String, List<Movie>>> grpMoveByGenreThnRtng = movies.stream().collect(Collectors.groupingBy(Movie::getGenre,
                Collectors.groupingBy(movie -> {
                    if (movie.getRating() >= 9) return "9-10";
                    if (movie.getRating() >= 6) return "6-8";
                    else return "1-5";
                })));
        System.out.println("grpMoveByGenreThnRtng :- " + grpMoveByGenreThnRtng);

        // 17. Group strings by whether they are palindrome or not
        List<String> words = Arrays.asList("madam", "apple", "level", "banana", "civic");

        Map<Boolean, List<String>> grpWordsByCheckingPalindrome =
                words.stream().collect(
                        Collectors.groupingBy(word-> new StringBuilder(word).reverse().toString().equals(word)));
        System.out.println("grpWordsByCheckingPalindrome :- "+ grpWordsByCheckingPalindrome);


        // 18. Group numbers by whether they are prime or non-prime

        List<Integer> numbers2 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> primeGrouping = numbers2.stream()
                .collect(Collectors.groupingBy(GroupingExample::isPrime));
        System.out.println("primeGrouping :- "+ primeGrouping);


    }

    public static  boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
