package school.hei.haapi.model;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.TypeDef;
import school.hei.haapi.repository.types.PostgresEnumType;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "\"course\"")
@Getter
@Setter
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String idCourse;
    @NotBlank(message = "Ref is mandatory")
    private String ref;
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Credit is mandatory")
    private int credits;
    @NotBlank(message = "hours is mandatory")
    private int total_hours;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<Note> userNote;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Course course = (Course) o;
        return idCourse != null && Objects.equals(idCourse, course.idCourse);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
