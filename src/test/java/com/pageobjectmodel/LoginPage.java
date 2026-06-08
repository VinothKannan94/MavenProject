package com.pageobjectmodel;

import com.base.BaseClass;
import com.interfaceelements.LoginPageInterfaceElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass implements LoginPageInterfaceElements {

    @FindBy(linkText = linkText_login)
    private static WebElement loginLink;

    @FindBy(id = username_id)
    private static WebElement username;

    @FindBy(css = password_css)
    private static WebElement password;

    @FindBy(xpath = signin_xpath)
    private static WebElement signin;

    @FindBy(id = title_id)
    private static WebElement title;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    protected static String getTextValue(WebElement element) {
        String text = "";
        try {
            text = element.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

}
