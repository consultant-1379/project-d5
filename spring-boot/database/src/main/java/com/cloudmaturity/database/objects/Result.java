package com.cloudmaturity.database.objects;

import com.cloudmaturity.database.assessment.Assessment;

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

    public Assessment amendAssessment(Assessment assessment)
    {
        Assessment temp = assessment;
        switch(category.toLowerCase())
        {
            case "culture":
                temp.setCultureScore(result);
                break;
            case "prodservicedesign":
                temp.setProdServiceDesignScore(result);
                break;
            case "team":
                temp.setTeamScore(result);
                break;
            case "process":
                temp.setProcessScore(result);
                break;
            case "architecture":
                temp.setArchitectureScore(result);
                break;
            case "maintenance":
                temp.setMaintenanceScore(result);
                break;
            case "delivery":
                temp.setDeliveryScore(result);
                break;
            case "provisioning":
                temp.setProvisioningScore(result);
                break;
            case "infrastructure":
                temp.setInfrastructureScore(result);
                break;
        }
        return temp;
    }
}
