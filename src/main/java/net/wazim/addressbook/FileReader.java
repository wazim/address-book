package net.wazim.addressbook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileReader {

    public List<String> readFile(Path addressBookFile) {
        try {
            return Files.readAllLines(addressBookFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
