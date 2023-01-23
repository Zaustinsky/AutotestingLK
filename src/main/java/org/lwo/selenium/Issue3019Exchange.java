package org.lwo.selenium;

import jdk.nashorn.internal.runtime.Context;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class Issue3019Exchange extends Issue{

    //вложения специальных методов, применимых только к данной заявке; общие помещены в класс Issue

    public <var> void issueExport() {
        WebElement firstbutton = driver.findElement(By.xpath("//ul[@class='nav']/li[2]//*[text() ='Размен']")); //вкладка "Размен"
        Actions actions = new Actions(driver); // скрол на элемент
        actions.moveToElement(firstbutton).click().perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", firstbutton); //JS скрипт клик элемента

    }

    public void mouseOverAndClick() { //наведение курсора мыши на п.м. создания заявки "+"

        By plusLocator = By.cssSelector("div > svg[class='svg-add']"); // CSS локатор для кнопки "+"
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(plusLocator)); // явное ожидание, пока кнопка "+" появится в DOM-модели
        driver.findElement(plusLocator).click();

    }
    public static void choiceOfSubdivision(String xpath) { //выбор Подразделения из выпадающего списка
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='wrapper__preloader']"))));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='itemGroup-wrapper'][1]//div[@class='css-1rtrksz select__value-container select__value-container--has-value']"))).click();
        WebElement device = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", device); //JS скрипт клик элемента
    }

    public static void collectionPoint(String xpath) throws Exception { //выбор ТИ из выпадающего списка
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
//        By invisibleElement = By.xpath("//div[@class='wrapper__preloader']");
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(invisibleElement)); // ожидание, пока станет невидимым элемент 'wrapper__preloader'
//        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='wrapper__preloader']"))));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='itemGroup-wrapper'][2]//div[@class='css-1rtrksz select__value-container select__value-container--has-value']"))).click();
        WebElement device = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", device); //JS скрипт клик элемента

    }
    public static void addAttachment() throws Exception {
        WebElement motion = driver.findElement(By.xpath("//*[text()='Добавить'][1]")); //поиск кнопки "Добавить"
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", motion); //скрол вниз на невидимый элемент
        motion.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='popup wrapper-m undefined']"))));
        WebElement listBags = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
        listBags.click();


        driver.findElement(By.xpath("//div[@id='react-select-4-option-0']")).click();  // выбор первого элемента из выпадающего списка (номер сумки)
        driver.findElement(By.xpath("//*[text()='Номинал']/ancestor::div[@class='itemGroup']//input")).click(); //xpath к полю "номинал валюты";
        driver.findElement(By.xpath("//*[text()='100']")).click(); //ввод номинала валюты
        driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("1000");
        driver.findElement(By.xpath("//*[text()='Добавить вложение']")).click(); //кнопка "Добавить вложение";
        driver.findElement(By.xpath("//*[text()='Добавить заявку']")).click(); //кнопка "Добавить заявку"
    }

    public static void checkBagNumber() throws IOException { // метод определения наличия свободных сумок у сх
        System.out.println(Issue.delimiter);
        try {
            List number = driver.findElements(By.xpath("//div[@class='m-body']//div[@class='itemGroup-wrapper'][1]//div[@class='css-1rtrksz select__value-container select__value-container--has-value']"));
            WebElement id = driver.findElement(By.xpath("//input[@id='react-select-4-input']"));
            if (id.isDisplayed()){
                System.out.println("У точки инкассации есть свободные сумки!");
            }

        } catch (Exception e){
            System.out.println("У точки инкассации нет свободных сумок!" + e.getMessage());
            System.out.println(Issue.delimiter);
            throw new RuntimeException();
        }

    }

}
