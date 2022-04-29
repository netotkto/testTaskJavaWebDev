import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class UserInterface {
    public static void showMenu(){
        System.out.println("==Application. Test Task==");
        System.out.println("Enter 1 to get information for requested FlightNumber and Date");
        System.out.println("Enter 2 to get information for requested IATA Airport Code and Date");
        System.out.println("Enter 3 to exit the application");
        System.out.print("Your choice: ");
    }

    public static void getInformationForRequestedFlightNumber(long flightNumber, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        List<String> responseFromAppByFlightNumberList = ApplicationResponse.getResponseFromApplicationWeightInfoByFlightNumber(flightNumber, userInputDate);
        for(String responseString: responseFromAppByFlightNumberList){
            System.out.println(responseString);
        }
    }

    public static void getInformationForRequestedIATACode(String IATACode, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        List<String> responseFromApplicationByIATACode = ApplicationResponse.getResponseFromApplicationNumberFlightsAndBaggagesInfoByIATACode(IATACode, userInputDate);
        for (String responseString: responseFromApplicationByIATACode){
            System.out.println(responseString);
        }
    }

    public static void exitApp(){
        System.out.println("Thank you for using application!");
        System.exit(1);
    }
}
