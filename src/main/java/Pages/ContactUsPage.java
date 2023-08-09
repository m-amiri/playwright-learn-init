package Pages;

import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ContactUsPage {
    private final Page contactUsPage;
    private static final String CATEGORY = "form.d-flex div.pos-relative";
    private static final String TOPIC = "li[value='3']";
    private static final String REGISTER_BUTTON = "div.jc-end-lg button.styles_btn--primary__y0GEv";
    private static final String FULL_NAME = "input[name='fullName']";
    private static final String EMAIL = "ایمیل*";
    private static final String PHONE = "input[name='phone']";
    private static final String MESSAGE_BOX = "textarea[name='message']";

    public ContactUsPage(Page page) {
        this.contactUsPage = page;
    }

    public void fillForm(String fullName, String email, String phone) {
        contactUsPage.locator(CATEGORY).click();
        contactUsPage.locator(TOPIC).click();
        assertThat(contactUsPage.locator(REGISTER_BUTTON))
                .hasClass(Pattern.compile(".*styles_btn--disabled.*"));
        contactUsPage.locator(FULL_NAME).fill(fullName);
        contactUsPage.getByLabel(EMAIL).fill(email);
        contactUsPage.locator(PHONE).fill(phone);
        contactUsPage.locator(MESSAGE_BOX).fill("The prices in digikala are very EXPENSIVE");
        assertThat(contactUsPage.locator(REGISTER_BUTTON)).not().hasClass(Pattern.compile(".*styles_btn--disabled.*"));
    }


}
