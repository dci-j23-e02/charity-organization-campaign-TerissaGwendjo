package model;

import util.IDGenerator;

public class Donation {

    private int id;
    private int donorId;
    private double amount;
    private String date;
    private String projectName;

    public Donation(int donorId, double amount, String date, String projectName) {
        this.id = IDGenerator.getNextIdCounter();
        this.donorId = donorId;
        this.amount = amount;
        this.date = date;
        this.projectName = projectName;
    }

    public int getId() {
        return id;
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", donorId=" + donorId +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                ", projectName='" + projectName + '\'' +
                '}';
    }
}
