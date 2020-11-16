package controller;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

class MockScanner extends BufferedReader {

  int calls;

  public MockScanner(Reader in, int sz) {
    super(in, sz);
  }

  public MockScanner(Reader in) {
    super(in);
  }


  public String readLine(){
    if (calls == 0){
      calls+=1;
      return "3";
    }
    return "-1";
  }

}
