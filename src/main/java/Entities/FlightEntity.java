package Entities;

import org.json.simple.JSONObject;

public class FlightEntity {
    private final long flightId;
    private final long flightNumber;
    private final String departureAirportIATACode;
    private final String arrivalAirportIATACode;
    private final String departureDate;

    public FlightEntity(JSONObject flightEntity) {
        this.flightId = (long) flightEntity.get("flightId");
        this.flightNumber = (long) flightEntity.get("flightNumber");
        this.departureAirportIATACode = (String) flightEntity.get("departureAirportIATACode");
        this.arrivalAirportIATACode = (String) flightEntity.get("arrivalAirportIATACode");
        this.departureDate = (String) flightEntity.get("departureDate");
    }

    public long getFlightId() {
        return flightId;
    }

    public long getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirportIATACode() {
        return departureAirportIATACode;
    }

    public String getArrivalAirportIATACode() {
        return arrivalAirportIATACode;
    }

    public String getDepartureDate() {
        return departureDate;
    }
}
