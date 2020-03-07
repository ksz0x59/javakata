package com.ksz.one;

import java.util.Objects;

public class Pet {

    private String name;
    private int weight;
    private boolean isDangerous;

    public Pet(String name, int weight, boolean isDangerous) {
        this.name = name;
        this.weight = weight;
        this.isDangerous = isDangerous;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int mass) {
        this.weight = mass;
    }

    public boolean isDangerous() {
        return isDangerous;
    }

    public void setDangerous(boolean dangerous) {
        isDangerous = dangerous;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return weight == pet.weight &&
                isDangerous == pet.isDangerous &&
                Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, weight, isDangerous);
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", mass=" + weight +
                ", isDangerous=" + isDangerous +
                '}';
    }

}
