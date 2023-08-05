import Pages.MainMenuPageEnum;
import org.junit.jupiter.api.Test;

public class MobileCategoryTest extends PlaywrightRunner{
    @Test
    public void navigateToMobileCategory() {
        homePage.navigate();
        mainMenuPage.navigateTo(MainMenuPageEnum.ELECTRONIC_DEVICE);
        mainMenuPage.navigateTo(MainMenuPageEnum.MOBILE);
        System.out.println();
    }
}
