package LetCode;

import Common.DriveManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.Assert;

public class RadioCheckbox extends DriveManager
{

    //Select 1 option
    @Test
    public void radioTest1() {
    createDriver("chrome");
    driver.get("https://letcode.in/radio");
    wait(2);

    WebElement radio1 = driver.findElement(By.xpath("//input[@id='yes']"));
    WebElement radio2 = driver.findElement(By.xpath("//input[@id='no']"));

    radio1.click();

    if (radio1.isSelected()) {
        System.out.println("Yes is selected");
    } else {
        System.out.println("No is selected");
    }
    quitBrowser();
}

    //Confirm only one option can be selected
    @Test
    public void radioTest2()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        wait(2);

        WebElement opt1 = driver.findElement(By.xpath("//input[@id='one']"));
        WebElement opt2 = driver.findElement(By.xpath("//input[@id='two']"));

        opt1.click();

        /*if (opt1.isSelected())
         Assert.assertTrue((opt2.isSelected()),"opt1 is already selected");*/
        wait(2);
        opt2.click();

        //if (opt2.isSelected())
            Assert.assertTrue((opt1.isSelected()),"opt2 is already selected");
    }

    //Find the bug
    @Test
    public void radioTest3()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        wait(2);

        WebElement bug1 = driver.findElement(By.xpath("//input[@id='nobug']"));
        WebElement bug2 = driver.findElement(By.xpath("//input[@id='bug']"));

        bug1.click();
        bug2.click();

       // if (bug1.isSelected())
             Assert.assertTrue((bug2.isSelected()),"bug1 is already selected");
        wait(2);

       // if (bug2.isSelected())
            Assert.assertTrue((bug1.isSelected()),"bug2 is already selected");
    }

    //Find which one is selected
    @Test
    public void radioTest4()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        wait(2);

        WebElement op1 = driver.findElement(By.xpath("//input[@id='foo']"));
        WebElement op2 = driver.findElement(By.xpath("//input[@id='notfoo']"));
        Assert.assertTrue(op1.isSelected(),"Bar is selected");
    }

    //Confirm last field is disabled
    @Test
    public void radioTest5()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        wait(2);
        WebElement op1 = driver.findElement(By.xpath("//input[@id='going']"));
        WebElement op2 = driver.findElement(By.xpath("//input[@id='notG']"));
        WebElement op3 = driver.findElement(By.xpath("//input[@id='maybe']"));

        Assert.assertTrue(op3.isEnabled(),"Option disabled");
    }

    //Find if checkbox is selected
    @Test
    public void radioTest6()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        wait(2);

        WebElement chk1 = driver.findElement(By.xpath("//*[contains(text(),' Remember me ')] "));

        Assert.assertTrue(chk1.isSelected());
    }
    //Accept the T&C
    @Test
    public void radioTest7()
    {
        createDriver("chrome");
        driver.get("https://letcode.in/radio");
        wait(2);

        WebElement chk2 = driver.findElement(By.xpath("//*[contains(text(),'I agree to the')]"));

        chk2.click();
    }
    }
