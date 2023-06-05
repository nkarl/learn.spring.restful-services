package learn.spring.RESTfulWebServices.p04_JPA;

import jakarta.validation.Valid;
import learn.spring.RESTfulWebServices.p01_DAOModel.User;
import learn.spring.RESTfulWebServices.p01_DAOModel.UserDAO;
import learn.spring.RESTfulWebServices.p02_ExceptionHandling.UserNotFoundException;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserDAOJPAService {
    private final UserDAO service;

    private final UserRepository repository;

    public UserDAOJPAService(UserDAO service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }

    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) throws UserNotFoundException {
        User user = service.findById(id);
        if (user == null)
            throw new UserNotFoundException("userId=" + id);

        return EntityModel.of(user);
    }


    @DeleteMapping("/jpa/users/{id}")
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        service.deleteById(id);
    }

    //    @RequestMapping(path = "/jpa/users", method = RequestMethod.POST)
    @PostMapping(path = "/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
}
