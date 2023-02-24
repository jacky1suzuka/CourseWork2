import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.util.Objects;

public class Task {
    private static int idGenerator;
    private String title;
    Type type;
    LocalDateTime dateTime;
    private Integer id;
    private String description;

    public Task(String title, Type type, String description) {
        idGenerator++;
        this.title = title;
        this.type = type;
        this.dateTime = LocalDateTime.now();
        this.id = idGenerator;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(title, task.title) && type == task.type && Objects.equals(dateTime, task.dateTime) && Objects.equals(id, task.id) && Objects.equals(description, task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, dateTime, id, description);
    }

    @Override
    public String toString() {
        return "Название: " + title + "\nОписание: " + description + "\nid: " + id  + "\nТип задачи: " + type + "\nДата создания: "
                + dateTime.get(ChronoField.YEAR) + "-" + dateTime.get(ChronoField.MONTH_OF_YEAR) + "-" + dateTime.get(ChronoField.DAY_OF_MONTH) +
                "\nВремя создания: " + dateTime.get(ChronoField.HOUR_OF_DAY) + "-" + dateTime.get(ChronoField.MINUTE_OF_HOUR) + "-" + dateTime.get(ChronoField.SECOND_OF_MINUTE);
    }
}
