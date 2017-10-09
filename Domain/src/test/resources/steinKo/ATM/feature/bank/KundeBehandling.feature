Feature: Customer Managment

Scenario: Opprett ny kunde
Given Person med navn "Sofie Korsveien" 
And person nummer 26074344574 ikke  er kunde kunde i banken
When  oppretter en ny kunde  med "Sofie Korsveien"
And person nummer 26073444574 and  pin 1234 customer number 456
Then a customer with customer number 456 exist

Scenario: Existeing Customer
Given Customer with customer number 100 exist
And Customer with customer number 101 exist
And Customer with customer number 102 exist
When find customer with customer number 100
Then persons name is "Anne Korsveien"
And person id is 26076144575
And customer number is 100
