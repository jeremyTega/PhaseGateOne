def personType(type):
    descriptions = {
        "INTJ": "INTJ (The Architect): Innovative, independent, and strategic thinkers.",
        "INTP": "INTP (The Thinker): Curious, creative, and enjoys exploring new ideas.",
        "ENTJ": "ENTJ (The Commander): Bold, confident, and a natural leader.",
        "ENTP": "ENTP (The Debater): Energetic, loves debating, and enjoys a challenge.",
        "INFJ": "INFJ (The Advocate): Thoughtful, kind, and always looking for meaning in life.",
        "INFP": "INFP (The Mediator): Creative, sensitive, and guided by strong personal values.",
        "ENFJ": "ENFJ (The Protagonist): Charismatic, inspiring, and great at motivating others.",
        "ENFP": "ENFP (The Campaigner): Fun, energetic, and loves new experiences.",
        "ISTJ": "ISTJ (The Logistician): Practical, detail-oriented, reliable.",
        "ISFJ": "ISFJ (The Defender): Friendly, responsible, and conscientious.",
        "ESTJ": "ESTJ (The Executive): Organized, decisive, traditional.",
        "ESFJ": "ESFJ (The Consul): Warmhearted, conscientious, and cooperative.",
        "ISTP": "ISTP (The Virtuoso): Logical, adaptable, hands-on.",
        "ISFP": "ISFP (The Adventurer): Artistic, gentle, spontaneous.",
        "ESTP": "ESTP (The Entrepreneur): Energetic, pragmatic, risk-taking.",
        "ESFP": "ESFP (The Entertainer): Outgoing, friendly, and accepting."
    }
    return descriptions.get(type)
