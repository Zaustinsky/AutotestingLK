package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Test {

    public void test3002() throws Exception {
        Issue3002 issue = new Issue3002();

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorizationLogin("BANK_BAPBBY2X");
        issue.autorizationPassword("123456");
        issue.issue();
        issue.kassa();
        issue.getSummRows();
        issue.mouseOverAndClick();
        issue.getDate();
        issue.insertDate();
        issue.choiceOfSelfDevice("//div[text()='132 - Расчетно-кассовый центр №750']");
        issue.fieldNameUser();
        issue.addAttachment();
        issue.scribeIssue();
        issue.getWatchIssues();
        issue.parseRowsIssue();
        issue.parseRowsIssueAttachments();
        issue.driver.quit();
    }

    public void test3001() throws Exception {
        Issue3001 issue = new Issue3001();

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorizationLogin("BANK_BAPBBY2X");
        issue.autorizationPassword("123456");
        issue.issue();
        issue.createIssueATM();
        issue.getSummRows();
        issue.mouseOverAndClick();
        issue.insertDate();
        issue.choiceOfSelfDevice("//div[text()='12894-Дрыгва, лунка 5 (автотест!!! Не трогать!!!)']");
        issue.mouseOverToCassette();
        issue.scribeIssue();
        issue.getSummRows();
        issue.getWatchIssues();
        issue.parseRowsIssue();
        issue.parseRowsIssueAttachments();
        issue.driver.quit();
    }

    public void test3003() throws Exception {
        Issue3003 issue = new Issue3003();

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorizationLogin("BANK_BAPBBY2X");
        issue.autorizationPassword("123456");
        issue.issue();
        issue.issueExport();
        issue.getSummRows();
        issue.mouseOverAndClick();
        issue.insertDate();
        issue.choiceOfSelfDevice1("//div[text()='132 - Расчетно-кассовый центр №750']");
        issue.addAttachment();
        issue.scribeIssue();
        issue.getSummRows();
        issue.getWatchIssues();
        issue.parseRowsIssue();
        issue.parseRowsIssueAttachments();
        issue.driver.quit();
     }

    public void testOrder01_Kassa() throws Exception {
        Order01_Kassa order = new Order01_Kassa();

        order.createGeckoDriver();
        order.goLink("https://big.lwo.by/auth");
        order.autorizationLogin("Firsov_a");
        order.autorizationPassword("123456");
        order.order();
        order.kassa();
        order.getSummRows();
        order.mouseOverAndClick();
        order.insertNumberDoc();
        order.getDate();
        order.insertDate();
        order.insertNumberMt_file();
        order.choiceOfSelfDevice("//div[text()='145 - ФИЛИАЛ ОАО 'БЕЛАГРОПРОМБАНК' - ГРОДНЕНСКОЕ ОБЛАСТНОЕ УПРАВЛЕНИЕ']");
        //order.fieldNameUser();
       // order.addAttachment();
        //order.scribeIssue();
        //order.getWatchIssues();
        //order.parseRowsIssue();
        //order.parseRowsIssueAttachments();
        //order.driver.quit();
    }
}
