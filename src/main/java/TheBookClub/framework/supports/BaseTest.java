package TheBookClub.framework.supports;

import TheBookClub.framework.tools.Report;
import TheBookClub.framework.webDrivers.DriverFactory;
import TheBookClub.framework.webDrivers.DriverManager;
import TheBookClub.framework.webDrivers.Drivers;
import com.aventstack.extentreports.Status;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static TheBookClub.framework.tools.Report.extentTest;

public class BaseTest extends DriverFactory {

    @BeforeAll
    public static void setUp() {
        Report.configurarExtentReport();
        Report.createTest("TITULO");
        DriverManager.setDriver(getBrowser(Drivers.CHROME));
        DriverManager.getDriver().get("https://www.google.com/");
        extentTest.log(Status.INFO, "Acessou navegador");
    }

    @AfterAll
    public static void tearDown() {
        Report.closeReport();
        DriverManager.quit();
    }

}