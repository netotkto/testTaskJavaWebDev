import Entities.CargoEntity;
import Entities.FlightEntity;
import Parser.ParseJSONFile;
import TransformData.TransformAndComparisonDates;
import UserRequests.UserRequestCargoInfoByFlightNumber;
import UserRequests.UserRequestNumberOfFlightsAndPiecesOfBaggageByIATACode;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, ParseException, java.text.ParseException {
        List<String> responseFromAppByFlightNumberList = ApplicationResponse.getResponseFromApplicationWeightInfoByFlightNumber(2005, "16-2-2015");
        for(String responseString: responseFromAppByFlightNumberList){
            System.out.println(responseString);
        }

        List<String> responseFromApplicationByIATACode = ApplicationResponse.getResponseFromApplicationNumberFlightsAndBaggagesInfoByIATACode("MIT", "23-03-2020");
        for (String responseString: responseFromApplicationByIATACode){
            System.out.println(responseString);
        }

    }

}
