package DataStructurePrograms.Problem14;

public class WeekDay {
    public String day;
    public int date;

    public WeekDay(String day, int date) {
        this.day = day;
        this.date = date;
    }

    @Override
    public String toString() {
        return day + " " + date;
    }
}
