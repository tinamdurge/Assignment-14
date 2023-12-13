package AlgorithmPrograms.Problem11;

public class Task implements Comparable<Task> {
    int deadline;
    int duration;

    public Task(int deadline, int duration) {
        this.deadline = deadline;
        this.duration = duration;
    }

    // method for sorting tasks by deadline
    @Override
    public int compareTo(Task otherTask) {
        return Integer.compare(this.deadline, otherTask.deadline);
    }

}
