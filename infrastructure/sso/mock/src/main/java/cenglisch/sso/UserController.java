package cenglisch.sso;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers() {
        // Hier können Sie Ihre Benutzerdaten aus einer Datenbank oder einem anderen Speicherort abrufen
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alice", "Smith", "alice@example.com"));
        users.add(new User(2L, "Bob", "Johnson", "bob@example.com"));
        return users;
    }

    private static class User {
        private Long id;
        private String firstName;
        private String lastName;
        private String email;

        public User(Long id, String firstName, String lastName, String email) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }
    }
}
