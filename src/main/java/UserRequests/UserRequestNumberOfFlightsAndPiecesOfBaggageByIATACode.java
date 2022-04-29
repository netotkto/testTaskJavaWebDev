package UserRequests;

import Entities.CargoEntity;
import Entities.FlightEntity;
import Parser.ParseJSONFile;
import TransformData.TransformAndComparisonDates;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRequestNumberOfFlightsAndPiecesOfBaggageByIATACode {
    private final String IATACode;
    private final String userInputDate; //dd-mm-yyyy
    private final List<FlightEntity> flightEntitiesObjectList;
    private final List<CargoEntity> cargoEntitiesObjectList;

    public UserRequestNumberOfFlightsAndPiecesOfBaggageByIATACode(String IATACode, String userInputDate) throws IOException, ParseException {
        ParseJSONFile flightEntities = new ParseJSONFile("src/main/resources/flightEntity.json");
        ParseJSONFile cargoEntities = new ParseJSONFile("src/main/resources/cargoEntity.json");
        this.flightEntitiesObjectList = flightEntities.getArrayOfFlightsObject();
        this.cargoEntitiesObjectList = cargoEntities.getArrayOfCargoesObject();
        this.IATACode = IATACode;
        this.userInputDate = userInputDate;
    }

    public List<FlightEntity> getFlightsDepartingFromThisAirportByIATA() throws java.text.ParseException { //get list of Entities.FlightEntity objects departing from airport
        List<FlightEntity> flightEntities = new ArrayList<>();
        for(FlightEntity flightEntity: this.flightEntitiesObjectList){
            if(flightEntity.getDepartureAirportIATACode().equals(this.IATACode) && TransformAndComparisonDates.compareTwoDates(this.userInputDate, flightEntity.getDepartureDate())){
                flightEntities.add(flightEntity);
            }
        }
        return flightEntities;
    }
    public List<FlightEntity> getFlightsArrivingToThisAirportByIATA() throws java.text.ParseException { //get list of Entities.FlightEntity objects arriving to airport
        List<FlightEntity> flightEntities = new ArrayList<>();
        for(FlightEntity flightEntity: this.flightEntitiesObjectList){
            if(flightEntity.getArrivalAirportIATACode().equals(this.IATACode) && TransformAndComparisonDates.compareTwoDates(this.userInputDate, flightEntity.getDepartureDate())){
                flightEntities.add(flightEntity);
            }
        }
        return flightEntities;
    }

    public int getNumberOfDepartingFlights() throws java.text.ParseException {
        return this.getFlightsDepartingFromThisAirportByIATA().size();
    }

    public int getNumberOfArrivingFlights() throws java.text.ParseException {
        return this.getFlightsArrivingToThisAirportByIATA().size();
    }

    public List<Integer> getIdOfDepartingFlights() throws java.text.ParseException {
        List<Integer> id = new ArrayList<>();
        for(FlightEntity flightEntity: this.getFlightsDepartingFromThisAirportByIATA()){
            id.add((int) flightEntity.getFlightId());
        }
        return id;
    }
    public List<Integer> getIdOfArrivingFlights() throws java.text.ParseException {
        List<Integer> id = new ArrayList<>();
        for(FlightEntity flightEntity: this.getFlightsArrivingToThisAirportByIATA()){
            id.add((int) flightEntity.getFlightId());
        }
        return id;
    }

    public List<Long> getArrivingFlightNumberList() throws java.text.ParseException {
        List<Long> flightNumberList = new ArrayList<>();
        for(FlightEntity flightEntity: this.getFlightsArrivingToThisAirportByIATA()){
            flightNumberList.add(flightEntity.getFlightNumber());
        }
        return flightNumberList;
    }

    public List<Long> getDepartingFlightNumberList() throws java.text.ParseException {
        List<Long> flightNumberList = new ArrayList<>();
        for(FlightEntity flightEntity: this.getFlightsDepartingFromThisAirportByIATA()){
            flightNumberList.add(flightEntity.getFlightNumber());
        }
        return flightNumberList;
    }
}
