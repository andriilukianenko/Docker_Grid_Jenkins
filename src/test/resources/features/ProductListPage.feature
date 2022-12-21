Feature: Check Product list page functionality

  Background: Product list page is opened
    Given Product list page is opened

  Scenario: Searching a product by the input field
    When Customer searches for DSC-H20 Blue
    Then Verify that Product with name DSC-H20 is appeared in the product list on the site page

  Scenario Outline: User clicks product category on the header on the product list page
    When the user clicks on <category>
    Then Verify that the <expectedTitle> is displayed

    Examples:
      | category | expectedTitle |
      | Webcams  | WEBCAMS       |


  Scenario: Test the valid login using DataTable
    Given Open Sign In page
    When Users enters the information in Email and Password fields
      | Email         | Pass   |
      | rewq@mail.com | 471666 |
    And Click on the LogIn button
    Then Verify that My Account button is displayed on the Main page
