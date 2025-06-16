const prompt = require("prompt-sync")()
const questions = [
["A. expand energy, enjoy groups", "B. conserve energy, enjoy one-on-one"],
["A. more outgoing, think out loud", "B. more reserved, think to you"],
["A. seek many tasks, public activities", "B. interaction with others"],
["A. external, communicative, express yourself", "B. internal, reticent"],
["A. active, initiate", "B. reflective, deliberate"],
["A. Interpret literally", "B. look for meaning and possibilities"],
["A. practical, realistic, experiential", "B. imaginative, innovative"],
["A. standard, usual, conventional", "B. different, novel, unique"],
["A. focus on here-and-now", "B. look to the future, global perspective big picture"],
["A. facts, things, what is", "B. ideas, dreams, what could be, philosophical"],
["A. logical, thinking, questioning", "B. empathetic, feeling, accommodating"],
["A. candid, straight forward, frank", "B. tactful, kind, encouraging"],
["A. firm, tend to criticize, hold the line", "B. gentle, tend to appreciate, conciliate"],
["A. tough-minded, just", "B. tender-hearted, merciful"],
["A. matter of fact, issue-oriented", "B. sensitive, people-oriented compassionate"],
["A. organized, orderly", "B. flexible, adaptable"],
["A. plan, schedule", "B. unplanned, spontaneous"],
["A. regulated, structured", "B. easy-going, live and let live"],
["A. preparation, plan ahead", "B. go with the flow, adapt as you go"],
["A. control, govern", "B. latitude, freedom"]
];

const personalityTypes = ["E", "I", "S", "N", "T", "F", "J", "P"];
const descriptions = {
    INTJ: "INTJ (The Architect): Innovative, independent, and strategic thinkers.",
    INTP: "INTP (The Thinker): Curious, creative, and enjoys exploring new ideas.",
    ENTJ: "ENTJ (The Commander): Bold, confident, and a natural leader.",
    ENTP: "ENTP (The Debater): Energetic, loves debating, and enjoys a challenge.",
    INFJ: "INFJ (The Advocate): Thoughtful, kind, and always looking for meaning in life.",
    INFP: "INFP (The Mediator): Creative, sensitive, and guided by strong personal values.",
    ENFJ: "ENFJ (The Protagonist): Charismatic, inspiring, and great at motivating others.",
    ENFP: "ENFP (The Campaigner): Fun, energetic, and loves new experiences.",
    ISTJ: "ISTJ (The Logistician): Practical, detail-oriented, reliable.",
    ISFJ: "ISFJ (The Defender): Friendly, responsible, and conscientious.",
    ESTJ: "ESTJ (The Executive): Organized, decisive, traditional.",
    ESFJ: "ESFJ (The Consul): Warmhearted, conscientious, and cooperative.",
    ISTP: "ISTP (The Virtuoso): Logical, adaptable, hands-on.",
    ISFP: "ISFP (The Adventurer): Artistic, gentle, spontaneous.",
    ESTP: "ESTP (The Entrepreneur): Energetic, pragmatic, risk-taking.",
    ESFP: "ESFP (The Entertainer): Outgoing, friendly, and accepting."
};

let userReport = [];
let personalityReport = [];
let countA = 0;
let countB = 0;
let personalityIndex = 0;

let name = prompt("What is your name?");

for (let i = 0; i < questions.length; i++) {
    let [optionA, optionB] = questions[i];
    let answer = prompt(
        `Question ${i + 1}:\n${optionA}\n${optionB}\nYour choice (A or B):`
    ).toUpperCase();

    while (answer !== "A" && answer !== "B") {
        answer = prompt("Invalid input. Please enter A or B:").toUpperCase();
    }

    if (answer === "A") {
        countA++;
        userReport.push(optionA);
    } else {
        countB++;
        userReport.push(optionB);
    }


    if ((i + 1) % 5 === 0 || i === questions.length - 1) {
        if (countA > countB) {
            personalityReport.push(personalityTypes[personalityIndex]);
        } else {
            personalityReport.push(personalityTypes[personalityIndex + 1]);
        }

        userReport.push(`Number of A: ${countA}, B: ${countB}\n`);
        countA = 0;
        countB = 0;
        personalityIndex += 2;
    }
}

const personalityType = personalityReport.join("");
let result = `Hello ${name}!\n\nYou chose:\n` + userReport.join("\n") + `\nYour Personality Type: ${personalityType}\n` +
(descriptions[personalityType] || "Unknown personality type.");
console.log(result)
