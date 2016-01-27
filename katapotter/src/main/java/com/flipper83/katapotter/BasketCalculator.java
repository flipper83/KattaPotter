package com.flipper83.katapotter;

import java.util.ArrayList;
import java.util.List;

public class BasketCalculator {
  private static final int BOOK_PRICE = 8;
  private static final float BOOK_DISCOUNT = 0.95f;

  public float calculatePrice(List<String> books) {
    List<List<String>> collections = addBooksToSetCollections(books);

    float amount = 0.0f;
    for (List<String> collection : collections) {
      int numBooks = collection.size();
      if (numBooks > 1) {
        amount += BOOK_PRICE * BOOK_DISCOUNT * numBooks;
      } else {
        amount += BOOK_PRICE * numBooks;
      }
    }
    return amount;
  }

  private List<List<String>> addBooksToSetCollections(List<String> books) {
    List<List<String>> collections = new ArrayList<>();
    for (String book : books) {
      addBookToSetCollections(book, collections);
    }
    return collections;
  }

  private void addBookToSetCollections(String book, List<List<String>> collections) {
    boolean added = false;

    for (int i = 0; i < collections.size() && !added; i++) {
      List<String> collection = collections.get(i);
      if (!collection.contains(book)) {
        collection.add(book);
        added = true;
      }
    }

    if (!added) {
      List<String> newCollection = new ArrayList<>();
      newCollection.add(book);
      collections.add(newCollection);
    }
  }
}
