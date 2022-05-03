package Entities;

import Entities.CargoEntities.Baggage;
import Entities.CargoEntities.Cargo;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CargoEntity {
    private final long flightId;
    private final JSONArray baggage;
    private final JSONArray cargoes;

    public CargoEntity(JSONObject obj) throws IOException, ParseException {
        this.flightId = (long) obj.get("flightId");
        this.baggage = (JSONArray)obj.get("baggage");
        this.cargoes = (JSONArray)obj.get("cargo");
    }

    public long getFlightId() {
        return flightId;
    }

    public List<Baggage> getbaggage() {
        List<Baggage> baggageArray = new ArrayList<>();
        for (Object baggageJSNONObj: this.baggage){
            Baggage baggage = new Baggage((JSONObject) baggageJSNONObj);
            baggageArray.add(baggage);
        }
        return baggageArray;
    }

    public List<Cargo> getCargoes(){
        List<Cargo> cargoesArray = new ArrayList<>();
        for (Object cargoJSNONObj: this.cargoes){
            Cargo cargo = new Cargo((JSONObject) cargoJSNONObj);
            cargoesArray.add(cargo);
        }
        return cargoesArray;
    }
}
