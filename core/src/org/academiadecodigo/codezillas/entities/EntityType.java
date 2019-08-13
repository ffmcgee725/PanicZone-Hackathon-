package org.academiadecodigo.codezillas.entities;

public enum EntityType {
    PLAYER("player", 16, 16),
    HOSTAGE("hostage", 16, 16),
    POLICE("police", 16, 16);

    private String id;
    private int height;
    private int weight;

    EntityType(String id, int height, int weight) {
        this.id = id;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWeith() {
        return weight;
    }
}
