package Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "children")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String fullName;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;


    private String age;

    @ManyToOne
    @JoinColumn(name = "educationalInstitution_id")
    private EducationalInstitution educationalinstitution;

}
