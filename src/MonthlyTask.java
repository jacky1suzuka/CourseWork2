import java.time.LocalDate;

public class MonthlyTask extends Task {
    public MonthlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.getDayOfMonth() == this.getDateTime().getDayOfMonth() && date.isAfter(this.getDateTime().toLocalDate()) || date.isEqual(this.getDateTime().toLocalDate());
    }
}
