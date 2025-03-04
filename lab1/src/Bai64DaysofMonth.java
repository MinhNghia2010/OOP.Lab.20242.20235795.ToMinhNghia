import java.util.Scanner;
public class Bai64DaysofMonth {
    public static boolean leapYear(int year) {
        if (year % 400 == 0) return true;
        if (year % 100 == 0) return false;
        if (year % 4 == 0) return true;
        return false;
    }

    public static int validMonth(String month) {
        if (month.equalsIgnoreCase("January") || month.equalsIgnoreCase("Jan.") || month.equalsIgnoreCase("Jan") || month.equals("1"))
            return 1;
        if (month.equalsIgnoreCase("February") || month.equalsIgnoreCase("Feb.") || month.equalsIgnoreCase("Feb") || month.equals("2"))
            return 2;
        if (month.equalsIgnoreCase("March") || month.equalsIgnoreCase("Mar.") || month.equalsIgnoreCase("Mar") || month.equals("3"))
            return 3;
        if (month.equalsIgnoreCase("April") || month.equalsIgnoreCase("Apr.") || month.equalsIgnoreCase("Apr") || month.equals("4"))
            return 4;
        if (month.equalsIgnoreCase("May") || month.equals("5")) return 5;
        if (month.equalsIgnoreCase("June") || month.equalsIgnoreCase("Jun.") || month.equalsIgnoreCase("Jun") || month.equals("6"))
            return 6;
        if (month.equalsIgnoreCase("July") || month.equalsIgnoreCase("Jul.") || month.equalsIgnoreCase("Jul") || month.equals("7"))
            return 7;
        if (month.equalsIgnoreCase("August") || month.equalsIgnoreCase("Aug.") || month.equalsIgnoreCase("Aug") || month.equals("8"))
            return 8;
        if (month.equalsIgnoreCase("September") || month.equalsIgnoreCase("Sep.") || month.equalsIgnoreCase("Sep") || month.equals("9"))
            return 9;
        if (month.equalsIgnoreCase("October") || month.equalsIgnoreCase("Oct.") || month.equalsIgnoreCase("Oct") || month.equals("10"))
            return 10;
        if (month.equalsIgnoreCase("November") || month.equalsIgnoreCase("Nov.") || month.equalsIgnoreCase("Nov") || month.equals("11"))
            return 11;
        if (month.equalsIgnoreCase("December") || month.equalsIgnoreCase("Dec.") || month.equalsIgnoreCase("Dec") || month.equals("12"))
            return 12;
        return 0;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter month:");
        String month;
        int valMonth = 0;
        while (valMonth == 0) {
            month = keyboard.nextLine();
            valMonth = validMonth(month);
            if (valMonth == 0) {
                System.out.println("Invalid month");
            }
        }
        System.out.println("Enter year:");
        int year = 0;
        while (year <= 0) {
            year = keyboard.nextInt();
            if (year <= 0) {
                System.out.println("Invalid year");
            }
        }
        if (leapYear(year) && valMonth == 2) {
            System.out.println("29");
        } else if (valMonth == 4 || valMonth == 6 || valMonth == 9 || valMonth == 11) {
            System.out.println("30");
        } else if (valMonth == 2) {
            System.out.println("28");
        } else {
            System.out.println("31");
        }
    }
}
