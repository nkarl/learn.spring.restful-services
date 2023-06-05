package learn.spring.RESTfulWebServices.p04_JPA;

import learn.spring.RESTfulWebServices.p01_DAOModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
