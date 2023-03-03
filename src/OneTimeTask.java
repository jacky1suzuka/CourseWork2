import java.time.LocalDate;

public class OneTimeTask extends Task {
    public OneTimeTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.equals(this.getDateTime().toLocalDate());
    }
}
