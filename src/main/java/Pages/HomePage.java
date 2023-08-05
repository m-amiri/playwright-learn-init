package Pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page homePage;
    private static final String URL = "https://www.digikala.com/";
    private static final String CONTACT_US = "div.d-block a[href='/page/contact-us/']";

    public HomePage(Page homePage) {
        this.homePage = homePage;
    }

    public void navigate() {
        homePage.navigate(URL);
    }

    public void navigateToContactUs () {
        homePage.locator(CONTACT_US).click();
    }
}
