package school.hei.haapi.model;


import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.TypeDef;
import school.hei.haapi.repository.types.PostgresEnumType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "\"note\"")
@Getter
@Setter
@TypeDef(name = "pgsql_enum", typeClass = PostgresEnumType.class)
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Note implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String idNote;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User student;

    private Double note;

    private LocalDate dateExamen;

    private String commentaire;

    @OneToMany(mappedBy = "course")
    @ToString.Exclude
    private Set<Note> studentNote;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Note note = (Note) o;
        return idNote != null && Objects.equals(idNote, note.idNote);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
