package com.flipper83.katapotter;

import java.util.ArrayList;
import java.util.List;

public class SetCollection {
  private List<String> collection = new ArrayList<>();

  public boolean addBook(String book) {
    if (!collection.contains(book)) {
      collection.add(book);
      return true;
    }
    return false;
  }

  public int numBooks() {
    return collection.size();
  }
}
