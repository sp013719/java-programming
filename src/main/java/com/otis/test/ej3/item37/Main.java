package com.otis.test.ej3.item37;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        Plant plant1 = new Plant("plant1", Plant.LifeCycle.ANNUAL);
        Plant plant2 = new Plant("plant2", Plant.LifeCycle.BIENNIAL);
        Plant plant3 = new Plant("plant3", Plant.LifeCycle.PERENNIAL);
        List<Plant> garden = Arrays.asList(plant1, plant2, plant3);

        option1(garden);
        option2(garden);
        option3(garden);
        option4(garden);
    }

    static void option1(List<Plant> garden) {
        // Using ordinal() to index into an array - DON'T DO THIS!
        @SuppressWarnings("unchecked")
        Set<Plant>[] plantsByLifeCycle = (Set<Plant>[]) new Set[Plant.LifeCycle.values().length];
        for (int i = 0; i < plantsByLifeCycle.length; i++)
            plantsByLifeCycle[i] = new HashSet<>();

        for (Plant p : garden)
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        // Print the results
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    static void option2(List<Plant> garden) {
        // Using an EnumMap to associate data with an enum
        Map<Plant.LifeCycle, Set<Plant>> plantsByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lc : Plant.LifeCycle.values())
            plantsByLifeCycle.put(lc, new HashSet<>());
        for (Plant p : garden)
            plantsByLifeCycle.get(p.lifeCycle).add(p);
        System.out.println(plantsByLifeCycle);
    }

    static void option3(List<Plant> garden) {
        // Naive stream-based approach - unlikely to produce an EnumMap!
        Map<Object, List<Plant>> map = garden.stream().collect(Collectors.groupingBy(p -> p.lifeCycle));
        System.out.println(map);
        System.out.println(map.getClass());
    }

    static void option4(List<Plant> garden) {
        // Using a stream and an EnumMap to associate data with an enum
        Map<Plant.LifeCycle, Set<Plant>> map = garden.stream().collect(Collectors.groupingBy(p -> p.lifeCycle,
                () -> new EnumMap<>(Plant.LifeCycle.class), Collectors.toSet()));
        System.out.println(map);
        System.out.println(map.getClass());
    }
}