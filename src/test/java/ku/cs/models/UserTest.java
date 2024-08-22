package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Password should not store in plain text")
    public void testPasswordIsNotStoreInPlainText() {
        User user = new User("user01", "plain-p@ssw0rd");
        String actual = user.getPassword();
        String unexpected = "plain-p@ssw0rd";
        assertNotEquals(unexpected, actual);
    }

    @Test
    @DisplayName("Password should be verified by plain text")
    public void testPasswordShouldBeVerified() {
        User user = new User("user01", "plain-p@ssw0rd");
        boolean actual = user.validatePassword("plain-p@ssw0rd");
        assertTrue(actual);
    }

    @Test
    @DisplayName("isUsername should working correctly True if and only if match")
    void testIsUsername() {
        User user = new User("user01", "plain-p@ssw0rd");

        assertTrue(user.isUsername("user01"));
        assertFalse(user.isUsername(""));
        assertFalse(user.isUsername("sun"));
    }

    @Test
    @DisplayName("Should be able to set password and validate password correctly")
    void testSetAndValidatePassword() {
        User user = new User("user01", "plain-p@ssw0rd");

        // should be able to login with old password
        assertTrue(user.validatePassword("plain-p@ssw0rd"));

        user.setPassword("new-pass&*2ord");

        // should be able to login with new password
        assertTrue(user.validatePassword("new-pass&*2ord"));

        // should not be able to login with old password
        assertFalse(user.validatePassword("plain-p@ssw0rd"));
    }

    @Test
    @DisplayName("Should be able to validate password correctly")
    void testValidatePassword() {
        User user = new User("user01", "plain-p@ssw0rd");

        // test in invalid password
        assertFalse(user.validatePassword("new-pass&*2ord"));

        // test in valid password
        assertTrue(user.validatePassword("plain-p@ssw0rd"));
    }
}