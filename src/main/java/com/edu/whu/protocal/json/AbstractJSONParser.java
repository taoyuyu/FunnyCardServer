package com.edu.whu.protocal.json;

    import com.edu.whu.protocal.Parser;

public abstract class AbstractJSONParser extends Parser {
  public AbstractJSONParser(String message) {
    super(message);
  }

  abstract int parseStatucCode();
  abstract String parsePlayerID();

}
