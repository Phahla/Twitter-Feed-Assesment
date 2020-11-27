import org.junit.runner.JUnitCore; 
import org.junit.runner.Result; 
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestRunner {

    public static void main(String[] args) {
        System.out.println("=============================== Unit Test Begin ==================================");
        TwitterTester twitterTester = new TwitterTester();
        twitterTester.GivenLengthTwoWhenCheckIfArgsLengthValidThenReturnTrue();
        twitterTester.GivenLengthThreeWhenCheckIfArgsLengthValidThenReturnFalse();
        twitterTester.GivenUserFileWhenInputTypeCheckerThenReturnTrue();
        twitterTester.GivenTweetsFileWhenInputTypeCheckerThenReturnTrue();
        twitterTester.GivenTweetsAndUserFileWhenInputTypeCheckerThenReturnFalse();
        twitterTester.GivenUserFileWhenCheckIfFilesExistThenReturnTrue();
        twitterTester.GivenTweetsFileWhenCheckIfFilesExistThenReturnTrue();
        twitterTester.GivenTweetsAndUserFileWhenCheckIfFilesExistThenReturnFalse();
        twitterTester.GivenStringWhenCheckForGreaterSignThenReturnFalse();
        twitterTester.GivenStringWhenCheckForGreaterSignThenReturnTrue();
        twitterTester.GivenStringWhenCheckIfUserExistsThenReturnFalse();
        twitterTester.GivenStringWhenCheckIfUserExistsThenReturnTrue();
        twitterTester.GivenStringWhenCheckIfTweetsExistsThenReturnFalse();
        twitterTester.GivenStringWhenCheckIfTweetsExistsThenReturnTrue();
        twitterTester.GivenStringWhenCheckIfTweetsLengthThenReturnFalse();
        twitterTester.GivenStringWhenCheckIfTweetsLengthThenReturnTrue();
        twitterTester.GivenStringWhenCheckIfTFollowersExistThenReturnFalse();
        twitterTester.GivenStringWhenCheckIfTFollowersExistThenReturnTrue();
        twitterTester.GivenStringWhenCheckIfUserIsFollowingThenReturnFalse();
        twitterTester.GivenStringWhenCheckIfUserIsFollowingThenReturnTrue();
        twitterTester.GivenATwoDimArrayListWhenGetTwitterUsersThenReturnTrue();
        twitterTester.GivenATwoDimArrayListWhenGetTweetsThenReturnTrue();
        System.out.println("=============================== Unit Test End ====================================");
    }
}
