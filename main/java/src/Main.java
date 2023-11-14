import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create instances of DonorClass
        System.out.println("Add Donor:");
        DonorClass donor1 = addDonor(scanner);
        DonorClass donor2 = addDonor(scanner);

        // Create instances of VolunteerClass
        System.out.println("\nAdd Volunteer:");
        VolunteerClass volunteer1 = addVolunteer(scanner);
        VolunteerClass volunteer2 = addVolunteer(scanner);

        // Create instances of ProjectClass
        System.out.println("\nAdd Project:");
        ProjectClass project1 = addProject(scanner);
        ProjectClass project2 = addProject(scanner);

        // Create instances of DonationClass
        System.out.println("\nAdd Donation:");
        DonationClass donation1 = addDonation(scanner, donor1.getId(), project1.getProjectName());
        DonationClass donation2 = addDonation(scanner, donor2.getId(), project2.getProjectName());

        // Assign volunteers to projects
        project1.addVolunteer(volunteer1);
        project1.addVolunteer(volunteer2);
        project2.addVolunteer(volunteer1);

        // Display information
        System.out.println("\nDonors:");
        displayDonorInfo(donor1);
        displayDonorInfo(donor2);

        System.out.println("\nVolunteers:");
        displayVolunteerInfo(volunteer1);
        displayVolunteerInfo(volunteer2);

        System.out.println("\nProjects:");
        displayProjectInfo(project1);
        displayProjectInfo(project2);

        System.out.println("\nDonations:");
        displayDonationInfo(donation1);
        displayDonationInfo(donation2);

        // Display volunteers assigned to projects
        System.out.println("\nVolunteers Assigned to Projects:");
        displayVolunteersAssignedToProject(project1);
        displayVolunteersAssignedToProject(project2);

        // Display project with the most volunteers
        System.out.println("\nProject with the Most Volunteers:");
        ProjectClass projectWithMostVolunteers = getProjectWithMostVolunteers(project1, project2);
        System.out.println(projectWithMostVolunteers.getProjectName() + " has the most volunteers.");

        scanner.close();
    }

    // Helper method to add a donor
    private static DonorClass addDonor(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new DonorClass(name, contactNumber, email);
    }

    // Helper method to add a volunteer
    private static VolunteerClass addVolunteer(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        return new VolunteerClass(name, contactNumber, email);
    }

    // Helper method to add a project
    private static ProjectClass addProject(Scanner scanner) {
        System.out.print("Project Name: ");
        String projectName = scanner.nextLine();
        System.out.print("Project Description: ");
        String projectDescription = scanner.nextLine();
        System.out.print("Target Amount: ");
        double targetAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        return new ProjectClass(projectName, projectDescription, targetAmount);
    }

    // Helper method to add a donation
    private static DonationClass addDonation(Scanner scanner, int donorId, String projectName) {
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Date (YYYY/MM/DD): ");
        String date = scanner.nextLine();

        return new DonationClass(donorId, amount, date, projectName);
    }

    // Helper method to display donor information
    private static void displayDonorInfo(DonorClass donor) {
        System.out.println(donor.getId() + ": " + donor.getName() + ", " + donor.getContactNumber() + ", " + donor.getEmail());
    }

    // Helper method to display volunteer information
    private static void displayVolunteerInfo(VolunteerClass volunteer) {
        System.out.println(volunteer.getId() + ": " + volunteer.getName() + ", " + volunteer.getContactNumber() + ", " + volunteer.getEmail());
    }

    // Helper method to display project information
    private static void displayProjectInfo(ProjectClass project) {
        System.out.println(project.getId() + ": " + project.getProjectName() + ", " + project.getProjectDescription() + ", Target Amount: $" + project.getTargetAmount());
    }

    // Helper method to display donation information
    private static void displayDonationInfo(DonationClass donation) {
        System.out.println(donation.getId() + ": Donor ID: " + donation.getDonorId() + ", Amount: $" + donation.getAmount() + ", Date: " + donation.getDate() + ", Project: " + donation.getProjectName());
    }

    // Helper method to display volunteers assigned to a project
    private static void displayVolunteersAssignedToProject(ProjectClass project) {
        System.out.println("Project: " + project.getProjectName());
        for (VolunteerClass volunteer : project.getAssignedVolunteers()) {
            System.out.println("- " + volunteer.getName());
        }
    }

    // Helper method to find the project with the most volunteers
    private static ProjectClass getProjectWithMostVolunteers(ProjectClass... projects) {
        ProjectClass projectWithMostVolunteers = null;
        int maxVolunteers = 0;

        for (ProjectClass project : projects) {
            int numVolunteers = project.getAssignedVolunteers().size();
            if (numVolunteers > maxVolunteers) {
                maxVolunteers = numVolunteers;
                projectWithMostVolunteers = project;
            }
        }

        return projectWithMostVolunteers;
    }
}
