Feature: Access to enter pin
  I want to use this template for my feature file

  @tag1
  Scenario: Entered Valid  Creditcard
    Given ATM in start state
    When Card is enterd
    And  Card is valid
    Then Access to enter pin

  