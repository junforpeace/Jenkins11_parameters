package allure.notifications;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Tag("simple")
public class SkippedTests {



  @Test
  @Disabled

    void skip1() {
        String a = "Go easy";
        String b = "On me";

        assertTrue(a==b);
    }
}
