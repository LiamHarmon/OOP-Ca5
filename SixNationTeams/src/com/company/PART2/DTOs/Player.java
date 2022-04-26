package com.company.PART2.DTOs;

public class Player
{
    private int id;
    private String full_name;
    private String position;
    private int caps;
    private double total_time;

    public Player(int playerId, String full_name, String position, int caps, double total_time)
    {
        this.id = playerId;
        this.full_name = full_name;
        this.position = position;
        this.caps = caps;
        this.total_time = total_time;
    }

    public Player(String full_name, String position, int caps, double total_time)
    {
        this.id = 0;
        this.full_name = full_name;
        this.position = position;
        this.caps = caps;
        this.total_time = total_time;
    }

    public Player()
    {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getCaps() {
        return caps;
    }

    public void setCaps(int caps) {
        this.caps = caps;
    }

    public double getTotal_time() {
        return total_time;
    }

    public void setTotal_time(double total_time) {
        this.total_time = total_time;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", full_name='" + full_name + '\'' +
                ", position='" + position + '\'' +
                ", caps=" + caps +
                ", total_time=" + total_time +
                '}';
    }
}
