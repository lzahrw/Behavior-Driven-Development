@tag
Feature: Pro Calculator

  Scenario: multiply two numbers
    Given Two input values, 3 and 4, and operation *
    When I do the operation on the two values
    Then I expect the result 12


  Scenario: divide two numbers
    Given Two input values, 12 and 4, and operation /
    When I do the operation on the two values
    Then I expect the result 3


  Scenario: power of two numbers
    Given Two input values, 3 and 4, and operation ^
    When I do the operation on the two values
    Then I expect the result 81


  Scenario Outline: calculate result of operation on two numbers
    Given Two input values, <first> and <second>, and operation <opt>
    When I do the operation on the two values
    Then I expect the result <result>

    Examples:
      | first | second | opt | result |
      | 6 | 2 | * | 12 |
      | 6 | 2 | / | 3 |
      | 6 | 2 | ^ | 36 |