package utils;

import com.rajatthareja.reportbuilder.Color;
import com.rajatthareja.reportbuilder.ReportBuilder;
import org.json.JSONObject;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReportUtils {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private static DateFormat dateFormatFile = new SimpleDateFormat("dd-M-yyyy");
    private static Date date = new Date();

    public static void gerar(){
        ReportBuilder reportBuilder = new ReportBuilder();
        reportBuilder.setReportDirectory("target/report/");
        reportBuilder.setReportFileName(dateFormatFile.format(date));
        reportBuilder.setReportTitle("Sr.Barriga");
        reportBuilder.setReportColor(Color.CYAN);
        reportBuilder.enableVoiceControl();
        reportBuilder.setAdditionalInfo("Environment", "My Environment");
        reportBuilder.setAdditionalInfo("Date", dateFormat.format(date));
        List<Object> cucumberJsonReports = new ArrayList<>();
        cucumberJsonReports.add(new File("target/cucumber.json"));
        reportBuilder.build(cucumberJsonReports);
    }
}
