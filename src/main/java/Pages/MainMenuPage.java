package Pages;

import com.microsoft.playwright.Page;

public class MainMenuPage {
    private final Page mainMenuPage;
    private static final String LOCATION = "span[data-cro-id='header-main-menu']";
    private static final String MOBILE = "div[class*='h-full flex-column'] a[href='/main/mobile/']";

    public MainMenuPage(Page mainMenuPage) {
        this.mainMenuPage = mainMenuPage;
    }

    public void navigateTo(MainMenuPageEnum category) {
        mainMenuPage.locator(LOCATION).hover();
        mainMenuPage.locator(category.getSelector()).click();
    }
}
