 import TransformData.GetStringInfoByFlightNumberList;
 import TransformData.WeightTransform;
import UserRequests.UserRequestCargoInfoByFlightNumber;
 import UserRequests.UserRequestNumberOfFlightsAndPiecesOfBaggageByIATACode;
 import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplicationResponse {
    public static List<String> getResponseFromApplicationWeightInfoByFlightNumber(long flightNumber, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        UserRequestCargoInfoByFlightNumber requestWeightInfo = new UserRequestCargoInfoByFlightNumber(flightNumber, userInputDate);

        Map<String, List> cargoAndBaggageMap = requestWeightInfo.getCargoAndBaggageListByFlightNumber();

        long cargoWeightInKg = GetWeightInfo.getWeightInfoByCargoEntitiesInKg(cargoAndBaggageMap, "Entities.Cargo");
        long cargoWeightInLb = WeightTransform.transformKgIntoLb(cargoWeightInKg);

        long baggageWeightInKg = GetWeightInfo.getWeightInfoByCargoEntitiesInKg(cargoAndBaggageMap, "Entities.Baggage");
        long baggageWeightInLb = WeightTransform.transformKgIntoLb(baggageWeightInKg);

        long totalWeightInKg = baggageWeightInKg + cargoWeightInKg;
        long totalWeightInLb = baggageWeightInLb + cargoWeightInLb;

        List<String> response = new ArrayList<>();

        response.add("It is flight with flight number: " + flightNumber + ",");
        response.add("Cargo Weight in Kg: " + cargoWeightInKg + ", Cargo Weight in Lb: " + cargoWeightInLb + ",");
        response.add("Baggage Weight in Kg: " + baggageWeightInKg + ", Baggage Weight in Lb: " + baggageWeightInLb + ",");
        response.add("Total Weight in Kg: " + totalWeightInKg + ", Total Weight in Lb: " + totalWeightInLb + ";");

        return response;
    }

    public static List<String> getResponseFromApplicationNumberFlightsAndBaggagesInfoByIATACode(String IATACode, String userInputDate) throws IOException, ParseException, java.text.ParseException {
        UserRequestNumberOfFlightsAndPiecesOfBaggageByIATACode requestByIATA = new UserRequestNumberOfFlightsAndPiecesOfBaggageByIATACode(IATACode,userInputDate);
        List<String> response = new ArrayList<>();

        List<Long> departingFlightNumberList = requestByIATA.getDepartingFlightNumberList();
        List<Long> arrivingFlightNumberList = requestByIATA.getArrivingFlightNumberList();

        int numberOfArrivingFlights = requestByIATA.getNumberOfArrivingFlights();
        int numberOfDepartingFlights = requestByIATA.getNumberOfDepartingFlights();

        response.add("Number of flights departing from this airport, (IATA Code: " + IATACode + "): " + numberOfDepartingFlights + ", Flight Numbers: " + GetStringInfoByFlightNumberList.getStringFromFlightNUmberList(departingFlightNumberList));
        response.add("Number of flights arriving to this airport, (IATA Code: " + IATACode + "): " + numberOfArrivingFlights + ", Flight Numbers: " + GetStringInfoByFlightNumberList.getStringFromFlightNUmberList(arrivingFlightNumberList));
        response.add("Total number (pieces) of baggage departing from this airport, (IATA Code: " + IATACode + "): " + GetWeightInfo.getTotalNumberPiecesOfBaggage(requestByIATA.getIdOfDepartingFlights()));
        response.add("Total number (pieces) of baggage arriving to this airport, (IATA Code: " + IATACode + "): " + GetWeightInfo.getTotalNumberPiecesOfBaggage(requestByIATA.getIdOfArrivingFlights()));

        return response;
    }
}
