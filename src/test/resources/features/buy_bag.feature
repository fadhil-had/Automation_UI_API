Feature: Buy product on MyDemoApp

  Scenario: Buy 2 blue Sauce Lab Back Packs
    When user selects product "Sauce Labs Backpack"
    And user selects product with color "Blue" and quantity "2"
    Then user proceed order product
    When user login
    And user checkout
    And user checkout payment
    Then user review payment
    Then user confirm payment