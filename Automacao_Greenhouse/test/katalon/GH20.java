package katalon;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GH20 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    //driver = new ChromeDriver();
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testGH20() throws Exception {
    driver.get("https://lucasfranciscocorreia.github.io/DesenvolvimentoWEB/");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Se inscreva e faça parte da comunidade'])[1]/following::button[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Física'])[1]/following::label[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[1]")).sendKeys("email@gmail.com");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[2]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[2]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[2]")).sendKeys("senha123");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[3]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[3]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[3]")).sendKeys("fulano de tal");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[4]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[4]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[4]")).sendKeys("1112223334445A");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[5]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[5]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[5]")).sendKeys("01001000");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[7]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[7]")).clear();
    Thread.sleep(2000); // espera a rua ser preenchida automaticamente
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[7]")).sendKeys("apartamento");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[8]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[8]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::input[8]")).sendKeys("100");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Jurídica'])[1]/following::button[1]")).click();
    assertEquals("Insira um CNPJ valido", closeAlertAndGetItsText());
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
