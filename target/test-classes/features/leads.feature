
Feature: LeadsTab testcases
Background:
Given the salesforce url
When user on "LoginPage"
When i enter the username as "suganyas@tekarch.com"
And i enter the password as "Sugan@23"
And i clicked on the button
When user on "HomePage"

#Scenario: TC20 Check leads tab link 
#When i clicked the leads tab
#Then i should see the leads page

Scenario: TC21 Select lead view
When i clicked the leads tab
Then i should see the leads page
When user on "LeadPage"
When i clicked the dropdownlist
Then i should see the dropdownlist
