package com.codecool.histogram;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TextReaderTest {



    @Test
    public void whenReadTextWithOneLine_ReturnCorrectString() throws IOException {
        TextReader textReader = new TextReader("src/test/resources/test.txt");
        String result = textReader.read() ;
        assertEquals("Harry Potter and the Sorcerer's Stone" + System.lineSeparator(), result);
    }

    @Test
    public void whenFileNotExist_ThrowFileNotFoundException() {
        TextReader textReader = new TextReader("src/test/resources/test12");
        assertThrows(FileNotFoundException.class, textReader::read
        );
    }

    @Test
    public void whenFileIsEmpty_ReturnEmptyString() throws IOException {
        TextReader textReader = new TextReader("src/test/resources/empty.txt");
        String result = textReader.read() ;
        assertEquals("", result);
    }

    @Test
    public void whenFileHasManyLines_ReturnCorrectNumberOfLines() throws IOException {
        TextReader textReader = new TextReader("src/test/resources/text.txt");
        String result = textReader.read() ;
        String [] lines = result.split(System.lineSeparator());
        assertEquals(33, lines.length);
    }






    
}
