package TransformData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatesManipulation {

    public static boolean verifyUserInputDate(String userInputDate){ //dd-mm-yyyy
        return userInputDate.matches("^([1-9]|0[1-9]|[12][0-9]|3[01])-([1-9]|0[1-9]|1[0-2])-\\d{4}$");
    }
    public static String transformUserInputDate(String userDateInput) throws ParseException {
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(userDateInput);
        return String.format("%d-%d-%d", date.getDate(), date.getMonth() + 1, date.getYear() + 1900); //dd-mm-yyyy
    }

    public static String transformFlightDate(String flightDate) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(flightDate);
        return String.format("%d-%d-%d", date.getDate(), date.getMonth() + 1, date.getYear() + 1900); //dd-mm-yyyy
    }

    public static boolean compareTwoDates(String userDateInput, String flightDate) throws ParseException { //Format userDate dd-mm-yyyy and Format flightDate yyyy-mm-dd
        return transformUserInputDate(userDateInput).equals(transformFlightDate(flightDate));
    }
}
