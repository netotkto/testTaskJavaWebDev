package Entities.CargoEntities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Cargo {
    private final long id;
    private final long weight;
    private final String weightUnit;
    private final long pieces;

    public Cargo(JSONObject baggage) {
        this.id = (long) baggage.get("id");
        this.weight = (long) baggage.get("weight");
        this.weightUnit = (String) baggage.get("weightUnit");
        this.pieces = (long) baggage.get("pieces");
    }

    public long getId() {
        return id;
    }

    public long getWeight() {
        return weight;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public long getPieces() {
        return pieces;
    }

    @Override
    public String toString(){
        return "Id: " + this.id + ", weight: " + this.weight + ", weightUnit: " + this.weightUnit + ", pieces: " + this.pieces;
    }
}