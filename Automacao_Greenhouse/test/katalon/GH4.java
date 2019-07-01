package katalon;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GH4 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGH4() throws Exception {
    driver.get("https://lucasfranciscocorreia.github.io/DesenvolvimentoWEB/");
    driver.findElement(By.id("navbarDropdownMenuLink-4")).click();
    driver.findElement(By.id("defaultLoginFormEmail")).click();
    driver.findElement(By.id("defaultLoginFormEmail")).clear();
    driver.findElement(By.id("defaultLoginFormEmail")).sendKeys("gabriel");
    driver.findElement(By.id("defaultLoginFormPassword")).click();
    driver.findElement(By.id("defaultLoginFormPassword")).clear();
    driver.findElement(By.id("defaultLoginFormPassword")).sendKeys("senhacorreta");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forgot password?'])[1]/following::button[1]")).click();
    // Warning: waitForTextPresent may require manual changes
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (driver.findElement(By.cssSelector("BODY")).getText().matches("^[\\s\\S]*Please enter an email address\\.[\\s\\S]*$")) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
