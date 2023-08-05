import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.MainMenuPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class PlaywrightRunner {
    protected static Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    protected HomePage homePage;
    protected ContactUsPage contactUsPage;
    protected MainMenuPage mainMenuPage;

    @BeforeAll
    public static void init() {
        playwright = Playwright.create();
    }

    @BeforeEach
    public void setUp() {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext();
        page = browserContext.newPage();
        contactUsPage = new ContactUsPage(page);
        homePage = new HomePage(page);
        mainMenuPage = new MainMenuPage(page);
    }

    @AfterEach
    public void tearDown() {
        browserContext.close();
        browser.close();
    }
}
