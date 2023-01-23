package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Issue3001Unloaded extends Issue {
    public <var> void tabATM(){
        WebElement firstbutton= driver.findElement(By.xpath("//ul[@class='nav']/li[2]//*[text() ='Устройство самообслуживания']")); //вкладка "Устройство самообслуживания"
        Actions actions = new Actions(driver); // скрол на элемент
        actions.moveToElement(firstbutton).click().perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", firstbutton); //JS скрипт клик элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    public static void getTypeIssue(){ // выбор из комбобокса "Тип" заявки на выгрузку
        By typeField = By.xpath("//div[@class='css-va7pk8 select__single-value']"); // локатор к полю "Тип"
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='wrapper__preloader']")))); // ожидание пока элемент wrapper__preloader исчезнет из DOM-модели
        driver.findElement(typeField).click();
        By typeLocator = By.xpath("//*[text()='Выгрузка']");
        driver.findElement(typeLocator).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
