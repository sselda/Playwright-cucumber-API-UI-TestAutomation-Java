Feature: Cart functionality

  Background:
    Given User is on products page

  Scenario: Add product to cart
    When User clicks on Add to Cart button
    Then Product should be visible in the cart
    And Cart quantity should be 1

  Scenario: Remove product from cart
    Given Product is already in the cart
    When User removes the product from cart
    Then Cart should be empty

  Scenario: Quantity cannot be less than 1
    Given Product is already in the cart
    When User decreases quantity to 0
    Then Quantity should remain 1