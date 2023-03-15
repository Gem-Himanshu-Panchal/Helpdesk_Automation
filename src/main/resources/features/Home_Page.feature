Feature: Helpdesk

  Background:
    Given Launch helpdesk "https://helpdeskui-np.geminisolutions.com/#"
    And Click on Login button
    And Verify if user is on Home page

  Scenario Outline: Verify if on clicking on Contact Us icon a dialog box appears on screen
    Given Click on "<contactUs>" icon
    Then Check if a dialog box with "<headerText>" appears
    And Verify if "<email>" is clickable
    Then Click on "<close>" icon
    And Verify if user is on Home page
    Examples:
      | contactUs | headerText | email                                | close     |
      | Support   | Contact Us | support.helpdesk@geminisolutions.com | contactUs |


  Scenario Outline: Verify if on clicking on Notification icon a dialog box appears on screen
    Given Click on "<notification>" icon
    Then Verify if "<headerText>" dialog box opens
    Then Verify "<image>" and "<text>" are present on dialog box
    And Click on "<unread>" button
    Then Verify "<image>" and "<text>" are present on dialog box
    And Click on "<class>" to close it
    And Verify if user is on Home page
    Examples:
      | notification | headerText    | image              | text                   | unread |class |
      | notification | Notifications | notification empty | No new notification !! | Unread |d-flex|