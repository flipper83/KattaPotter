package com.flipper83.katapotter;

import java.util.List;

public class BasketCalculator {
  private static final int BOOK_PRICE = 8;

  public int calculatePrice(List<String> books) {
    int amount = BOOK_PRICE * books.size();
    return amount;
  }
}
