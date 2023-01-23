package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Issue3001Inkass extends Issue {
    public static void getTypeIssue(){ // выбор из комбобокса "Тип" заявки на инкассацию
        By typeField = By.xpath("//div[@class='css-va7pk8 select__single-value']"); // локатор к полю "Тип"
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='wrapper__preloader']")))); // ожидание пока элемент wrapper__preloader исчезнет из DOM-модели
        driver.findElement(typeField).click();
        By typeLocator = By.xpath("//*[text()='Инкассация']");
        driver.findElement(typeLocator).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public <var> void tabATM(){
        WebElement firstbutton= driver.findElement(By.xpath("//ul[@class='nav']/li[2]//*[text() ='Устройство самообслуживания']")); //вкладка "Устройство самообслуживания"
        Actions actions = new Actions(driver); // скрол на элемент
        actions.moveToElement(firstbutton).click().perform();
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", firstbutton); //JS скрипт клик элемента
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void mouseOverToCassette(){ //заполнение кассет ДН
        WebElement motion1 = driver.findElement(By.xpath("//div[@class='itemActionBlock']")); //кассета 1
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion1); //скрол вниз на невидимый элемент
        motion1.click();
        motion1.click();
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/form/div[11]/button[2]")).click();

        WebElement motion2 = driver.findElement(By.xpath("//div[@class='wrapper-itemTable undefined'][2]//div[@class='itemActionBlock']")); //кассета 2
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion2); //скрол вниз на невидимый элемент
        motion2.click();
        motion2.click();
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/form/div[11]/button[2]")).click();

        WebElement motion3 = driver.findElement(By.xpath("//div[@class='wrapper-itemTable undefined'][3]//div[@class='itemActionBlock']")); //кассета 3
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion3); //скрол вниз на невидимый элемент
        motion3.click();
        motion3.click();
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/form/div[11]/button[2]")).click();

        WebElement motion4 = driver.findElement(By.xpath("//div[@class='wrapper-itemTable undefined'][4]//div[@class='itemActionBlock']")); //кассета 4
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion4); //скрол вниз на невидимый элемент
        motion4.click();
        motion4.click();
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/form/div[11]/button[2]")).click();

        WebElement motion7 = driver.findElement(By.xpath("//div[@class='wrapper-itemTable undefined'][7]//div[@class='itemActionBlock']")); //кассета 7
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion2); //скрол вниз на невидимый элемент
        motion7.click();
        motion7.click();
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/form/div[11]/button[2]")).click();

        WebElement button = driver.findElement(By.xpath("//button[@class='addNotif']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button); //скрол вниз на невидимый элемент
        button.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

}
