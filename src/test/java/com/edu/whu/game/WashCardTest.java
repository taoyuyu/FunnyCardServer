package com.edu.whu.game;

import org.junit.Test;

public class WashCardTest {
  @Test
  public void testWashCard() {
    int[] cards = {0,1,2,3,4,5,6,7,8,9,10,11,12};
    WashCard washCard = new WashCard();

    for (int i = 0; i < 10; ++i)
      washCard.randomNumber(cards);
  }
}
