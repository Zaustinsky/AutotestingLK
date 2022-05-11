package org.lwo.selenium;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Test {

    public void test3002() {
        Issue3002 issue = new Issue3002();

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorization();
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

    public void test3001() {
        Issue3001 issue = new Issue3001();

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorization();
        issue.issue();
        issue.createIssueATM();
        issue.getSummRows();
        issue.mouseOverAndClick();
        issue.insertDate();
        issue.choiceOfSelfDevice("//div[text()='12-Дрыгва, лунка 5 (автотест!!! Не трогать!!!)']");
        issue.mouseOverToCassette();
        issue.scribeIssue();
        issue.getSummRows();
        issue.getWatchIssues();
        issue.parseRowsIssue();
        issue.parseRowsIssueAttachments();
        issue.driver.quit();
    }

    public void test3003() {
        Issue3003 issue = new Issue3003();

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorization();
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
        issue.driver.quit();
    }
}
