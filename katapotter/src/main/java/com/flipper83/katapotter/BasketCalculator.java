package com.flipper83.katapotter;

import java.util.List;

public class BasketCalculator {
  private static final int BOOK_PRICE = 8;
  private static final float BOOK_DISCOUNT = 0.95f;

  public float calculatePrice(List<String> books) {

    NormalizeBasket normalizeBasket = new NormalizeBasket();
    normalizeBasket.addBooks(books);

    float amount = 0.0f;
    for (SetCollection collection : normalizeBasket.getCollections()) {
      int numBooks = collection.numBooks();
      if (numBooks > 1) {
        amount += BOOK_PRICE * BOOK_DISCOUNT * numBooks;
      } else {
        amount += BOOK_PRICE * numBooks;
      }
    }
    return amount;
  }
}
