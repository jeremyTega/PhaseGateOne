import function_mensturalapp
print("====welcome to your menstrual tracker====")
day=int(input("enter the day start of your menstural flow eg: 1 - 31: "))
month=int(input("enter the month of your menstural flow eg: 1 - 12: "))
year=int(input("enter the year of your menstural flow eg: 2025: "))
start = function_mensturalapp.start_date(year,month, day)
print(f'your menstural cycle starts on the {start}')
print(f'and your possible ovulation period are {function_mensturalapp.predict_ovulation_period(start)}')
print(f'your safe periods arre {function_mensturalapp.safe_periods(start)}')
