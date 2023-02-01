package model;

import java.util.List;
import java.util.Objects;

public class Order {
    private int orderID;
    private double price;
    private Customer customer;
    private Waiter waiter;
    private Cafe cafe;
    private PaymentType paymentType;
    public List<MenuItems> menuItemsList;

    public Order(int orderID, double price, Customer customer, Waiter waiter, Cafe cafe, PaymentType paymentType){
        this.orderID = orderID;
        this.price = price;
        this.customer = customer;
        this.waiter = waiter;
        this.cafe = cafe;
        this.paymentType = paymentType;
    }

    public Order() {
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Waiter getWaiter() {
        return waiter;
    }
    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }

    public Cafe getCafe() {
        return cafe;
    }
    public void setCafe(Cafe cafe) {
        this.cafe = cafe;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public List<MenuItems> getMenuItemsList() {
        return menuItemsList;
    }

    public void setMenuItemsList(List<MenuItems> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", price='" + price + '\'' +
                ", customer='" + customer.toString() + '\'' +
                ", waiter='" + waiter.toString() + '\'' +
                ", cafe='" + cafe.toString() + '\'' +
                ", paymentType='" + paymentType.toString() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && Double.compare(order.price, price) == 0 && Objects.equals(customer, order.customer) && Objects.equals(waiter, order.waiter) && Objects.equals(cafe, order.cafe) && Objects.equals(paymentType, order.paymentType) && Objects.equals(menuItemsList, order.menuItemsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, price, customer, waiter, cafe, paymentType, menuItemsList);
    }
}
