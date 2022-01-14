package cn.eviao.k8slearn.linkmanager.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Link implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotBlank
    @Size(max = 64)
    @Column
    private String name;

    @Column
    @Size(max = 64)
    private String description;

    @NotBlank
    @Size(max = 256)
    @Column
    private String url;

    @Column
    private String screen;

    @Column
    private Integer userid;

    @Column
    private String username;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(id, link.id) && Objects.equals(name, link.name) && Objects.equals(description, link.description) && Objects.equals(url, link.url) && Objects.equals(screen, link.screen) && Objects.equals(userid, link.userid) && Objects.equals(username, link.username) && Objects.equals(createdAt, link.createdAt) && Objects.equals(updatedAt, link.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, url, screen, userid, username, createdAt, updatedAt);
    }
}
