import org.junit.Test;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class googleSearchTest {
    @Test
    public void shouldSearch() {
        open("https://google.com/");

        element(byName("q")).setValue("selenide").pressEnter();

    }
}
