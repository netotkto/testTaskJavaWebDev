package Parser;

import Entities.CargoEntity;
import Entities.FlightEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseJSONFile {
    private final JSONArray entities;

    public ParseJSONFile(String path) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object obj = jsonParser.parse(reader);
        this.entities = (JSONArray) obj;
    }

    public JSONArray getEntities() {
        return entities;
    }

    public List<FlightEntity> getArrayOfFlightsObject(){
        JSONArray flightEntitiesJSONArray = this.getEntities();
        List<FlightEntity> flightEntitiesObjectArray = new ArrayList<>();
        for (Object flightEntity: flightEntitiesJSONArray){
            flightEntitiesObjectArray.add(new FlightEntity((JSONObject) flightEntity));
        }
        return flightEntitiesObjectArray;
    }
    public List<CargoEntity> getArrayOfCargoesObject() throws IOException, ParseException {

        JSONArray cargoEntitiesJSONArray = this.getEntities();
        List<CargoEntity>cargoEntitiesObjectArray = new ArrayList<>();
        for (Object cargoEntity: cargoEntitiesJSONArray) {
            cargoEntitiesObjectArray.add(new CargoEntity((JSONObject) cargoEntity));
        }
        return  cargoEntitiesObjectArray;
    }
}
