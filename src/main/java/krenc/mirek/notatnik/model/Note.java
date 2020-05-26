package krenc.mirek.notatnik.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private Long id;
    @Size(min = 3, message = "Note should have at least 3 characters")
    private String content;
    private LocalDate created;

    public Note(@Size(min = 3, message = "Note should have at least 3 characters") String content, LocalDate created) {
        this.content = content;
        this.created = created;
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", created=" + created +
                '}';
    }
}
