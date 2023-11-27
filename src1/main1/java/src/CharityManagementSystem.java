import java.util.*;

public class CharityManagementSystem {
    private static HashMap<Integer, DonorClass> donorsMap = new HashMap<>();
    private static HashSet<VolunteerClass> volunteersSet = new HashSet<>();
    private static TreeMap<String, ProjectClass> projectsMap = new TreeMap<>();
    private static LinkedList<DonationClass> donationsList = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add Donors
        System.out.println("Add Donors:");
        DonorClass donor1 = addDonor(scanner);
        DonorClass donor2 = addDonor(scanner);

        // Add Volunteers
        System.out.println("\nAdd Volunteers:");
        VolunteerClass volunteer1 = addVolunteer(scanner);
        VolunteerClass volunteer2 = addVolunteer(scanner);

        // Add Projects
        System.out.println("\nAdd Projects:");
        ProjectClass project1 = addProject(scanner);
        ProjectClass project2 = addProject(scanner);

        // Add Donations
        System.out.println("\nAdd Donations:");
        DonationClass donation1 = addDonation(scanner, donor1.getId(), project1.getProjectName());
        DonationClass donation2 = addDonation(scanner, donor2.getId(), project2.getProjectName());

        // Get and display Donor details
        System.out.println("\nGet Donor Details:");
        getDonorDetails(scanner);

        // Get and display Volunteer details
        System.out.println("\nGet Volunteer Details:");
        getVolunteerDetails(scanner);

        // Get and display Project details
        System.out.println("\nGet Project Details:");
        getProjectDetails(scanner);

        // Get and display Donation details
        System.out.println("\nGet Donation Details:");
        getDonationDetails(scanner);

