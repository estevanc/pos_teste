package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroCarro {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.firefox.marionette","C:\\Users\\alu200910696\\Downloads\\geckodriver.exe");  
    driver = new FirefoxDriver();
    baseUrl = "http://phptravels.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCadastroCarro() throws Exception {
    driver.get(baseUrl + "/admin");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("admin@phptravels.com");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("demoadmin");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.linkText("Accounts")).click();
    driver.findElement(By.linkText("Cars")).click();
    driver.findElement(By.cssSelector("#Cars > li > a")).click();
    driver.findElement(By.cssSelector("button.btn.btn-success")).click();
    driver.findElement(By.name("carname")).clear();
    driver.findElement(By.name("carname")).sendKeys("Teste");
    new Select(driver.findElement(By.name("carstars"))).selectByVisibleText("5");
    driver.findElement(By.name("locations[1][price]")).clear();
    driver.findElement(By.name("locations[1][price]")).sendKeys("50");
    driver.findElement(By.id("add")).click();
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
