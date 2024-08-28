package com.cloudmaturity.database.assessment;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document("Assessment")
public class Assessment {


    @Id
    private String ID;

    //Assessment reference info
    private String teamName;
    //Assessment result info
    private double cultureScore;
    private double prodServiceDesignScore;
    private double teamScore;
    private double processScore;
    private double architectureScore;
    private double maintenanceScore;
    private double deliveryScore;
    private double provisioningScore;
    private double infrastructureScore;


    public Assessment(String teamName, double cultureScore, double prodServiceDesignScore
            , double teamScore, double processScore
            , double architectureScore, double maintenanceScore, double deliveryScore, double provisioningScore, double infrastructureScore)
    {
        this.teamName = teamName;
        this.cultureScore = cultureScore;
        this.prodServiceDesignScore = prodServiceDesignScore;
        this.teamScore = teamScore;
        this.processScore = processScore;
        this.architectureScore = architectureScore;
        this.maintenanceScore = maintenanceScore;
        this.deliveryScore = deliveryScore;
        this.provisioningScore = provisioningScore;
        this.infrastructureScore = infrastructureScore;
    }

    public String getID()
    {
        return ID;
    }

    public String getTeamName()
    {
        return teamName;
    }

    public double getCultureScore() {
        return cultureScore;
    }

    public double getProdServiceDesignScore() {
        return prodServiceDesignScore;
    }

    public double getTeamScore() {
        return teamScore;
    }

    public double getProcessScore() {
        return processScore;
    }

    public double getArchitectureScore() {
        return architectureScore;
    }

    public double getMaintenanceScore() {
        return maintenanceScore;
    }

    public double getDeliveryScore() {
        return deliveryScore;
    }

    public double getProvisioningScore() {
        return provisioningScore;
    }

    public double getInfrastructureScore() {
        return infrastructureScore;
    }

    public void setCultureScore(double cultureScore) {
        this.cultureScore = cultureScore;
    }

    public void setProdServiceDesignScore(double prodServiceDesignScore) {
        this.prodServiceDesignScore = prodServiceDesignScore;
    }

    public void setTeamScore(double teamScore) {
        this.teamScore = teamScore;
    }

    public void setProcessScore(double processScore) {
        this.processScore = processScore;
    }

    public void setArchitectureScore(double architectureScore) {
        this.architectureScore = architectureScore;
    }

    public void setMaintenanceScore(double maintenanceScore) {
        this.maintenanceScore = maintenanceScore;
    }

    public void setDeliveryScore(double deliveryScore) {
        this.deliveryScore = deliveryScore;
    }

    public void setProvisioningScore(double provisioningScore) {
        this.provisioningScore = provisioningScore;
    }

    public void setInfrastructureScore(double infrastructureScore) {
        this.infrastructureScore = infrastructureScore;
    }
}
