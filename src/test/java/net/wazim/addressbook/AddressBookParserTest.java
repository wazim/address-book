package net.wazim.addressbook;

import net.wazim.addressbook.domain.Gender;
import net.wazim.addressbook.domain.Person;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertThat;

public class AddressBookParserTest {

    private AddressBookParser addressBookParser;

    @Before
    public void setUp() throws Exception {
        addressBookParser = new AddressBookParser();
    }

    @Test
    public void parseAddressBookContent() {
        List<String> addressBookFileContent = asList(
                "Bill McKnight, Male, 16/03/77",
                "Paul Robinson, Male, 15/01/85",
                "Gemma Lane, Female, 20/11/91",
                "Sarah Stone, Female, 20/09/80",
                "Wes Jackson, Male, 14/08/74"
        );

        List<Person> addressBookContacts = addressBookParser.toAddressContacts(addressBookFileContent);

        assertThat(addressBookContacts, CoreMatchers.hasItems(
                new Person("Bill McKnight", Gender.Male, LocalDate.of(1977, Month.MARCH, 16)),
                new Person("Paul Robinson", Gender.Male, LocalDate.of(1985, Month.JANUARY, 15)),
                new Person("Gemma Lane", Gender.Female, LocalDate.of(1991, Month.NOVEMBER, 20)),
                new Person("Sarah Stone", Gender.Female, LocalDate.of(1980, Month.SEPTEMBER, 20)),
                new Person("Wes Jackson", Gender.Male, LocalDate.of(1974, Month.AUGUST, 14))
        ));
    }


}
