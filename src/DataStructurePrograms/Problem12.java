package DataStructurePrograms;

import java.util.Calendar;

public class Problem12 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Invalid input: input should be <month> <year>");
            return;
        }

        int month = Integer.parseInt(args[0]);
        int year = Integer.parseInt(args[1]);

        if (month < 1 || month > 12) {
            System.out.println("Invalid input: month should be between 1-12");
            return;
        }

        int[][] calendar = getCalendar(month, year);
        System.out.println(getMonthName(month) + " " + year);
        printCalendar(calendar);
    }

    public static int[][] getCalendar(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        int[][] calendarArr = new int[6][7]; // maximum of 6 weeks in a month

        int currentDay = 1;

        for (int week = 0; week < calendarArr.length; week++) {
            for (int dayOfWeek = 0; dayOfWeek < calendarArr[week].length; dayOfWeek++) {
                if (week == 0 && dayOfWeek < startDay - 1) {
                    // empty slots in the first week
                    calendarArr[week][dayOfWeek] = -1;
                } else if (currentDay <= maxDay) {
                    calendarArr[week][dayOfWeek] = currentDay;
                    currentDay++;
                }
            }
        }

        return calendarArr;
    }

    public static void printCalendar(int[][] calendar) {
        System.out.println("S   M   T   W   Th   F   Sa");

        for (int[] week : calendar) {
            for (int day : week) {
                if (day == -1) {
                    System.out.print("    ");
                } else {
                    System.out.printf("%-4d", day);
                }
            }
            System.out.println();
        }
    }

    public static String getMonthName(int month) {
        String[] monthNames = { "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };
        return monthNames[month - 1];
    }
}
