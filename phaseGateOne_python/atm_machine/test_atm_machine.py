import methodsAtmMachine
import random
import unittest
from unittest.mock import patch

class TestATMFunctions(unittest.TestCase):


     def test_create_account(self):

        firstName = "Alice"
        lastName = "Smith"
        phone = "1234567890"
        pin = "4321"
        account = methodsAtmMachine.createAccount(firstName, lastName,  pin)
        self.assertEqual(account["firstName"], firstName)
        self.assertEqual(account["lastName"], lastName)
        self.assertEqual(account["pin"], pin)


     def test_deposit_success(self):
            createAccount("John", "Doe", account_number,"123456789")
            account_number = 123456789
            amount = 1000.0
            expected_balance = 6000.0
            result = methodsAtmMachine.depositMoney(account_number, amount)
            # self.assertIn("Deposit successful", result)
            # self.assertIn(f"New balance: {expected_balance}", result)
            self.assertEqual (expected_balance, result )
