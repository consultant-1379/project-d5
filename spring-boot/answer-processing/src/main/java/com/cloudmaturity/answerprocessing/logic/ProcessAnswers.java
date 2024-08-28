package com.cloudmaturity.answerprocessing.logic;

import com.cloudmaturity.answerprocessing.objects.Answers;
import com.cloudmaturity.answerprocessing.objects.Result;

public class ProcessAnswers
{
    /*
     *  Processes the answers received from user to determine a result
     * From spec: "If you answered Yes to question 1 and/or 3, place your dot on Predictive.
     * If you answered Yes to questions 2 and/or 4, place your dot on Iterative. If you answered
     * Yes to a mix of odd and even numbered questions (or none at all), place your dot halfway along
     * the dotted line between the two."
     *
     * result is a double between 0-4 as is defined as such:
     * No Process = 0
     * Waterfall = 1
     * Agile = 2
     * Cloud Native = 3
     * Next = 4
     *
     * In-between is allowed, the in-between of waterfall and agile is 1.5
     */
    public Result process(Answers answers)
    {
        if(answers.getQ0Ans()){ return new Result(answers.getTeamName(), answers.getCategory(), 3); }

        boolean isWaterfall = answers.getQ1Ans() || answers.getQ3Ans();
        boolean isAgile = answers.getQ2Ans() || answers.getQ4Ans();
        boolean isBoth = isAgile && isWaterfall;
        boolean isNothing = !isAgile && !isWaterfall;

        double result = 0;
        if(isBoth || isNothing) { result = 1.5; }
        else if(isWaterfall) { result = 1; }
        else { result = 2; }

        return new Result(answers.getTeamName(), answers.getCategory(), result);
    }
}
