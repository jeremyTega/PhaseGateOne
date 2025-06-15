from datetime import datetime


store = {
    "name": "SEMI COLON STORES",
    "branch": "MAIN BRANCH",
    "phone": "0808182545",
    "date": datetime.now().strftime("%Y-%m-%d %H:%M:%S"),
    "cashierName": ""
}


customer_name = input("What is the customer's name? ")
vat_rate = 7.5
sub_total = 0
items = []

while True:
    item_name = input("What did the customer buy? ")
    quantity = int(input("How many pieces? "))
    price = float(input("How much per unit? "))
    total = quantity * price
    items.append({"item": item_name, "quantity": quantity, "price": price, "total": total})
    sub_total += total

    add_more = input("Do you want to add more items?  ").lower()
    if add_more != "yes":
        break

store["cashierName"] = input("What is your name? ")
discount = float(input("Enter discount amount: "))
vat = (sub_total * vat_rate) / 100
bill_total = sub_total + vat - discount


print("\n--- RECEIPT ---")
print(f"Store: {store['name']}")
print(f"Branch: {store['branch']}")
print(f"Phone: {store['phone']}")
print(f"Date: {store['date']}")
print(f"Cashier: {store['cashierName']}")
print(f"Customer: {customer_name}")
print("\nItems Purchased:")
for item in items:
    print(f"{item['quantity']} x {item['item']} @ ₦{item['price']:.2f} each = ₦{item['total']:.2f}")
print(f"\nSubtotal: ₦{sub_total:.2f}")
print(f"VAT @ {vat_rate}%: ₦{vat:.2f}")
print(f"Discount: ₦{discount:.2f}")
print(f"Total: ₦{bill_total:.2f}")

amount_given = float(input("How much did the customer pay? "))
while amount_given < bill_total:
    print("Amount given is less than the total. Please enter a valid amount.")
    amount_given = float(input("How much did the customer pay? "))
change = amount_given - bill_total
print(f"Amount Paid: ₦{amount_given:.2f}")
print(f"Change: ₦{change:.2f}")
print("\nThank you for shopping with us!")
