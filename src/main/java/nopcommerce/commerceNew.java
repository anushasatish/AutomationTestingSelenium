package nopcommerce;

import Common.DriveManager2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


// Selenium Assignment 1

public class commerceNew extends DriveManager2
{
    //Test Case 4: correct Username and correct password
    // Open chrome browser
    //Maximize the browser
    //Get url:https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F
    //Enter Username: admin@yourstore.com
    //Password: admin
    //Verify the title of the dashboard page after login (nopcommerce)
    //Click on Welcome Admin on the right top corner and select Logout option.

@Test
    public void commerceLogin()
{
    createDriver("chrome");
    //createDriver("safari");

    logCommerce ();
    System.out.println(driver.getTitle());
    wait(2);
    quitBrowser();
}


   /* Test Case 1: Wrong Username and wrong password
    Open chrome browser
    Maximize the browser
    Get url: https://opensource-demo.orangehrmlive.com/
    Enter Username: admin1@yourstore.com
    Password: aadmin
    Get the text of the error message using getText() and verify it in if else condition. Expectation is
    error message should be present and match.*/

@Test
public void comLogin1()
{

    createDriver("chrome");

    driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
    driver.manage().window().maximize();
    wait(3);

    WebElement usernameElement = driver.findElement(By.xpath ("//input [@value ='admin@yourstore.com']"));
    usernameElement.clear();
    wait(2);
    usernameElement.sendKeys("admin1@yourstore.com");
    WebElement passwordElement = driver.findElement(By.name("Password"));
    passwordElement.clear();
    passwordElement.sendKeys("aadmin");
    wait(2);
    WebElement loginButton = driver.findElement(By.className("login-button"));
    loginButton.click();
    String actualmsg1 = driver.findElement(By.xpath("//form/div[contains(.,'Login was unsuccessful. Please correct the errors and try again.')]")).getText();
    //String actualmsg2 = driver.findElement(By.xpath("//ul/li[contains(.,'No customer account found')]")).getText();
    String errormsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";

    System.out.println(actualmsg1);
    //System.out.println(actualmsg2);

    if (errormsg.contentEquals(actualmsg1))
        System.out.println("Correct error msg");
    else
        System.out.println("Incorrect error msg");

    wait(2);
}


   /* Test Case 2: Correct Username and wrong password
    Open chrome browser
    Maximize the browser
    Get url: https://opensource-demo.orangehrmlive.com/
    Enter Username: admin1@yourstore.com
    Password: aadmin
    Get the text of the error message using getText() and verify it in if else condition. Expectation is
    error message should be present and match.*/

    @Test
    public void comLogin2()
    {
        createDriver("chrome");

        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        wait(3);

        WebElement usernameElement = driver.findElement(By.xpath ("//input [@value ='admin@yourstore.com']"));
        usernameElement.clear();
        wait(2);
        usernameElement.sendKeys("admin@yourstore.com");
        WebElement passwordElement = driver.findElement(By.name("Password"));
        passwordElement.clear();
        passwordElement.sendKeys("aadmin");
        wait(2);
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        String actualmsg1 = driver.findElement(By.xpath("//form/div[contains(.,'Login was unsuccessful. Please correct the errors and try again.')]")).getText();
        //String actualmsg2 = driver.findElement(By.xpath("//ul/li[contains(.,'No customer account found')]")).getText();
        String errormsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "The credentials provided are incorrect";

        System.out.println(actualmsg1);
        //System.out.println(actualmsg2);

        if (errormsg.contentEquals(actualmsg1))
            System.out.println("Correct error msg");
        else
            System.out.println("Incorrect error msg");

        wait(2);
    }

    /* Test Case 3: Wrong Username and correct password
    Open chrome browser
    Maximize the browser
    Get url: https://opensource-demo.orangehrmlive.com/
    Enter Username: admin1@yourstore.com
    Password: admin
    Get the text of the error message using getText() and verify it in if else condition. Expectation is
    error message should be present and match.*/

    @Test
    public void comLogin3()
    {
        createDriver("chrome");

        driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        driver.manage().window().maximize();
        wait(3);

        WebElement usernameElement = driver.findElement(By.xpath ("//input [@value ='admin@yourstore.com']"));
        usernameElement.clear();
        wait(2);
        usernameElement.sendKeys("admin1@yourstore.com");
        WebElement passwordElement = driver.findElement(By.name("Password"));
        passwordElement.clear();
        passwordElement.sendKeys("admin");
        wait(2);
        WebElement loginButton = driver.findElement(By.className("login-button"));
        loginButton.click();
        String actualmsg1 = driver.findElement(By.xpath("//form/div[contains(.,'Login was unsuccessful. Please correct the errors and try again.')]")).getText();
        //String actualmsg2 = driver.findElement(By.xpath("//ul/li[contains(.,'No customer account found')]")).getText();
        String errormsg = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";

        System.out.println(actualmsg1);
        //System.out.println(actualmsg2);

        if (errormsg.contentEquals(actualmsg1))
            System.out.println("Correct error msg");
        else
            System.out.println("Incorrect error msg");

        wait(2);
    }


}
