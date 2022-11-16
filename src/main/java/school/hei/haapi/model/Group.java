package school.hei.haapi.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"group\"")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group implements Serializable {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private String idGroup;

  private String name;
  private String ref;

  @CreationTimestamp
  private Instant creationDatetime;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Group group = (Group) o;
    return idGroup != null && Objects.equals(idGroup, group.idGroup);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
