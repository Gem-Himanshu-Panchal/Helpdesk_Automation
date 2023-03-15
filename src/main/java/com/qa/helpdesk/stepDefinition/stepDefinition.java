package com.qa.helpdesk.stepDefinition;

import com.gemini.generic.reporting.GemTestReporter;
import com.gemini.generic.reporting.STATUS;
import com.gemini.generic.ui.utils.DriverAction;
import com.qa.helpdesk.Locators.locator;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.io.FileReader;
import java.util.List;
import java.util.Properties;

public class stepDefinition {
    boolean passed = false;

    @Given("^Launch helpdesk \"([^\"]*)\"$")
    public void launch_Helpdesk_URL(String url) {
        passed = false;
        try {
            DriverAction.waitUntilElementAppear(locator.elementWithText("button", "Login with SSO"), 15);
            List<WebElement> presentImages = DriverAction.getElements(locator.loginImages);

            if (DriverAction.getCurrentURL().equalsIgnoreCase(url) && presentImages.size() == 5
                    && DriverAction.isExist(locator.loginDiv)
                    && DriverAction.isExist(locator.elementWithText("div", "Welcome Back"))
                    && DriverAction.isExist(locator.elementWithText("button", "Login with SSO"))
                    && DriverAction.isExist(locator.elementWithText("para", "For any queries, contact us at:"))
                    && DriverAction.isExist(locator.elementWithText("para", "support.helpdesk@geminisolutions.com")))
                passed = true;
        } catch (Exception ex) {
            passed = false;
            System.out.println(ex);
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if Helpdesk URL is launched",
                    "Helpdesk URL is launched",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if Helpdesk URL is launched",
                    "Unable to launch Helpdesk URL", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Click on Login button")
    public void click_On_Login_Button() {
        passed = false;
        try {
            DriverAction.waitSec(3);
            if (DriverAction.isExist(locator.elementWithText("button", "Login with SSO"))) {
                DriverAction.click(locator.elementWithText("button", "Login with SSO"));
            }
            DriverAction.waitSec(3);
            Properties login = new Properties();
            try (FileReader in = new FileReader(".idea/login.properties")) {
                login.load(in);
            }
            String username = login.getProperty("username");
            String password = login.getProperty("password");

            if (DriverAction.isExist(locator.loginElements("email"))) {
                DriverAction.getElement(locator.loginElements("email")).sendKeys(username);
                DriverAction.getElement(locator.loginElements("submit")).click();
                DriverAction.waitSec(2);
                DriverAction.getElement(locator.loginElements("password")).sendKeys(password);
                DriverAction.getElement(locator.loginElements("submit")).click();
                DriverAction.waitSec(2);
                DriverAction.getElement(locator.loginElements("submit")).click();
                passed = true;
            }

        } catch (Exception ex) {
            passed = false;
            System.out.println(ex);
        }
    }

    @And("Verify if user is on Home page")
    public void verify_If_User_Is_On_Home_page() {
        passed = false;
        try {
            DriverAction.waitSec(5);
            if (DriverAction.isExist(locator.elementWithText("image", "gemini_logo"))
                    && DriverAction.isExist(locator.elementWithText("span", "My Tickets"))
                    && DriverAction.isExist(locator.elementWithText("image", "logout"))
                    && DriverAction.isExist(locator.elementWithText("button", "Create New Ticket"))
                    && DriverAction.isExist(locator.searchTicketInput)
                    && DriverAction.isExist(locator.elementWithText("image", "userGuide"))
                    && DriverAction.isExist(locator.elementWithText("image", "Support"))
                    && DriverAction.isExist(locator.elementWithText("image", "calender"))
                    && DriverAction.isExist(locator.elementWithText("image", "more"))
                    && DriverAction.isExist(locator.elementWithText("para", "Rows per page"))
                    && DriverAction.isExist(locator.ticketColumnHeader) && DriverAction.isExist(locator.existingTicketRow)
                    && DriverAction.isExist(locator.elementWithText("button", "Filter")))
                passed = true;
        } catch (Exception ex) {
            passed = false;
            System.out.println(ex);
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if user is on helpdesk home page",
                    "User is on helpdesk home page",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if user is on Helpdesk Home page",
                    "User is unable to step on helpdesk home page", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @Given("Click on {string} icon")
    public void click_On_Icon(String iconName) {
        passed = false;
        try {
            if (DriverAction.isExist(locator.elementWithText("image", iconName))) {
                DriverAction.click(locator.elementWithText("image", iconName));
            }
        } catch (Exception ex) {
            passed = false;
            System.out.println(ex);
        }
    }

    @Then("Check if a dialog box with {string} appears")
    public void check_If_A_Dialog_Box_With_header_Appears(String headerText) {
        passed = false;
        try {
            DriverAction.waitSec(3);
            if (DriverAction.isExist(locator.contactUsModalBox)
                    && DriverAction.isExist(locator.elementWithText("div", headerText))
                    && DriverAction.isExist(locator.elementWithText("image", "contactUs"))
                    && DriverAction.isExist(locator.elementWithText("para", "For any queries, contact us at:"))
                    && DriverAction.isExist(locator.elementWithText("para", "support.helpdesk@geminisolutions.com")))
                passed = true;


        } catch (Exception ex) {
            passed = false;
            System.out.println(ex);
        }
        if (passed)
            GemTestReporter.addTestStep("Check if a dialog box appears on screen with header text: " + headerText,
                    "Contact us dialog box is present",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Check if a dialog box appears on screen with header text: " + headerText,
                    "Contact us dialog box is missing", STATUS.FAIL, DriverAction.takeSnapShot());
    }

    @And("Verify if {string} is clickable")
    public void verify_If_Email_Is_Clickable(String element) {
        passed = false;
        try {
            WebElement emailLink = DriverAction.getElement(locator.elementWithText("para", element));
            if (!emailLink.getAttribute("class").contains("disabled")) {
                passed = true;
            }
        } catch (Exception ex) {
            passed = false;
            System.out.println(ex);
        }
        if (passed)
            GemTestReporter.addTestStep("Verify if '"+element+"' is clickable",
                    "Email is clickable",
                    STATUS.PASS, DriverAction.takeSnapShot());
        else
            GemTestReporter.addTestStep("Verify if '"+element+"' is clickable",
                    "Email is not clickable", STATUS.FAIL, DriverAction.takeSnapShot());
    }
}





