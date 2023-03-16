### Bank Account Test

Java (JDK) and Maven should be installed and added to System variables.

- Clone repo to local dir and open cmd.exe in it
- To get results and HTML report, run: mvn test
- Report is created in: target/surefire-reports/index.html

User story:

Create a test for the Account class.

* Check if the constructor Account(String name, String number) sets the arguments well (when the account is created, the balance should be equal to 0.0).
* Check if the setters set the appropriate values and if the getters return the appropriate values.
* Check if the Account printout format is correct: number&emsp;name&emsp;balance. The balance should be rounded to 2 decimals.
* Create 100,000 accounts using the constructor Account(String name) and check if all numbers are different.

Create a test for the Bank class.  
For all tests, create a unique bank that is reset before each test.  
Consider that this bank cannot have an account with a negative balance.

* Check if opening an account works properly by inserting 5 accounts and then checking if those accounts can be retrieved.
* Check if the payment method works well.
* Check if the money transfer method works well.
* Check if the method for calculating the total money in the bank (getSumMoney) works well.

If an error is found in the code based on the tests, fix the original code.