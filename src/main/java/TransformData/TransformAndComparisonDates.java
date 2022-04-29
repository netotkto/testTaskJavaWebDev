package TransformData;

import javax.xml.crypto.dsig.Transform;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransformAndComparisonDates {
    private final String userDateInput; //dd-mm-YYYY
    private final String flightDate; //yyyy-mm-dd

    public TransformAndComparisonDates(String userDateInput, String flightDate) {
        this.userDateInput = userDateInput;
        this.flightDate = flightDate;
    }

    public static String transformUserInputDate(String userDateInput) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(userDateInput);
        return String.format("%d-%d-%d", date.getDate(), date.getMonth() + 1, date.getYear() + 1900); //dd-mm-yyyy
    }

    public String transformUserInputDate() throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(this.userDateInput);
        return String.format("%d-%d-%d", date.getDate(), date.getMonth() + 1, date.getYear() + 1900); //dd-mm-yyyy
    }

    public static String transformFlightDate(String flightDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(flightDate);
        return String.format("%d-%d-%d", date.getDate(), date.getMonth() + 1, date.getYear() + 1900); //dd-mm-yyyy
    }

    public String transformFlightDate() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(this.flightDate);
        return String.format("%d-%d-%d", date.getDate(), date.getMonth() + 1, date.getYear() + 1900); //dd-mm-yyyy
    }

    public static boolean compareTwoDates(String userDateInput, String flightDate) throws ParseException { //Format userDate dd-mm-yyyy and Format flightDate yyyy-mm-dd
        return transformUserInputDate(userDateInput).equals(transformFlightDate(flightDate));
    }
}
