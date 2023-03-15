package com.qa.helpdesk.Locators;

import org.openqa.selenium.By;

public class locator {

   public static By loginBtn = By.xpath("//button[@class='py-2 button_backgroundBtn__vdCcK login_loginBtn__gB3Xc']");
   public static By loginImages =By.xpath("//img");
   public static By loginDiv = By.xpath("//div[@class='login_rightSection__Zk2B6']");
   public static By loginWelcomeText = By.xpath("//div[@class='login_welcomeBackText__KZTKM']");
   public static By loginPara1 = By.ById.xpath("//p[contains(text(),'For any queries, contact us at:')]");
   public static By loginPara2 = By.xpath("//p[contains(text(),'support.helpdesk@geminisolutions.com')]");

public static By gemLogo = By.xpath("//div[@class='leftmenu_gemlogo__oSj-w']//img");
public  static By loginHeader = By.xpath("//section[@class='header_myTickets__aaVje']//span");
public static By logoutBtn = By.xpath("//img[@alt='logout']");
public static By createNewTicketBtn = By.xpath("//button[contains(text(),'Create New Ticket')]");
public static By searchTicketInput = By.xpath("//input[@class='ps-5 input_input__MxCyY input_innerText__ykEnO']");
public static By ticketColumnHeader = By.xpath("//thead[@class='MuiTableHead-root css-1wbz3t9']");
public static By existingTicketRow = By.xpath("//tbody//tr");
}

