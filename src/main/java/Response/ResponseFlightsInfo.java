package Response;

import TransformData.GetStringFlightNumberList;
import Weight.GetWeightInfo;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ResponseFlightsInfo {
    private final String IATACode;
    private final List<Long> departingFlightNumberList;
    private final List<Long> arrivingFlightNumberList;
    private final int numberOfArrivingFlights;
    private final int numberOfDepartingFlights;
    private final List<Integer> idOfDepartingFlights;
    private final List<Integer> idOfArrivingFlights;

    public ResponseFlightsInfo(String IATACode,
                               List<Long> departingFlightNumberList,
                               List<Long> arrivingFlightNumberList,
                               int numberOfArrivingFlights,
                               int numberOfDepartingFlights,
                               List<Integer> idOfDepatringFlights,
                               List<Integer> idOfArrivingFlights
                               ){
        this.IATACode = IATACode;
        this.departingFlightNumberList = departingFlightNumberList;
        this.arrivingFlightNumberList = arrivingFlightNumberList;
        this.numberOfArrivingFlights = numberOfArrivingFlights;
        this.numberOfDepartingFlights = numberOfDepartingFlights;
        this.idOfDepartingFlights = idOfDepatringFlights;
        this.idOfArrivingFlights = idOfArrivingFlights;

    }
    public List<String> getStringInfo() throws IOException, ParseException {
        List<String> response = new ArrayList<>();

        response.add("Number of flights departing from this airport, (IATA Code: " + IATACode + "): " + numberOfDepartingFlights + ", Flight Numbers: " + GetStringFlightNumberList.getStringFlightNumberList(departingFlightNumberList));
        response.add("Number of flights arriving to this airport, (IATA Code: " + IATACode + "): " + numberOfArrivingFlights + ", Flight Numbers: " + GetStringFlightNumberList.getStringFlightNumberList(arrivingFlightNumberList));
        response.add("Total number (pieces) of baggage departing from this airport, (IATA Code: " + IATACode + "): " + GetWeightInfo.getTotalNumberPiecesOfBaggage(idOfDepartingFlights));
        response.add("Total number (pieces) of baggage arriving to this airport, (IATA Code: " + IATACode + "): " + GetWeightInfo.getTotalNumberPiecesOfBaggage(idOfArrivingFlights));

        return response;
    }
}
