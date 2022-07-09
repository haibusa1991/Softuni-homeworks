package com.example.football.models.dto;

public class TeamImportDto {
//        "name":"Sc",
//        "stadiumName":"Tera",
//        "fanBase":317723,
//        "history":"Cras pellentesque volutpat dui. Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti. Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum.",
//        "townName":"Dallas"

    private String name;
    private String stadiumName;
    private int fanBase;
    private String history;
    private String townName;

    public TeamImportDto() {
    }

    public String getName() {
        return name;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public int getFanBase() {
        return fanBase;
    }

    public String getHistory() {
        return history;
    }

    public String getTownName() {
        return townName;
    }
}
