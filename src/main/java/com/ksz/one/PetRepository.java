package com.ksz.one;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PetRepository {

    private final Map<Pet, Person> petMap = new HashMap<>();

    {
        petMap.put(new Pet("Max", 12, true), new Person("Liam", 12, Sex.MALE));
        petMap.put(new Pet("Charlie", 5, false), new Person("Noah", 22, Sex.MALE));
        petMap.put(new Pet("Cooper", 6, true), new Person("William", 40, Sex.MALE));
        petMap.put(new Pet("Buddy", 2, false), new Person("James", 40, Sex.MALE));
        petMap.put(new Pet("Rocky", 5, true), new Person("Oliver", 14, Sex.MALE));
        petMap.put(new Pet("Milo", 11, false), new Person("Benjamin", 14, Sex.MALE));
        petMap.put(new Pet("Jack", 3, false), new Person("Emma", 9, Sex.FEMALE));
        petMap.put(new Pet("Bella", 5, false), new Person("Olivia", 9, Sex.FEMALE));
        petMap.put(new Pet("Luna", 6, false), new Person("Ava", 9, Sex.FEMALE));
        petMap.put(new Pet("Daisy", 6, true), new Person("Isabella", 19, Sex.FEMALE));
        petMap.put(new Pet("Lily", 7, false), new Person("Sophia", 19, Sex.FEMALE));
        petMap.put(new Pet("Molly", 13, false), new Person("Charlotte", 25, Sex.FEMALE));
        petMap.put(new Pet("Bailey", 9, false), new Person("Mia", 19, Sex.FEMALE));
    }

    public Map<Pet, Person> getAllPets () {
        return petMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
