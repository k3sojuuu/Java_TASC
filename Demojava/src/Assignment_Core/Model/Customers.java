package Assignment_Core.Model;

public class Customers {
    private String id;
    private String name;
    private String email;
    private String phoneNumber;

    // Constructor
    public Customers(String id, String name, String email, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter và Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "| " + id + "   |" +
                "   " + name +  "   |" +
                "  " + email + "        |" +
                " " + phoneNumber + "   |";
    }
}
