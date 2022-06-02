package allure.notifications;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class FailedTests {
    @Test
    void fail1() {
        assertTrue(false);
    }

    @Test
    void fail2() {
        assertTrue(2>5);
    }

    @Test
    void fail3() {
        assertFalse(2<5);
    }
}
