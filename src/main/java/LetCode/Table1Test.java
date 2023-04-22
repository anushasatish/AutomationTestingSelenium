package LetCode;

import Common.DriveManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Table1Test extends DriveManager
{
    @Test
    public void table1()
    {
        int sum = 0;
        createDriver("chrome");
        driver.get("https://letcode.in/table");
        wait(2);


        List<WebElement> HeaderElements = driver.findElements(By.xpath("//table[@id='shopping']/thead//th"));
        List<String> headers = new ArrayList<>();

        for (WebElement element : HeaderElements)
        {
            headers.add(element.getText());
        }

        int indexOfPrice = headers.indexOf("Price") + 1;

        List<WebElement> priceElements =  driver.findElements(By.xpath("//table[@id='shopping']/tbody//tr/td["+indexOfPrice+"]"));

        for(WebElement price : priceElements)
        {
            sum = sum + Integer.parseInt(price.getText());
        }

        System.out.println("Sum of elements :: " +sum);

        int totalFromWeb = Integer.parseInt(driver.findElement(By.xpath("//table[@id='shopping']/tfoot/td["+indexOfPrice+"]/b")).getText());

        System.out.println("Total from web table :: " +totalFromWeb);

        Assert.assertEquals(totalFromWeb, sum, "Total is not equal to the result shown in the web");

    }

}
