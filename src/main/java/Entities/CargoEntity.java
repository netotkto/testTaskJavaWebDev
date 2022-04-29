package Entities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargoEntity {
    private final long flightId;
    private final JSONArray baggages;
    private final JSONArray cargoes;

    public CargoEntity(JSONObject obj) throws IOException, ParseException {
        this.flightId = (long) obj.get("flightId");
        this.baggages = (JSONArray)obj.get("baggage");
        this.cargoes = (JSONArray)obj.get("cargo");
    }

    public long getFlightId() {
        return flightId;
    }

    public List<Baggage> getBaggages() {
        List<Baggage> baggagesArray = new ArrayList<Baggage>();
        for (Object baggageJSNONObj: this.baggages){
            Baggage baggage = new Baggage((JSONObject) baggageJSNONObj);
            baggagesArray.add(baggage);
        }
        return baggagesArray;
    }

    public List<Cargo> getCargoes(){
        List<Cargo> cargoesArray = new ArrayList<Cargo>();
        for (Object cargoJSNONObj: this.cargoes){
            Cargo cargo = new Cargo((JSONObject) cargoJSNONObj);
            cargoesArray.add(cargo);
        }
        return cargoesArray;
    }
}
