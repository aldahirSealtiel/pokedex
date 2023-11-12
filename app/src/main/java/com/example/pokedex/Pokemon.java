package com.example.pokedex;

import java.lang.reflect.Type;

public class Pokemon
{
    private String id;
    private String name;
    private Type type;
    private Stats stats;
    private int soundId;
    private int imageId;

    public enum Type
    {
          FIRE, WATER, PLANT, ELECTRIC
    }

    public Pokemon(String id, String name, int imageId, int soundId, Type type, Stats stats )
    {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageId = imageId;
        this.soundId = soundId;
        this.stats = stats;
    }
    public int getSoundId() {
        return soundId;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public int getImageId() {
        return imageId;
    }

    public Stats getStats() {
        return stats;
    }

}
