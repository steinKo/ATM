Feature: Ta Ut Penger
For å kjøpe noen øl 
Som en eier av kontorn
 Ønker jeg ta ut penger


Scenario: Ta ut lovlig belop frq spare konto
Given Jeg har 400 kr på konto
Then vises melding 
  """
  Enter customer number
  A = OK
  """
When jeg taster inn "101" for kudenummer
And trykker på knapp A
Then vises melding 
  """
  Enter pin
  A = OK
  """
When jeg taster inn "4567" for pin
And trykker på knapp A
Then vises melding 
  """
  Select Account
  A = Checking
  B = Savings
  C = Exit
  """
When trykker på knapp B
Then vises medling 
  """
  Balance= 400 kr
  A=Deposit
  B=Withdrawal
  C=Cancel
 """
When jeg tar ut 200 kr
Then kontoen skal ha en saldo på 200 kr
Then vises medling 
  """
  Balance= 200 kr
  A=Deposit
  B=Withdrawal
  C=Cancel
 """
 When jeg kanelere interaksjonen mmed konto
 Then vises meldingen 
  """
  Select Account
  A = Checking
  B = Savings
  C = Exit
  """
  When jeg avslutter intteraksjonen med ATM
  Then vises meldingen
  """
  Enter customer number
  A = OK
  """
 

Scenario: Ta ut lovlig belop fra bruks konto
Given Jeg har 600 kr på konto
Then vises melding 
  """
  Enter customer number
  A = OK
  """
When jeg taster inn "100" for kudenummer
And trykker på knapp A
Then vises melding 
  """
  Enter pin
  A = OK
  """
When jeg taster inn "1234" for pin
And trykker på knapp A
Then vises medling 
  """
  Select Account
  A = Checking
  B = Savings
  C = Exit
  """
When trykker på knapp A
Then vises medling 
  """
  Balance= 600 kr
  A=Deposit
  B=Withdrawal
  C=Cancel
  """
When jeg tar ut 200 kr
Then kontoen skal ha en saldo på 400 kr
Then vises medling
  """
  Balance= 400 kr
  A=Deposit
  B=Withdrawal
  C=Cancel
  """
  
Scenario: Kanseler
Given Jeg har 400 kr på konto
Then vises melding 
  """
  Enter customer number
  A = OK
  """
When jeg taster inn "102" for kudenummer
And trykker på knapp A
Then vises melding 
  """
  Enter pin
  A = OK
  """
When jeg taster inn "1234" for pin
And trykker på knapp A
Then vises melding 
  """
  Select Account
  A = Checking
  B = Savings
  C = Exit
  """
When trykker på knapp B
Then vises medling 
  """
  Balance= 400 kr
  A=Deposit
  B=Withdrawal
  C=Cancel
 """
When trykker på knapp C
Then vises medling 
  """
  Select Account
  A = Checking
  B = Savings
  C = Exit
  """

Scenario: Avslutt
Given Jeg har 600 kr på konto
Then vises melding 
  """
  Enter customer number
  A = OK
  """
When jeg taster inn "103" for kudenummer
And trykker på knapp A
Then vises melding 
  """
  Enter pin
  A = OK
  """
When jeg taster inn "1234" for pin
And trykker på knapp A
Then vises medling 
  """
  Select Account
  A = Checking
  B = Savings
  C = Exit
  """
When trykker på knapp C
Then vises medling 
  """
  Enter customer number
  A = OK
  """
  
 Scenario: Kundenummeret ekistere ikke
Given Jeg har 600 kr på konto
Then vises melding 
  """
  Enter customer number
  A = OK
  """
When jeg taster inn "234" for kudenummer
And trykker på knapp A
Then vises melding 
  """
  Enter pin
  A = OK
  """
  When jeg taster inn "456" for pin
And trykker på knapp A
Then vises melding 
  """
  Enter customer number
  A = OK
  """
Scenario: Feil Pin
Given Jeg har 600 kr på konto
Then vises melding 
  """
  Enter customer number
  A = OK
  """
When jeg taster inn "102" for kudenummer
And trykker på knapp A
Then vises melding 
  """
  Enter pin
  A = OK
  """
When jeg taster inn "123" for pin
And trykker på knapp A
Then vises medling 
  """
  Enter customer number
  A = OK
  """


