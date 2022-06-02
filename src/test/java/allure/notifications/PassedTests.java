package allure.notifications;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class PassedTests {

    @Test

    void pass1() {

        assertTrue(5<3);
    }

    @Test
    void pass2() {
        assertFalse(3>9);
    }
    @Test
    void pass3() {
        assertTrue(15>9);
    }

}

