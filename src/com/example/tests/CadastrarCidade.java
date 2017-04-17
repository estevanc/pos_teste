package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastrarCidade {
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
  public void testCadastrarCidade() throws Exception {
    driver.get(baseUrl + "/admin");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
    driver.findElement(By.cssSelector("ins.iCheck-helper")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("demoadmin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.xpath("//ul[@id='social-sidebar-menu']/li[9]/a/span")).click();
    driver.findElement(By.linkText("Add")).click();
    driver.findElement(By.id("location")).click();
    driver.findElement(By.id("location")).clear();
    driver.findElement(By.id("location")).sendKeys("Cidade do Teste");
    driver.findElement(By.id("long")).clear();
    driver.findElement(By.id("long")).sendKeys("10");
    driver.findElement(By.id("lat")).clear();
    driver.findElement(By.id("lat")).sendKeys("10");
    driver.findElement(By.cssSelector("button.btn.btn-primary")).click();
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
