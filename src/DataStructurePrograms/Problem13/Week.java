package DataStructurePrograms.Problem13;

import DataStructures.*;

public class Week {
    public Queue<WeekDay> daysList;

    public Week() {
        daysList = new Queue<>();
    }

    public void addDay(WeekDay day) {
        daysList.add(day);
    }
}
