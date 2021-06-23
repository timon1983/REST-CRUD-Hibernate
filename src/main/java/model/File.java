package model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id", nullable = false , unique = true)
    private long id;
    @Column(name = "path",nullable = false)
    private String path;
    @Column(name = "metaData",nullable = false)
    private String metaData;

    public File(String path, String metaData) {
        this.path = path;
        this.metaData = metaData;
    }

    public File() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMetaData() {
        return metaData;
    }

    public void setMetaData(String metaData) {
        this.metaData = metaData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        File file = (File) o;
        return id == file.id &&
                path.equals(file.path) &&
                metaData.equals(file.metaData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path, metaData);
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", metaData='" + metaData + '\'' +
                '}';
    }
}
