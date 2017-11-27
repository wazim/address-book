package net.wazim.addressbook;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FileReaderTest {

    @Test
    public void canReadAFilesContents() {
        FileReader fileReader = new FileReader();
        List<String> fileLines = fileReader.readFile(Paths.get(this.getClass().getClassLoader().getResource("AddressBook").getPath()));

        assertThat(fileLines.get(0), is("Bill McKnight, Male, 16/03/77"));
        assertThat(fileLines.get(1), is("Paul Robinson, Male, 15/01/85"));
        assertThat(fileLines.get(2), is("Gemma Lane, Female, 20/11/91"));
        assertThat(fileLines.get(3), is("Sarah Stone, Female, 20/09/80"));
        assertThat(fileLines.get(4), is("Wes Jackson, Male, 14/08/74"));
    }

}
