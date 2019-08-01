import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

class Automation {
    Automation(WebDriver driver){
        Actions act=new Actions(driver);

        // Set window size to 1366x768
        driver.manage().window().setSize(new Dimension(1366,768));

        // Launch browser and direct it to the URL
        driver.get("https://www.rrrgggbbb.com/");

        // Find letter web elements
        WebElement red_letter=driver.findElement(By.id("R"));
        WebElement green_letter=driver.findElement(By.id("G"));
        WebElement blue_letter=driver.findElement(By.id("B"));

        // Hover red letter web element
        act.moveToElement(red_letter).perform();

        // Assert if the element is hovered (background is red and letter colour is black)
        Assertions(driver,"R");

        // Wait 5 seconds
        Wait();

        // Hover green letter web element (used offset of X -25 because hover targets the middle of the element)
        act.moveToElement(green_letter).moveByOffset(-25,0).perform();

        // Assert if the element is hovered (background is green and letter colour is black)
        Assertions(driver,"G");

        // Wait 5 seconds
        Wait();

        // Hover blue letter web element
        act.moveToElement(blue_letter).perform();

        // Assert if the element is hovered (background is red and letter colour is black)
        Assertions(driver,"B");

        // Wait 5 seconds
        Wait();
    }

    private static void Wait(){
        try{
            Thread.sleep(5000);
        }catch(InterruptedException err){
            System.out.println("Failed to wait a 3 seconds interval !!");
        }
    }

    private String GetBackgroundColor(WebDriver driver){
        return driver.findElement(By.xpath("//body")).getCssValue("background-color");
    }

    private String GetFontColor(WebDriver driver,String color){
        String xpath="//*[@id='"+color+"-fill' and @class='black']";

        return driver.findElement(By.xpath(xpath)).getCssValue("background-color");
    }

    private void Assertions(WebDriver driver,String color){
        String bg_color=GetBackgroundColor(driver);
        String font_color=GetFontColor(driver,color);

        switch(color){
            case"R":
                assert(bg_color.equals("rgba(255, 0, 0, 1)")):"Background color is not red !!";
                assert(font_color.equals("rgba(0, 0, 0, 1)")):"Font color is not black !!";
                break;
            case"G":
                assert(bg_color.equals("rgba(0, 255, 0, 1)")):"Background color is not green !!";
                assert(font_color.equals("rgba(0, 0, 0, 1)")):"Font color is not black !!";
                break;
            case"B":
                assert(bg_color.equals("rgba(0, 0, 255, 1)")):"Background color is not blue !!";
                assert(font_color.equals("rgba(0, 0, 0, 1)")):"Font color is not black !!";
                break;
        }
    }
}
