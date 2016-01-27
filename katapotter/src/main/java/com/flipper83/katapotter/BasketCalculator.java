package com.flipper83.katapotter;

import java.util.ArrayList;
import java.util.List;

public class BasketCalculator {
  private static final int BOOK_PRICE = 8;
  private static final float BOOK_DISCOUNT = 0.95f;

  public float calculatePrice(List<String> books) {
    List<SetCollection> collections = addBooksToSetCollections(books);

    float amount = 0.0f;
    for (SetCollection collection : collections) {
      int numBooks = collection.numBooks();
      if (numBooks > 1) {
        amount += BOOK_PRICE * BOOK_DISCOUNT * numBooks;
      } else {
        amount += BOOK_PRICE * numBooks;
      }
    }
    return amount;
  }

  private List<SetCollection> addBooksToSetCollections(List<String> books) {
    List<SetCollection> collections = new ArrayList<>();
    for (String book : books) {
      addBookToSetCollections(book, collections);
    }
    return collections;
  }

  private void addBookToSetCollections(String book, List<SetCollection> collections) {
    boolean added = false;

    for (int i = 0; i < collections.size() && !added; i++) {
      SetCollection collection = collections.get(i);
      added = collection.addBook(book);
    }

    if (!added) {
      SetCollection newCollection = new SetCollection();
      newCollection.addBook(book);
      collections.add(newCollection);
    }
  }
}
