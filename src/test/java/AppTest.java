import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();
  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("a puzzle for you");
  }
  @Test
  public void replaceVowels() {
    goTo("http://localhost:4567");
    fill("#sentence").with("a new test");
    submit(".btn");
    assertThat(pageSource()).contains("- n-w t-st");
  }

  @Test
  public void replaceVowels_findsAnyVowelsAndReplacesThemWithHyphens() {
    App testApp = new App();
    assertEquals("th-s -s - s-mpl- -np-t s-nt-nc-", testApp.replaceVowels("this is a sample input sentence"));
  }
}
