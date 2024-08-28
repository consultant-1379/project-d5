package com.cloudmaturity.answerprocessing.objects;

public class Answers
{
    private String teamName;
    private String category;
    private boolean q0Ans; //question 0 refers to the initial question that determines if you are cloud native or not
    private boolean q1Ans;
    private boolean q2Ans;
    private boolean q3Ans;
    private boolean q4Ans;

    public Answers(){}
    public Answers(String teamName, String category, boolean q0Ans, boolean q1ans, boolean q2ans, boolean q3ans, boolean q4ans)
    {
        this.teamName = teamName; this.category = category; this.q0Ans = q0Ans; this.q1Ans = q1ans; this.q2Ans = q2ans; this.q3Ans = q3ans; this.q4Ans = q4ans;
    }

    public String getTeamName() { return teamName; }
    public String getCategory() { return category; }
    public boolean getQ0Ans() { return q0Ans; }
    public boolean getQ1Ans() { return q1Ans; }
    public boolean getQ2Ans() { return q2Ans; }
    public boolean getQ3Ans() { return q3Ans; }
    public boolean getQ4Ans() { return q4Ans; }
}