        scanner.close();
    }

    private static DonorClass addDonor(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        DonorClass donor = new DonorClass(name, contactNumber, email);
        donorsMap.put(donor.getId(), donor);
        System.out.println("DonorClass added successfully.");
        return donor;
    }

    private static VolunteerClass addVolunteer(Scanner scanner) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Contact Number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        VolunteerClass volunteer = new VolunteerClass(name, contactNumber, email);
        volunteersSet.add(volunteer);
        System.out.println("VolunteerClass added successfully.");
        return volunteer;
    }

    private static ProjectClass addProject(Scanner scanner) {
        System.out.print("Project Name: ");
        String projectName = scanner.nextLine();
        System.out.print("Project Description: ");
        String projectDescription = scanner.nextLine();
        System.out.print("Target Amount: ");
        double targetAmount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        ProjectClass project = new ProjectClass(projectName, projectDescription, targetAmount);
        projectsMap.put(project.getProjectName(), project);
        System.out.println("ProjectClass added successfully.");
        return project;
    }

    private static DonationClass addDonation(Scanner scanner, int donorId, String projectName) {
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Date (YYYY/MM/DD): ");
        String date = scanner.nextLine();

        DonationClass donation = new DonationClass(donorId, amount, date, projectName);
        donationsList.add(donation);
        System.out.println("DonationClass added successfully.");
        return donation;
    }

    private static void getDonorDetails(Scanner scanner) {
        System.out.print("Enter Donor ID: ");
        int donorId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        DonorClass donor = donorsMap.get(donorId);
        if (donor != null) {
            System.out.println("DonorClass Details: Name: " + donor.getName() + ", Contact Number: " +
                    donor.getContactNumber() + ", Email: " + donor.getEmail());
        } else {
            System.out.println("DonorClass not found.");
        }
    }

    private static void getVolunteerDetails(Scanner scanner) {
        System.out.print("Enter Volunteer ID: ");
        int volunteerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        VolunteerClass volunteer = findVolunteerById(volunteerId);
        if (volunteer != null) {
            System.out.println("VolunteerClass Details: Name: " + volunteer.getName() + ", Contact Number: " +
                    volunteer.getContactNumber() + ", Email: " + volunteer.getEmail());
        } else {
            System.out.println("VolunteerClass not found.");
        }
    }

    private static VolunteerClass findVolunteerById(int volunteerId) {
        for (VolunteerClass volunteer : volunteersSet) {
            if (volunteer.getId() == volunteerId) {
                return volunteer;
            }
        }
        return null;
    }

    private static void getProjectDetails(Scanner scanner) {
        System.out.print("Enter Project Name: ");
        String projectName = scanner.nextLine();

        ProjectClass project = projectsMap.get(projectName);
        if (project != null) {
            System.out.println("ProjectClass Details: Description: " + project.getProjectDescription() +
                    ", Target Amount: $" + project.getTargetAmount());
        } else {
            System.out.println("ProjectClass not found.");
        }
    }

    private static void getDonationDetails(Scanner scanner) {
        System.out.print("Enter Donation ID: ");
        int donationId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        DonationClass donation = findDonationById(donationId);
        if (donation != null) {
            System.out.println("DonationClass Details: DonorClass ID: " + donation.getDonorId() +
                    ", Amount: $" + donation.getAmount() + ", Date: " + donation.getDate() +
                    ", ProjectClass Name: " + donation.getProjectName());
        } else {
            System.out.println("DonationClass not found.");
        }
    }

    private static DonationClass findDonationById(int donationId) {
        for (DonationClass donation : donationsList) {
            if (donation.getId() == donationId) {
                return donation;
            }
        }
        return null;
    }

    //GOLDEN ACHIEVEMENT
    while (true) {
        printMenu();
        Scanner scanner;
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                updateDetails(scanner);
                break;
            case 2:
                viewDetails();
                break;
            case 3:
                calculateTotalFunds();
                break;
            case 4:
                calculateProjectFunds(scanner);
                break;
            case 5:
                assignVolunteer(scanner);
                break;
            case 6:
                findTopDonor();
                break;
            case 7:
                findMostActiveVolunteer();
                break;
            case 8:
                findMostFundedProject();
                break;
            case 9:
                findProjectWithMostVolunteers();
                break;
            case 10:
                calculateAverageDonation();
                break;
            case 11:
                calculateTotalNumbers();
                break;
            case 12:
                // Sorting details method (To be implemented based on specific sorting requirements)
                // sortDetails();
                System.out.println("Sorting details is not implemented in this example.");
                break;
            case 0:
                System.out.println("Exiting the application. Goodbye!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}

    private static void printMenu() {
        // (unchanged)
    }

    private static void updateDetails(Scanner scanner) {
        System.out.println("\n==== Update Details ====");
        System.out.println("1. Update Donor");
        System.out.println("2. Update Volunteer");
        System.out.println("3. Update Project");
        System.out.println("4. Update Donation");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                updateDonor(scanner);
                break;
            case 2:
                updateVolunteer(scanner);
                break;
            case 3:
                updateProject(scanner);
                break;
            case 4:
                updateDonation(scanner);
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
        }
    }

    private static void updateDonor(Scanner scanner) {
        System.out.print("Enter Donor ID: ");
        int donorId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        DonorClass donor = donorsMap.get(donorId);
        if (donor != null) {
            System.out.print("New Contact Number: ");
            String newContactNumber = scanner.nextLine();
            donor.setContactNumber(newContactNumber);
            System.out.println("DonorClass updated successfully.");
        } else {
            System.out.println("DonorClass not found.");
        }
    }

    private static void updateVolunteer(Scanner scanner) {
        System.out.print("Enter Volunteer ID: ");
        int volunteerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        VolunteerClass volunteer = findVolunteerById(volunteerId);
        if (volunteer != null) {
            System.out.print("New Contact Number: ");
            String newContactNumber = scanner.nextLine();
            volunteer.setContactNumber(newContactNumber);
            System.out.println("VolunteerClass updated successfully.");
        } else {
            System.out.println("VolunteerClass not found.");
        }
    }

    private static void updateProject(Scanner scanner) {
        System.out.print("Enter Project Name: ");
        String projectName = scanner.nextLine();

        ProjectClass project = projectsMap.get(projectName);
        if (project != null) {
            System.out.print("New Target Amount: ");
            double newTargetAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            project.setTargetAmount(newTargetAmount);
            System.out.println("ProjectClass updated successfully.");
        } else {
            System.out.println("ProjectClass not found.");
        }
    }

    private static void updateDonation(Scanner scanner) {
        System.out.print("Enter Donation ID: ");
        int donationId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        DonationClass donation = findDonationById(donationId);
        if (donation != null) {
            System.out.print("New Amount: ");
            double newAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume the newline character
            donation.setAmount(newAmount);
            System.out.println("DonationClass updated successfully.");
        } else {
            System.out.println("DonationClass not found.");
        }
    }

    private static void viewDetails() {
        System.out.println("\n==== View Details ====");
        System.out.println("1. View All Donors");
        System.out.println("2. View All Volunteers");
        System.out.println("3. View All Projects");
        System.out.println("4. View All Donations");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                viewAllDonors();
                break;
            case 2:
                viewAllVolunteers();
                break;
            case 3:
                viewAllProjects();
                break;
            case 4:
                viewAllDonations();
                break;
            default:
                System.out.println("Invalid choice. Returning to the main menu.");
        }
    }

    private static void viewAllDonors() {
        System.out.println("\n==== All Donors ====");
        for (DonorClass donor : donorsMap.values()) {
            System.out.println("ID: " + donor.getId() + ", Name: " + donor.getName() +
                    ", Contact Number: " + donor.getContactNumber() + ", Email: " + donor.getEmail());
        }
    }

    private static void viewAllVolunteers() {
        System.out.println("\n==== All Volunteers ====");
        for (VolunteerClass volunteer : volunteersSet) {
            System.out.println("ID: " + volunteer.getId() + ", Name: " + volunteer.getName() +
                    ", Contact Number: " + volunteer.getContactNumber() + ", Email: " + volunteer.getEmail());
        }
    }

    private static void viewAllProjects() {
        System.out.println("\n==== All Projects ====");
        for (ProjectClass project : projectsMap.values()) {
            System.out.println("Name: " + project.getProjectName() +
                    ", Description: " + project.getProjectDescription() +
                    ", Target Amount: $" + project.getTargetAmount());
        }
    }
    private static void viewAllDonations() {
        System.out.println("\n==== All Donations ====");
        for (DonationClass donation : donationsList) {
            System.out.println("ID: " + donation.getId() + ", Donor ID: " + donation.getDonorId() +
                    ", Amount: $" + donation.getAmount() + ", Date: " + donation.getDate() +
                    ", Project Name: " + donation.getProjectName());
        }
    }

    private static void calculateTotalFunds() {
        double totalFunds = 0;
        for (DonationClass donation : donationsList) {
            totalFunds += donation.getAmount();
        }
        System.out.println("\nTotal funds raised: $" + totalFunds);
    }

    private static void calculateProjectFunds(Scanner scanner) {
        System.out.print("Enter Project Name: ");
        String projectName = scanner.nextLine();

        double projectFunds = 0;
        for (DonationClass donation : donationsList) {
            if (donation.getProjectName().equalsIgnoreCase(projectName)) {
                projectFunds += donation.getAmount();
            }
        }
        System.out.println("Total funds raised for " + projectName + ": $" + projectFunds);
    }

    private static void assignVolunteer(Scanner scanner) {
        System.out.print("Enter Volunteer ID: ");
        int volunteerId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        VolunteerClass volunteer = findVolunteerById(volunteerId);
        if (volunteer != null) {
            System.out.print("Enter Project Name: ");
            String projectName = scanner.nextLine();

            ProjectClass project = projectsMap.get(projectName);
            if (project != null) {
                project.addVolunteer(volunteer);
                System.out.println("Volunteer assigned successfully to " + projectName + ".");
            } else {
                System.out.println("Project not found.");
            }
        } else {
            System.out.println("Volunteer not found.");
        }
    }

    private static void findTopDonor() {
        double maxDonation = 0;
        DonorClass topDonor = null;

        for (DonorClass donor : donorsMap.values()) {
            double totalDonation = 0;

            for (DonationClass donation : donationsList) {
                if (donation.getDonorId() == donor.getId()) {
                    totalDonation += donation.getAmount();
                }
            }

            if (totalDonation > maxDonation) {
                maxDonation = totalDonation;
                topDonor = donor;
            }
        }

        if (topDonor != null) {
            System.out.println("\nTop Donor: " + topDonor.getName());
        } else {
            System.out.println("No donations recorded. Top donor not available.");
        }
    }

    private static void findMostActiveVolunteer() {
        int maxProjectsAssigned = 0;
        VolunteerClass mostActiveVolunteer = null;

        for (VolunteerClass volunteer : volunteersSet) {
            int projectsAssigned = 0;

            for (ProjectClass project : projectsMap.values()) {
                if (project.hasVolunteer(volunteer)) {
                    projectsAssigned++;
                }
            }

            if (projectsAssigned > maxProjectsAssigned) {
                maxProjectsAssigned = projectsAssigned;
                mostActiveVolunteer = volunteer;
            }
        }

        if (mostActiveVolunteer != null) {
            System.out.println("\nMost Active Volunteer: " + mostActiveVolunteer.getName());
        } else {
            System.out.println("No projects assigned. Most active volunteer not available.");
        }
    }

    private static void findMostFundedProject() {
        double maxFunds = 0;
        ProjectClass mostFundedProject = null;

        for (ProjectClass project : projectsMap.values()) {
            double totalFunds = 0;

            for (DonationClass donation : donationsList) {
                if (donation.getProjectName().equalsIgnoreCase(project.getProjectName())) {
                    totalFunds += donation.getAmount();
                }
            }

            if (totalFunds > maxFunds) {
                maxFunds = totalFunds;
                mostFundedProject = project;
            }
        }

        if (mostFundedProject != null) {
            System.out.println("\nMost Funded Project: " + mostFundedProject.getProjectName());
        } else {
            System.out.println("No funds raised. Most funded project not available.");
        }
    }

    private static void findProjectWithMostVolunteers() {
        int maxVolunteers = 0;
        ProjectClass projectWithMostVolunteers = null;

        for (ProjectClass project : projectsMap.values()) {
            int volunteersCount = project.getVolunteers().size();

            if (volunteersCount > maxVolunteers) {
                maxVolunteers = volunteersCount;
                projectWithMostVolunteers = project;
            }
        }

        if (projectWithMostVolunteers != null) {
            System.out.println("\nProject with Most Volunteers: " + projectWithMostVolunteers.getProjectName());
        } else {
            System.out.println("No volunteers assigned. Project with most volunteers not available.");
        }
    }

    private static void calculateAverageDonation() {
        double totalDonation = 0;
        int donationCount = donationsList.size();

        if (donationCount > 0) {
            for (DonationClass donation : donationsList) {
                totalDonation += donation.getAmount();
            }

            double averageDonation = totalDonation / donationCount;
            System.out.println("\nAverage Donation: $" + averageDonation);
        } else {
            System.out.println("No donations recorded. Average donation not available.");
        }
    }

    private static void calculateTotalNumbers() {
        int totalDonors = donorsMap.size();
        int totalVolunteers = volunteersSet.size();
        int totalProjects = projectsMap.size();
        int totalDonations = donationsList.size();

        System.out.println("\nTotal Donors: " + totalDonors + ", Total Volunteers: " + totalVolunteers +
                ", Total Projects: " + totalProjects + ", Total Donations: " + totalDonations);
    }

    private static VolunteerClass findVolunteerById(int volunteerId) {
        for (VolunteerClass volunteer : volunteersSet) {
            if (volunteer.getId() == volunteerId) {
                return volunteer;
            }
        }
        return null;
    }

    private static DonationClass findDonationById(int donationId) {
        for (DonationClass donation : donationsList) {
            if (donation.getId() == donationId) {
                return donation;
            }
        }
        return null;
    }

    // Add more methods as needed based on your specific requirements

}
