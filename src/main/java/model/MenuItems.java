package model;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.Objects;

public class MenuItems {
    private int menuId;
    private String nameUkr;
    private String nameEng;
    private int price;

    public MenuItems(int menuId, String nameUkr, String nameEng, int price) {
        this.menuId = menuId;
        this.nameUkr = nameUkr;
        this.nameEng = nameEng;
        this.price = price;
    }

    public MenuItems (){
    }

    @JsonGetter
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @JsonGetter
    public String getNameUkr() {
        return nameUkr;
    }

    public void setNameUkr(String nameUkr) {
        this.nameUkr = nameUkr;
    }

    @JsonGetter
    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    @JsonGetter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "menuId='" + menuId + '\'' +
                ", nameUkr='" + nameUkr + '\'' +
                ", nameEng='" + nameEng + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItems menuItems = (MenuItems) o;
        return menuId == menuItems.menuId && price == menuItems.price && Objects.equals(nameUkr, menuItems.nameUkr) && Objects.equals(nameEng, menuItems.nameEng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, nameUkr, nameEng, price);
    }
}
