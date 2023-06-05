package learn.spring.kotlinRESTfulWebServices.p01_DAOModel

import learn.spring.RESTfulWebServices.p02_ExceptionHandling.UserNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
class UserDAOService(private val service: UserDAO) {

    @GetMapping("/users")
    fun getAllUsers(): List<User> {
        return service.findAll()
    }

    @GetMapping("/users/{id}")
    fun getUser(@PathVariable id: Int): User {
        val user: User =
            service.findById(id)
        if (user == null)
            throw UserNotFoundException("id=$id")
        return user
    }

    @DeleteMapping("/users/{id}")
    fun deleteUser(@PathVariable id: Int) {
        service.deleteById(id)
    }

    @PostMapping("/users")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        val newUser: User = service.save(user)
        val location: URI = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(newUser.id)
            .toUri()
        return ResponseEntity.created(location).build()
    }
}