
package com.mycompany.simulacioncrud;

import java.util.ArrayList;


public class DataRepository {
     private static ArrayList<Person> personList = new ArrayList<>();

    public static ArrayList<Person> getPersonList() {
        return personList;
    }

    public static void addPerson(Person person) {
        personList.add(person);
    }

    public static void updatePerson(int index, Person updatedPerson) {
        if (index >= 0 && index < personList.size()) {
            personList.set(index, updatedPerson);
        }
    }

    public static void deletePerson(int index) {
        if (index >= 0 && index < personList.size()) {
            personList.remove(index);
        }
    }
    
}
