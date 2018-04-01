package com.edu.whu.game;

import java.util.Random;

public class WashCard {
  private  Random random = new Random();

  public void randomNumber(int[] cards) {
    for (int i = 0; i < cards.length; ++i) {
      int x = random.nextInt(cards.length - i);
      System.out.print(cards[x] + " ");
      int temp = cards[x];
      cards[x] = cards[cards.length - 1 - i];
      cards[cards.length- 1 - i] = temp;
    }
    System.out.println();
  }

}
