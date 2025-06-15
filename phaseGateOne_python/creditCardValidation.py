def validate_credit_card(credit_card):
    credit_card = credit_card.strip()
    card_type = ""
    card_valid = ""
    card_length = len(credit_card)

    if credit_card.startswith("4"):
        card_type = "Visa Card"
    elif credit_card.startswith("5"):
        card_type = "MasterCard"
    elif credit_card.startswith("37"):
        card_type = "American Express Card"
    elif credit_card.startswith("6"):
        card_type = "Discovery Card"
    else:
        card_type = "Invalid Card"

    even_sum = 0
    odd_sum = 0
    temp = 0

    for i in range(card_length - 1, -1, -1):
        digit = int(credit_card[i])
        temp += 1

        if temp % 2 == 0:
            digit *= 2
            if digit > 9:
                digit -= 9
            even_sum += digit
        else:
            odd_sum += digit

    total_sum = even_sum + odd_sum
    card_valid = "Valid" if total_sum % 10 == 0 else "Invalid"

    print("Credit Card Number:", credit_card)
    print("Card Type:", card_type)
    print("Card Length:", card_length)
    print("Card Validity:", card_valid)


validate_credit_card("4539578763621486")
