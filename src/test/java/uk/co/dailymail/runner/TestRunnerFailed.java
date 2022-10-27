package uk.co.dailymail.runner;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "uk/co/dailymail",
        features = "@target/rerun.txt",
        plugin = {"pretty", "html:target/cucumber-report/cucumber.html",
                "com.cucumber.listener.ExtentCucumberFormatter:src/main/java/uk/co/dailymail/testReport/reportFailed.html"
        },
        tags = {}
)
public class TestRunnerFailed {

        @AfterClass
        public static void setUp() {
                String projectPath = System.getProperty("user.dir");
                String reportConfigPath = projectPath + "/src/test/java/resources/extentreport/extent-config.xml";
                Reporter.loadXMLConfig(reportConfigPath);
                Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
                Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
                Reporter.setSystemInfo("Machine", "Windows 11" + "64 Bit");
                Reporter.setSystemInfo("Selenium", "4.0.0");
                Reporter.setSystemInfo("Maven", "3.8.0");
                Reporter.setSystemInfo("Java Version", "1.8.0_121");
        }

}


