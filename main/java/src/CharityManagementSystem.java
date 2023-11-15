import java.util.*;

public class CharityManagementSystem {
    // Using HashMap for Donors with donor's ID as the key
    private static HashMap<Integer, DonorClass> donorsMap = new HashMap<>();

    // Using HashSet for Volunteers
    private static HashSet<VolunteerClass> volunteersSet = new HashSet<>();

    // Using TreeMap for Projects with project's name as the key
    private static TreeMap<String, ProjectClass> projectsMap = new TreeMap<>();

    // Using LinkedList for Donations
    private static LinkedList<DonationClass> donationsList = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Add Donors
        System.out.println("Add Donors:");
        DonorClass donor1 = addDonor("John Doe", "1234567890", "johndoe@gmail.com");
        DonorClass donor2 = addDonor("Jane Smith", "0987654321", "janesmith@gmail.com");

        // Add Volunteers
        System.out.println("\nAdd Volunteers:");
        VolunteerClass volunteer1 = addVolunteer("Volunteer 1", "111222333", "volunteer1@gmail.com");
        VolunteerClass volunteer2 = addVolunteer("Volunteer 2", "444555666", "volunteer2@gmail.com");

        // Add Projects
        System.out.println("\nAdd Projects:");
        ProjectClass project1 = addProject("Clean Water Project", "Providing clean water to remote areas", 50000);
        ProjectClass project2 = addProject("Education for All", "Ensuring education access for everyone", 75000);

        // Add Donations
        System.out.println("\nAdd Donations:");
        DonationClass donation1 = addDonation(donor1.getId(), 1000, "2023/11/01", project1.getProjectName());
        DonationClass donation2 = addDonation(donor2.getId(), 500, "2023/11/02", project2.getProjectName());

        // Get and display Donor details
        System.out.println("\nGet Donor Details:");
        getDonorDetails(1);

        // Get and display Volunteer details
        System.out.println("\nGet Volunteer Details:");
        getVolunteerDetails(1);

        // Get and display Project details
        System.out.println("\nGet Project Details:");
        getProjectDetails("Clean Water Project");

        // Get and display Donation details
        System.out.println("\nGet Donation Details:");
        getDonationDetails(1);

        scanner.close();
    }

    private static DonorClass addDonor(String name, String contactNumber, String email) {
        DonorClass donor = new DonorClass(name, contactNumber, email);
        donorsMap.put(donor.getId(), donor);
        System.out.println("DonorClass added successfully.");
        return donor;
    }

    private static VolunteerClass addVolunteer(String name, String contactNumber, String email) {
        VolunteerClass volunteer = new VolunteerClass(name, contactNumber, email);
        volunteersSet.add(volunteer);
        System.out.println("VolunteerClass added successfully.");
        return volunteer;
    }

    private static ProjectClass addProject(String name, String description, double targetAmount) {
        ProjectClass project = new ProjectClass(name, description, targetAmount);
        projectsMap.put(project.getProjectName(), project);
        System.out.println("ProjectClass added successfully.");
        return project;
    }

    private static DonationClass addDonation(int donorId, double amount, String date, String projectName) {
        DonationClass donation = new DonationClass(donorId, amount, date, projectName);
        donationsList.add(donation);
        System.out.println("DonationClass added successfully.");
        return donation;
    }

    private static void getDonorDetails(int donorId) {
        DonorClass donor = donorsMap.get(donorId);
        if (donor != null) {
            System.out.println("DonorClass Details: Name: " + donor.getName() + ", Contact Number: " +
                    donor.getContactNumber() + ", Email: " + donor.getEmail());
        } else {
            System.out.println("DonorClass not found.");
        }
    }

    private static void getVolunteerDetails(int volunteerId) {
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

    private static void getProjectDetails(String projectName) {
        ProjectClass project = projectsMap.get(projectName);
        if (project != null) {
            System.out.println("ProjectClass Details: Description: " + project.getProjectDescription() +
                    ", Target Amount: $" + project.getTargetAmount());
        } else {
            System.out.println("ProjectClass not found.");
        }
    }

    private static void getDonationDetails(int donationId) {
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
}
