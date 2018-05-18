import Components.HomeWindow.HomeView;
import Services.ExceptionHandler;
import org.omg.CORBA.portable.UnknownException;

public class Main {

    public static void main(String[] args) {
        setupGlobalExceptionHandling();
        javax.swing.SwingUtilities.invokeLater(new HomeView());
    }

    private static void setupGlobalExceptionHandling() {
        Thread.setDefaultUncaughtExceptionHandler(
                (Thread t, Throwable e) -> {
                    ExceptionHandler.handle(new UnknownException(e));
                });
    }
}
