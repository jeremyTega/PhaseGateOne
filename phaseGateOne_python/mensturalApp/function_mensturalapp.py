from datetime import date, timedelta

def start_date(year, month, day):
    try:
        return date(year, month, day)
    except ValueError as e:
        print(f"Invalid date: {e}")
        return None

def predict_ovulation_period(start_date):
    return [start_date + timedelta(days=i) for i in range(14, 20)]

def safe_periods(start_date):
    return [start_date + timedelta(days=i) for i in range(6, 10)]

def predict_period_end(start_date, period_length):
    return start_date + timedelta(days=period_length - 1)

def predict_next_period(start_date, cycle_length):
    return start_date + timedelta(days=cycle_length)
