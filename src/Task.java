import java.util.Objects;

public class Task {
    private static int idGenerator;
    private String title;
    private Integer id;
    private String description;

    public Task(String title, String description) {
        idGenerator++;
        this.title = title;
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
        return id == task.id && title.equals(task.title) && description.equals(task.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, id, description);
    }

    @Override
    public String toString() {
        return "Название: " + title + "\nОписание: " + description + "\nid: " + id ;
    }
}
