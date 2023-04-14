package LetCode;

import Common.DriveManager;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Alert;
import org.testng.Assert;



public class AlertsTest extends DriveManager
{
    //Simple Alert
    @Test
    public void AlertTest1()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");

        wait(2);

        driver.findElement (By.xpath("//button[@id='accept']")).click();

        wait(2);

        String alert1Text = "Hey! Welcome to LetCode";

        Alert alert = driver.switchTo().alert();

        String alertTextFromWeb = alert.getText();

        Assert.assertEquals(alertTextFromWeb, alert1Text, "Simple Alert test is not as expected.");

        alert.accept();

        wait(2);

    }

    //Confirm Alert
    @Test
    public void AlertTest2()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");
        wait(2);

        driver.findElement (By.xpath("//button[@id='confirm']")).click();

        wait(2);

        String alert2Text = "Are you happy with LetCode?";

        Alert alert2 = driver.switchTo().alert();

        String alertTextFromWeb = alert2.getText();

        Assert.assertEquals(alertTextFromWeb, alert2Text, "Confirm Alert test is not as expected.");

        alert2.dismiss();

        wait(2);

        System.out.println(alertTextFromWeb);
    }

    //Prompt Alert
    @Test
    public void AlertTest3()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");
        wait(2);

        driver.findElement (By.xpath("//button[@id='prompt']")).click();
        wait(2);

        Alert alert3 = driver.switchTo().alert();

        alert3.sendKeys("Anu");
        wait(2);

        alert3.accept();

        String msg = "Your name is: Anu";
        String message = driver.findElement(By.xpath("//p[@id='myName']")).getText();

        System.out.println(message);

        Assert.assertEquals(message, msg, "Prompt alert msg is not as expected");


    }

    //Sweet Alert
    @Test
    public void AlertTest4()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/alert");
        wait(2);

        driver.findElement (By.xpath("//button[@id='modern']")).click();
        wait(2);

        String msg1 = "Modern Alert - Some people address me as sweet alert as well";
        String message1 = driver.findElement(By.xpath("//p[contains(text(),'Modern')]")).getText();

        System.out.println(message1);
        Assert.assertEquals(message1, msg1, "Sweet alert msg is not as expected");

        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
        quitBrowser();
    }

}
