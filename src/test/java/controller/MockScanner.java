package controller;

import java.io.BufferedReader;
import java.io.Reader;


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
    if (calls == 1){
      calls+=1;
      return  "2";
    }
    if (calls ==2){
      calls+=1;
      return "a";
    }
    if (calls ==3){
      calls+=1;
      return "7";
    }
    if (calls ==4){
      calls+=1;
      return "3";
    }
    return "-1";
  }

}
