package Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "educationalInstitution")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EducationalInstitution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String address;

    private String number;
}
