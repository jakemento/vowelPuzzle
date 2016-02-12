import java.io.*;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;



public class App {
  static String userSentence;
  // static String newSentence;
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";


    get("/", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/results", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String userSentence = request.queryParams("sentence");
      request.session().attribute("sentence", userSentence);

      String alteredSentence = replaceVowels(userSentence);
      model.put("alteredSentence", alteredSentence);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/guess", (request, response) -> {
      HashMap<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/results.vtl");

      String userGuess = request.queryParams("guess");
      String guessResult = guessAnswer(userGuess,
      request.session().attribute("sentence"));


      model.put("guessResult", guessResult);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


  }

  public static String replaceVowels(String userSentence) {
    // userSentence.equals(userSentence);
    String newUserSentence = userSentence.replaceAll("[aeiouAI]","-");

      return newUserSentence;

  }



  public static String guessAnswer(String userGuess, String userSentence) {
    if (userGuess.equals(userSentence)) {
      return ("That is correct! nice work");
    } else {
      return ("Incorrect my friend, guess again!");
    }
    }
}
