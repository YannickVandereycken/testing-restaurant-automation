Feature: Choose date & time

  As a customer
  I want to be able to choose the date & time
  In order to book a reservation at that day and time
#Persona
#Jef - Customer

  Rule: The chosen time and date of the reservation must be in the future

    @UI
    Scenario: A reservation can be made for a future date & time
      Given it is now 23/11/2022 15:53
      When Jef makes a reservation for 23/12/2022 16:00
      Then Jef should be able to book a reservation

  Rule: The chosen time and date of the reservation must be within the opening hours

    @UI
    Scenario: a reservation can be made when the chosen time is during opening hours
      Given the restaurant is open on Tuesday 15:00
      When Jef makes a reservation for Tuesday 15:00
      Then Jef should be able to book a reservation

  Rule: A reservation can only be made for 2-8 persons

    @UI
    Scenario: A reservation can be made for 2-8 persons
      When Jef makes a reservation for 2 persons
      Then Jef should be able to book a reservation

    @UI
    Scenario: A reservation can be made for 2-8 persons
      When Jef makes a reservation for 8 persons
      Then Jef should be able to book a reservation