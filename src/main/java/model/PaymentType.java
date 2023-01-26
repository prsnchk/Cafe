package model;

import java.util.Objects;

public class PaymentType {
    private int idPaymentType;
    private String name;

    public PaymentType(int idPaymentType, String name) {
        this.idPaymentType = idPaymentType;
        this.name = name;
    }

    public PaymentType (){
    }

    public int getIdPaymentType() {
        return idPaymentType;
    }

    public void setIdPaymentType(int idPaymentType) {
        this.idPaymentType = idPaymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "idPaymentType='" + idPaymentType + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentType that = (PaymentType) o;
        return idPaymentType == that.idPaymentType && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPaymentType, name);
    }
}
