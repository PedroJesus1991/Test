import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/home/pedro/IdeaProjects/chromedriver");

        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);

        // Set window size to the maximum width and height of the screen,
        driver.manage().window().maximize();

        // launch Fire fox and direct it to the Base URL
        driver.get("https://www.rrrgggbbb.com/");

        WebElement body;

        WebElement red_letter = driver.findElement(By.xpath("//*[@id='letterR']"));
        act.moveToElement(red_letter).perform();

        // Assert if the element is found (background is red)
        driver.findElement(By.xpath("//body[@class='r']"));

        Wait(3);

        WebElement green_letter = driver.findElement(By.xpath("//*[@id='letterG']"));
        act.moveToElement(green_letter).perform();

        // Assert if the element is found (background is green)
        driver.findElement(By.xpath("//body[@class='g']"));

        Wait(3);

        WebElement blue_letter = driver.findElement(By.xpath("//*[@id='letterB']"));
        act.moveToElement(blue_letter).perform();

        // Assert if the element is found (background is blue)
        driver.findElement(By.xpath("//body[@class='b']"));


        Wait(3);

        driver.close();
    }

    private static void Wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException err) {
            System.out.println("Failed to wait a 3 seconds interval !!");
        }
    }
}