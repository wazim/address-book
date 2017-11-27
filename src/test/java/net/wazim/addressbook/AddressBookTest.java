package net.wazim.addressbook;

import net.wazim.addressbook.domain.Gender;
import net.wazim.addressbook.domain.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddressBookTest {

    private static final Person WES_JACKSON = new Person("Wes Jackson", Gender.Male, LocalDate.of(1974, Month.AUGUST, 14));
    public static final Person BILL_MCKNIGHT = new Person("Bill McKnight", Gender.Male, LocalDate.of(1977, Month.MARCH, 16));
    public static final Person PAUL_ROBINSON = new Person("Paul Robinson", Gender.Male, LocalDate.of(1985, Month.JANUARY, 15));

    private AddressBook addressBook;

    @Before
    public void setupAddressBook() {
        addressBook = new AddressBook(Arrays.asList(
                BILL_MCKNIGHT,
                PAUL_ROBINSON,
                new Person("Gemma Lane", Gender.Female, LocalDate.of(1991, Month.NOVEMBER, 20)),
                new Person("Sarah Stone", Gender.Female, LocalDate.of(1980, Month.SEPTEMBER, 20)),
                WES_JACKSON
        ));
    }

    @Test
    public void countNumberOfMalesInAddressBook() {
        assertThat(
                addressBook.retrieveNumberOfPeopleMatchingGender(Gender.Male),
                is(3L)
        );
    }

    @Test
    public void retrieveOldestPersonInAddressBook() {
        assertThat(
                addressBook.retrieveOldestPerson(),
                is(WES_JACKSON)
        );
    }

    @Test
    public void getDaysAgeDifferenceBetweenTwoPeople(){
        assertThat(
                addressBook.ageDifferenceInDaysBetween(BILL_MCKNIGHT, PAUL_ROBINSON),
                is(2862L)
        );
    }
}
