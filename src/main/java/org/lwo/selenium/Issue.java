package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

public class Issue {

    WebDriver driver;
    public final static String delimiter = "-----------------------------------";
    public static String LOGIN_AGRA = "BANK_BAPBBY2X";
    public static String PASSWORD_AGRA = "123456";

    public void createGeckoDriver(){
        System.setProperty("webdriver.gecko.driver", "C:\\SeleniumGecko\\geckodriver.exe");
        driver = new FirefoxDriver();
        new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void goLink(String link) { //переход по ссылке на ресурс
        driver.get(link);
        driver.manage().window().maximize();
    }

    public void autorization() {
        driver.findElement(By.xpath("//input[@id='_inputOneEl']")).sendKeys("BANK_BAPBBY2X");
        driver.findElement(By.xpath("//input[@id='_inputTwoEl']")).sendKeys("123456");
        driver.findElement(By.xpath("//*[text() ='ВОЙТИ']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void issue(){ //вкладка "Заявки"
        driver.findElement(By.xpath("//ul[@class='nav']/li[2]")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void getSummRows() {
        //WebDriver driver = DriverFactory.getWebDriver();
        List<WebElement> optionsList = driver.findElements(By.xpath("//div[@class='tableListItems_group_wrapper']/*"));
        int countDown = 0;
        for (WebElement span : optionsList) {
            if (span.getAttribute("class").startsWith("checkboxInput__wrapper")) {
                countDown++;

            }
        }
        System.out.println("Количество созданных заявок: " + countDown);
        //отбор нужного количества строк с одинаковым значением атрибута class + получение их общей суммы
        System.out.println(delimiter);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void mouseOverAndClick() { //наведение курсора мыши на п.м. создания заявки "+"
        WebElement motion = driver.findElement(By.xpath("//div[@class='addSectionItem ']"));
        Actions builder = new Actions(driver);
        builder.moveToElement(motion);
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //waitForPageLoad();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //waitForOne.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='addSectionItem ']")));

        driver.findElement(By.xpath("//div[@class='wrapper-add']//span")).click();
    }

    public void getDate(){ //получение серверной даты
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String output = dateFormat.format(date);
        System.out.println("Серверная дата: " + output);
    }

    public void insertDate(){ //выбор даты
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String output = dateFormat.format(date);
        driver.findElement(By.xpath("//input[@id='actionDate']")).sendKeys(output);
    }

    public void choiceOfSelfDevice(String xpath){ //выбор конкретного УС из выпадающего списка
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='wrapper__preloader']"))));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='css-10nd86i basic-single customSelect']//div[@class='css-1rtrksz select__value-container select__value-container--has-value']"))).click();
        WebElement device = driver.findElement(By.xpath(xpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()", device); //JS скрипт клик элемента
    }

    public void scribeIssue(){ // подписание заявки
        driver.findElement(By.xpath("//div[@id='root']/div/header/div[3]/div[2]/div/div/div[3]/button")).click(); //очистить
        driver.findElement(By.xpath("//div[@class='wrapper-drop']")).click(); //клик по менюшке для вызова меню подписания
        driver.findElement(By.xpath("//a[@class='itemActionDrop'][3]/span")).click(); //п.м. "Подписать"
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[2]/div[4]/button[2]")).click(); //кнопка "Подписать" на форме подписания
        driver.findElement(By.xpath("(//input[@name='signPassword'])[2]")).sendKeys("11111111"); //ввод пароля
        driver.findElement(By.xpath("//*[text() = 'Подписать']")).click(); // п.м. "Подписать"
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath("//div[@id='root']/div/div[2]/div/div/div/div[3]/button")).click(); //закрыть форму уведомления о подписании
        //driver.findElement(By.xpath("//div[@id='root']/div/header/div[3]/div[2]/div/div/div[3]/button")).click(); //ок
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void getWatchIssues(){ // раскрытие и просмотр созданной заявки
        driver.findElement(By.xpath("//div[@class='item-itemTable _widthCell-5-60']")).click();
        WebElement number = driver.findElement(By.xpath("//div[@class='item-itemTable _widthCell-5-103']/span[@class='item-itemTable__label']"));
        System.out.println("ID созданной заявки: " + number.getText());
        System.out.println(delimiter);
    }

    public void parseRowsIssue() {
        //парсинг строки созданной заявки (вывод соответствия полей: наименование и значение)
        List<WebElement> headerColumns = driver.findElements(By.xpath("//div[@class='contentHeader_fixed']//div[@class='headerTable _h-60'][1]/*"));
        List<WebElement> listOfRows = driver.findElements(By.xpath("//div[@class='tableItem ']/*"));
        for (int i = 0; i < headerColumns.size(); i++) {
            System.out.println(headerColumns.get(i).getText() + ": " + listOfRows.get(i).getText());
        }
        System.out.println(delimiter);
    }

    public void parseRowsIssueAttachments() {
        //парсинг строки вложений созданной заявки (вывод соответствия полей: наименование и значение)
        List<WebElement> headerColumns = driver.findElements(By.xpath("//div[@class='tableC nTable']//div[@class='headerTable _h-60']/*"));
        List<WebElement> listOfRows = driver.findElements(By.xpath("//div[@class='tableC nTable']//div[@class='contentTable ']/div[@class='wrapper-itemTable undefined']/div[@class='tableItem ']"));
        for (WebElement row : listOfRows) {
            List<WebElement> childs = row.findElements(By.xpath("./*"));
            for (int i = 0; i < headerColumns.size(); i++) {
                System.out.println(headerColumns.get(i).getText() + ": " + childs.get(i).getText());
            }
            System.out.println(Issue.delimiter);
        }
    }

}
