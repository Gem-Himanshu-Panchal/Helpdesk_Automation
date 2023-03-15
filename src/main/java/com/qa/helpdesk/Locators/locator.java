package com.qa.helpdesk.Locators;


import org.openqa.selenium.By;

public class locator {
    //LOGIN PAGE
public static By elementWithText(String elementType,String elementText){
    switch (elementType){
        case "button": return By.xpath("//button[contains(text(),'"+elementText+"')]");
        case "div": return By.xpath("//div[contains(text(),'"+elementText+"')]");
        case "para": return By.xpath("//p[contains(text(),'"+elementText+"')]");
        case "image": return By.xpath("//img[@alt='"+elementText+"']");
        case "span": return By.xpath("//span[contains(text(),'"+elementText+"')]");
        default:return null;
    }
}
public static By elementByClass(String elementType, String classValue){
    switch (elementType){
        case "div":return By.xpath("//div[@class='"+classValue+"']");
        default:return null;
    }
}
    public static By loginImages = By.xpath("//img");
    public static By loginDiv = By.xpath("//div[@class='login_rightSection__Zk2B6']");
    public static By loginElements(String elementType){
        return By.xpath("//input[@type='"+elementType+"']");
    }

    //HOME PAGE
    public static By searchTicketInput = By.xpath("//input[@class='ps-5 input_input__MxCyY input_innerText__ykEnO']");
    public static By ticketColumnHeader = By.xpath("//thead[@class='MuiTableHead-root css-1wbz3t9']");
    public static By existingTicketRow = By.xpath("//tbody//tr");


    //CONTACT US DIALOG BOX
    public static By contactUsModalBox = By.xpath("//div[@class='modal-content']");

    //NOTIFICATION DIALOG BOX
    public static By notificationModalBox = By.xpath("//div[@class='notification_container__7wGjb']");

}

