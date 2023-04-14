package OrangeHRM;

import Common.DriveManager;
import org.testng.annotations.Test;

public class PrintAllPages  extends DriveManager
{
    @Test
    public void printPages()
    {
        createDriver("chrome");
        loginOrangeHRM();
        quitBrowser();

    }


}
