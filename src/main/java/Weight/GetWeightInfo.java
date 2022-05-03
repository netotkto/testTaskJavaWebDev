package Weight;

import Entities.CargoEntities.Baggage;
import Entities.CargoEntities.Cargo;
import Entities.CargoEntity;
import Parser.ParseJSONFile;
import Weight.Pound;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetWeightInfo {
    public static long getWeightInfoByCargoEntities(Map<String, List> cargoAndBaggage, String whatTypeOfCargo /*"Entities.CargoEntities.Cargo" or "Entities.CargoEntities.Baggage"*/){
        long cargoWeight = 0;
        List<Cargo> cargoObjectList = cargoAndBaggage.get(whatTypeOfCargo);
        for(Cargo cargo: cargoObjectList){
            if(cargo.getWeightUnit().equals("kg")){
                cargoWeight += cargo.getWeight();
            }
            else if (cargo.getWeightUnit().equals("lb")){
                cargoWeight += new Pound(cargo.getWeight()).transformIntoKg();
            }
        }
        return cargoWeight;
    }



    public static long getTotalNumberPiecesOfBaggage(List<Integer> id) throws IOException, ParseException { //by id
        List<CargoEntity> cargoEntities = new ParseJSONFile("src/main/resources/cargoEntity.json").getArrayOfCargoesObject();
        List<Baggage> baggageList = null;
        long pieces = 0;
        for(CargoEntity cargoEntity: cargoEntities){
            for (Integer integer : id) {
                if (cargoEntity.getFlightId() == integer) {
                    baggageList = cargoEntity.getbaggage();
                }
            }
        }
        if (baggageList != null) {
            for (Baggage baggage : baggageList) {
                pieces += baggage.getPieces();
            }
        }
        return pieces;
    }
}
