import Entities.Baggage;
import Entities.Cargo;
import Entities.CargoEntity;
import Parser.ParseJSONFile;
import TransformData.WeightTransform;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class GetWeightInfo {
    public static long getWeightInfoByCargoEntitiesInKg(Map<String, List> cargoAndBaggage, String whatTypeOfCargo /*"Entities.Cargo" or "Entities.Baggage"*/){
        long cargoWeightInKg = 0;
        List<Cargo> cargoObjectList = cargoAndBaggage.get(whatTypeOfCargo);
        for(Cargo cargo: cargoObjectList){
            if(cargo.getWeightUnit().equals("kg")){
                cargoWeightInKg += cargo.getWeight();
            }
            else if (cargo.getWeightUnit().equals("lb")){
                cargoWeightInKg += WeightTransform.transformLbIntoKg(cargo.getWeight());
            }
        }
        return cargoWeightInKg;
    }

    public static long getWeightInfoByCargoEntitiesInLb(Map<String, List> cargoAndBaggage, String whatTypeOfCargo){
        return WeightTransform.transformKgIntoLb(getWeightInfoByCargoEntitiesInKg(cargoAndBaggage, whatTypeOfCargo));
    }

    public static long getTotalWeightInKg(Map<String, List> cargoAndBaggage) {
        return getWeightInfoByCargoEntitiesInKg(cargoAndBaggage, "Entities.Cargo") + getWeightInfoByCargoEntitiesInKg(cargoAndBaggage, "Entities.Baggage");
    }

    public static long getTotalWeightInLb(Map<String, List> cargoAndBaggage){
        return WeightTransform.transformKgIntoLb(getTotalWeightInKg(cargoAndBaggage));
    }

    public static long getTotalNumberPiecesOfBaggage(List<Integer> id) throws IOException, ParseException { //by id
        List<CargoEntity> cargoEntities = new ParseJSONFile("src/main/resources/cargoEntity.json").getArrayOfCargoesObject();
        List<Baggage> baggages = null;
        long pieces = 0;
        for(CargoEntity cargoEntity: cargoEntities){
            for (Integer integer : id) {
                if (cargoEntity.getFlightId() == integer) {
                    baggages = cargoEntity.getBaggages();
                }
            }
        }
        if (baggages != null) {
            for (Baggage baggage : baggages) {
                pieces += baggage.getPieces();
            }
        }
        return pieces;
    }
}
