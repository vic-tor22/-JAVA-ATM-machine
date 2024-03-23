package timetable;

import java.util.*;

public class SchoolTimetableGenerator {

    // Define the days of the week in East African Time
    private static final String[] DAYS_OF_WEEK = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    // Define the number of periods in a day
    private static final int NUM_PERIODS = 6; // Assuming 6 periods per day

    // Define subjects offered in the school
    private static final String[] SUBJECTS = {"Maths", "Science", "English", "History", "Geography", "Art"};

    public static void main(String[] args) {
        // Initialize a timetable grid
        String[][] timetable = new String[DAYS_OF_WEEK.length][NUM_PERIODS];

        // Generate random timetable
        generateTimetable(timetable);

        // Print the generated timetable
        printTimetable(timetable);
    }

    // Method to generate a random timetable
    private static void generateTimetable(String[][] timetable) {
        Random random = new Random();

        // Loop through each day
        for (int day = 0; day < DAYS_OF_WEEK.length; day++) {
            // Assign lunch hour at the third period (index 2)
            timetable[day][2] = "Lunch";

            // Assign the special hour at 11 am (index 4)
            timetable[day][4] = "Special Hour";

            // Shuffle the subjects to randomize the timetable
            List<String> subjectsList = Arrays.asList(SUBJECTS);
            Collections.shuffle(subjectsList);

            // Assign subjects to periods for the current day
            for (int period = 0; period < NUM_PERIODS; period++) {
                // Check if it's lunch hour or special hour, skip if true
                if (period == 2 || period == 4) continue;

                // Pick a random subject from the shuffled list
                String subject = subjectsList.get(period % subjectsList.size());
                timetable[day][period] = subject;
            }
        }
    }

    // Method to print the generated timetable
    private static void printTimetable(String[][] timetable) {
        System.out.println("School Timetable (East African Time):");
        System.out.println("--------------------------------------");

        // Print column headers
        System.out.printf("%-10s", "Day");
        for (int period = 0; period < NUM_PERIODS; period++) {
            System.out.printf("%-20s", "Period " + (period + 1));
        }
        System.out.println();

        // Loop through each day and period to print the timetable
        for (int day = 0; day < DAYS_OF_WEEK.length; day++) {
            System.out.printf("%-10s", DAYS_OF_WEEK[day]);
            for (int period = 0; period < NUM_PERIODS; period++) {
                String time;
                if (period < 2) {
                    time = (period + 8) + ":00 AM"; // Start from 8:00 AM
                } else if (period == 2) {
                    time = "12:00 PM"; // Lunch hour
                } else if (period < 5) {
                    time = (period - 1) + ":00 PM"; // After lunch, start from 1:00 PM
                } else {
                    time = "11:00 AM"; // Special hour
                }
                System.out.printf("%-20s", time + " - " + (timetable[day][period] != null ? timetable[day][period] : "Free"));
            }
            System.out.println();
        }
    }
}


