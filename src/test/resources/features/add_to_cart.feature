Feature: Add to cart

  As a customer
  I want to be able to add items to my cart
  In order to order multiple items at once
#Persona
#Jef - Customer

  Rule: The cart can contain a maximum of 10 items

    @UI
    Scenario: A product is added to the cart when if cart does not exceed 10 items
      Given Jef has 1 “Fanta” in his cart
      When Jef adds 1 “Salmon Poke” to his cart
      Then 1 “Salmon Poke” should be added to his cart

    @UI
    Scenario: a message is shown when more than 10 items are added to the cart
      Given Jef has 10 “Fanta” in his cart
      When Jef adds 1 “Salmon Poke” to his cart
      Then a message should be given that the cart can’t contain more than 10 products

  Rule: The product needs to be available

    @UI
    Scenario: A product is added to the cart when it is available
      Given there are 13 “Fanta” available
      When Jef adds 5 “Fanta” to his cart
      Then 5 “Fanta” should be added to his cart

  Rule: A product can be added multiple times at once (quantity)

    @UI
    Scenario: A product can be added multiple times at once
      When Jef adds 5 “Fanta” to his cart
      Then 5 “Fanta” should be added to his cart

  Rule: The price of the product is shown based on the amount that will be added

    @UI
    Scenario: The price of the product is shown based on the amount that will be added
      Given the price of 1 “Fanta” is €2,5
      When Jef chooses to add 5 “Fanta” to his cart
      Then the total price of €12,5 should be given

  Rule: It should be possible to add additional instructions (e.g. for allergies, extra's, etc..)

    @UI
    Scenario: Additional info is given when it was provided
      Given Jef has chosen a “Tuna Poke”
      When Jef adds the note “without cucumber”
      And Jef adds 1 “Tuna Poke” to his cart
      Then 1 “Tuna Poke” should be added to his cart
      And it should include the note “without cucumber”

    @UI
    Scenario: No additional info is given when it was not provided
      Given Jef has chosen a “Tuna Poke”
      When Jef adds “Tuna Poke” to his cart
      But he did not add a note
      Then 1 “Tuna Poke” should be added to his cart
      But it should not include a note

  Rule: At least one item must be added to the cart

    @UI
    Scenario: 1 or more products are added to the cart based on the chosen quantity
      When Jef adds 1 “Fanta” to his cart
      Then 1 “Fanta” should be added to his cart