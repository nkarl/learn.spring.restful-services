package learn.spring.RESTfulServices.p04_JPA;

import learn.spring.RESTfulServices.p01_DAOModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
