package net.wazim.addressbook;

import net.wazim.addressbook.domain.Gender;
import net.wazim.addressbook.domain.Person;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ApplicationRunner {

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        AddressBookParser addressBookParser = new AddressBookParser();

        Path addressBookInputFile = Paths.get(args[0]);

        List<String> addressBookContent = fileReader.readFile(addressBookInputFile);
        List<Person> addressContacts = addressBookParser.toAddressContacts(addressBookContent);

        AddressBook addressBook = new AddressBook(addressContacts);

        System.out.format("There are %d males in the address book\n", addressBook.retrieveNumberOfPeopleMatchingGender(Gender.Male));

        System.out.format("The oldest person in the address book is %s\n", addressBook.retrieveOldestPerson().name());

        System.out.format("Bill McKnight is %d days older than Paul Robinson\n", addressBook.ageDifferenceInDaysBetween(
                addressContacts.stream().filter(person -> person.name().equals("Bill McKnight")).findFirst().get(),
                addressContacts.stream().filter(person -> person.name().equals("Paul Robinson")).findFirst().get()
        ));
    }


}
