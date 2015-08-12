import org.junit.*;
import static org.junit.Assert.*;
import org.fluentlenium.adapter.FluentTest;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import java.lang.*;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRPSGame extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
    return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Rock Paper Scissors");
  }

  @Test
  public void returnWinner() {
    goTo("http://localhost:4567/");
    find("#oneRock").click();
    find("#twoPaper").click();
    submit(".btn");
    assertThat(pageSource()).contains("Paper");

  }

  @Test
  public void returnWinner_CheckForCorrectWinner_true(){
    RPSGame newGame = new RPSGame();

    assertEquals("Congratulations! Paper Wins!", newGame.returnWinner(0, 1));

  }

  @Test
  public void returnWinner_CheckForTie_true() {
    RPSGame newGame = new RPSGame();

    assertEquals("Congratulations! You Tied!", newGame.returnWinner(1,1));
    }

    @Test
    public void userInput_CheckForCorrectInt_true() {
      RPSGame  newGame = new RPSGame();

      Integer num1 = 1;
      assertEquals(num1, newGame.userInput("paper"));
    }

}
