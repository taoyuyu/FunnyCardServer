package com.edu.whu.protocal.json;

import com.alibaba.fastjson.JSONObject;
import com.edu.whu.protocal.UtilStrings;

public class MyJSONParser extends AbstractJSONParser {
  private JSONObject jsonObject;
  public MyJSONParser(String message) {
    super(message);
    parse();
  }


  @Override
  public int parseStatucCode() {
    return jsonObject.getInteger(UtilStrings.STATUS_CODE);
  }

  @Override
  public String parsePlayerID() {
    return jsonObject.getString(UtilStrings.PLAYER_ID);
  }

  @Override
  public boolean check() {
    //TODO 检查json格式
    return true;
  }

  @Override
  public void parse() {
    jsonObject = JSONObject.parseObject(this.message);
  }
}
