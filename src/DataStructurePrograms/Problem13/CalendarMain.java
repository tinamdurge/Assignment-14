package DataStructurePrograms.Problem13;

import DataStructures.*;
import java.util.Calendar;

public class CalendarMain {
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

        Queue<Week> calendarQueue = generateCalendar(month, year);

        // Display the calendar
        System.out.println(getMonthName(month) + " " + year);
        displayCalendar(calendarQueue);
    }

    public static Queue<Week> generateCalendar(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);

        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        Queue<Week> calendarQueue = new Queue<>();

        int currentDay = 1;

        for (int week = 0; week < 6; week++) {
            Week newWeek = new Week();
            for (int day = 0; day < 7; day++) {
                if (week == 0 && day < startDay - 1) {
                    newWeek.addDay(new WeekDay("NULL", 0));
                } else if (currentDay <= maxDay) {
                    newWeek.addDay(new WeekDay(getDayName(day), currentDay));
                    currentDay++;
                }
            }
            calendarQueue.add(newWeek);
        }

        return calendarQueue;
    }

    public static void displayCalendar(Queue<Week> calendarQueue) {
        System.out.println("S   M   T   W   Th   F   Sa");

        while (!calendarQueue.isEmpty()) {
            Week week = calendarQueue.dequeue();
            Queue<WeekDay> daysList = week.daysList;

            while (!daysList.isEmpty()) {
                WeekDay day = daysList.dequeue();
                if (day.date == 0) {
                    System.out.print("    ");
                } else {
                    System.out.printf("%-4s", day.date);
                }
            }
            System.out.println();
        }
    }

    public static String getDayName(int dayOfWeek) {
        String[] dayNames = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
        return dayNames[dayOfWeek];
    }

    public static String getMonthName(int month) {
        String[] monthNames = { "January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December" };
        return monthNames[month - 1];
    }
}
