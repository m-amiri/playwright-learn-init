import org.junit.jupiter.api.Test;

public class FirstTest extends PlaywrightRunner{
    @Test
    public void firstTest(){
        page.navigate("https://www.google.com/");
        System.out.println();
    }
}
