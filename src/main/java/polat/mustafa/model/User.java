package polat.mustafa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author MPolat
 */

@Entity
@Table(name = "USERS")
@Getter
@Setter
public class User extends BaseModel{

    @Id
    @GeneratedValue(generator = "User", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "User", sequenceName = "USER_ID_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME", length = 50, nullable = false)
    private String name;

    @Column(name = "SURNAME", length = 50, nullable = false)
    private String surname;

    @NotBlank
    @Column(name = "USERNAME", length = 50, nullable = false, unique = true)
    private String username;

    @NotNull
    @Column(name = "PASSWORD", length = 400, nullable = false)
    private String password;

    @Email
    @Column(name = "EMAIL", length = 50, unique = true)
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "USER_CITIES",
               joinColumns = @JoinColumn(name = "user_id"),
               inverseJoinColumns = @JoinColumn(name = "city_id"))
    private Set<City> citySet = new HashSet<>();

}
