package junit;

import static org.junit.jupiter.api.Assertions.*;

import com.giomodiogo.business.LoginService;
import com.giomodiogo.exception.InvalidPasswordException;
import com.giomodiogo.helper.AppHelper;
import org.junit.jupiter.api.*;

import java.util.logging.Logger;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnitSampleTests {
    Logger logger = Logger.getLogger(JUnitSampleTests.class.getName());

    private LoginService loginService;

    @BeforeAll
    void setup() {
        loginService = new LoginService();
        loginService.login();
        logger.info("BeforeAll");
    }

    @AfterAll
    void finish() {
        loginService.logout();
        assertFalse(loginService.isLogged());
        logger.info("AfterAll");
    }

    @BeforeEach
    void loggingTime() {
        logger.info(String.valueOf(System.currentTimeMillis()));
    }

    @Test
    void didLogin() {
        assertTrue(loginService.isLogged());
    }

    @Test
    void removeLetterFromText() {
        String expected = "SDF";
        String actual = "ASDFA";
        assertEquals(expected, AppHelper.removeLetter(actual, "A"));
    }

    @Test
    void onlyEvenNumbers() {
        Integer[] expected = {2, 4, 6};
        Integer[] actual = {1, 2, 3, 4, 5, 6};

        assertArrayEquals(expected, AppHelper.returnsEven(actual));
    }

    @Test
    void checkInvalidPassword() {
        assertThrows(InvalidPasswordException.class, () -> this.loginService.validatesPassword("12345"));
    }
}
