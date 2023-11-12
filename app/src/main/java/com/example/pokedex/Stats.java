package com.example.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Stats implements Parcelable {
    private String hp;
    private String attack;
    private String defense;
    private String speed;


    public Stats(String hp, String attack, String defense, String speed)
    {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    public String getHp() {
        return hp;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
    }

    public String getSpeed() {
        return speed;
    }

    protected Stats(Parcel in)
    {
        hp = in.readString();
        attack = in.readString();
        defense = in.readString();
        speed = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
            dest.writeString(hp);
            dest.writeString(attack);
            dest.writeString(defense);
            dest.writeString(speed);
    }

}
