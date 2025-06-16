import unittest
from datetime import date
import function_mensturalapp

class TestDateFunctions(unittest.TestCase):

    def test_start_date_valid(self):
        result = function_mensturalapp.start_date(2025, 6, 6)
        self.assertEqual(result, date(2025, 6, 6))

    def test_start_date_invalid(self):
        result = function_mensturalapp.start_date(2025, 2, 30)
        self.assertIsNone(result)

    def test_predict_ovulation_period(self):
        start = date(2025, 6, 6)
        expected = [
            date(2025, 6, 20),
            date(2025, 6, 21),
            date(2025, 6, 22),
            date(2025, 6, 23),
            date(2025, 6, 24),
            date(2025, 6, 25)
        ]
        self.assertEqual(function_mensturalapp.predict_ovulation_period(start), expected)

    def test_safe_periods(self):
        start = date(2025, 6, 6)
        expected = [
            date(2025, 6, 12),
            date(2025, 6, 13),
            date(2025, 6, 14),
            date(2025, 6, 15)
        ]
        self.assertEqual(function_mensturalapp.safe_periods(start), expected)

    def test_predict_period_end(self):
        start = date(2025, 6, 6)
        period_length = 5
        expected = date(2025, 6, 10)
        self.assertEqual(function_mensturalapp.predict_period_end(start, period_length), expected)

    def test_predict_next_period(self):
        start = date(2025, 6, 6)
        cycle_length = 28
        expected = date(2025, 7, 4)
        self.assertEqual(function_mensturalapp.predict_next_period(start, cycle_length), expected)


