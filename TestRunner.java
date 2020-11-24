import org.junit.runner.JUnitCore; 
import org.junit.runner.Result; 
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRunner {

    public static void main(String[] args) {
        System.out.println("=============================== Unit Test Begin ==================================");
        TwitterTester twitterTester = new TwitterTester();

        System.out.println("=============================== Unit Test End ====================================");
    }
}
