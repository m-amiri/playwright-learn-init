import Pages.MainMenuPageEnum;
import Services.EnvironmetReaderService;
import org.junit.jupiter.api.Test;

public class MobileCategoryTest extends PlaywrightRunner{
    @Test
    public void navigateToMobileCategory() {
        page.navigate(EnvironmetReaderService.getProperty("url"));
        mainMenuPage.navigateTo(MainMenuPageEnum.ELECTRONIC_DEVICE);
        mainMenuPage.navigateTo(MainMenuPageEnum.MOBILE);
        System.out.println();
    }
}
