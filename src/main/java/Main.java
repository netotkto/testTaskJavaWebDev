import Interface.ConsoleOutput;
import Interface.UserInterface;
import Response.ApplicationResponse;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        /*
        List<String> responseFromAppByFlightNumberList = ApplicationResponse.getResponseFromApplicationWeightInfo(2005, "16-2-2015");
        for(String responseString: responseFromAppByFlightNumberList){
            System.out.println(responseString);
        }

        List<String> responseFromApplicationByIATACode = ApplicationResponse.getResponseFromApplicationNumberFlightsAndBaggageInfo("MIT", "23-03-2020");
        for (String responseString: responseFromApplicationByIATACode){
            System.out.println(responseString);
        }

        System.out.println(2*0.4536);
        */

        UserInterface.run();
    }

}
