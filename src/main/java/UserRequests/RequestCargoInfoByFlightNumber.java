package UserRequests;

import Entities.CargoEntity;
import Entities.FlightEntity;
import Interface.ConsoleOutput;
import Parser.ParseJSONFile;
import TransformData.DatesManipulation;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestCargoInfoByFlightNumber {

    private final long flightNumber;
    private final String userInputDate; //format: dd-mm-yyyy
    private final List<FlightEntity> flightEntitiesObjectList;
    private final List<CargoEntity> cargoEntitiesObjectList;

    public RequestCargoInfoByFlightNumber(long flightNumber, String userInputDate) throws IOException, ParseException {
        ParseJSONFile flightEntities = new ParseJSONFile("src/main/resources/flightEntity.json");
        ParseJSONFile cargoEntities = new ParseJSONFile("src/main/resources/cargoEntity.json");
        this.flightEntitiesObjectList = flightEntities.getListOfFlightsObject();
        this.cargoEntitiesObjectList = cargoEntities.getListOfCargoesObject();
        this.flightNumber = flightNumber;
        this.userInputDate = userInputDate;
    }

    public long getFlightIdByFlightNumber() throws java.text.ParseException {
        for (FlightEntity flightEntityObject : this.flightEntitiesObjectList) {
            if (flightEntityObject.getFlightNumber() == this.flightNumber && DatesManipulation.compareTwoDates(this.userInputDate, flightEntityObject.getDepartureDate())) {
                return flightEntityObject.getFlightId();
            }
        }
        System.out.println("There no matches");
        ConsoleOutput.exitApp();
        return -1;
    }
    public Map<String, List> getCargoAndBaggageList() throws java.text.ParseException {
        Map<String, List> cargoAndBaggage = new HashMap<>();
        if(this.getFlightIdByFlightNumber() != -1){
            for (CargoEntity cargoEntity : this.cargoEntitiesObjectList){
                if(this.getFlightIdByFlightNumber() == cargoEntity.getFlightId()){
                    cargoAndBaggage.put("Baggage", cargoEntity.getBaggage());
                    cargoAndBaggage.put("Cargo", cargoEntity.getCargoes());
                }
            }
        }
        return cargoAndBaggage;
    }
}
