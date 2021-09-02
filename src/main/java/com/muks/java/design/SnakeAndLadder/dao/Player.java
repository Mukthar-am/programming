package com.muks.java.design.SnakeAndLadder.dao;

public class Player {
    public int Id = -1;
    public String Name = "";

    public Player(int id, String name) {
        this.Id = id;
        this.Name = name;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public boolean equals(Object o) {
        if (o == null || o != this) {
            return false;
        }

        if ( (o instanceof Player)
                && (this.Id == ((Player) o).Id)
                && (this.Name == ((Player) o).Name) ) {

            return true;
        }
        return false;
    }

    public int hashcode() {
        return this.Id;
    }

    public String toString() {
        return "(pid: " + this.Id + ", pname: " + this.Name + ")";
    }
}
