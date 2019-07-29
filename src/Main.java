import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Main {

    public static void main(String[] args) {
        String bg_color, font_color;
        System.setProperty("webdriver.chrome.driver", "/home/pedro/IdeaProjects/chromedriver");

        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);

        // Set window size to the maximum width and height of the screen,
        driver.manage().window().maximize();

        // launch browser and direct it to the URL
        driver.get("https://www.rrrgggbbb.com/");

        WebElement red_letter = driver.findElement(By.id("R"));
        act.moveToElement(red_letter).perform();

        // Assert if the element is found (background is red and letter colour is black)
        bg_color = driver.findElement(By.xpath("//body")).getCssValue("background-color");
        font_color = driver.findElement(By.xpath("//*[@id='R-fill' and @class='black']")).getCssValue("background-color");
        assert (bg_color.equals("rgba(255, 0, 0, 1)")) : "Background color is not red !!";
        assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";

        Wait();

        WebElement green_letter = driver.findElement(By.id("G"));
        act.moveToElement(green_letter).moveByOffset(-100, 0).perform();

        // Assert if the element is found (background is green and letter colour is black)
        bg_color = driver.findElement(By.xpath("//body")).getCssValue("background-color");
        font_color = driver.findElement(By.xpath("//*[@id='G-fill' and @class='black']")).getCssValue("background-color");
        assert (bg_color.equals("rgba(255, 0, 0, 1)")) : "Background color is not green !!";
        assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";

        Wait();

        WebElement blue_letter = driver.findElement(By.id("B"));
        act.moveToElement(blue_letter).perform();

        // Assert if the element is found (background is red and letter colour is black)
        bg_color = driver.findElement(By.xpath("//body")).getCssValue("background-color");
        font_color = driver.findElement(By.xpath("//*[@id='B-fill' and @class='black']")).getCssValue("background-color");
        assert (bg_color.equals("rgba(0, 0, 255, 1)")) : "Background color is not blue !!";
        assert (font_color.equals("rgba(0, 0, 0, 1)")) : "Font color is not black !!";

        Wait();

        driver.close();
    }

    private static void Wait() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException err) {
            System.out.println("Failed to wait a 3 seconds interval !!");
        }
    }
}