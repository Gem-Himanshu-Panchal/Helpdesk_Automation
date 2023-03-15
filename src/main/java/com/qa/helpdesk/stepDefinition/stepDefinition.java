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

import java.util.ArrayList;
import java.util.List;

public class stepDefinition {
    boolean ispassed = false;

    @Given("^Launch helpdesk \"([^\"]*)\"$")
    public void launchHelpdeskURL(String url) {
        ispassed = false;
        try {
            DriverAction.waitSec(5);
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
        System.out.println("nil");
    }

    @And("Click on {string} button")
    public void clickOnButton(String loginBtn) {
        ispassed=false;
        try{
            DriverAction.waitSec(5);
            if(DriverAction.isExist(locator.loginBtn)){
               DriverAction.click(locator.loginBtn);
                ispassed=true;
            }
        }catch (Exception ex){
            ispassed=false;
        }
    }

    @And("Verify if user is successfully login into helpdesk")
    public void verifyIfUserIsSuccessfullyLoginIntoHelpdesk() {
        ispassed=false;
        try{
DriverAction.waitSec(30);
        }catch (Exception ex){
            ispassed=false;
        }
        if (ispassed)
            GemTestReporter.addTestStep("Verify if Helpdesk URL is launched",
                    "Helpdesk URL is launched",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if Helpdesk URL is launched",
                    "Unable to launch Helpdesk URL", STATUS.FAIL, DriverAction.takeSnapShot());
    }
}





