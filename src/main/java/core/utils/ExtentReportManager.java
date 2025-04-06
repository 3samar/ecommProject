package core.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {
    private static ExtentReports extent;

    public static ExtentReports getReportInstance() {
        if (extent == null) {
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);

            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Tester", "YourName");
        }
        return extent;
    }
}
