package model;


import java.util.Objects;

public class Customer {
    private int customerId;
    private String firstName;
    private String secondName;
    private String phone;
    private String email;
    private LoyaltyCard loyaltyCard;

    public Customer(int customerId, String firstName, String secondName, String phone, String email) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
    }

    public Customer(int customerId, String firstName, String secondName, String phone, String email, LoyaltyCard loyaltyCard) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.email = email;
        this.loyaltyCard = loyaltyCard;
    }

    public Customer() {
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public LoyaltyCard getLoyaltyCard() {
        return loyaltyCard;
    }

    public void setLoyaltyCard(LoyaltyCard loyaltyCard) {
        this.loyaltyCard = loyaltyCard;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", loyaltyCardId='" + loyaltyCard.getIdLoyaltyCard() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId && Objects.equals(firstName, customer.firstName) && Objects.equals(secondName, customer.secondName) && Objects.equals(phone, customer.phone) && Objects.equals(email, customer.email) && Objects.equals(loyaltyCard, customer.loyaltyCard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, secondName, phone, email, loyaltyCard);
    }
}



