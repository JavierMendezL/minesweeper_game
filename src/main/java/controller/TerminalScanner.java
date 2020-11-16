package controller;

import java.io.BufferedReader;

public class TerminalScanner {
  private final BufferedReader scanner;

  public TerminalScanner(BufferedReader bufferedReader) {
    this.scanner = bufferedReader;
  }

  public int readNumberFromTerminal(int maxNum) {
    String readValue;
    int value = 0;
    boolean verified = false;

    do {
      try {
        System.out.print("Insert value: [0-" + maxNum + "] ");
        readValue = scanner.readLine();
        value = Integer.parseInt(readValue);

        if (value <= maxNum && value > 0) {
          verified = true;
        }
      } catch (Exception e) {
        System.out.println("Value not expected");
      }
    } while (!verified);

    return value;
  }


}
