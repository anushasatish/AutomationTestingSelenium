package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriveManager {
    public WebDriver driver;

    public void createDriver(String browser) {
        if (browser.equals("safari")) {
            driver = new SafariDriver();
        } else {
            driver = new ChromeDriver();
        }
    }

    public void loginOrangeHRM() {
        //open app
       driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");


        wait(3);

        //find username field on page
        WebElement usernameElement = driver.findElement(By.name("username"));
        //enter username value
        usernameElement.sendKeys("Admin");
        //pwd
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("admin123");

        //login

        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        wait(2);
    }

    public void wait(int seconds) {
        try
        {
            Thread.sleep(seconds * 1000);
        }
        catch (InterruptedException interruptedException)
        {
            System.out.println(interruptedException);
        }

    }
    public void quitBrowser()
    {
        driver.quit();
    }
}
