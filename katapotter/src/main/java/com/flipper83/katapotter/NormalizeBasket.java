package com.flipper83.katapotter;

import java.util.ArrayList;
import java.util.List;

public class NormalizeBasket {
  List<SetCollection> collections = new ArrayList<>();

  public List<SetCollection> getCollections() {
    return collections;
  }

  public void addBooks(List<String> books) {
    for (String book : books) {
      addBookToSetCollections(book);
    }
  }

  private void addBookToSetCollections(String book) {
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
