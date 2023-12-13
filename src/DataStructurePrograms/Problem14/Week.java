package DataStructurePrograms.Problem14;

import DataStructures.*;

public class Week {
    public Stack<WeekDay> daysList;

    public Week() {
        daysList = new Stack<>();
    }

    public void addDay(WeekDay day) {
        daysList.add(day);
    }
}
