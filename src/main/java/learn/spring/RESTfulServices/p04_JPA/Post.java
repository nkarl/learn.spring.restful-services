package learn.spring.RESTfulServices.p04_JPA;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import learn.spring.RESTfulServices.p01_DAOModel.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue
    private Integer id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
}
