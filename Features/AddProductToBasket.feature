Feature: Add Product To Basket
  Scenario:
    Given I launch hepsiburada.com
    When I search for "cep telefonu"
    And click on search button
    Then filter response should be "cep telefonu"
    When I set price range between 3000 and 5000
    And click on approve button
    Then selected filters should be 3000-5000
    When I click on product
    Then product detail page is present
    When I click on all sellers
    And I click on Satıcı sorter twice
    And I click on Sepete Ekle button
    And I click on Sepetim button
    Then I verify true product at basket