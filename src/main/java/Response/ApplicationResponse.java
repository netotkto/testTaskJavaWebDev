package Response;

import UserRequests.RequestCargoInfoByFlightNumber;
import UserRequests.RequestFlightsInfoByIATA;
import Weight.GetWeightInfo;
import Weight.Kilogram;
 import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplicationResponse {
    public static List<String> getResponseFromApplicationWeightInfo(long flightNumber, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        RequestCargoInfoByFlightNumber requestWeightInfo = new RequestCargoInfoByFlightNumber(flightNumber, userInputDate);

        Map<String, List> cargoAndBaggageMap = requestWeightInfo.getCargoAndBaggageList();

        Kilogram cargoWeight = new Kilogram(GetWeightInfo.getWeightInfoByCargoEntities(cargoAndBaggageMap, "Cargo"));
        Kilogram baggageWeight = new Kilogram(GetWeightInfo.getWeightInfoByCargoEntities(cargoAndBaggageMap, "Baggage"));
        Kilogram totalWeight = new Kilogram(baggageWeight.getValue() + cargoWeight.getValue());

        return new ResponseWeightInfo(flightNumber, cargoWeight, baggageWeight, totalWeight).getStringInfo();
    }

    public static List<String> getResponseFromApplicationNumberFlightsAndBaggageInfo(String IATACode, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        RequestFlightsInfoByIATA requestByIATA = new RequestFlightsInfoByIATA(IATACode,userInputDate);
        List<String> response = new ArrayList<>();

        List<Long> departingFlightNumberList = requestByIATA.getDepartingFlightNumberList();
        List<Long> arrivingFlightNumberList = requestByIATA.getArrivingFlightNumberList();

        List<Integer> idOfDepartingFlights = requestByIATA.getIdOfDepartingFlights();
        List<Integer> idOfArrivingFlights = requestByIATA.getIdOfArrivingFlights();

        int numberOfArrivingFlights = requestByIATA.getNumberOfArrivingFlights();
        int numberOfDepartingFlights = requestByIATA.getNumberOfDepartingFlights();

        return new ResponseFlightsInfo(IATACode, departingFlightNumberList, arrivingFlightNumberList, numberOfArrivingFlights, numberOfDepartingFlights, idOfDepartingFlights, idOfArrivingFlights).getStringInfo();
    }

}
