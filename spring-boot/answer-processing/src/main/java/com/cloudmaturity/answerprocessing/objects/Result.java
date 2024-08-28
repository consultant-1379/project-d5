package com.cloudmaturity.answerprocessing.objects;

public class Result
{
    private String teamName;
    private String category;
    private double result;

    public Result(){}
    public Result(String teamName, String category, double result)
    { this.teamName = teamName; this.category = category; this.result = result;}

    public String getTeamName() { return teamName; }
    public String getCategory() { return category; }
    public double getResult() { return result; }
}
