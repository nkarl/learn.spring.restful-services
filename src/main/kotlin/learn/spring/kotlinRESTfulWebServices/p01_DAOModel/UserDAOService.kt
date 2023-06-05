package learn.spring.kotlinRESTfulWebServices.p01_DAOModel

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import java.net.URI

@RestController
class UserDAOService(private val service: UserDAO) {

    @GetMapping("/users")
    fun retrieveAllUsers(): List<User> {
        return service.findAll()
    }

    @GetMapping("/users/{id}")
    fun retrieveUser(@PathVariable id: Int): User {
        return service.findById(id)
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