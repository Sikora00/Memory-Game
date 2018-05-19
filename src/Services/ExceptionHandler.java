package Services;

import Components.Common.ErrorDialog;
import Components.Common.UnknowErrorDialog;
import Components.Common.ValidationErrorDialog;

import java.util.Arrays;

public class ExceptionHandler {
    public static void handle(Throwable e) {
        switch (e.getClass().getSimpleName()) {
            case "RankingStorageNotFoundException": {
                new ErrorDialog("Ranking storage not found").open();
                break;
            }
            case "ValidationException": {
                new ValidationErrorDialog(e.getMessage()).open();
                break;
            }
            case "UnknownException": {
                new UnknowErrorDialog().open();
                break;
            }
            case "SerializationException":
            case "DeserializationException": {
                new ErrorDialog(e.getMessage()).open();
                break;
            }
            default: {
                ExceptionHandler.handle(new UnknownError());
                break;
            }
        }
    }
}
