public class Admin extends Person{
    private String phone;
    private String PW = "Admin1234";
    private String ID = "Admin";

    public Admin(String name, String phone) {
        super(name);
        this.phone = phone;

    }

    public String getPhone() {
        return phone;
    }

    public String getPW() {
        return PW;
    }

    public String getID() {
        return ID;
    }
}
