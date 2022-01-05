package cn.eviao.k8slearn.linkmanager.entity;

import com.google.common.base.Objects;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

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
        return Objects.equal(id, link.id) && Objects.equal(name, link.name) && Objects.equal(description, link.description) && Objects.equal(url, link.url) && Objects.equal(userid, link.userid) && Objects.equal(username, link.username) && Objects.equal(createdAt, link.createdAt) && Objects.equal(updatedAt, link.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, description, url, userid, username, createdAt, updatedAt);
    }
}
