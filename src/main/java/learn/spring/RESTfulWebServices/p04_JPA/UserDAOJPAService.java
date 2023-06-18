package learn.spring.RESTfulWebServices.p04_JPA;

import jakarta.validation.Valid;
import learn.spring.RESTfulWebServices.p01_DAOModel.User;
import learn.spring.RESTfulWebServices.p02_ExceptionHandling.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserDAOJPAService {

    private final UserRepository repository;

    public UserDAOJPAService(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<Optional<User>> getUser(@PathVariable int id) throws UserNotFoundException {
        Optional<User> user = repository.findById(id);
        if (user.isEmpty())
            throw new UserNotFoundException("userId=" + id);

        return EntityModel.of(user);
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        repository.deleteById(id);
    }

    // @RequestMapping(path = "/jpa/users", method = RequestMethod.POST)
    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        repository.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
