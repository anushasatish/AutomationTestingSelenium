package SeleniumTest;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FirstSelenium {
    public static void main(String[] args)
    {
        ChromeDriver chromedriver = new ChromeDriver();
        chromedriver.get ("https://www.amazon.ca/");

        SafariDriver  safaridriver = new SafariDriver();
        safaridriver.get ("https://www.amazon.ca/");


    }
}
