package com.smart.quizapp;

import java.util.ArrayList;
import java.util.Collections;

public class QuizData {

    public static ArrayList<Question> getQuestions(String topic) {
        ArrayList<Question> list = new ArrayList<>();

        switch (topic) {
            case "Android":
                list.add(new Question(
                        "Which language is used for Android?",
                        "Swift", "Java", "Python", "Ruby",
                        2
                ));
                list.add(new Question(
                        "Which company developed Android?",
                        "Apple", "Microsoft", "Google", "Amazon",
                        3
                ));
                list.add(new Question(
                        "What is Android Studio?",
                        "IDE", "OS", "Language", "Browser",
                        1
                ));
                list.add(new Question(
                        "Minimum SDK defines?",
                        "App size", "Android version support", "Speed", "UI",
                        2
                ));
                list.add(new Question(
                        "What is an APK?",
                        "Android Package Kit", "Android Programming Kit", "Android Project Kit", "Application Package Kit",
                        1
                ));
                break;
            case "Java":
                list.add(new Question(
                        "Who invented Java?",
                        "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "Guido van Rossum",
                        1
                ));
                list.add(new Question(
                        "What is the extension of a Java file?",
                        ".java", ".class", ".jar", ".j",
                        1
                ));
                list.add(new Question(
                        "What is the main method in Java?",
                        "public static void main(String[] args)", "public void main(String[] args)", "private static void main(String[] args)", "static void main(String[] args)",
                        1
                ));
                break;
            case "Kotlin":
                list.add(new Question(
                        "Which company developed Kotlin?",
                        "JetBrains", "Google", "Microsoft", "Oracle",
                        1
                ));
                list.add(new Question(
                        "Is Kotlin 100% interoperable with Java?",
                        "Yes", "No", "Only with some libraries", "Only with some versions",
                        1
                ));
                list.add(new Question(
                        "What is the keyword to declare a variable in Kotlin?",
                        "var", "val", "let", "const",
                        1
                ));
                break;
        }

        Collections.shuffle(list);
        return list;
    }
}