import java.time.LocalDate;

public class YearlyTask extends Task{
    public YearlyTask(String title, Type type, String description) {
        super(title, type, description);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return date.getDayOfMonth() == this.getDateTime().getDayOfMonth() && date.getMonth() == this.getDateTime().getMonth() && date.isAfter(this.getDateTime().toLocalDate()) || date.isEqual(this.getDateTime().toLocalDate());
    }
}
