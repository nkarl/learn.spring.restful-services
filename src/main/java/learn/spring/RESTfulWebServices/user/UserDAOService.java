package learn.spring.RESTfulWebServices.user;

import org.springframework.web.bind.annotation.*;

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
        return service.findOne(id);
    }

//    @RequestMapping(path = "/users", method = RequestMethod.POST)
    @PostMapping(path = "/users")
    public void createUser(@RequestBody User user) {
        service.save(user);
    }

}
