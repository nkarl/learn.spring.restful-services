package learn.spring.RESTfulServices.p01_DAOModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import learn.spring.RESTfulServices.p04_JPA.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "user_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, message = "Name must contain at least 2 characters.")
    private String name;

    @Past(message = "Birth Date should be in the past.")
    private LocalDate birthDate;

    @OneToMany(mappedBy = "user")
//    @JsonIgnore
    private List<Post> posts;

    User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }
}
