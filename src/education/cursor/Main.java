package education.cursor;

import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {

        Map<LocalDate, BooksList> report = new TreeMap<>();
        report.put(LocalDate.of(2022, 1, 1), BooksList.BOOK1);
        report.put(LocalDate.of(2022, 1, 2), BooksList.BOOK2);
        report.put(LocalDate.of(2022, 1, 3), BooksList.BOOK3);
        report.put(LocalDate.of(2022, 1, 4), BooksList.BOOK4);
        report.put(LocalDate.of(2022, 1, 5), BooksList.BOOK5);
        System.out.println(report);

        System.out.print("Do you want to take a BOOK6? (type 'y' if so): ");
        Scanner sc = new Scanner(System.in);
        String answer = sc.next();
        if (answer.equals("y")) {
            report.put(LocalDate.now(), BooksList.BOOK6);
        } else {
            System.out.println("Ok");
        }

        System.out.print("Search by dates (only such as '2007-12-03' allowed): ");
        String date = sc.next();
        try {
            LocalDate searchDate = LocalDate.parse(date);
            if (report.containsKey(searchDate)) {
                System.out.println(report.get(searchDate));
            } else {
                System.out.println("There are no books for this date");
            }
        } catch (Exception e) {
            System.out.println("Invalid input, hence no search result");
        } finally {

            System.out.println("Dates of taken books: ");
            for (Map.Entry<LocalDate, BooksList> i : report.entrySet()) {
                System.out.print(i.getKey() + " / ");
            }

            System.out.println("\nList of books for a whole range: ");
            for (Map.Entry<LocalDate, BooksList> j : report.entrySet()) {
                System.out.print(j.getValue() + " / ");
            }
        }
    }

}
