package learn.spring.RESTfulWebServices.user;

import jakarta.validation.Valid;
import learn.spring.RESTfulWebServices.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserDAOService {
    private final UserDAO service;

    public UserDAOService(UserDAO service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) throws UserNotFoundException {
        User user = service.findById(id);
        if (user == null)
            throw new UserNotFoundException("userId=" + id);
        return user;
    }


    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) throws UserNotFoundException {
        service.deleteById(id);
    }

    //    @RequestMapping(path = "/users", method = RequestMethod.POST)
    @PostMapping(path = "/users")
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
