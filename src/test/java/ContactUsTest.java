import org.junit.jupiter.api.Test;

public class ContactUsTest extends PlaywrightRunner{
    @Test
    public void contactUsTest() {
        homePage.navigate();
        homePage.navigateToContactUs();
        contactUsPage.fillForm(getProperty("fullName"), getProperty("email"), getProperty("phone"));

        System.out.println();
    }

}
