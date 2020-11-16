package controller;

import junit.framework.TestCase;
import org.junit.Before;

import java.io.InputStreamReader;

public class TerminalScannerTest extends TestCase {
    TerminalScanner terminalScanner;
    @Before
    public void setUp() {
        MockScanner mockScanner = new MockScanner(new InputStreamReader(System.in));
        terminalScanner = new TerminalScanner(mockScanner);
    }

    public void testReadRowFromTerminal() {
        int result = terminalScanner.readNumberFromTerminal(8);
        assertEquals(3, result);
    }

}