package Interface;

public class VerifyUserInputDate {
    public static boolean verifyUserInputDate(String userInputDate){ //dd-mm-yyyy
        return userInputDate.matches("^([1-9]|0[1-9]|[12][0-9]|3[01])-([1-9]|0[1-9]|1[0-2])-\\d{4}$");
    }
}
