public class DonationClass {
    private static int idCounter = 1;
    private int id;
    private int donorId;
    private double amount;
    private String date;
    private String projectName;

    public DonationClass(int donorId, double amount, String date, String projectName) {
        this.id = idCounter++;
        this.donorId = donorId;
        this.amount = amount;
        this.date = date;
        this.projectName = projectName;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public int getDonorId() {
        return donorId;
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
}
