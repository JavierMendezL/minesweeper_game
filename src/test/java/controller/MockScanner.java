package controller;

import java.io.BufferedReader;
import java.io.Reader;


class MockScanner extends BufferedReader {

  int calls;
  boolean status;
  int statusCall;
  public MockScanner(Reader in, int sz) {
    super(in, sz);
  }

  public MockScanner(Reader in) {
    super(in);
  }
  public MockScanner(Reader in, boolean status) {
    super(in);
    this.status = status;
  }


  public String readLine(){
    if (status){
      if (statusCall == 0){
        statusCall+=1;
        return "1";
      }
      if (statusCall == 1){
        statusCall+=1;
        return "0";
      }
      if (statusCall == 2){
        statusCall+=1;
        return "1";
      }
      if (statusCall == 3){
        statusCall+=1;
        return "1";
      }
      if (statusCall == 4){
        statusCall+=1;
        return "0";
      }
      if (statusCall == 5){
        statusCall+=1;
        return "2";
      }
      if (statusCall == 6){
        statusCall+=1;
        return "1";
      }
      if (statusCall == 7){
        statusCall+=1;
        return "1";
      }
      if (statusCall == 8){
        statusCall+=1;
        return "0";
      }
      if (statusCall == 9){
        statusCall+=1;
        return "0";
      }
      if (statusCall == 10){
        statusCall+=1;
        return "0";
      }
      if (statusCall == 11){
        statusCall+=1;
        return "0";
      }
      if (statusCall == 12){
        statusCall+=1;
        return "0";
      }
      if (statusCall == 13){
        statusCall+=1;
        return "2";
      }
      if (statusCall == 14){
        statusCall+=1;
        return "2";
      }

    }
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
