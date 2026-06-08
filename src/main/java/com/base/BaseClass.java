package com.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.awt.*;
import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class BaseClass {

    public static WebDriver driver;

    protected static WebDriver launchBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("chrome")) {
                driver = new ChromeDriver();
            } else if (browserName.equalsIgnoreCase( "firefox")) {
                driver = new FirefoxDriver();
            } else if (browserName.equalsIgnoreCase( "edge")) {
                driver = new EdgeDriver();
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING BROWSER LAUNCH");
        }
        driver.manage().window().maximize();
        return driver;
    }
//get url
    protected static void launchUrl(String url) {
        try {
            driver.get(url);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING URL LAUNCH");
        }
    }
//sendKeys
    protected static void passInput(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING VALUE PASSING");
        }
    }
//click
    protected static void clickOnElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING ELEMENT CLICK");
        }
    }
    //navigate To
    protected static void navigateTo(String url){
        try {
            driver.navigate().to(url);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING NAVIGATE URL");
        }
    }
    //Navigate back
    protected static void navigateBack() {
        try {
            driver.navigate().back();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING NAVIGATE BACK");
        }
    }
    //Navigate forward
    protected static void navigateForward() {
        try {
            driver.navigate().forward();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING NAVIGATE FORWARD");
        }
    }
    //Navigate refresh
    protected static void navigateRefresh() {
        try {
            driver.navigate().refresh();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING NAVIGATE REFRESH");
        }
    }
    //Alert
    protected static void handleAlert(String action, String textToSend) {
        try {
            Alert alert = driver.switchTo().alert();
            if (action.equalsIgnoreCase("accept")) {
                alert.accept();
            } else if (action.equalsIgnoreCase("dismiss")) {
                alert.dismiss();
            } else if (action.equalsIgnoreCase("close")) {
                alert.accept();
            } else if (action.equalsIgnoreCase("getText")) {
                System.out.println(alert.getText());
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING ALERT");
        }
    }
    //Frames Handling
    protected static void switchToFrame(WebElement element, int index, String id, String value) {
        try {
            if (value.equalsIgnoreCase("element")) {
                driver.switchTo().frame(element);
            } else if(value.equalsIgnoreCase("index")) {
                driver.switchTo().frame(index);
            } else if (value.equalsIgnoreCase("value")) {
                driver.switchTo().frame(value);
            }else if (value.equalsIgnoreCase("id")) {
                driver.switchTo().frame(id);
            }

        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING FRAMES");
        }
    }
    //Actions Class Methods
    protected static void  dragAndDrop(WebElement source, WebElement target) {
        try {
            Actions a = new Actions(driver);
            a.dragAndDrop(source, target).perform();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING DRAG AND DROP." + e.getMessage());
        }
    }
//Move to element
    protected static void moveToElement(WebElement element) {
        try {
            Actions a = new Actions(driver);
            a.moveToElement(element).perform();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING MOVE TO ELEMENT." + e.getMessage());
        }
    }
//Click Action
    protected static void clickAction(WebElement element) {
        try {
            Actions a = new Actions(driver);
            a.click().perform();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING CLICK." + e.getMessage());
        }
    }
    //Right Click
    protected static void rightClick(WebElement element) {
        try {
            Actions a = new Actions(driver);
            a.contextClick(element).perform();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING RIGHT CLICK." + e.getMessage());
        }
    }
//Double click
    protected static void doubleClick(WebElement element) {
        try {
            Actions a = new Actions(driver);
            a.doubleClick(element).perform();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING DOUBLE CLICK." + e.getMessage());
        }
    }
    //Robot Class
    protected static void robotKeyPressRelease(int keyCode) {
        try {
            Robot robot = new Robot();
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);

        } catch (AWTException e) {
            Assert.fail("ERROR : OCCUR DURING KEY PRESS OPERATIONS." + e.getMessage());
        }
    }
    //window Handling
    protected static void windowHandling(int index) {
        try {
            Set<String> allWindows = driver.getWindowHandles();
            List<String> windowList = new ArrayList<>(allWindows);
            driver.switchTo().window(windowList.get(index));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING WINDOW SWITCH OPERATIONS." + e.getMessage());
        }
    }
    //selectDropDown
    protected static void selectDropDown(WebElement element, String type, String value) {
        try {
            Select s = new Select(element);
            if (type.equalsIgnoreCase("index")) {
                s.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("value")) {
                s.selectByValue(value);
            } else if (type.equalsIgnoreCase("text")) {
                s.selectByVisibleText(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING SELECT DROP DOWN OPERATIONS." + e.getMessage());
        }
    }
    //Check box and Radio Button Selection

    protected static void selectCheckOrRadio(WebElement element) {
        try {
            if (element.isDisplayed() && element.isEnabled()) {
                if (!element.isSelected()) {
                    element.click();
                    System.out.println("Element Successfully Selected..");
                } else {
                    System.out.println("Element Already Selected");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("ERROR : OCCUR DURING CHECKBOX OR RADIO BUTTON SELECTION. Message: " + e.getMessage());
        }
    }
    // Is enabled
    protected static boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING isElementEnabled OPERATION. Message: " + e.getMessage());
            return false;
        }
    }
    //Is displayed
    protected static boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING isElementDisplayed OPERATION. Message: " + e.getMessage());
            return false;
        }
    }
    // Is selected
    protected static boolean isElementSelected(WebElement element) {
        try {
            return element.isSelected();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING isElementSelected OPERATION. Message: " + e.getMessage());
            return false;

        }
    }
    //Get options (Dropdown)
    protected static List<WebElement> getDropDownOptions(WebElement element) {
        try {
            Select s = new Select(element);
            return s.getOptions();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING getDropDownOptions OPERATION. Message: " + e.getMessage());
            return null;
        }
    }
    //Get title
    protected static String getPageTitle() {
        try {
            return driver.getTitle();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING getPageTitle. Message: " + e.getMessage());
            return null;
        }
    }
    // Get current url
    protected static String getCurrentPageUrl() {
        try {
            return driver.getCurrentUrl();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING getCurrentPageUrl. Message: " + e.getMessage());
            return null;
        }
    }
    //Get text
    protected static String getElementText(WebElement element) {
        try {
            return element.getText();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING getElementText. Message: " + e.getMessage());
            return null;
        }
    }
    //Get attribute
    protected static String getElementAttribute(WebElement element, String attributeName) {
        try {
            return element.getAttribute(attributeName);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING getElementAttribute. Message: " + e.getMessage());
            return null;
        }
    }
    // Explicit Wait
    protected static void waitForVisibility(WebElement element, int timeoutSeconds) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING waitForVisibility. Message: " + e.getMessage());
        }
    }
    //Take screenshot
    protected static void takeScreenshot(String fileName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshots/" + fileName + ".png");
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING takeScreenshot. Message: " + e.getMessage());
        }
    }
    //Scroll up and down
    protected static void scrollUpDown(int x, int y) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(" + x + "," + y + ")");
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING scrollUpDown. Message: " + e.getMessage());
        }

    }
    //Get first selected option
    protected static String getFirstSelectedOptionText(WebElement element) {
        try {
            Select s = new Select(element);
            return s.getFirstSelectedOption().getText();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING getFirstSelectedOptionText. Message: " + e.getMessage());
            return null;
        }
    }
    //Get all selected options
    protected static List<WebElement> getAllSelectedOptions(WebElement element) {
        try {
            Select s = new Select(element);
            return s.getAllSelectedOptions();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING getAllSelectedOptions. Message: " + e.getMessage());
            return null;
        }
    }
    // Is multiple
    protected static boolean isDropdownMultiple(WebElement element) {
        try {
            Select s = new Select(element);
            return s.isMultiple();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING isDropdownMultiple. Message: " + e.getMessage());
            return false;
        }
    }
    //select Options
    protected static void selectOptions(WebElement element, String type, String value) {
        try {
            Select select = new Select(element);
            if(type.equalsIgnoreCase("text")) {
                select.selectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.selectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("value")) {
                select.selectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING SELECT OPTION");
        }
    }
    //De-select Options
    protected static void deSelectOptions(WebElement element, String type, String value) {
        try {
            Select select = new Select(element);
            if(type.equalsIgnoreCase("text")) {
                select.deselectByVisibleText(value);
            } else if (type.equalsIgnoreCase("index")) {
                select.deselectByIndex(Integer.parseInt(value));
            } else if (type.equalsIgnoreCase("value")) {
                select.deselectByValue(value);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING DESELECT OPTION");
        }
    }
    //Close browser
    protected static void closeBrowser(){
        try {
            driver.close();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING BROWSER CLOSE ");
        }
    }
    //Browser Termination
    protected static void browserTermination() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING BROWSER TERMINATION ");
        }
    }

    //JavaScript Executor
    protected static void clickUsingJsExecutor(WebElement element, String action){
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            if (action.equalsIgnoreCase("click")){
                js.executeScript("arguments[0].click();", element);
            } else if (action.equalsIgnoreCase("send keys")) {
                js.executeScript("arguments[0].value= " + ";", element);
            } else if(action.equalsIgnoreCase("scrollIntoView")) {
                js.executeScript("arguments[0].crollIntoView(true);", element);
            }
        } catch (Exception e) {
            Assert.fail("ERROR : OCCUR DURING clickUsingJsExecutor. Message: " + e.getMessage());

        }
    }

}


