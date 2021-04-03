package com.ksz.one;

import java.util.*;
import java.util.stream.Collectors;

public class PetService {

    private PetRepository repository;

    PetService() {
    }

    PetService(PetRepository petRepository) {
        this.repository = petRepository;
    }

    public Set<Pet> petsOfAgePeople() {
        Map<Pet, Person> petsMap = repository.getAllPets();

        Set<Pet> petSet = petsMap.entrySet().stream()
                .filter(e -> e.getValue().getAge() > 17)
                .map(e -> e.getKey())
                .collect(Collectors.toSet());
        return petSet;
    }

    public Set<Pet> dangerousPetsWagesLessThanSix() {
        Map<Pet, Person> petsMap = repository.getAllPets();

        Set<Pet> petSet = petsMap.keySet().stream()
                .filter(pet -> pet.isDangerous())
                .filter(pet -> pet.getWeight() < 6)
                .collect(Collectors.toSet());
        return petSet;
    }

    public Set<Person> peopleOlderThanTwenty() {
        Map<Pet, Person> petsMap = repository.getAllPets();

        Set<Person> personSet = petsMap.values().stream()
                .filter(person -> person.getAge() > 20)
                .collect(Collectors.toSet());

        return personSet;
    }

    public Set<Person> peopleWithOnePet() {

        Map<Pet, Person> petsMap = repository.getAllPets();

        Map<Person, List<Pet>> personPetMap = new HashMap<>();

        for (Map.Entry<Pet, Person> entry : petsMap.entrySet()) {
            Person oldVal = entry.getValue();
            Pet oldKey = entry.getKey();

            List<Pet> newVal = null;

            if (personPetMap.containsKey(oldVal)) {
                newVal = personPetMap.get(oldVal);
                newVal.add(oldKey);
            } else {
                newVal = new ArrayList<>();
                newVal.add(oldKey);
            }

            personPetMap.put(oldVal, newVal);
        }

        return personPetMap.entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<Person> peopleWithOnePetV2() {
        Map<Pet, Person> petsMap = repository.getAllPets();

        Map<Person, List<Pet>> personPetMap = petsMap.entrySet().stream()
                .collect(Collectors
                        .groupingBy((Map.Entry::getValue), Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        return personPetMap.entrySet().stream()
                .filter(e -> e.getValue().size() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Person personWithMaxPets() {
        Map<Pet, Person> petsMap = repository.getAllPets();

        Map<Person, List<Pet>> personPetMap = petsMap.entrySet().stream()
                .collect(Collectors
                        .groupingBy((Map.Entry::getValue), Collectors.mapping(Map.Entry::getKey, Collectors.toList())));


        TreeSet<Integer> petCountSet = new TreeSet<>();

        for (Map.Entry<Person, List<Pet>> entry : personPetMap.entrySet()) {
            petCountSet.add(entry.getValue().size());
        }

        return personPetMap.entrySet().stream()
                .filter(e -> e.getValue().size() == petCountSet.last())
                .map(Map.Entry::getKey).findFirst().get();
    }

    public Integer sumDangerousPetsWeight() {
        Map<Pet, Person> petsMap = repository.getAllPets();

        return petsMap.keySet().stream()
                .filter(Pet::isDangerous)
                .mapToInt(Pet::getWeight).sum();
    }

    public Map.Entry<Pet, Person> getMostDangerousPetAndOwner() {
        Map<Pet, Person> petsMap = repository.getAllPets();

        int MaxWeightOfDangerousPet = petsMap.keySet().stream()
                .filter(Pet::isDangerous)
                .mapToInt(Pet::getWeight).max().orElse(-1);

        return petsMap.entrySet().stream()
                .filter(e -> e.getKey().getWeight() == MaxWeightOfDangerousPet)
                .findFirst().get();
    }
}
