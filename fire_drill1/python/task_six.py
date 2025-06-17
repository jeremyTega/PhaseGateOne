for i in range(1, 11):
    if i >= 4 and i % 4 == 0:
        temp = i
        count = 0
        while count <= 4:
            print(temp)
            temp = temp * i
            count += 1
