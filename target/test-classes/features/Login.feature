Feature: login to application

Scenario Outline: positive test validating login
Given initialize the browser with chrome
And navigate to "http://10.1.7.227:5070" site
And click on Login link in homepage to land on secure sign in page
When user enters <username> and <password> and logs in
Then verify that user is successfully logged in
#Example is used to parameterized in Gherkins, then Scenario
#has to be changed to Scenario outline

Examples:
|username	|password	|
|mosope		|@Brown123	|
|ibk2022	|ibkk		|
