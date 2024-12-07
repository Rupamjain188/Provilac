package utils;

import java.io.File;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import Variables_Properties.configProperties;

public class Extended_Report {
    private static ExtentReports ExReport;

    public static ExtentReports GenrateExtendReport() {
        if (ExReport == null) { // Ensure single instance
            ExReport = new ExtentReports();
            File ExtentReportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReport\\extentreport.html");
            
            ExtentSparkReporter sparkReport = new ExtentSparkReporter(ExtentReportFile);
            
            sparkReport.config().setTheme(Theme.DARK);
            sparkReport.config().setReportName("Provilac Report");
            sparkReport.config().setDocumentTitle("Provilac Automation Report");
            sparkReport.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
            
            ExReport.attachReporter(sparkReport);
            ExReport.setSystemInfo("Application URL", configProperties.property.getProperty("url"));
            ExReport.setSystemInfo("Application Browser Name", configProperties.getProperty("browserName"));
            ExReport.setSystemInfo("Email Id Used", configProperties.getProperty("Email"));
            ExReport.setSystemInfo("Operating System Used", configProperties.getProperty("opratingSystem"));
        }
        return ExReport;
    }
}
