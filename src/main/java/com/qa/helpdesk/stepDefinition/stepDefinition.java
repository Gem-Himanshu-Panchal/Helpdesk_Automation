package com.qa.helpdesk.stepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.gemini.generic.ui.utils.DriverManager;
import com.qa.helpdesk.Locators.locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.reflections.vfs.Vfs;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class stepDefinition {
    boolean ispassed = false;

    @Given("^Launch helpdesk \"([^\"]*)\"$")
    public void launchHelpdeskURL(String url) {
        ispassed = false;
        try {
            DriverAction.waitUntilElementAppear(locator.loginBtn, 15);
            String extractedURL = DriverAction.getCurrentURL();
            List<WebElement> presentImages = DriverAction.getElements(locator.loginImages);

            if (extractedURL.equalsIgnoreCase(url) && presentImages.size() == 5 && DriverAction.isExist(locator.loginDiv)
                    && DriverAction.getElementText(locator.loginWelcomeText).equalsIgnoreCase("Welcome Back") && DriverAction.isExist(locator.loginBtn)
                    && DriverAction.getElementText(locator.loginPara1).equalsIgnoreCase("For any queries, contact us at:")
                    && DriverAction.getElementText(locator.loginPara2).equalsIgnoreCase("support.helpdesk@geminisolutions.com"))
                ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if Helpdesk URL is launched",
                    "Helpdesk URL is launched",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if Helpdesk URL is launched",
                    "Unable to launch Helpdesk URL", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("test")
    public void test() {
        System.out.println("Hello World");
    }

    @And("Click on {string} button")
    public void clickOnButton(String loginBtn) {
        ispassed = false;
        try {
            DriverAction.waitSec(3);
            if (DriverAction.isExist(locator.loginBtn)) {
                DriverAction.click(locator.loginBtn);
            }
            DriverAction.waitSec(3);
            Properties login = new Properties();
            try (FileReader in = new FileReader(".idea/login.properties")) {
                login.load(in);
            }
            String username = login.getProperty("username");
            String password = login.getProperty("password");
            System.out.println(username+" "+password);
            if(DriverAction.isExist(locator.loginElements("email"))){
                DriverAction.getElement(locator.loginElements("email")).sendKeys(username);
                DriverAction.getElement(locator.loginElements("next")).click();
                DriverAction.waitSec(2);
                DriverAction.getElement(locator.loginElements("password")).sendKeys(password);
                DriverAction.getElement(locator.loginElements("next")).click();
                DriverAction.waitSec(2);
                DriverAction.getElement(locator.loginElements("next")).click();
                ispassed=true;
            }

        } catch (Exception ex) {
            ispassed = false;
        }
    }

    @And("Verify if user is successfully login into helpdesk")
    public void verifyIfUserIsSuccessfullyLoginIntoHelpdesk() {
        ispassed = false;
        try {
            DriverAction.waitUntilElementAppear(locator.gemLogo, 30);
            if (DriverAction.isExist(locator.gemLogo) && DriverAction.isExist(locator.loginHeader) && DriverAction.isExist(locator.logoutBtn)
                    && DriverAction.isExist(locator.createNewTicketBtn) && DriverAction.isExist(locator.searchTicketInput) &&
                    DriverAction.isExist(locator.ticketColumnHeader) && DriverAction.isExist(locator.existingTicketRow) &&
                    DriverAction.isExist(locator.filterButton))
                ispassed = true;
        } catch (Exception ex) {
            ispassed = false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if user successfully logged in",
                    "User is on Helpdesk home page",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if user successfully logged in",
                    "User is unable to go on home page", STATUS.FAIL, DriverAction.takeSnapShot());
    }
}





