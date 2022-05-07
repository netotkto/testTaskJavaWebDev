package Interface;

import TransformData.DatesManipulation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {
    static Scanner scanner = new Scanner(System.in);
    public static int requestChoice(){
        System.out.print("Your choice: ");
        try {
            return scanner.nextInt();
        }catch (InputMismatchException e){
            System.out.println("You enter not number!");
            ConsoleOutput.exitApp();
            return 0;
        }
    }

    public static long requestFlightNumber(){
        System.out.print("Flight Number: ");
        try{
            return scanner.nextLong();
        }catch (InputMismatchException e){
            System.out.println("You enter not number!");
            ConsoleOutput.exitApp();
            return 0;
        }
    }

    public static String requestDate(){
        System.out.print("Date (Format: dd-mm-yyyy): ");
        String date = scanner.next();
        if(DatesManipulation.verifyUserInputDate(date)){
            return date;
        }
        else {
            System.out.println("You enter incorrect date! Try one more time");
            return requestDate();
        }
    }

    public static String requestIATACode(){
        System.out.print("Enter IATA Code: ");
        return scanner.next().toUpperCase();
    }
}
