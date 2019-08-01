import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/pedro/IdeaProjects/chromedriver");
        WebDriver driver;

        // Start Driver and actions initialization (headless mode with fallback to normal mode or simply normal mode)
        if (args.length > 0 && args[0].equals("headless")) {
            try {
                driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                new Automation(driver);
            } catch (Exception err) {
                System.out.println("Headless mode not working properly. Fallback to normal mode !!");
                driver = new ChromeDriver();
                new Automation(driver);
            }
        } else {
            driver = new ChromeDriver();
        }


        // Close browser
        driver.close();
    }
}