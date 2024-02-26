Feature: Salesforce Login testcases


#@regression
#Scenario: Login Error Message - 1
#Given the salesforce url
#When user on "LoginPage"
#When i enter the username as "suganyas@tekarch.com"
#And i enter the password as ""
#And i clicked on the button
#Then i should see the login error message

#@regression
#Scenario: Login To Salesforce - 2
#Given the salesforce url
#When user on "LoginPage"
#When i enter the username as "suganyas@tekarch.com"
#And i enter the password as "Sugan@23"
#And i clicked on the button
#When user on "HomePage"
#Then i should see the homepage

#	@regression
#	Scenario: Check RemeberMe - 3
#	Given the salesforce url
 #When user on "LoginPage"
#	When i enter the username as "suganyas@tekarch.com"
#	And i enter the password as "Sugan@23"
#	And i selected remember user name checkbox
#	And i clicked on the button
#	When user on "HomePage"
#	And i clicked the user menu dropdown
#	And i clicked on the logout button
#	Then i should see the username on the username textbox
	
#	@regression
#	Scenario: Forgot Password- 4 A
#	Given the salesforce url
#When user on "LoginPage"
#	When i click on the forget password
#	Then i should see the forget password page
#	When i enter the forget password usernamefield as "suganyas@tekarch.com"
#	And i clicked the continue button
#	Then i should password reset page with email associated with my username

#	@regression
#	Scenario: Forgot Password- 4 B
#	Given the salesforce url
# When user on "LoginPage"
#	When i entered the wrong username as "123"
#	When i entered the wrong password as "22131"
#	And i clicked on the button
#	Then i should see the error message
