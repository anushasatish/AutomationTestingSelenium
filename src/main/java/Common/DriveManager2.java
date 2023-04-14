package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriveManager2
{
    public WebDriver driver;

    public void createDriver(String browser)
    {
        if (browser.equals("safari"))
        {
            driver = new SafariDriver();
        } else
        {
            driver = new ChromeDriver();
        }
    }

   public void logCommerce()
    {
        //open app
        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

        driver.manage().window().maximize();


        wait(3);

        WebElement usernameElement = driver.findElement(By.xpath ("//input [@value ='admin@yourstore.com']"));
        usernameElement.clear();
        wait(2);
        usernameElement.sendKeys("admin@yourstore.com");
        WebElement passwordElement = driver.findElement(By.name("Password"));
        passwordElement.clear();
        passwordElement.sendKeys("admin");
        wait(2);

        //login

        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();

        wait(2);
    }

    public void wait(int seconds)
    {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException interruptedexception)
        {
            System.out.println(interruptedexception);
        }

    }
    public void quitBrowser()
    {
        //driver.quit();
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        logoutButton.click();

    }
}


