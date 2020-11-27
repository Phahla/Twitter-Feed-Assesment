import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;

import java.util.*;
import java.io.File;
import org.junit.Test;

public class TwitterTester {
    
    ErrorHandling errorHandling = new ErrorHandling();
    Users users = new Users();
    Tweets tweets = new Tweets();

    TwitterTester(){}

   

    @Test 
    public void GivenLengthTwoWhenCheckIfArgsLengthValidThenReturnTrue(){
        int givenValue = 2;
        boolean expectedValue = true;

        boolean result = errorHandling.checkIfArgsLengthValid(givenValue);
        assertEquals(expectedValue, result);
        System.out.println("Test 1 passed");
    } 
 
    @Test 
    public void GivenLengthThreeWhenCheckIfArgsLengthValidThenReturnFalse(){
        int givenValue = 3;
        boolean expectedValue = false;

        boolean result = errorHandling.checkIfArgsLengthValid(givenValue);
        assertEquals(expectedValue, result);
        System.out.println("Test 2 passed");
    }

    //====================================================================================

    @Test
    public void GivenUserFileWhenInputTypeCheckerThenReturnTrue() {
        String givenValue1 = "user.tt";
        String givenValue2 = "tweets.txt";

        boolean expectedValue = true;
        try {
            errorHandling.inputFileTypeChecker(givenValue1,givenValue2);

        } catch(Exception e) {
            String expectedMessage = ValidationCodes.invalidUserFileType.toString("",0);
            assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
            System.out.println("Test 3 passed");
        }
    }

    @Test
    public void GivenTweetsFileWhenInputTypeCheckerThenReturnTrue() {
        String givenValue1 = "user.txt";
        String givenValue2 = "tweets.tt";

        boolean expectedValue = true;
        try {
            errorHandling.inputFileTypeChecker(givenValue1,givenValue2);

        } catch(Exception e) {
            String expectedMessage = ValidationCodes.invalidTweetFileType.toString("",0);
            assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
            System.out.println("Test 4 passed");
        }
    }

    @Test
    public void GivenTweetsAndUserFileWhenInputTypeCheckerThenReturnFalse() {
        String givenValue1 = "user.txt";
        String givenValue2 = "tweets.txt";

        try {
            errorHandling.inputFileTypeChecker(givenValue1,givenValue2);

            String message = ValidationCodes.valid.toString("",0);
            String expectedMessage = "";
            assertEquals(expectedMessage,message);
            System.out.println("Test 5 passed");

        } catch(Exception e) {
        }
    }
   
    //=====================================================================================
   
    @Test
    public void GivenUserFileWhenCheckIfFilesExistThenReturnTrue() {

        File givenFile1 = new File( "non.txt");
        File givenFile2 = new File("tweets.txt");
        boolean expectedValue = true;
        try {
            errorHandling.checkIfFilesExist(givenFile1,givenFile2);

        } catch(Exception e) {
            String expectedMessage = ValidationCodes.userFileNotExist.toString("",0);
            assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
            System.out.println("Test 6 passed");
        }
    }

    @Test
    public void GivenTweetsFileWhenCheckIfFilesExistThenReturnTrue() {
        File givenFile1 = new File("users.txt");
        File givenFile2 = new File("tweet.txt");
        boolean expectedValue = true;
        try {
            errorHandling.checkIfFilesExist(givenFile1,givenFile2);

        } catch(Exception e) {
            String expectedMessage = ValidationCodes.tweetsFileNotExist.toString("",0);
            assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
            System.out.println("Test 7 passed");
        }
    }

    @Test
    public void GivenTweetsAndUserFileWhenCheckIfFilesExistThenReturnFalse() {
        File givenFile1 = new File("users.txt");
        File givenFile2 = new File("tweets.txt");

        try {
            errorHandling.checkIfFilesExist(givenFile1,givenFile2);

            String message = ValidationCodes.valid.toString("",0);
            String expectedMessage = "";
            assertEquals(expectedMessage,message);
            System.out.println("Test 8 passed");

        } catch(Exception e) {
        }
    }

    //=====================================================================================

    @Test
    public void GivenStringWhenCheckForGreaterSignThenReturnFalse() {
        String givenString = " Mike tweets";
        int givenLine = 0;
        boolean expectedValue = true;
        try {
            errorHandling.checkForGreaterSign(givenString,givenLine);

        } catch(Exception e) {
            String expectedMessage = ValidationCodes.greaterNotSignExists.toString("",givenLine);
            assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
            System.out.println("Test 9 passed");
        }
    }

    @Test
    public void GivenStringWhenCheckForGreaterSignThenReturnTrue() {
        String givenString = " Mike > tweets";
        int givenLine = 0;
        boolean expectedValue = true;

        try {
            errorHandling.checkForGreaterSign(givenString,givenLine);

            String message = ValidationCodes.valid.toString("",0);
            String expectedMessage = "";
            assertEquals(expectedMessage,message);
            System.out.println("Test 10 passed");

        } catch(Exception e) {
        }
    }

        //=====================================================================================

        @Test
        public void GivenStringWhenCheckIfUserExistsThenReturnFalse() {
            String givenString = "";
            int givenLine = 0;
            boolean expectedValue = true;
            try {
                errorHandling.checkIfUserExists(givenString,givenLine);
    
            } catch(Exception e) {
                String expectedMessage = ValidationCodes.userNotExists.toString("",givenLine);
                assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
                System.out.println("Test 11 passed");
            }
        }
    
