Feature: Confirm reservation
  As a customer
  I want to be able to confirm my reservation
  in order to book a table
#Persona
#Jef - Customer

  Rule: the user must accept the terms and conditions

    @UI
    Scenario: A reservation can be made when the terms and conditions are accepted
      Given Jef has accepted the terms and conditions
      When Jef makes a reservation
      Then the reservation should be made

    @UI
    Scenario: A message is given when the terms and conditions are not accepted
      Given Jef has not accepted the terms and conditions
      When Jef makes a reservation
      Then a message should be given that the terms and condition need to be accepted before making a reservation

  Rule: the first name of the customer must be provided

    @UI
    Scenario: A reservation can be made when the first name is provided
      Given Jef has provided “Jef” as his first name
      When Jef makes a reservation
      Then the reservation should be made

    @UI
    Scenario: A message is given when the first name is not provided
      Given Jef has not provided a first name
      When Jef makes a reservation
      Then a message should be given that the first name needs to be provided before making a reservation

  Rule: The last name of the customer must be provided

    @UI
    Scenario: A reservation can be made when the last name is provided
      Given Jef has provided “Peeters” as his last name
      When Jef makes a reservation
      Then a message should be given that the first name needs to be provided before making a reservation

    @UI
    Scenario: A message is given when the last name is not provided
      Given Jef has not provided a last name
      When Jef makes a reservation
      Then a message should be given that the last name needs to be provided before making a reservation