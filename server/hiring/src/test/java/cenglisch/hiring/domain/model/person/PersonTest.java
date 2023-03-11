package cenglisch.hiring.domain.model.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    @Test
    public void testLastNameValidation() {

    }

    @Test
    public void testFirstNameValidation() {

    }

    private void invalidEmailAssertion(String email) {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Person(
                    "s",
                    "s",
                    email
            );
        });
        assertEquals(
                "provide a valid email",
                exception.getMessage()
        );
    }

    @Test
    public void testInvalidEmails() {
        invalidEmailAssertion("plainaddress");
        invalidEmailAssertion("#@%^%#$@#$@#.com");
        invalidEmailAssertion("@example.com");
        invalidEmailAssertion("Joe Smith <email@example.com>");
        invalidEmailAssertion("email.example.com");
        invalidEmailAssertion("email@example@example.com");
        invalidEmailAssertion(".email@example.com");
        invalidEmailAssertion("email.@example.com");
        invalidEmailAssertion("email..email@example.com");
        invalidEmailAssertion("あいうえお@example.com");
        invalidEmailAssertion("email@example.com (Joe Smith)");
        invalidEmailAssertion("email@example");
        invalidEmailAssertion("email@-example.com");
        invalidEmailAssertion("email@example..com");
        invalidEmailAssertion("Abc..123@example.com");
    }

    private void testValidEmail(String email) {
        var person = new Person(
                "s",
                "s",
                email
        );
        assertEquals(
                email,
                person.getEmail()
        );
    }

    @Test
    public void testValidEmails() {
        testValidEmail("email@example.com");
        testValidEmail("firstname.lastname@example.com");
        testValidEmail("email@subdomain.example.com");
        testValidEmail("firstname+lastname@example.com");
        testValidEmail("email@123.123.123.123");
        testValidEmail("email@[123.123.123.123]");
        testValidEmail("\"email\"@example.com");
        testValidEmail("1234567890@example.com");
        testValidEmail("email@example-one.com");
        testValidEmail("_______@example.com");
        testValidEmail("email@example.name");
        testValidEmail("email@example.museum");
        testValidEmail("email@example.co.jp");
        testValidEmail("firstname-lastname@example.com");
    }
}