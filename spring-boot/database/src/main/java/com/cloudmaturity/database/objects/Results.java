package com.cloudmaturity.database.objects;

public class Results
{
    private double culture;
    private double product_service_design;
    private double team;
    private double process;
    private double architecture;
    private double maintenance;
    private double delivery;
    private double provisioning;
    private double infrastructure;

    public Results(){}
    public Results(double culture, double product_service_design, double team, double process, double architecture,
                   double maintenance, double delivery, double provisioning, double infrastructure)
    {
        this.culture = culture; this.product_service_design = product_service_design; this.team = team;
        this.process = process; this.architecture = architecture; this.maintenance = maintenance;
        this.delivery = delivery; this.provisioning = provisioning; this.infrastructure = infrastructure;
    }



    public double getCulture() { return culture; }
    public double getProduct_service_design() { return product_service_design; }
    public double getTeam() { return team; }
    public double getProcess() { return process; }
    public double getArchitecture() { return architecture; }
    public double getMaintenance() { return maintenance; }
    public double getDelivery() { return delivery; }
    public double getProvisioning() { return provisioning; }
    public double getInfrastructure() { return infrastructure; }
}
