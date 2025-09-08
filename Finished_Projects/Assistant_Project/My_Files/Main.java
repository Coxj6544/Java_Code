import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        Result result_A = JUnitCore.runClasses(AssistantTest.class);
        Result result_AC = JUnitCore.runClasses(AssistantCentreTest.class);
        
        for (Failure failure : result_A.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }

        for (Failure failure : result_AC.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }

        System.out.println("All tests successful: " + (result_A.wasSuccessful() && result_AC.wasSuccessful()));
    }
}
