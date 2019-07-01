package katalon;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GH41 {
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
  public void testGH41() throws Exception {
    driver.get("https://lucasfranciscocorreia.github.io/DesenvolvimentoWEB/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Se inscreva e faça parte da comunidade'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CRIAR CONTA'])[1]/following::label[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[1]")).sendKeys("teste@gmail.com");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[2]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[2]")).sendKeys("senha123");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[3]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[3]")).sendKeys("fulano de tal");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::label[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[1]")).sendKeys("01/01/2000");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[2]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[2]")).sendKeys("01001000");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[4]")).clear();
	Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[4]")).sendKeys("apartamento");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::div[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[5]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::input[5]")).sendKeys("100");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='F'])[1]/following::button[1]")).click();
    assertEquals("Preencha todos os campos corretamente", closeAlertAndGetItsText());
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
