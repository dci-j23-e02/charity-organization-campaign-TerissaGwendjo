public class VolunteerClass {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String contactNumber;
    private String email;

    public VolunteerClass(String name, String contactNumber, String email) {
        this.id = idCounter++;
        this.name = name;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
