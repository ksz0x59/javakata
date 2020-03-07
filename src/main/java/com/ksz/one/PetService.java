package com.ksz.one;

import java.util.*;
import java.util.stream.Collectors;

public class PetService {

    private PetRepository repository;

    PetService () {}

    PetService (PetRepository petRepository)
    {
        this.repository = petRepository;
    }

    public  Set<Pet> petsOfAgePeople() {
        return null;
    }

    public  Set<Pet> dangerousPetsWagesLessThanSix() {
        return null;
    }

    public  Set<Person> peopleOlderThanTwenty() {
        return null;
    }

    public Set<Person> peopleWithOnePet() {
        return null;
    }

    public Set<Person> peopleWithOnePetV2() {
        return null;
    }

    public Person personWithMaxPets() {
        return null;
    }

    public Integer sumDangerousPetsWeight() {
        return null;
    }

    public Map.Entry<Pet, Person> getMostDangerousPetAndOwner() {
        return null;
    }
}
