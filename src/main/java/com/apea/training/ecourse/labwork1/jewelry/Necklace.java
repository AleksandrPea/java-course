package com.apea.training.ecourse.labwork1.jewelry;

import com.apea.training.ecourse.labwork1.stones.Gemstone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Necklace implements Jewel {

    private List<Gemstone> gemstones;

    private Necklace(List<Gemstone> gemstones) {
        this.gemstones = gemstones;
    }

    public static Necklace create(Gemstone first, Gemstone... gemstones) {
        List<Gemstone> list = new ArrayList<Gemstone>();
        list.add(first);
        Collections.addAll(list, gemstones);
        if (list.contains(null)) {
            throw new NullPointerException("No null gems!!");
        }
        return new Necklace(list);
    }

    @Override
    public double price() {
        return gemstones.stream().mapToDouble(Gemstone::totalPrice).sum();
    }

    @Override
    public double weight() {
        return gemstones.stream().mapToDouble(Gemstone::getWeight).sum();
    }

    @Override
    public int size() {
        return gemstones.size();
    }

    @Override
    public Gemstone[] getGemstones() {
        Gemstone[] arr = new Gemstone[gemstones.size()];
        return gemstones.toArray(arr);
    }
}
