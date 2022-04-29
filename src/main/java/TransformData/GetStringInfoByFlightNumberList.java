package TransformData;

import java.util.List;

public class GetStringInfoByFlightNumberList {
    public static String getStringFromFlightNUmberList(List<Long> flightNumberList){
        String response = "-";
        if(flightNumberList.size() == 0){
            return response;
        }
        else {
            return flightNumberList.toString().replace("[", "").replace("]", "");
        }
    }
}
