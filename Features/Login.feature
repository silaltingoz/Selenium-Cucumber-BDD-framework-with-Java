Feature: Login
  Scenario:
    Given I launch chrome browser
    When I open HepsiBurada home page
    Then I verify that logo is present on page
    When user mouse hover Giriş Yap veya Üye ol
    And user clicks on Giriş Yap
    Then "Yardıma İhtiyacım var" should be display
    When User enters e-mail as "sample@mail.com"
    And click on Giriş Yap
    Then Title should be "Hoş geldiniz"
    When user enters password as "password"
    And User click on Giriş Yap
    Then Login button should be "Hesabım"





