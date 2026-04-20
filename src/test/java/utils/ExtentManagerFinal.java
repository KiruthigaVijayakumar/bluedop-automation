package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManagerFinal {
	
	public static ExtentReports getReport() {

        ExtentSparkReporter spark =
                new ExtentSparkReporter("reports/BluedopReport.html");

        spark.config().setReportName("Bluedop Automation Report");
        spark.config().setDocumentTitle("Automation Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        return extent;}
}
