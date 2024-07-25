package co.edu.uptcSoft.model;

public class User {

    //Atributos
    private String name;
    private String password;

    //Constructor
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    //Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //ToString
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
