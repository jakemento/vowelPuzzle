import java.io.*;

import org.apache.commons.lang.StringUtils;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    // String layout = "templates/layout.vtl";
    //
    // get("/", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/home.vtl");
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
    //
    // get("/results", (request, response) -> {
    //   HashMap<String, Object> model = new HashMap<String, Object>();
    //   model.put("template", "templates/detector.vtl");
    //
    //   String userSentence = request.queryParams("sentence");
    //
    //   String alteredSentence = replaceWord(userSentence, wordToReplace, replaceWith);
    //   model.put("alteredSentence", alteredSentence);
    //   return new ModelAndView(model, layout);
    // }, new VelocityTemplateEngine());
  }




//   public static String replaceVowels(String userSentence, String wordToReplace, String replaceWith) {
//     String[] userSentenceArray = userSentence.split("\\s+");
//     for (Integer i = 0 ; i < userSentenceArray.length ; i++){
//       if (wordToReplace.equals(userSentenceArray[i])) {
//         userSentenceArray[i] = replaceWith;
//       }
//     }
//     String newSentence = StringUtils.join(userSentenceArray, " ");
//     return newSentence;
//   }
}
