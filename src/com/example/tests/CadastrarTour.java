package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastrarTour {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette","C:\\eclipse\\geckodriver-v0.14.0-win64\\geckodriver.exe");
    driver = new FirefoxDriver();
    baseUrl = "http://www.phptravels.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCadastrarTour() throws Exception {
    driver.get(baseUrl + "/admin");
    driver.findElement(By.cssSelector("ins.iCheck-helper")).click();
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
    driver.findElement(By.name("password")).sendKeys("demoadmin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Tours")).click();
    driver.findElement(By.cssSelector("#Tours > li > a")).click();
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    driver.findElement(By.name("tourname")).clear();
    driver.findElement(By.name("tourname")).sendKeys("Tour Teste");
    driver.findElement(By.name("maxadult")).clear();
    driver.findElement(By.name("maxadult")).sendKeys("2");
    driver.findElement(By.name("adultprice")).clear();
    driver.findElement(By.name("adultprice")).sendKeys("2");
    driver.findElement(By.id("adultbtn")).click();
    new Select(driver.findElement(By.name("tourstars"))).selectByVisibleText("5");
    driver.findElement(By.name("tourdays")).clear();
    driver.findElement(By.name("tourdays")).sendKeys("2");
    driver.findElement(By.name("tournights")).clear();
    driver.findElement(By.name("tournights")).sendKeys("2");
    driver.findElement(By.id("add")).click();
    driver.findElement(By.cssSelector("a.navbar-brand > span")).click();
    driver.findElement(By.linkText("Log Out")).click();
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
