package My_Files;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Main {
    public static void main(String[] args) {
        Result result_WT = JUnitCore.runClasses(WordTracker.class);

        for (Failure failure : result_WT.getFailures()) {
            System.out.println("Test failed: " + failure.toString());
        }

        System.out.println("All tests successful: " + (result_WT.wasSuccessful()));
    }
}
