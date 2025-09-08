import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        Result result_RBT = JUnitCore.runClasses(RBT_Tests.class);

        for (Failure failure : result_RBT.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }

        System.out.println("All tests successful: " + (result_RBT.wasSuccessful()));
    }
}