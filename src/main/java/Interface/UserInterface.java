package Interface;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public class UserInterface {
    public static void run() throws IOException, ParseException, java.text.ParseException {
            ConsoleOutput.showMenu();
            switch (ConsoleInput.requestChoice()){
                case 1:
                    long flightNumber = ConsoleInput.requestFlightNumber();
                    String date = ConsoleInput.requestDate();
                    ConsoleOutput.getInformationForRequestedFlightNumber(flightNumber, date);
                    break;
                case 2:
                    String IATACode = ConsoleInput.requestIATACode();
                    date = ConsoleInput.requestDate();
                    ConsoleOutput.getInformationForRequestedIATACode(IATACode, date);
                    break;
                case 3:
                    ConsoleOutput.exitApp();
                    break;
                default:
                    System.out.println("You enter incorrect number!");
            }
    }
}
