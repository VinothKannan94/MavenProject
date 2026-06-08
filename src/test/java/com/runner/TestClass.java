package com.runner;

import com.base.BaseClass;
import com.pageobjectmanager.PageObjectManager;
import com.utility.ReadExcelData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestClass {

    public static void main(String[] args)  {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.youtube.com/");

        String search = ReadExcelData.getSearchInput(1,0);
        System.out.println("Searched Text : " + search);

        driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(search);

        driver.findElement(By.xpath("//button[@title='Search']")).click();


    }
}

