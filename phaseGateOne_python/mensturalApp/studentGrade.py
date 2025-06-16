number_of_student = int(input("Enter number of students: "))
number_of_subject = int(input("Enter number of subjects: "))

students = []
subject_summary = []

best_grad = float('-inf')
worst_grad = float('inf')

best_grad_name = ""
worst_grad_name = ""

class_total = 0
class_average = 0

overall_high_score = -1
overall_high_score_student_name = ""
overall_high_score_subject_name = ""

overall_lowest_score = 1000000000000000000000000000000000000000
overall_lowest_score_student_name = ""
overall_lowest_score_subject_name = ""

for i in range(number_of_student):
    student_name = input(f"\nEnter name for student {i + 1}: ")
    scores = []
    total = 0
    average = 0

    for j in range(number_of_subject):
       while True:
             score = int(input(f"Enter score for subject {j + 1}: "))
             if 1 <= score <= 100:
              break
             print("Score must be between 1 and 100.")
       total += score
       scores.append(score)
    if total > best_grad:
            best_grad = total
            best_grad_name = student_name

    if total < worst_grad:
            worst_grad = total
            worst_grad_name = student_name
    class_total += total

    if score > overall_high_score:
           overall_high_score = score
           overall_high_score_student_name = student_name
           overall_high_score_subject_name = f"Subject {j + 1}"

    if score < overall_lowest_score:
            overall_lowest_score = score
            overall_lowest_score_student_name = student_name
            overall_lowest_score_subject_name = f"Subject {j + 1}"



    student = {
        "name": student_name,
        "scores": scores,
        "total": total,
        "average":(total/ number_of_subject)
    }
    students.append(student)

for index in range(number_of_subject):
  highest_score = -1
  lowest_score = 101
  total_score = 0
  average_score =0
  number_of_pass = 0
  number_of_fail= 0
  highest_scorer = ""
  lowest_scorer = ""
  subjetc = 0
  for student in students:
      score = student['scores'][index]
      total_score += score
      average_score = total_score / number_of_student
      if score >= 50:
          number_of_pass += 1
      else:
          number_of_fail +=1
      if score > highest_score:
          highest_score = score
          highest_scorer = student['name']

      if score < lowest_score:
          lowest_score = score
          lowest_scorer = student['name']

  subject_data = {
        'subject': index + 1,
        'highest_score': highest_score,
        'lowest_score': lowest_score,
        'highest_scorer': highest_scorer,
        'lowest_scorer': lowest_scorer,
        'number_of_pass': number_of_pass,
        'number_of_fail': number_of_fail,
        'total': total_score,
        'average': total_score / number_of_student
    }
  subject_summary.append(subject_data)


hardest_subject = 0
easiest_subject = 0
hardest = ""
easiest = ""

for index in range(number_of_subject):
    subject_data = subject_summary[index]

    temp_pass = subject_data["number_of_pass"]
    if temp_pass > easiest_subject:
        easiest_subject = temp_pass
        easiest = f"Subject {subject_data['subject']}"

    temp_fail = subject_data["number_of_fail"]
    if temp_fail > hardest_subject:
        hardest_subject = temp_fail
        hardest = f"Subject {subject_data['subject']}"



print("\n--- Student Scores ---")
for student in students:
    formatted_scores = [f"{score}" for score in student['scores']]
    print(f"Student: {student['name']:<2} | Scores: {'  '.join(formatted_scores)} | {student['total']} | {student['average']:.2f}")


print("\n--- Subject Summary ---")
for subject in subject_summary:
    print(f"\n Subject {subject['subject']}")
    print(f"Total Score: {subject['total']}")
    print(f"Average Score: {subject['average']:.2f}")
    print(f"Highest Score: {subject['highest_score']} by {subject['highest_scorer']}")
    print(f"Lowest Score: {subject['lowest_score']} by {subject['lowest_scorer']}")
    print(f"Passed: {subject['number_of_pass']}")
    print(f"Failed: {subject['number_of_fail']}")



print(f"\nOverall Highest Score: {overall_high_score} by {overall_high_score_student_name} in {overall_high_score_subject_name}")
print(f"Overall Lowest Score: {overall_lowest_score} by {overall_lowest_score_student_name} in {overall_lowest_score_subject_name}")

print(f"\nEasiest Subject: {easiest} with {easiest_subject} passes")
print(f"Hardest Subject: {hardest} with {hardest_subject} fails")
print(f"\n Best Graduating Student: {best_grad_name} with total {best_grad}")
print(f" Worst Graduating Student: {worst_grad_name} with total {worst_grad}")


class_average = class_total / (number_of_student * number_of_subject)
print(f"\nClass Total: {class_total}")
print(f" Class Average: {class_average:.2f}")
