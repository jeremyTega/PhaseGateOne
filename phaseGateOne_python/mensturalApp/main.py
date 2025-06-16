import function_mensturalapp

print("==== Welcome to Your Menstrual Tracker ====")

day = int(input("Enter the day your menstrual flow starts (1-31): "))
month = int(input("Enter the month (1-12): "))
year = int(input("Enter the year (e.g. 2025): "))

period_length = int(input("Enter your average period length (e.g. 5): "))
cycle_length = int(input("Enter your average cycle length (e.g. 28): "))

start = function_mensturalapp.start_date(year, month, day)

if start:
    print(f"\n Your menstrual cycle starts on: {start.strftime('%d %b %Y')}")

    end = function_mensturalapp.predict_period_end(start, period_length)
    print(f"Your period may end around: {end.strftime('%d %b %Y')}")

    next_start = function_mensturalapp.predict_next_period(start, cycle_length)
    print(f"Your next period is expected around: {next_start.strftime('%d %b %Y')}")

    print("\nYour ovulation period may be:")
    for date in function_mensturalapp.predict_ovulation_period(start):
        print("  -", date.strftime('%d %b %Y'))

    print(" Your safe period may be:")
    for date in function_mensturalapp.safe_periods(start):
        print("  -", date.strftime('%d %b %Y'))
else:
    print("Failed to calculate due to invalid date input.")
