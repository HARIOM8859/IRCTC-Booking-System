public class User {
    private String Username;
    private String Password;
    private String FullName;
    private String Contact;

    public User(String username, String password, String fullName, String contact) {
        Username = username;
        Password = password;
        FullName = fullName;
        Contact = contact;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return FullName + " ("+ Username + ") ";
    }
}
