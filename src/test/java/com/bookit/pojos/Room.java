package com.bookit.pojos;

import java.util.Objects;

/**
 *  {
 *         "id": 112,
 *         "name": "harvard",
 *         "description": "veritas",
 *         "capacity": 6,
 *         "withTV": true,
 *         "withWhiteBoard": false
 *     },
 */
public class Room implements Comparable<Room>{
    private int id;
    private String name;
    private String description;
    private int capacity;
    private boolean withTV;
    private boolean withWhiteBoard;

    public Room(){

    }

    //to check if 2 room objects are equals
    //otherwise, default equals method will be used
    //and it check only if 2 variables
    //point on the same object in the memory (heap)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id == room.id && Objects.equals(name, room.name);
    }
    //need to override if you gonna use hash based data structures
    //like HashMap, HashSet
    //Otherwise, HashSet/HashMap will not contain only unique values
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Room(String name, String description, int capacity, boolean withTV, boolean withWhiteBoard) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
        this.withTV = withTV;
        this.withWhiteBoard = withWhiteBoard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isWithTV() {
        return withTV;
    }

    public void setWithTV(boolean withTV) {
        this.withTV = withTV;
    }

    public boolean isWithWhiteBoard() {
        return withWhiteBoard;
    }

    public void setWithWhiteBoard(boolean withWhiteBoard) {
        this.withWhiteBoard = withWhiteBoard;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", capacity=" + capacity +
                ", withTV=" + withTV +
                ", withWhiteBoard=" + withWhiteBoard +
                '}';
    }

    @Override
    public int compareTo(Room o) {
        return this.name.compareTo(o.getName());
    }
}
