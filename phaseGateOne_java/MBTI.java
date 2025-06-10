import java.util.ArrayList;
import java.util.Scanner;

public class MBTI {


public static String personType(String type) {
    if (type.equals("INTJ")) {
        return """
            INTJ (The Architect): Innovative, independent, and strategic thinkers.
            """;
    } else if (type.equals("INTP")) {
        return """
            INTP (The Thinker): Curious, creative, and enjoys exploring new ideas.
            """;
    } else if (type.equals("ENTJ")) {
        return """
            ENTJ (The Commander): Bold, confident, and a natural leader.
            """;
    } else if (type.equals("ENTP")) {
        return """
            ENTP (The Debater): Energetic, loves debating, and enjoys a challenge.
            """;
    } else if (type.equals("INFJ")) {
        return """
            INFJ (The Advocate): Thoughtful, kind, and always looking for meaning in life.
            """;
    } else if (type.equals("INFP")) {
        return """
            INFP (The Mediator): Creative, sensitive, and guided by strong personal values.
            """;
    } else if (type.equals("ENFJ")) {
        return """
            ENFJ (The Protagonist): Charismatic, inspiring, and great at motivating others.
            """;
    } else if (type.equals("ENFP")) {
        return """
            ENFP (The Campaigner): Fun, energetic, and loves new experiences.
            """;
    } else if (type.equals("ISTJ")) {
        return """
            ISTJ (The Logistician): Practical, detail-oriented, reliable.
            """;
    } else if (type.equals("ISFJ")) {
        return """
            ISFJ (The Defender): Friendly, responsible, and conscientious.
            """;
    } else if (type.equals("ESTJ")) {
        return """
            ESTJ (The Executive): Organized, decisive, traditional.
            """;
    } else if (type.equals("ESFJ")) {
        return """
            ESFJ (The Consul): Warmhearted, conscientious, and cooperative.
            """;
    } else if (type.equals("ISTP")) {
        return """
            ISTP (The Virtuoso): Logical, adaptable, hands-on.
            """;
    } else if (type.equals("ISFP")) {
        return """
            ISFP (The Adventurer): Artistic, gentle, spontaneous.
            """;
    } else if (type.equals("ESTP")) {
        return """
            ESTP (The Entrepreneur): Energetic, pragmatic, risk-taking.
            """;
    } else if (type.equals("ESFP")) {
        return """
            ESFP (The Entertainer): Outgoing, friendly, and accepting.
            """;
    } else {
        return "Unknown personality type.";
    }
}
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[][] questions = {
            {"A. expand energy, enjoy groups", "B. conserve energy, enjoy one-on-one"},
            {"A. more outgoing, think out loud", "B. more reserved, think to you"},
            {"A. seek many tasks, public activities", "B. interaction with others"},
            {"A. external, communicative, express yourself", "B. internal, reticent"},
            {"A. active, initiate", "B. reflective, deliberate"},
            {"A. Interpret literally", "B. look for meaning and possibilities"},
            {"A. practical, realistic, experiential", "B. imaginative, innovative"},
            {"A. standard, usual, conventional", "B. different, novel, unique"},
            {"A. focus on here-and-now", "B. look to the future, global perspective big picture"},
            {"A. facts, things, what is", "B. ideas, dreams, what could be, philosophical"},
            {"A. logical, thinking, questioning", "B. empathetic, feeling, accommodating"},
            {"A. candid, straight forward, frank", "B. tactful, kind, encouraging"},
            {"A. firm, tend to criticize, hold the line", "B. gentle, tend to appreciate, conciliate"},
            {"A. tough-minded, just", "B. tender-hearted, merciful"},
            {"A. matter of fact, issue-oriented", "B. sensitive, people-oriented compassionate"},
            {"A. organized, orderly", "B. flexible, adaptable"},
            {"A. plan, schedule", "B. unplanned, spontaneous"},
            {"A. regulated, structured", "B. easy-going, live and let live"},
            {"A. preparation, plan ahead", "B. go with the flow, adapt as you go"},
            {"A. control, govern", "B. latitude, freedom"}
        };
        System.out.println("what is your name");
        String username = input.nextLine();

        ArrayList<String> userReport = new ArrayList<>();
        ArrayList<String> generalReport = new ArrayList<>();
        ArrayList<String> personalityReport = new ArrayList<>();
        int countA = 0;
        int countB = 0;

        String[] personalityTypes = {"E", "I", "S", "N", "T", "F", "J", "P"};
        int personalityIndex = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i][0]);
            System.out.println(questions[i][1]);
            String answer = input.nextLine().trim().toUpperCase();
            while (!answer.equals("A") && !answer.equals("B")) {
                System.out.println("Invalid choice. Please enter A or B.");
                answer = input.nextLine().trim().toUpperCase();
            }
            if (answer.equals("A")) {
                countA++;
                userReport.add(questions[i][0]);
            } else {
                countB++;
                userReport.add(questions[i][1]);
            }
            if ((i + 1) % 5 == 0 || i == questions.length - 1) {
                if (countA > countB) {
                    personalityReport.add(personalityTypes[personalityIndex]);
                } else {
                    personalityReport.add(personalityTypes[personalityIndex + 1]);
                }
                userReport.add("Number of A selected: " + countA);
                userReport.add("Number of B selected: " + countB);
                userReport.add("  ");
                generalReport.addAll(userReport);
                 userReport.clear();
                 countA = 0;
                 countB = 0;
                personalityIndex += 2;
            }
        }
        System.out.println("Hello" + username + " you choose: ");
        for (String entry : generalReport) {
            System.out.println(entry);
        }
        System.out.println("\nPersonality Type: " + String.join("", personalityReport));
        String userPersonality = String.join("",personalityReport);
        System.out.println(personType(userPersonality));

    }
}
