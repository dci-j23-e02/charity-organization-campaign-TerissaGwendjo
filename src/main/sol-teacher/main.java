import model.Donation;
import model.Donor;
import model.Project;
import model.Volunteer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

public class main {

    public static void main(String[] args) {
        // HashMap to store the details of the donors
        // with the donor's ID as the key and the donor object as the value.
        HashMap<Integer, Donor> donors = new HashMap<>();
        Donor d1 = new Donor("John Doe", "1234567890", "johndoe@gmail.com");
        donors.put(d1.getId(), d1);
        System.out.println(donors);


        // HashSet to store the details of the volunteers.
        // This will allow you to quickly access volunteer details and ensure that there are no duplicate volunteers.

        HashSet<Volunteer> volunteers = new HashSet<>();
        Volunteer v1 = new Volunteer("Jane Smith", "0987654321", "janesmith@gmail.com");
        volunteers.add(v1);
        System.out.println(volunteers);


        // a TreeMap to store the details of the projects with the project's name as the key and the project object as the value.
        // This will allow you to quickly access project details using the project's name and keep the projects sorted.
        TreeMap<String, Project> projects = new TreeMap<>();
        Project p1 = new Project("Project 1 ", "Project 1 Desc.", 3000);
        projects.put(p1.getName(), p1);
        System.out.println(projects);

        // Create a LinkedList to store the details of the donations.
        // This will allow you to easily add and remove donations.
        // ArrayList would be better for this task :
        ArrayList<Donation> donations = new ArrayList<>();

        Donation don1 = new Donation(d1.getId(), 500, "24.11.2023", p1.getName() );

        donations.add(don1);

        System.out.println(donations);

    }
}
