import function_mbti
def main():
        questions = [
            ("A. expand energy, enjoy groups", "B. conserve energy, enjoy one-on-one"),
            ("A. more outgoing, think out loud", "B. more reserved, think to you"),
            ("A. seek many tasks, public activities", "B. interaction with others"),
            ("A. external, communicative, express yourself", "B. internal, reticent"),
            ("A. active, initiate", "B. reflective, deliberate"),
            ("A. Interpret literally", "B. look for meaning and possibilities"),
            ("A. practical, realistic, experiential", "B. imaginative, innovative"),
            ("A. standard, usual, conventional", "B. different, novel, unique"),
            ("A. focus on here-and-now", "B. look to the future, global perspective big picture"),
            ("A. facts, things, what is", "B. ideas, dreams, what could be, philosophical"),
            ("A. logical, thinking, questioning", "B. empathetic, feeling, accommodating"),
            ("A. candid, straight forward, frank", "B. tactful, kind, encouraging"),
            ("A. firm, tend to criticize, hold the line", "B. gentle, tend to appreciate, conciliate"),
            ("A. tough-minded, just", "B. tender-hearted, merciful"),
            ("A. matter of fact, issue-oriented", "B. sensitive, people-oriented compassionate"),
            ("A. organized, orderly", "B. flexible, adaptable"),
            ("A. plan, schedule", "B. unplanned, spontaneous"),
            ("A. regulated, structured", "B. easy-going, live and let live"),
            ("A. preparation, plan ahead", "B. go with the flow, adapt as you go"),
            ("A. control, govern", "B. latitude, freedom")
        ]

        username = input("What is your name? ")

        user_report = []
        general_report = []
        personality_report = []
        count_a = 0
        count_b = 0

        personality_types = ["E", "I", "S", "N", "T", "F", "J", "P"]
        personality_index = 0

        for i, (option_a, option_b) in enumerate(questions):
            print(f"Question {i + 1}:")
            print(option_a)
            print(option_b)
            answer = input("Your choice (A/B): ").strip().upper()
            while answer not in ["A", "B"]:
                print("Invalid choice. Please enter A or B.")
                answer = input("Your choice (A/B): ").strip().upper()

            if answer == "A":
                count_a += 1
                user_report.append(option_a)
            else:
                count_b += 1
                user_report.append(option_b)

            if (i + 1) % 5 == 0 or i == len(questions) - 1:
                if count_a > count_b:
                    personality_report.append(personality_types[personality_index])
                else:
                    personality_report.append(personality_types[personality_index + 1])

                user_report.append(f"Number of A selected: {count_a}")
                user_report.append(f"Number of B selected: {count_b}")
                user_report.append("  ")
                general_report.extend(user_report)
                user_report.clear()
                count_a = 0
                count_b = 0
                personality_index += 2

        print(f"\nHello {username}, you chose:")
        for i in general_report:
            print(i)

        personality_type = "".join(personality_report)
        print(f"\nPersonality Type: {personality_type}")
        print(function_mbti.personType(personality_type))
print(main())


