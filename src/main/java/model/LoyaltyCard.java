package model;


import java.util.Objects;

public class LoyaltyCard {
    private int idLoyaltyCard;
    private int discount;
    private String pointsBalance;

    public LoyaltyCard(int idLoyaltyCard, int discount, String pointsBalance) {
        this.idLoyaltyCard = idLoyaltyCard;
        this.discount = discount;
        this.pointsBalance = pointsBalance;
    }

    public LoyaltyCard() {
    }


    public int getIdLoyaltyCard() {
        return idLoyaltyCard;
    }

    public void setIdLoyaltyCard(int idLoyaltyCard) {
        this.idLoyaltyCard = idLoyaltyCard;
    }


    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }


    public String getPointsBalance() {
        return pointsBalance;
    }

    public void setPointsBalance(String pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    @Override
    public String toString(){
        return "LoyaltyCard{" +
                "idLoyaltyCard='" + idLoyaltyCard + '\'' +
                ", discount='" + discount + '\'' +
                ", pointsBalance='" + pointsBalance + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoyaltyCard that = (LoyaltyCard) o;
        return idLoyaltyCard == that.idLoyaltyCard && discount == that.discount && Objects.equals(pointsBalance, that.pointsBalance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLoyaltyCard, discount, pointsBalance);
    }
}
