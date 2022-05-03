package Response;

import Response.ResponseWeightInfo;
 import TransformData.GetStringFlightNumberList;
 import UserRequests.UserRequestCargoInfo;
 import UserRequests.UserRequestNumberOfFlightsAndPiecesOfBaggage;
import Weight.GetWeightInfo;
import Weight.Kilogram;
 import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplicationResponse {
    public static List<String> getResponseFromApplicationWeightInfo(long flightNumber, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        UserRequestCargoInfo requestWeightInfo = new UserRequestCargoInfo(flightNumber, userInputDate);

        Map<String, List> cargoAndBaggageMap = requestWeightInfo.getCargoAndBaggageList();

        Kilogram cargoWeight = new Kilogram(GetWeightInfo.getWeightInfoByCargoEntities(cargoAndBaggageMap, "Entities.CargoEntities.Cargo"));
        Kilogram baggageWeight = new Kilogram(GetWeightInfo.getWeightInfoByCargoEntities(cargoAndBaggageMap, "Entities.CargoEntities.Baggage"));
        Kilogram totalWeight = new Kilogram(baggageWeight.getValue() + cargoWeight.getValue());

        return new ResponseWeightInfo(flightNumber, cargoWeight, baggageWeight, totalWeight).getStringInfo();
    }

    public static List<String> getResponseFromApplicationNumberFlightsAndBaggageInfo(String IATACode, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        UserRequestNumberOfFlightsAndPiecesOfBaggage requestByIATA = new UserRequestNumberOfFlightsAndPiecesOfBaggage(IATACode,userInputDate);
        List<String> response = new ArrayList<>();

        List<Long> departingFlightNumberList = requestByIATA.getDepartingFlightNumberList();
        List<Long> arrivingFlightNumberList = requestByIATA.getArrivingFlightNumberList();

        int numberOfArrivingFlights = requestByIATA.getNumberOfArrivingFlights();
        int numberOfDepartingFlights = requestByIATA.getNumberOfDepartingFlights();

        response.add("Number of flights departing from this airport, (IATA Code: " + IATACode + "): " + numberOfDepartingFlights + ", Flight Numbers: " + GetStringFlightNumberList.getStringFlightNumberList(departingFlightNumberList));
        response.add("Number of flights arriving to this airport, (IATA Code: " + IATACode + "): " + numberOfArrivingFlights + ", Flight Numbers: " + GetStringFlightNumberList.getStringFlightNumberList(arrivingFlightNumberList));
        response.add("Total number (pieces) of baggage departing from this airport, (IATA Code: " + IATACode + "): " + GetWeightInfo.getTotalNumberPiecesOfBaggage(requestByIATA.getIdOfDepartingFlights()));
        response.add("Total number (pieces) of baggage arriving to this airport, (IATA Code: " + IATACode + "): " + GetWeightInfo.getTotalNumberPiecesOfBaggage(requestByIATA.getIdOfArrivingFlights()));

        return response;
    }

}
