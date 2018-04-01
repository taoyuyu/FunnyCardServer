package com.edu.whu.server.load;

public interface LoadBalance {
  String getNextHost();
  boolean removeOneHost(String host);
  void addOneHost(String host);
}
