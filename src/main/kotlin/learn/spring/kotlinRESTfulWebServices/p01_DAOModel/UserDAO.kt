package learn.spring.kotlinRESTfulWebServices.p01_DAOModel

import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class UserDAO {
    private final var usersCount = 0

    val users: MutableList<User> = mutableListOf(
        User(++usersCount, "Adam", LocalDate.now().minusYears(30)),
        User(++usersCount, "Eve", LocalDate.now().minusYears(25)),
        User(++usersCount, "Jim", LocalDate.now().minusYears(20)),
    )

    public fun findAll() = listOf(users)

    fun findById(id: Int): User {
        val user = users.filter { it.id == id }
        return user.first()
    }

    fun deleteById(id: Int) {
        users.removeIf { it.id == id }
    }

    fun save(user: User): User {
        val u = User(++usersCount, user.name, user.birthDate)
        users.add(u)
        return u
    }
}