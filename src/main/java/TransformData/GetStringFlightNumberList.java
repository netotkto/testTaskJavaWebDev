package TransformData;

import java.util.List;

public class GetStringFlightNumberList {
    public static String getStringFlightNumberList(List<Long> flightNumberList){
        String response = "-";
        if(flightNumberList.size() == 0){
            return response;
        }
        else {
            return flightNumberList.toString().replace("[", "").replace("]", "");
        }
    }
}
