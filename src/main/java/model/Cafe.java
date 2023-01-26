package model;

import java.util.Objects;

public class Cafe {
    private int id;
    private String cafeName;

    public Cafe(int id, String cafeName) {
        this.id = id;
        this.cafeName = cafeName;
    }

    public Cafe() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCafeName() {
        return cafeName;
    }

    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "id='" + id + '\'' +
                ", cafeName='" + cafeName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cafe cafe = (Cafe) o;
        return id == cafe.id && Objects.equals(cafeName, cafe.cafeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cafeName);
    }
}
