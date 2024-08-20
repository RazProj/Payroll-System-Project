import java.util.Calendar;

public class BirthDate {
    private int year;
    private int month;
    private int day;

    // Constructor initializes a BirthDate object with provided year, month, and day after validating them.
    public BirthDate(int year, int month, int day) {
        Calendar currentDate = Calendar.getInstance();
        if (checkYear(year, currentDate)) {
            throw new IllegalArgumentException("Year out of range.");
        }
        if (checkMonth(year, month, currentDate)) {
            throw new IllegalArgumentException("Month out of range.");
        }
        if (checkDay(year, month, day)) {
            throw new IllegalArgumentException("Day out of range.");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Check if the provided year is valid.
    public boolean checkYear(int year, Calendar currentDate) {
        return year > currentDate.get(Calendar.YEAR);
    }

    // Check if the provided month is valid.
    public boolean checkMonth(int year, int month, Calendar currentDate) {
        return month < 1 || month > 12 || (month - 1 > currentDate.get(Calendar.MONTH) && year == currentDate.get(Calendar.YEAR));
    }

    // Check if the provided day is valid according to the month and year (leap years considered).
    public boolean checkDay(int year, int month, int day) {
        int[] thirtyDaysMonths = {4, 6, 9, 11};  // April, June, September, November
        int[] thirtyOneDaysMonths = {1, 3, 5, 7, 8, 10, 12};  // January, March, May, July, August, October, December
        // Special handling for February (leap years).
        if (month == 2) {
            if (day < 1 || day > 29) {
                return true;
            } else if (day == 29) {
                return !leapYear(year);
            }
            return false;
        }

        // Validate days for months with 30 days.
        for (int m : thirtyDaysMonths) {
            if (month == m) {
                return !(day >= 1 && day <= 30);
            }
        }

        // Validate days for months with 31 days.
        for (int m : thirtyOneDaysMonths) {
            if (month == m) {
                return !(day >= 1 && day <= 31);
            }
        }

        // If month is not recognized, it's invalid.
        return true;
    }

    // Determine if a year is a leap year.
    public boolean leapYear(int year) {
        if (year % 400 == 0)
            return true;
        else if (year % 100 == 0)
            return false;
        else
            return year % 4 == 0;

    }


    // Getters and setters for year, month, and day.
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        Calendar currentDate = Calendar.getInstance();
        if (checkYear(year, currentDate)) {
            throw new IllegalArgumentException("Year out of range.");
        }
        this.year = year;
    }

    public void setMonth(int year, int month) {
        Calendar currentDate = Calendar.getInstance();
        if (checkMonth(year, month, currentDate)) {
            throw new IllegalArgumentException("Month out of range.");
        }
        this.month = month;
    }

    public void setDay(int year, int month, int day) {
        if (checkDay(year, month, day)) {
            throw new IllegalArgumentException("Day out of range.");
        }
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }


    // Provide a string representation of the date in DD/MM/YYYY format.
    public String toString() {
        return String.format("%d/%d/%d", day, month, year);
    }

}
