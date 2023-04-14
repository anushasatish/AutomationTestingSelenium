package LetCode;

import Common.DriveManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetCodeTest extends DriveManager
{
    By FruitsDD = By.xpath("//select[@id='fruits']");
    By SuperHeroDD = By.xpath("//select[@id='superheros']");

    //DropDown 1 Fruits
    @Test
    public void dropDown()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        wait(2);

        Select select = new Select(driver.findElement(FruitsDD));
        select.selectByVisibleText("Mango");

        String notification = driver.findElement(By.xpath("//p[@class='subtitle']")).getText();
        Assert.assertTrue(notification.contains("Mango"));


        //DropDown 2 Superheroes

        List<String> superHeroes = Arrays.asList("Ant-Man","Batman","Iron Man");
        Select select1 = new Select(driver.findElement(SuperHeroDD));

        if (select1.isMultiple())
        {

            for(String superHero:superHeroes)
            {
                select1.selectByVisibleText(superHero);
            }

        }
        else
        {
            select1.selectByVisibleText("Superman");
        }

        List <WebElement> selectedOptions = select1.getAllSelectedOptions();
        List<String> superHeroesFromWeb = new ArrayList<>();

        for ( WebElement option : selectedOptions)
        {
            superHeroesFromWeb.add(option.getText());
        }

        Assert.assertTrue(superHeroesFromWeb.containsAll(superHeroes));

    }

    //Dropdown 3 Programming language
    @Test
    public void progLangDD()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        wait(2);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='lang']")));
        List<WebElement> allOptions = select.getOptions();

        System.out.println("The languages are : ");

        for(WebElement option:allOptions)
        {
            System.out.println(option.getText());
        }
        select.selectByVisibleText(allOptions.get(allOptions.size()-1).getText());

    }

    //Dropdown 4 countries - select India

    @Test
    public void country()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/dropdowns");
        wait(2);

        Select select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
        List<WebElement> countries =select.getOptions();

        select.selectByValue("India");
        System.out.println(select.getFirstSelectedOption().getText());



    }
}
