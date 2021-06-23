package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id", unique = true, nullable = false)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "uploadDate",nullable = false)
    private long uploaded;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private File file;

    public Event(long uploaded, File file) {
        this.uploaded = uploaded;
        this.file = file;
    }

    public Event(long uploaded) {
        this.uploaded = uploaded;
    }

    public Event() {
    }

    public long getId() {
        return id;
    }

    public long getUploadDate() {
        return uploaded;
    }

    public File getFile() {
        return file;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUploadDate(long uploadDate) {
        this.uploaded = uploadDate;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return id == event.id &&
                uploaded == event.uploaded &&
                user.equals(event.user) &&
                file.equals(event.file);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, uploaded, file);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", user=" + user +
                ", uploadDate=" + uploaded +
                ", file=" + file +
                '}';
    }
}
