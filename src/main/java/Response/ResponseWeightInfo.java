package Response;

import Weight.Kilogram;
import Weight.Pound;

import java.util.ArrayList;
import java.util.List;

public class ResponseWeightInfo {
    private final Kilogram totalWeight;
    private final long flightNumber;
    private final Kilogram cargoWeight;
    private final Kilogram baggageWeight;

    public ResponseWeightInfo(long flightNumber, Kilogram cargoWeight, Kilogram baggageWeight, Kilogram totalWeight) {
        this.flightNumber = flightNumber;
        this.cargoWeight = cargoWeight;
        this.baggageWeight = baggageWeight;
        this.totalWeight = totalWeight;
    }

    public List<String> getStringInfo(){
        List<String> response = new ArrayList<>();

        response.add("It is flight with flight number: " + flightNumber + ",");
        response.add("Cargo Weight in : " + cargoWeight + ", Cargo Weight in Lb: " + new Pound(cargoWeight.transformIntoLb()) + ",");
        response.add("Baggage Weight in : " + baggageWeight + ", Baggage Weight in Lb: " + new Pound (baggageWeight.transformIntoLb()) + ",");
        response.add("Total Weight in : " + totalWeight + ", Total Weight in Lb: " + new Pound (totalWeight.transformIntoLb()) + ";");

        return response;
    }


}
