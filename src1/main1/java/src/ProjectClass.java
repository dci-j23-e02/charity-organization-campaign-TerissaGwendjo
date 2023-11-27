import java.util.ArrayList;
import java.util.List;

public class ProjectClass {
    private static int idCounter = 1;
    private int id;
    private String projectName;
    private String projectDescription;
    private double targetAmount;
    private List<VolunteerClass> assignedVolunteers; //List of assigned Volunteers taking the Volunteer Class as an argument


    public ProjectClass(String projectName, String projectDescription, double targetAmount) {
        this.id = idCounter++;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.targetAmount = targetAmount;
        this.assignedVolunteers = new ArrayList<>();
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public List<VolunteerClass> getAssignedVolunteers() {
        return assignedVolunteers;
    }

    public void addVolunteer(VolunteerClass volunteer) {
        this.assignedVolunteers.add(volunteer);
    }

    public void removeVolunteer(VolunteerClass volunteer) {
        this.assignedVolunteers.remove(volunteer);
    }
}
