package net.wazim.addressbook;

import net.wazim.addressbook.domain.Gender;
import net.wazim.addressbook.domain.Person;

import java.time.temporal.ChronoUnit;
import java.util.List;

public class AddressBook {

    private final List<Person> addressBookContacts;

    public AddressBook(List<Person> addressBookContacts) {
        this.addressBookContacts = addressBookContacts;
    }

    public long retrieveNumberOfPeopleMatchingGender(Gender gender) {
        return addressBookContacts.stream().filter(person -> person.gender() == gender).count();
    }

    public Person retrieveOldestPerson() {
        return addressBookContacts
                .stream()
                .sorted((o1, o2) -> o1.dateOfBirth().compareTo(o2.dateOfBirth()))
                .findFirst()
                .get();
    }

    public long ageDifferenceInDaysBetween(Person firstPerson, Person secondPerson) {
        return ChronoUnit.DAYS.between(firstPerson.dateOfBirth(), secondPerson.dateOfBirth());
    }
}
