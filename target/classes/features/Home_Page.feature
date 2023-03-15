Feature: Helpdesk

  Background:
    Given Launch helpdesk "https://helpdeskui-np.geminisolutions.com/#"
    And Click on Login button
    And Verify if user is on Home page

  Scenario Outline: Verify if on clicking on Contact Us button a dialog box appears on screen
    Given Click on "<contactUs>" icon
    Then Check if a dialog box with "<headerText>" appears
    And Verify if "<email>" is clickable
    Then Click on "<close>" icon
    And Verify if user is on Home page
    Examples:
      | contactUs | headerText     | email                                |close|
      | Support   | Contact Us | support.helpdesk@geminisolutions.com |contactUs    |


