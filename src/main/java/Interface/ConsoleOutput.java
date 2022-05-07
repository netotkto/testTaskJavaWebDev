package Interface;

import Response.ApplicationResponse;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class ConsoleOutput {
    public static void showMenu(){
        System.out.println("==Application. Test Task==");
        System.out.println("Enter 1 to get information for requested FlightNumber and Date");
        System.out.println("Enter 2 to get information for requested IATA Airport Code and Date");
        System.out.println("Enter 3 to exit the application");
    }

    public static void showInfoForRequestedFlightNumber(long flightNumber, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        List<String> responseFromAppByFlightNumberList = ApplicationResponse.getResponseFromApplicationWeightInfo(flightNumber, userInputDate);
        for(String responseString: responseFromAppByFlightNumberList){
            System.out.println(responseString);
        }
    }

    public static void showInfoForRequestedIATACode(String IATACode, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        List<String> responseFromApplicationByIATACode = ApplicationResponse.getResponseFromApplicationNumberFlightsAndBaggageInfo(IATACode, userInputDate);
        for (String responseString: responseFromApplicationByIATACode){
            System.out.println(responseString);
        }
    }

    public static void exitApp(){
        System.out.println("Thank you for using application!");
        System.exit(1);
    }
}
