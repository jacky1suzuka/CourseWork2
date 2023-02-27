import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task {
    public DailyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.isAfter(this.getDateTime().toLocalDate()) || date.isEqual(this.getDateTime().toLocalDate());
    }
}
