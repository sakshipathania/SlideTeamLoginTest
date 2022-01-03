@Google_paid_login
Feature: Login with google paid account test

  Scenario Outline: Login with google paid account test
  Given User is on Home Pagev 
  And user enters the Username and Passwordv 
  Then user clicks on Login button and verify the page_v 
  Then user downloads the PPTv
  Then user clicks on the Logout pagev 
  Then verify the messagev 