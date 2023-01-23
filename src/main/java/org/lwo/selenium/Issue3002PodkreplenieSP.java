package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Issue3002PodkreplenieSP extends Issue {

//вложения специальных методов, применимых только к данной заявке; общие помещены в класс Issue

    public <var> void kassa() {
        WebElement firstbutton = driver.findElement(By.xpath("//ul[@class='nav']/li[2]//*[text() ='Касса, подкрепление']")); //вкладка "Касса, подкрепление"
        Actions actions = new Actions(driver); // скрол на элемент
        actions.moveToElement(firstbutton).click().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", firstbutton); //JS скрипт клик элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void fieldNameUser() { // Заполнение поле "ФИО кассового работника"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//input[@id='cashier']")).sendKeys("Заустинский Д.И.");
    }

    public void addAttachment() {
        WebElement motion = driver.findElement(By.xpath("//*[text()='Добавить']")); //поиск кнопки "Добавить"
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion); //скрол вниз на невидимый элемент
        motion.click();
        driver.findElement(By.xpath("//*[text()='Номинал валюты']/ancestor::div[@class='itemGroup']")).click(); //xpath к полю "номинал валюты";
        driver.findElement(By.xpath("//*[text()='100']")).click(); //ввод номинала валюты
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//*[text()='Добавить Вложение']")).click(); //кнопка "Добавить вложение";
        driver.findElement(By.xpath("//*[text()='Добавить заявку']")).click(); //кнопка "Добавить заявку"
    }

}
//ancestor::div[@class='itemGroup']"
//*[text()='Количество']/ancestor::div[@class='itemGroup']