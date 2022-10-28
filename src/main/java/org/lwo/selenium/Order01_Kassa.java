package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Order01_Kassa extends Order{

    //вложения специальных методов, применимых только к данной заявке; общие помещены в класс Issue

    public <var> void kassa() {
        WebElement firstbutton = driver.findElement(By.xpath("//*[text()='Подкрепление кассы']")); //вкладка "Подкрепление кассы"
        Actions actions = new Actions(driver); // скрол на элемент
        actions.moveToElement(firstbutton).click().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", firstbutton); //JS скрипт клик элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }


}
