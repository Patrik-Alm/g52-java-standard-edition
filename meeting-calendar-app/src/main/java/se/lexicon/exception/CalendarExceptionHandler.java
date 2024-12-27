package se.lexicon.exception;

import se.lexicon.util.ConsoleColors;

import java.sql.SQLException;

public class CalendarExceptionHandler {

    public static void handleException(Exception exception){

        if (exception instanceof AuthorizationFailedException){
            System.out.println(ConsoleColors.RED + exception.getMessage() + ConsoleColors.RESET);
        }
        else if (exception instanceof UserExpiredException){
            System.out.println(ConsoleColors.YELLOW + exception.getMessage() + ConsoleColors.RESET);
        }
        else if (exception instanceof DBConnectionException){
            System.out.println(ConsoleColors.BLUE + exception.getMessage() + ConsoleColors.RESET);
        }
        else if (exception instanceof SQLException){
            System.out.println(ConsoleColors.YELLOW + exception.getMessage() + ConsoleColors.RESET);
        }else {
            System.out.println(ConsoleColors.RED + exception.getMessage() + ConsoleColors.RESET);
        }


    }
}
