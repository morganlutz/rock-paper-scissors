import static java.lang.System.out;

public class RPSGame {
  public static void main(String[] args) {

  }

  public static String returnWinner (Integer userOne, Integer userTwo) {
    if ((userOne == 0 && userTwo == 1) ||
       ( userOne == 1 && userTwo == 0)) {
      return "Congratulations! Paper Wins!";
    } else if ((userOne == 0 && userTwo == 2) ||
              ( userOne == 2 && userTwo == 0)) {
      return "Congratulations! Rock Wins!";
    } else if ((userOne == 1 && userTwo == 2) ||
              ( userOne == 2 && userTwo == 1)) {
      return "Congratulations! Scissors Wins!";
    } else {
      return "Congratulations! You Tied!";
    }


  }

}
