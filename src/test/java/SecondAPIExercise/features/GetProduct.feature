Feature: Get product API

  Scenario Outline: Get Products
    Given :Category "<name>" and results "<results>"
    When  :user calls GET API
    Then  :check if the status code is 200
    And   :get the first product's id

    Examples:
      | name          | results |
      | meat-seafood  | 3       |
      | coffee        | 2       |
      | fresh-produce | 4       |
