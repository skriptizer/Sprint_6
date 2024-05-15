package com.example;

import java.util.List;

public class AlexLion extends Lion {
    private final String placeOfLiving = "Нью-Йоркский зоопарк";
    private final List<String> friends = List.of("Марти", "Глория", "Мелман");

    public AlexLion(Feline feline) throws Exception {
        super("Самец", feline);
    }

    public List<String> getFriends() {
        return friends;
    }

    public String getPlaceOfLiving() {
        return placeOfLiving;
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
