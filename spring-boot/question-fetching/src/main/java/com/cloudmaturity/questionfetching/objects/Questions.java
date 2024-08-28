package com.cloudmaturity.questionfetching.objects;

public class Questions
{
    private String question0;
    private String question1;
    private String question2;
    private String question3;
    private String question4;

    public Questions(){}
    public Questions(String q0, String q1, String q2, String q3, String q4)
    {
        this.question0 = q0; this.question1 = q1; this.question2 = q2;
        this.question3 = q3; this.question4 = q4;
    }

    public String getQuestion0() { return question0; }
    public String getQuestion1() { return question1; }
    public String getQuestion2() { return question2; }
    public String getQuestion3() { return question3; }
    public String getQuestion4() { return question4; }
}