        @Test
        public void GivenStringWhenCheckIfUserExistsThenReturnTrue() {
            String givenString = " Mike ";
            int givenLine = 0;
            boolean expectedValue = true;
    
            try {
                errorHandling.checkIfUserExists(givenString,givenLine);
    
                String message = ValidationCodes.valid.toString("",0);
                String expectedMessage = "";
                assertEquals(expectedMessage,message);
                System.out.println("Test 12 passed");
    
            } catch(Exception e) {
            }
        }

                //=====================================================================================

                @Test
                public void GivenStringWhenCheckIfTweetsExistsThenReturnFalse() {
                    String givenString = "";
                    int givenLine = 0;
                    boolean expectedValue = true;
                    try {
                        errorHandling.checkIfTweetExists(givenString,givenLine);
            
                    } catch(Exception e) {
                        String expectedMessage = ValidationCodes.tweetNotExist.toString("",givenLine);
                        assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
                        System.out.println("Test 13 passed");
                    }
                }
            
                @Test
                public void GivenStringWhenCheckIfTweetsExistsThenReturnTrue() {
                    String givenString = " Mike ";
                    int givenLine = 0;
                    boolean expectedValue = true;
            
                    try {
                        errorHandling.checkIfTweetExists(givenString,givenLine);
            
                        String message = ValidationCodes.valid.toString("",0);
                        String expectedMessage = "";
                        assertEquals(expectedMessage,message);
                        System.out.println("Test 14 passed");
            
                    } catch(Exception e) {
                    }
                }

                //=====================================================================================

                @Test
                public void GivenStringWhenCheckIfTweetsLengthThenReturnFalse() {
                    String givenString = "plpknknsknksnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnndppppppppppppppppppppppppppppppppppppppppppppppppppppppppppldplllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll";
                    int givenLine = 0;
                    boolean expectedValue = true;
                    try {
                        errorHandling.checkTweetLength(givenString,givenLine);
            
                    } catch(Exception e) {
                        String expectedMessage = ValidationCodes.tweetLengthTooLong.toString("",givenLine);
                        assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
                        System.out.println("Test 15 passed");
                    }
                }
            
                @Test
                public void GivenStringWhenCheckIfTweetsLengthThenReturnTrue() {
                    String givenString = " Mike is a new user ";
                    int givenLine = 0;
                    boolean expectedValue = true;
            
                    try {
                        errorHandling.checkTweetLength(givenString,givenLine);
            
                        String message = ValidationCodes.valid.toString("",0);
                        String expectedMessage = "";
                        assertEquals(expectedMessage,message);
                        System.out.println("Test 16 passed");
            
                    } catch(Exception e) {
                    }
                }

                //=====================================================================================

                @Test
                public void GivenStringWhenCheckIfTFollowersExistThenReturnFalse() {
                    String givenString = "";
                    int givenLine = 0;
                    boolean expectedValue = true;
                    try {
                        errorHandling.checkIfFollowsExists(givenString,givenLine);
            
                    } catch(Exception e) {
                        String expectedMessage = ValidationCodes.followsNotExist.toString("",givenLine);
                        assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
                        System.out.println("Test 17 passed");
                    }
                }
            
                @Test
                public void GivenStringWhenCheckIfTFollowersExistThenReturnTrue() {
                    String givenString = "Mike follows Veranld, Alfred ";
                    int givenLine = 0;
                    boolean expectedValue = true;
            
                    try {
                        errorHandling.checkIfFollowsExists(givenString,givenLine);
            
                        String message = ValidationCodes.valid.toString("",0);
                        String expectedMessage = "";
                        assertEquals(expectedMessage,message);
                        System.out.println("Test 18 passed");
            
                    } catch(Exception e) {
                    }
                }

                //=====================================================================================

                @Test
                public void GivenStringWhenCheckIfUserIsFollowingThenReturnFalse() {
                    String givenString = "";
                    int givenLine = 0;
                    boolean expectedValue = true;
                    try {
                        errorHandling.checkIfUserIsFollowingAnyone(givenString,givenLine);
            
                    } catch(Exception e) {
                        String expectedMessage = ValidationCodes.followingPeopleNotExist.toString("",givenLine);
                        assertEquals(expectedValue,e.getMessage().contains(expectedMessage));
                        System.out.println("Test 19 passed");
                    }
                }
            
                @Test
                public void GivenStringWhenCheckIfUserIsFollowingThenReturnTrue() {
                    String givenString = "Mike follows Veranld, Alfred ";
                    int givenLine = 0;
                    boolean expectedValue = true;
            
                    try {
                        errorHandling.checkIfUserIsFollowingAnyone(givenString,givenLine);
            
                        String message = ValidationCodes.valid.toString("",0);
                        String expectedMessage = "";
                        assertEquals(expectedMessage,message);
                        System.out.println("Test 20 passed");
            
                    } catch(Exception e) {
                    }
                }

                //====================================================================================

                @Test 
                public void GivenATwoDimArrayListWhenGetTwitterUsersThenReturnTrue(){
                    ArrayList<ArrayList<String>> givenList = new ArrayList<ArrayList<String>>();
                    boolean expectedValue = true;
            

                    boolean result = false;
                    if(givenList.equals(users.getTwitterUsers())){
                        result = true;
                    }
                    assertEquals(expectedValue, result);
                    System.out.println("Test 21 passed");
                } 
             
                @Test 
                public void GivenATwoDimArrayListWhenGetTweetsThenReturnTrue(){
                    ArrayList<ArrayList<String>> givenList = new ArrayList<ArrayList<String>>();
                    boolean expectedValue = true;
            

                    boolean result = false;
                    if(givenList.equals(tweets.getTweets())){
                        result = true;
                    }
                    assertEquals(expectedValue, result);
                    System.out.println("Test 22 passed");
                } 
            
}


