package model;



import java.util.Objects;

public class Waiter {
    private int id;
    private String firstName;

    public Waiter(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }
    public Waiter() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Waiter{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Waiter waiter = (Waiter) o;
        return id == waiter.id && Objects.equals(firstName, waiter.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }
}
