package model;

import util.IDGenerator;

import java.util.ArrayList;
import java.util.List;

public class Project {


    private int id;
    private String name;
    private String description;
    private double targetAmount;
    private List<Volunteer> assignedVolunteers;

    public Project( String name, String description, double targetAmount) {
        this.id = IDGenerator.getNextIdCounter();
        this.name = name;
        this.description = description;
        this.targetAmount = targetAmount;
        this.assignedVolunteers =new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName(){
        return name;
    }

    public  double getTargetAmount(){
        return targetAmount;
    }

    public List<Volunteer> getAssignedVolunteers(){
        return assignedVolunteers;
    }


    public void addVolunteer(Volunteer v){
        this.assignedVolunteers.add(v);
    }

    public void removeVolunteer(Volunteer v){
        this.assignedVolunteers.remove(v);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", targetAmount=" + targetAmount +
                ", assignedVolunteers=" + assignedVolunteers +
                '}';
    }
}
