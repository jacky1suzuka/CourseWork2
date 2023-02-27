import java.time.LocalDate;

public class WeeklyTask extends Task {
    public WeeklyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.getDayOfWeek().equals(this.getDateTime().getDayOfWeek());
    }
}
