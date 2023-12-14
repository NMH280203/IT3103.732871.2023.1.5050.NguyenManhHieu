//Nguyen Manh Hieu 20215050
import java.util.Scanner;
public class DaysInMonth {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] months = {
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        };

        int[] daysInMonth = {
            31, 28, 31, 30, 31, 30,
            31, 31, 30, 31, 30, 31
        };

        System.out.print("Enter a month (full name, abbreviation, 3 letters, or number): ");
        String monthInput = scanner.nextLine().toLowerCase();
        
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        
        int month = -1;
        
        // Determine the month index based on the user's input
        if (monthInput.matches("^(1?\\d|jan(uary)?|feb(ruary)?|mar(ch)?|apr(il)?|may|jun(e)?|jul(y)?|aug(ust)?|sep(tember)?|oct(ober)?|nov(ember)?|dec(ember)?)$")) {
            switch (monthInput) {
                case "1":
                case "january":
                case "jan":
                case "jan.":
                    month = 0;
                    break;
                case "2":
                case "february":
                case "feb":
                case "feb.":
                    month = 1;
                    break;
                case "3":
                case "march":
                case "mar":
                case "mar.":
                    month = 2;
                    break;
                case "4":
                case "april":
                case "apr":
                case "apr.":
                    month = 3;
                    break;
                case "5":
                case "may":
                    month = 4;
                    break;
                case "6":
                case "june":
                case "jun":
                case "jun.":
                    month = 5;
                    break;
                case "7":
                case "july":
                case "jul":
                case "jul.":
                    month = 6;
                    break;
                case "8":
                case "august":
                case "aug":
                case "aug.":
                    month = 7;
                    break;
                case "9":
                case "september":
                case "sep":
                case "sep.":
                    month = 8;
                    break;
                case "10":
                case "october":
                case "oct":
                case "oct.":
                    month = 9;
                    break;
                case "11":
                case "november":
                case "nov":
                case "nov.":
                    month = 10;
                    break;
                case "12":
                case "december":
                case "dec":
                case "dec.":
                    month = 11;
                    break;
            }
        }
        
        if (month == -1) {
            System.out.println("Invalid month input. Please try again.");
            scanner.close();
            return;
        }

        if (year < 0 || year < 1583) {
            System.out.println("Invalid year input. Please enter a non-negative year after 1582.");
            scanner.close();
            return;
        }

        int days = daysInMonth[month];

        // Check for a leap year and update February's days if necessary
        if (month == 1 && isLeapYear(year)) {
            days = 29;
        }

        System.out.println("There are " + days + " days in " + months[month] + " " + year + ".");

        scanner.close();
    }

    // Function to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

