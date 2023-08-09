import Annotations.PlaywrightPages;
import Pages.ContactUsPage;
import Pages.HomePage;
import Pages.MainMenuPage;
import Services.EnvironmetReaderService;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;

@ExtendWith(TestWatcherExtention.class)
public class PlaywrightRunner {
    protected static Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;
    @PlaywrightPages
    protected HomePage homePage;
    @PlaywrightPages
    protected ContactUsPage contactUsPage;
    @PlaywrightPages
    protected MainMenuPage mainMenuPage;

    @BeforeAll
    public static void init() {
        playwright = Playwright.create();
    }

    @BeforeEach
    public void setUp() throws NoSuchMethodException {
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("videos/"))
                .setRecordVideoSize(1920, 1080));
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(true));
        page = browserContext.newPage();
        page.setDefaultTimeout(60000);
        Class<?> clazz = this.getClass().getSuperclass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(PlaywrightPages.class)) {
                Class<?>[] constructorType = {Page.class};
                try {
                    field.set(this, field.getType().getConstructor(constructorType).newInstance(page));
                } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
                    System.out.println("Could not call constructor for page with name: " + this.getClass());
                }
            }
        }
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        browserContext.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("traces/" + testInfo.getDisplayName().replace("()", "") + ".zip")));
        browserContext.close();
        browser.close();
    }

    protected String getProperty(String key) {
        return EnvironmetReaderService.getProperty(key);
    }
}
