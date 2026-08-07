import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

// org.junit.jupiter.api.Test is fully qualified here: the class under test is also named Test.
class TestMainTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream captured;

    @BeforeEach
    void redirectStdout() {
        captured = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captured, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    void restoreStdout() {
        System.setOut(originalOut);
    }

    @org.junit.jupiter.api.Test
    void mainPrintsBothEmployees() {
        Test.main(new String[0]);

        assertEquals(
                String.join(System.lineSeparator(), "Guldu 1120", "Dinhga 1122")
                        + System.lineSeparator(),
                captured.toString(StandardCharsets.UTF_8));
    }

    @org.junit.jupiter.api.Test
    void classIsInstantiable() {
        assertNotNull(new Test());
    }
}
