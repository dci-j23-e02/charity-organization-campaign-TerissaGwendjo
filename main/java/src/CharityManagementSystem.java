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
}