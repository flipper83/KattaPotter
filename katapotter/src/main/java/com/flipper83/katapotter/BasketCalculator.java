package com.flipper83.katapotter;

import java.util.List;

public class BasketCalculator {
  private static final int BOOK_PRICE = 8;
  private static final float BOOK_DISCOUNT = 0.05f;

  public float calculatePrice(List<String> books) {

    NormalizeBasket normalizeBasket = new NormalizeBasket();
    normalizeBasket.addBooks(books);

    float amount = 0.0f;
    for (SetCollection collection : normalizeBasket.getCollections()) {
      int numBooks = collection.numBooks();
      float discount = calculateDiscount(numBooks);
      amount += BOOK_PRICE * discount * numBooks;
    }
    return amount;
  }

  private float calculateDiscount(int numBooks) {
    return 1.0f - ((numBooks - 1) * BOOK_DISCOUNT);
  }
}
