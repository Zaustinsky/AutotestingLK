package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Issue3003 extends Issue {
    //вложения специальных методов, применимых только к данной заявке; общие помещены в класс Issue

    public <var> void issueExport() {
        WebElement firstbutton = driver.findElement(By.xpath("//ul[@class='nav']/li[2]//*[text() ='Касса, вывоз']")); //вкладка "Касса, вывоз"
        Actions actions = new Actions(driver); // скрол на элемент
        actions.moveToElement(firstbutton).click().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", firstbutton); //JS скрипт клик элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void choiceOfSelfDevice1(String xpath){ //выбор конкретного УС из выпадающего списка
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='wrapper__preloader']"))));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-10nd86i basic-single customSelect']//div[@class='css-1rtrksz select__value-container select__value-container--has-value']"))).click();
        WebElement device = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", device); //JS скрипт клик элемента
    }

    public void addAttachment() {
        WebElement motion = driver.findElement(By.xpath("//*[text()='Добавить'][1]")); //поиск кнопки "Добавить"
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion); //скрол вниз на невидимый элемент
        motion.click();
        driver.findElement(By.xpath("//input[@id='bag']")).sendKeys("555");
        driver.findElement(By.xpath("//div[@class='css-10nd86i basic-single customSelect']")).click();
        driver.findElement(By.xpath("//*[text()='Годные']")).click();
        driver.findElement(By.xpath("//*[text()='Номинал валюты']/ancestor::div[@class='itemGroup']")).click(); //xpath к полю "номинал валюты";
        driver.findElement(By.xpath("//*[text()='100']")).click(); //ввод номинала валюты
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//*[text()='Добавить вложение']")).click(); //кнопка "Добавить вложение";
        driver.findElement(By.xpath("//*[text()='Добавить заявку']")).click(); //кнопка "Добавить заявку"
    }



}
