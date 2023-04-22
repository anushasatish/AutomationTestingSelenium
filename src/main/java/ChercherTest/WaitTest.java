package ChercherTest;

import Common.DriveManager;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitTest extends DriveManager
{
    @Test
    public void test1()
    {
        createDriver("chrome");
        driver.get("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#alert")).click();
        WebDriverWait alertwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertwait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Text :: " +driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        quitBrowser();
    }

    @Test
    public void test2()
    {
        createDriver("chrome");
        driver.get("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#populate-text")).click();
        WebDriverWait alertwait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        alertwait1.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("#h2"),"Selenium Webdriver"));

        System.out.println(driver.findElement(By.cssSelector("#h2")).getText());
        quitBrowser();
    }

    @Test
    public void test3()
    {
        createDriver("chrome");
        driver.get("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#display-other-button")).click();
        WebDriverWait alertwait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        alertwait2.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#hidden")));

    }

    @Test
    public void test4()
    {
        createDriver("chrome");
        driver.get("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#enable-button")).click();
        WebDriverWait alertwait3 = new WebDriverWait(driver, Duration.ofSeconds(10));

        alertwait3.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#disable")));

        System.out.println(driver.findElement(By.cssSelector("#disable")).getText());


    }

    @Test
    public void test5()
    {
        createDriver("chrome");
        driver.get("https://chercher.tech/practice/explicit-wait");

        driver.findElement(By.cssSelector("#checkbox")).click();
        WebDriverWait alertwait4 = new WebDriverWait(driver, Duration.ofSeconds(10));

        alertwait4.until(ExpectedConditions.elementToBeSelected(By.cssSelector("#ch")));

    }


}
