package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList userList;
    @BeforeEach
    void setUp() {
        userList = new UserList();
        userList.addUser("John", "123");
        userList.addUser("Jane", "456");
        userList.addUser("Jack", "789");
    }


    @Test
    @DisplayName("User should be found in UserList")
    public void testUserListFindUser() {
        // TODO: add 3 users to UserList
        // I DID IT


        // TODO: find one of them
        String target = "Jane";
        User targetUser = userList.findUserByUsername("Jane");


        // TODO: assert that UserList found User
        // String expected = "<one of username>";
        // String actual = user.getUsername();
        assertEquals("Jane", targetUser.getUsername());
        assertNull(userList.findUserByUsername("BAIBA"));
    }

    @Test
    @DisplayName("User should be null if not found")
    public void testIfUserNotInUserList() {
        assertNull(userList.findUserByUsername("BAIBA"));
    }

    @Test
    @DisplayName("User can change password")
    public void testUserCanChangePassword() {
        // TODO: add 3 users to UserList
        // I DID IT
        // TODO: change password of one user
        boolean canChange = userList.changePassword("John","123","555");

        // TODO: assert that user can change password
        // assertTrue(actual);
        assertTrue(canChange);

    }

    @Test
    @DisplayName("User with correct password can login")
    public void testUserListShouldReturnObjectIfUsernameAndPasswordIsCorrect() {
        // TODO: add 3 users to UserList
        // did it

        // TODO: call login() with correct username and password
        User loggedInUser = userList.login("Jane","456");


        // TODO: assert that User object is found
        assertEquals(userList.findUserByUsername("Jane"), loggedInUser);
    }

    @Test
    @DisplayName("User with incorrect password cannot login")
    public void testUserListShouldReturnNullIfUsernameAndPasswordIsIncorrect() {
        // TODO: add 3 users to UserList
        // did it

        // TODO: call login() with incorrect username or incorrect password
        User loggedInUser = userList.login("Jack","456");

        // TODO: assert that the method return null
        assertNull(loggedInUser);
    }


    @Test
    @DisplayName("UserList should be able to add new user")
    void testAddUser() {
        userList.addUser("Marine", "123kkk");

        assertNotNull(userList.findUserByUsername("Marine"));
        assertEquals("Marine", userList.findUserByUsername("Marine").getUsername());
    }

}