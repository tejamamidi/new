@tag
Feature: Title of your feature
  I want to use this template for my feature file

  

  @tag1
  Scenario: login
  Given I open browser 
    
    When i enter send keys "admin@yourstore.com" And "admin"
    When i click login
    Then see the dashboardpage
    When i click the productpage and " Products" option
Then i see the products page
    When i click the edit option 
   
    When i click multimedia table and add the picture