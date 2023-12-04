@Amazonstore
Feature: Journey on Amazon website

@Test1
 Scenario: Add to cart product
    Given User launch the chrome browser with URL "https://www.amazon.in/"
    When User search the "iphone"
    Then User select product from product list 
    And  User see product details page and store the price in variable
    And  User click on add to cart button
    And  Close the browser
    
 
@Test2
 Scenario: Validate the filtered list
 
    Given User launch the chrome browser with URL "https://www.amazon.in/"
    When  User search the "phone"
    When  User add the filters
    Then  Validate the filtered list
     And  Close the browser
    
@Test3     
 Scenario: Register user on Amazon website
 
      Given User launch the chrome browser with URL "https://www.amazon.in/"
      When  User hover and click on Start here. link 
      When User enters Your name as "Pat Cummins", Mobile number as "9373428164" and Password as "Pat@8338"
      And User click on Verify mobile number button 
      And Close the browser
      
    