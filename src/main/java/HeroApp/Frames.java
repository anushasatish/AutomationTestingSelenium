package HeroApp;

import Common.DriveManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.xpath;


public class Frames extends DriveManager
{
    By fname = By.xpath("//body[contains (text(),'BOTTOM')]");
    By fname1 = By.xpath("//div[contains (text(),'MIDDLE')]");
    By fname2 = By.xpath("//body[contains (text(),'RIGHT')]");
    By fname3 = By.xpath("//body[contains (text(),'LEFT')]");


    //Switching from one frame to other

    @Test
    public void frameTest() throws NoSuchFrameException, NoSuchElementException
    {
        createDriver("chrome");
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        wait(2);

        driver.switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(fname).getText());

        driver.switchTo().defaultContent();
        wait(2);

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(fname1).getText());

        driver.switchTo().defaultContent();
        wait(2);

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-right");
        System.out.println(driver.findElement(fname2).getText());

        driver.switchTo().defaultContent();
        wait(2);

        driver.switchTo().frame("frame-top");

        driver.switchTo().frame("frame-left");
        System.out.println(driver.findElement(fname3).getText());


    }
}