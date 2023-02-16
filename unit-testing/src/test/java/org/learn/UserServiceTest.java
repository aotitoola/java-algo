package org.learn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.learn.unitTesting.model.User;
import org.learn.unitTesting.repository.UserDao;
import org.learn.unitTesting.service.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// enables us to use Mockito
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    // mock dependency injection for this class
    @InjectMocks
    UserServiceImpl userService;

    @Mock
    EmailVerificationServiceImpl emailVerificationService;

    @Mock
    UserDao userDao;
    String firstName;
    String lastName;
    String email;
    String password;
    String repeatPassword;

    @BeforeEach
    void init() {
        firstName = "Deji";
        lastName = "Otitoola";
        email = "test@test.com";
        password = "12345678";
        repeatPassword = "12345678";
    }

    @DisplayName("User Object Created")
    @Test
    void testCreateUser_whenDetailsProvided_returnUserObject() {

        // Arrange [Get the data ready]
        // ** we stop working on a test approach as soon as it does not compile or fails
        // code to interface for Service classes
        when(userDao.save(Mockito.any(User.class))).thenReturn(true);

        // Act
        // should return User Object
        User user = userService.createUser(firstName, lastName, email, password, repeatPassword);

        // Assert
        assertNotNull(user, "the createUser() method should not be null");
        assertEquals(firstName, user.getFirstName(), "User's first name is incorrect");
        assertEquals(lastName, user.getLastName(), "User's last name is incorrect");
        assertEquals(email, user.getEmail(), "User's email is incorrect");
        assertNotNull(user.getId(), "User id is missing!");

        // verify that the save method is called exactly one time
        Mockito.verify(userDao, Mockito.times(1)).save(Mockito.any(User.class));
        Mockito.verify(userDao, Mockito.atLeastOnce()).save(Mockito.any(User.class));
    }

    @DisplayName("Empty First name causes correct exception")
    @Test
    void testCreateUser_whenFirstNameIsEmpty_throwsIllegalArgumentException() {
        // Arrange [Get the data ready]
        // ** we stop working on a test approach as soon as it does not compile or fails
        String firstName = "";
        String exceptionMsg = "User's first name is empty.";

        // Act
        IllegalArgumentException thrown =
                assertThrows(IllegalArgumentException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);

        },"Empty first name should have caused an Illegal Argument Exception");

        // validate exception message
        assertEquals(exceptionMsg, thrown.getMessage(), "Exception error message is not correct");


    }


    @DisplayName("If save() method causes RuntimeException, a UserServiceException is thrown")
    @Test
    void testCreateUser_whenSaveMethodThrowsException_thenThrowsUserServiceException() {
        // Arrange
        when(userDao.save(Mockito.any(User.class))).thenThrow(RuntimeException.class);

        // Act & Assert
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);

        }, "should have thrown UserServiceException instead");

    }


    // how stub void methods with exception
    @Test
    void testCreateUser_whenEmailNotificatinExceptionThrown_throwsUserServiceException() {
        // Arrange
        when(userDao.save(Mockito.any(User.class))).thenReturn(true);

        // because we are mocking a void method, we do this
        //  when(emailVerificationService.scheduleEmailConfirmation(Mockito.any(User.class)))
        //                .thenThrow(RuntimeException.class);

        doThrow(EmailNotificationServiceException.class)
                .when(emailVerificationService)
                .scheduleEmailConfirmation(Mockito.any(User.class));

        // this will not throw exception
        // if you do not want to invoke an exception
        //        doNothing().when(emailVerificationService)
        //                .scheduleEmailConfirmation(Mockito.any(User.class));

        // Act & Assert
        assertThrows(UserServiceException.class, () -> {
            userService.createUser(firstName, lastName, email, password, repeatPassword);

        }, "should have thrown UserServiceException instead");

        // verify that emailVerificationService was invoked once
        Mockito.verify(emailVerificationService, Mockito.times(1))
                .scheduleEmailConfirmation(Mockito.any(User.class));

    }


    @Test
    void testCreateUser_whenUserCreated_schedulesEmailConfirmation() {
        // Arrange
        when(userDao.save(Mockito.any(User.class))).thenReturn(true);

        doCallRealMethod().when(emailVerificationService)
                .scheduleEmailConfirmation(any(User.class));

        // Act
        userService.createUser(firstName, lastName, email, password, repeatPassword);

        // verify that emailVerificationService was invoked once
        Mockito.verify(emailVerificationService, Mockito.times(1))
                .scheduleEmailConfirmation(Mockito.any(User.class));
    }



//    @Test
//    void createUser_whenUserCreated_returnUserObjectContainsSameFirstName() {
//
//        // Arrange [Get the data ready]
//        // ** we stop working on a test approach as soon as it does not compile or fails
//        // code to interface for Service classes
//        UserService userService = new UserServiceImpl();
//        String firstName = "Deji";
//        String lastName = "Otitoola";
//        String email = "test@test.com";
//        String password = "12345678";
//
//        // Act
//        // should return User Object
//        User user = userService.createUser(firstName, lastName, email, password);
//
//        // Assert
//        assertEquals(firstName, user.getFirstName(), "User's first name is incorrect");
//    }



}
