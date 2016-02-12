import java.io.*;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
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

      String alteredSentence = replaceVowels(userSentence);
      model.put("alteredSentence", alteredSentence);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }




  public static String replaceVowels(String userSentence) {
    String newUserSentence = userSentence.replaceAll("[a,e,i,o,u,A,I]","-");
      return newUserSentence;
  }
}
