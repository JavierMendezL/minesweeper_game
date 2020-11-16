package controller;

import java.io.BufferedReader;
import java.io.Closeable;
import java.util.Scanner;

public class TerminalScanner {
  private final BufferedReader scanner;

  public TerminalScanner(BufferedReader bufferedReader) {
    this.scanner = bufferedReader;
  }

  public int readRowFromTerminal(int maxRow) {
    String readValue;
    int value = 0;
    boolean verified = false;

    do {
        try {
            System.out.print("Insert value: [0-"+maxRow+"] ");
            readValue = scanner.readLine();
            value = Integer.parseInt(readValue);

            if (value<=maxRow && value>0){
                verified = true;
            }
        }catch (Exception e){
            System.out.println("Value not expected");
        }
    }while (!verified);

    return value;
  }



}
