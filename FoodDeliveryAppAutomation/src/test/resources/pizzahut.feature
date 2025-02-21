@Smoke
Feature: Validate Pizzahut pizza order flow

  Scenario Outline: Validate Pizzahut pizza order flow
    Given User launches Pizzahut application with "<URL>"
    And User sees a pop-up for delivery asking to enter location
    Then User types address as "<Address>"
    And User selects the first auto-populated drop-down option
    When User navigates to the details page
    And User clicks on the Pizzas menu option
    When User selects add button of any pizza
    Then User clicks on Drinks option
    And User selects Pepsi option to add into the Basket
    Then User sees 2 items in checkout button
    Then User removes the Pizza item from the Basket
    Then User clicks on Checkout button
    And User sees minimum order required pop-up displayed

    Examples:
      | URL                      | Address               |
      | https://www.pizzahut.co.in | Forum Mall |


