package UserRequests;

import Entities.CargoEntity;
import Entities.FlightEntity;
import Parser.ParseJSONFile;
import TransformData.TransformAndComparisonDates;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRequestCargoInfoByFlightNumber {

    private final long flightNumber;
    private final String userInputDate; //format: dd-mm-yyyy
    private final List<FlightEntity> flightEntitiesObjectList;
    private final List<CargoEntity> cargoEntitiesObjectList;

    public UserRequestCargoInfoByFlightNumber(long flightNumber, String userInputDate) throws IOException, ParseException {
        ParseJSONFile flightEntities = new ParseJSONFile("src/main/resources/flightEntity.json");
        ParseJSONFile cargoEntities = new ParseJSONFile("src/main/resources/cargoEntity.json");
        this.flightEntitiesObjectList = flightEntities.getArrayOfFlightsObject();
        this.cargoEntitiesObjectList = cargoEntities.getArrayOfCargoesObject();
        this.flightNumber = flightNumber;
        this.userInputDate = userInputDate;
    }

    public long getFlightIdByFlightNumber() throws java.text.ParseException {
        for (FlightEntity flightEntityObject : this.flightEntitiesObjectList) {
            if (flightEntityObject.getFlightNumber() == this.flightNumber && TransformAndComparisonDates.compareTwoDates(this.userInputDate, flightEntityObject.getDepartureDate())) {
                return flightEntityObject.getFlightId();
            }
        }
        return -1;
    }
    public Map<String, List> getCargoAndBaggageListByFlightNumber() throws java.text.ParseException {
        Map<String, List> cargoAndBaggage = new HashMap<>();
        if(this.getFlightIdByFlightNumber() != -1){
            for (CargoEntity cargoEntity : this.cargoEntitiesObjectList){
                if(this.getFlightIdByFlightNumber() == cargoEntity.getFlightId()){
                    cargoAndBaggage.put("Entities.Baggage", cargoEntity.getBaggages());
                    cargoAndBaggage.put("Entities.Cargo", cargoEntity.getCargoes());
                }
            }
        }
        return cargoAndBaggage;
    }
}
