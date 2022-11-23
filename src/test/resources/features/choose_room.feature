Feature: Choose a room

  As a customer
  I want to be able to choose a room
  In order sit in the room I want to
#Persona
#Jef - Customer

  Rule: The room must still have available seats at the given reservation time

    @UI
    Scenario: a room can be chosen when there are still places available
      Given there are free tables in Grote zaal on thursday at 6pm
      When Jef reserves a table in Grote zaal on thursday at 6pm
      Then Jef should be able to make a reservation

    @UI
    Scenario: a room can not be chosen when there are no places available
      Given there are no free tables in Lege kamer on thursday at 6pm
      When Jef tries to reserve a table in Lege kamer on thursday at 6pm
      Then the room Lege kamer is not available anymore for reservation

  Rule: Only customers with reservations for 2 can make a reservation for the small room

    @UI
    Scenario: the small room can be booked for a reservation of 2 people
      Given Jef has chosen to make a reservation for 2
      When Jef reserves a table for the “Kleine zaal”
      Then Jef should be able to make a reservation

    @UI
    Scenario: the small room can’t be chosen for reservations of more than 2 people
      Given Jef has chosen to make a reservation for 3
      When Jef tries to reserve a table in the “Kleine zaal”
      Then Jef should only be able to make a reservation in “Middelgrote zaal”, “Lege kamer” or “Grote zaal”

  Rule: Only customers with reservations for 4 can make a reservation for the middle-sized room

    @UI
    Scenario: the middle-sized room can only be booked for a reservation of 4 people
      Given Jef has chosen to make a reservation for 4
      When Jef reserves a table in the “middle-sized room”
      Then Jef should be able to make a reservation in the middle-sized room

    @UI
    Scenario Outline: A message is given when the middle-sized room is chosen for a reservation for more or less than 4 people
      Given Jef has chosen to make a reservation for <people>
      When Jef tries to reserve a table in the “middle-sized room”
      Then Jef should only be able to make a reservation in the “Lege kamer” or “Grote zaal”

      Examples:
        | people |
        | 3      |
        | 5      |

  Rule: customers with reservations for 2-8 can make a reservation for the big room

    @UI
    Scenario: the big room can only be booked for a reservation of 2-8 people
      Given Jef has chosen to make a reservation for 2
      When Jef reserves a table in the “big room”
      Then Jef should be able to make a reservation in the “big room”

  Rule: 1 room must be chosen for creating a reservation

    @UI
    Scenario: 1 room can be booked at a time
      When Jef chooses the “small room”
      Then Jef should be able to book a reservation for the “small room”