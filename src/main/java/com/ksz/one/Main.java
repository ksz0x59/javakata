package com.ksz.one;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        PetRepository petRepository = new PetRepository();

        PetService petService = new PetService(petRepository);

        System.out.println("########################");

        Set<Pet> dangerousPetsWagesLessThanSix = petService.dangerousPetsWagesLessThanSix();

        dangerousPetsWagesLessThanSix.forEach(System.out::println);

        System.out.println("########################");

        Set<Pet> petsOfAgePeople = petService.petsOfAgePeople();

        petsOfAgePeople.forEach(System.out::println);

        System.out.println("########################");

        Set<Person> peopleOlderThanTwenty = petService.peopleOlderThanTwenty();

        peopleOlderThanTwenty.forEach(System.out::println);

        System.out.println("########################");

        Set<Person> peopleWithOnlyOnePet = petService.peopleWithOnePetV2();
        peopleWithOnlyOnePet.forEach(System.out::println);

        System.out.println("########################");

        Person personWithMaxPets = petService.personWithMaxPets();
        System.out.println(personWithMaxPets);

        System.out.println("########################");
        System.out.println("Sum of Dangerous Pets weight is : " + petService.sumDangerousPetsWeight());

        System.out.println("########################");
        Map.Entry<Pet, Person> petPersonEntry = petService.getMostDangerousPetAndOwner();

        System.out.println("The most Dangerous Pet is : " + petPersonEntry.getKey()
                + " Pet is woned by : " + petPersonEntry.getValue());
    }
}
