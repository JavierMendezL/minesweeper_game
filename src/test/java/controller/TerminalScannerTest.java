package controller;

import junit.framework.TestCase;
import org.junit.Before;

public class TerminalScannerTest extends TestCase {
    TerminalScanner terminalScanner;
    @Before
    public void setUp() {
        terminalScanner = new TerminalScanner();
    }

    public void testReadRowFromTerminal() {
        int result = terminalScanner.readRowFromTerminal(8);
        assertEquals(3, result);

    }
}