const prompt = require("prompt-sync")()

let number_of_student = Number(prompt("Enter number of students: "))
let number_of_subject = Number(prompt("Enter number of subjects: "))

let students = []
let subject_summary = []

let best_grad = -Infinity
let worst_grad = Infinity
let best_grad_name = ""
let worst_grad_name = ""

let class_total = 0
let class_average = 0

let overall_high_score = -1
let overall_high_score_student_name = ""
let overall_high_score_subject_name = ""

let overall_lowest_score = Infinity
let overall_lowest_score_student_name = ""
let overall_lowest_score_subject_name = ""

for (let i = 0;  i < number_of_student ; i++) {
    let student_name = prompt(`\nEnter name for student ${i + 1}: `)
    let scores = []
    let total = 0

    for (let j = 0 ; j < number_of_subject;  j++) {
        let score
        while (true) {
            score = Number(prompt(`Enter score for subject ${j + 1}: `))
            if (score >= 1 && score <= 100) break
                console.log("Score must be between 1 and 100.")
        }

        scores.push(score)
        total += score

        if (score > overall_high_score) {
            overall_high_score = score
            overall_high_score_student_name = student_name
            overall_high_score_subject_name = `Subject ${j + 1}`
        }

        if (score < overall_lowest_score) {
            overall_lowest_score = score
            overall_lowest_score_student_name = student_name
            overall_lowest_score_subject_name = `Subject ${j + 1}`
        }
    }

    if (total > best_grad) {
        best_grad = total
        best_grad_name = student_name
    }

    if (total < worst_grad) {
        worst_grad = total
        worst_grad_name = student_name
    }

    class_total += total

    let student = {
        name: student_name,
        scores: scores,
        total: total,
        average: total / number_of_subject,
    }

    students.push(student)
}

for (let index = 0 ; index < number_of_subject ; index++) {
    let highest_score = -1
    let lowest_score = 101
    let total_score = 0
    let number_of_pass = 0
    let number_of_fail = 0
    let highest_scorer = ""
    let lowest_scorer = ""

    for (let student of students) {
        let score = student.scores[index]
        total_score += score

        if (score >= 50) {
            number_of_pass += 1
        } else {
            number_of_fail += 1
        }

        if (score > highest_score) {
            highest_score = score
            highest_scorer = student.name
        }

        if (score < lowest_score) {
            lowest_score = score
            lowest_scorer = student.name
        }
    }

    subject_summary.push({
        subject: index + 1,
        highest_score: highest_score,
        lowest_score: lowest_score,
        highest_scorer: highest_scorer,
        lowest_scorer: lowest_scorer,
        number_of_pass: number_of_pass,
        number_of_fail: number_of_fail,
        total: total_score,
        average: total_score / number_of_student,
    })
}

let hardest_subject = 0
let easiest_subject = 0
let hardest = ""
let easiest = ""

for (let subject of subject_summary) {
    if (subject.number_of_pass > easiest_subject) {
        easiest_subject = subject.number_of_pass
        easiest = `Subject ${subject.subject}`
    }

    if (subject.number_of_fail > hardest_subject) {
        hardest_subject = subject.number_of_fail
        hardest = `Subject ${subject.subject}`
    }
}


console.log("\n--- Student Scores ---")
for (let student of students) {
    let formatted_scores = student.scores.join("  ");
    console.log(
        `Student: ${student.name} | Scores: ${formatted_scores} | ${student.total} | ${student.average.toFixed(2)}`
    );
}


console.log("\n--- Subject Summary ---")
for (let subject of subject_summary) {
    console.log(`\nSubject ${subject.subject}`)
    console.log(`Total Score: ${subject.total}`)
    console.log(`Average Score: ${subject.average.toFixed(2)}`)
    console.log(`Highest Score: ${subject.highest_score} by ${subject.highest_scorer}`)
    console.log(`Lowest Score: ${subject.lowest_score} by ${subject.lowest_scorer}`)
    console.log(`Passed: ${subject.number_of_pass}`)
    console.log(`Failed: ${subject.number_of_fail}`)
}

console.log(`\nOverall Highest Score: ${overall_high_score} by ${overall_high_score_student_name} in ${overall_high_score_subject_name}`)
console.log(`Overall Lowest Score: ${overall_lowest_score} by ${overall_lowest_score_student_name} in ${overall_lowest_score_subject_name}`)

console.log(`\nEasiest Subject: ${easiest} with ${easiest_subject} passes`)
console.log(`Hardest Subject: ${hardest} with ${hardest_subject} fails`)

console.log(`\nBest Graduating Student: ${best_grad_name} with total ${best_grad}`)
console.log(`Worst Graduating Student: ${worst_grad_name} with total ${worst_grad}`)

class_average = class_total / (number_of_student * number_of_subject)
console.log(`\nClass Total: ${class_total}`)
console.log(`Class Average: ${class_average.toFixed(2)}`)
