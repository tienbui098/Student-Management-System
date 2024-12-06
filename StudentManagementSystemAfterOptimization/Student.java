package org.StudentManagementSystemAfterOptimization;

public class Student {
    private String id;
    private String name;
    private double score;

    public Student(String id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getRanking() {
        if (score < 5.0) return "Fail";
        if (score < 6.5) return "Medium";
        if (score < 7.5) return "Good";
        if (score < 9.0) return "Very Good";
        return "Excellent";
    }

    @Override
    public String toString() {
        return String.format("ID: %s, Name: %s, Score: %.1f, Ranking: %s", id, name, score, getRanking());
    }
}