package AlgorithmPrograms.Problem11;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of tasks: ");
        int n = sc.nextInt();
        sc.nextLine();

        Task[] tasks = new Task[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter task " + (i + 1) + " deadline: ");
            int deadline = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter task " + (i + 1) + " duration: ");
            int duration = sc.nextInt();
            sc.nextLine();

            tasks[i] = new Task(deadline, duration);
        }

        // sorting the tasks based on the deadlines
        Arrays.sort(tasks);

        // printing overshoots for tasks
        int time = 0;
        int overshoot = 0;
        for (int i = 0; i < n; i++) {
            time += tasks[i].duration;
            overshoot += Math.max(overshoot, time - tasks[i].deadline);
            System.out.println("Task " + (i + 1) + " overshoots by " + overshoot);
        }
        sc.close();
    }
}
