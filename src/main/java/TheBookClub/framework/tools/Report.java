package TheBookClub.framework.tools;

import TheBookClub.framework.utils.CreateFolder;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Report {

    public static WebDriver driver;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static final String CAMINHO_REPORT = System.getProperty("user.dir")
            + File.separator + "src" + File.separator + "main"
            + File.separator + "resources" + File.separator + "report";
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;

    public static void configurarExtentReport(){
        CreateFolder.createDirectory(CAMINHO_REPORT);

        sparkReporter = new ExtentSparkReporter(CAMINHO_REPORT + File.separator + "ReportTestSpark.html");

        sparkReporter.config().setDocumentTitle("The Book Clube");
        sparkReporter.config().setReportName("The Book Clube");
        sparkReporter.config().setEncoding("UTF-8");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extentReports = new ExtentReports();

        extentReports.attachReporter(sparkReporter);
    }

    public static void createTest(String testName){
        extentTest = extentReports.createTest(testName);
        test.set(extentTest);
    }

    public static void closeReport(){
        extentReports.flush();
        if (driver!=null){
            driver.quit();
            driver = null;
        }
    }

}