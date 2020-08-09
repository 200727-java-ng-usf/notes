package com.revature.compare.models;

import java.util.Objects;

// How to create a POJO:
    // declare variables
    // declare constructors
    // declare getters and setters
    // override hashCode, equals, and toString
public class Box implements Comparable<Box> {

    private double volume;
    private String color;

    public Box(double volume, String color) {
        this.volume = volume;
        this.color = color;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Double.compare(box.volume, volume) == 0 &&
                Objects.equals(color, box.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, color);
    }

    @Override
    public String toString() {
        return "Box{" +
                "volume=" + volume +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public int compareTo(Box otherBox) {

        if (this.volume > otherBox.volume) {
            return 1;
        } else if (this.volume < otherBox.volume) {
            return -1;
        } else {
            return this.color.compareTo(otherBox.color); // if both boxes have equal volume, compare by color
        }

        // one-liner version of the above code (because Double implements Comparable)
        // return Double.compare(this.volume, otherBox.volume);

    }

}
