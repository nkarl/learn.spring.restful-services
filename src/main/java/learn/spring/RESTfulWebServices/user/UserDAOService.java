package learn.spring.RESTfulWebServices.user;

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
    public User retrieveUser(@PathVariable int id) {
        User user = service.findOne(id);
        if (user == null)
            throw new UserNotFoundException("id: " + id);
        return user;
    }

    //    @RequestMapping(path = "/users", method = RequestMethod.POST)
    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        service.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
