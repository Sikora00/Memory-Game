import Components.HomeWindow.HomeView;
import Services.ExceptionHandler;

public class Main {

    public static void main(String[] args) {
        setupGlobalExceptionHandling();
        javax.swing.SwingUtilities.invokeLater(new HomeView());
    }

    private static void setupGlobalExceptionHandling() {
        Thread.setDefaultUncaughtExceptionHandler(
                (Thread t, Throwable e) -> {
                    ExceptionHandler.handle(e);
                });
    }
}
