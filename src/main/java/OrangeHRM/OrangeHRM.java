package OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Scanner;

public class OrangeHRM
{
 static WebDriver driver;
    public static void main(String[] args) throws InterruptedException
    {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter browser : ");
        String browser = sc.nextLine();

        //fire browser
        if (browser.equals("safari"))
        {
            driver = new SafariDriver();
        }
        else
        {
            driver = new ChromeDriver();
        }

        //open app
        driver.get ("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(2000);

        //find username field on page
        WebElement usernameElement  = driver.findElement(By.name("username"));
        //enter username value
        usernameElement.sendKeys("Admin");
        //pwd
        WebElement passwordElement = driver.findElement(By.name("password"));
        passwordElement.sendKeys("admin123");

        //login

        WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
        loginButton.click();

        Thread.sleep(2000);
        driver.quit();

    }
}
