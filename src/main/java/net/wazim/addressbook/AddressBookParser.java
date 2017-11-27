package net.wazim.addressbook;

import net.wazim.addressbook.domain.Gender;
import net.wazim.addressbook.domain.Person;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class AddressBookParser {

    private static final String DELIMITER = ", ";
    private static final ZoneId ZONE_ID = ZoneId.of("Europe/London");

    public List<Person> toAddressContacts(List<String> addressBookFileContent) {
        return addressBookFileContent.stream().map(addressLine -> {
            String[] personDetails = addressLine.split(DELIMITER);
            try {
                Date parse = new SimpleDateFormat("dd/MM/yy").parse(personDetails[2]);
                return new Person(
                        personDetails[0],
                        Gender.valueOf(personDetails[1]),
                        parse.toInstant().atZone(ZONE_ID).toLocalDate()
                );
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).collect(toList());
    }

}
