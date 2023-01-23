package org.lwo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class Test {

    public void test3002PodkreplenieSP() throws Exception {
        Issue3002PodkreplenieSP issue = new Issue3002PodkreplenieSP(); // Заявка на вывоз из СП

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
        issue.tearDown();
    }

    public void test3001Loaded() throws Exception {
        Issue3001Loaded issue = new Issue3001Loaded(); // Заявка на загрузку банкомата

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorizationLogin("BANK_BAPBBY2X");
        issue.autorizationPassword("123456");
        issue.issue();
        issue.tabATM();
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
        issue.tearDown();
    }

    public void test3001Unloaded() throws Exception {
        Issue3001Unloaded issue = new Issue3001Unloaded(); // Заявка на выгрузку банкомата

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorizationLogin("BANK_BAPBBY2X");
        issue.autorizationPassword("123456");
        issue.issue();
        issue.tabATM();
        issue.getSummRows();
        issue.mouseOverAndClick();
        Issue3001Unloaded.getTypeIssue();
        issue.insertDate();
        issue.choiceOfSelfDevice("//div[text()='12894-Дрыгва, лунка 5 (автотест!!! Не трогать!!!)']");
        issue.clickButton();
        issue.scribeIssue();
        issue.getSummRows();
        issue.parseRowsIssue();
        issue.tearDown();
    }
    public void test3001Inkass() throws Exception {
        Issue3001Inkass issue = new Issue3001Inkass(); // Заявка на загрузку банкомата

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorizationLogin("BANK_BAPBBY2X");
        issue.autorizationPassword("123456");
        issue.issue();
        issue.tabATM();
        issue.getSummRows();
        issue.mouseOverAndClick();
        Issue3001Inkass.getTypeIssue();
        issue.insertDate();
        issue.choiceOfSelfDevice("//div[text()='12894-Дрыгва, лунка 5 (автотест!!! Не трогать!!!)']");
        issue.mouseOverToCassette();
        issue.scribeIssue();
        issue.getSummRows();
        issue.getWatchIssues();
        issue.parseRowsIssue();
        issue.parseRowsIssueAttachments();
        issue.tearDown();
    }

    public void test3012VyvozFromSP() throws Exception {
        Issue3012VyvozFromSP issue = new Issue3012VyvozFromSP(); // Заявка на подкрепление СП

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
        issue.tearDown();
     }

    public void test3019Exchange() throws Exception {
        Issue3019Exchange issue = new Issue3019Exchange(); // Заявка на подкрепление СП

        issue.createGeckoDriver();
        issue.goLink("https://big.lwo.by/auth");
        issue.autorizationLogin("BUSINESS");
        issue.autorizationPassword("123456");
        issue.issue();
        issue.issueExport();
        issue.getSummRows();
        issue.mouseOverAndClick();
        issue.insertDate();
        Issue3019Exchange.choiceOfSubdivision("//div[text()='666 - Вася Василек']");
        Issue3019Exchange.collectionPoint("//div[text()='0377 - Универмаг Московский']");
        Issue3019Exchange.addAttachment();
        issue.scribeIssue();
        issue.getSummRows();
        issue.getWatchIssues();
        issue.parseRowsIssue();
        issue.parseRowsIssueAttachments();
        issue.tearDown();
    }

    public void testOrder01_Kassa() throws Exception {
        Order01_Kassa order = new Order01_Kassa(); // Наряд на подкрепление кассы банка

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
        order.senderDestination("//*[text()=\"145 - ФИЛИАЛ ОАО 'БЕЛАГРОПРОМБАНК' - ГРОДНЕНСКОЕ ОБЛАСТНОЕ УПРАВЛЕНИЕ\"]"); // СП отправителя (Подразделение справочника НБРБ)
        order.recipientDestination("//*[text()=\"146 - ФИЛИАЛ N 423 ОАО 'АСБ БЕЛАРУСБАНК' В Г. СМОРГОНИ\"]"); // СП получателя
        order.fieldNameUser("Заустинский Дмитрий Иванович");
        order.jobTitle("директор");
        order.addAttachment();
        order.scribeIssue();
        order.getWatchIssues();
        order.parseRowsIssue();
        order.parseRowsIssueAttachments();
        order.getSummRows();
        order.tearDown();
    }
}
