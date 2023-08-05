import org.junit.jupiter.api.Test;

public class ContactUsTest extends PlaywrightRunner{
    @Test
    public void contactUsTest() {
        homePage.navigate();
        homePage.navigateToContactUs();
        contactUsPage.fillForm();

        System.out.println();
    }

}
