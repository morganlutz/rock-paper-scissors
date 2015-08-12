import java.util.Random;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.out;

import java.util.Map;
import java.util.HashMap;

import spark.ModelAndView;

import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


public class RPSGame {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String userInputOne = request.queryParams("userOne");
      String userInputTwo = request.queryParams("userTwo");



      model.put("winner", userInput);

      return new ModelAndView(model,layout);
    }, new VelocityTemplateEngine());

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

  public static Integer computerChoice () {
    Random myRandomGenerator = new Random();
    Integer random = myRandomGenerator.nextInt(3);
    return random;
  }

  public static Integer userInput (String rpsValue) {
    if (rpsValue == "rock") {
      return 0;
    } else if (rpsValue == "paper") {
      return 1;
    } esle {
      return 2;
    }
  }
}
