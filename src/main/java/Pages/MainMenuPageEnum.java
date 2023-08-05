package Pages;

public enum MainMenuPageEnum {
    MOBILE("div[class*='h-full flex-column'] a[href='/main/mobile/']"),
    ELECTRONIC_DEVICE("div[class*='h-full flex-column'] a[href='/main/electronic-devices/']");
    private String category;

    MainMenuPageEnum(String category) {
        this.category = category;
    }

    public String getSelector() {
        return category;
    }
}
