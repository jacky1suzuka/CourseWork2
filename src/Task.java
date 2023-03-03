import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Objects;

public abstract class Task {
    private static int idGenerator;
    private String title;
    private Type type;
    private LocalDateTime dateTime;
    private Integer id;
    private String description;
    private String repeatability;

    public Task(String title, Type type, String description) {
        idGenerator++;
        this.title = title;
        this.type = type;
        this.dateTime = LocalDateTime.now();
        this.id = idGenerator;
        this.description = description;
    }

    public String getRepeatability() {
        return repeatability;
    }

    public void setRepeatability(String repeatability) {
        this.repeatability = repeatability;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract boolean appearsIn(LocalDate date);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id.equals(task.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Название: " + title + "\nОписание: " + description + "\nid: " + id  + "\nТип задачи: " + type + "\nДата создания: "
                + dateTime.get(ChronoField.YEAR) + "-" + dateTime.get(ChronoField.MONTH_OF_YEAR) + "-" + dateTime.get(ChronoField.DAY_OF_MONTH) + "\nПовторяемость: " + repeatability + "\n";
    }
}
