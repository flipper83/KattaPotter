package com.flipper83.katapotter;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketCalculatorTest {
  private static final List<String> EMPTY_BASKET = new ArrayList<>();
  private static final String FIRST_BOOK = "Philosopher stone";
  private static final String SECOND_BOOK = "The chamber of secrets";
  private static final String THIRD_BOOK = "Prisoner of Azkaban";
  public static final int DELTA_ZERO = 0;

  @Test
  public void shouldReturnZeroPriceForAnEmptyBasket() {
    BasketCalculator basketCalculator = new BasketCalculator();

    float amount = basketCalculator.calculatePrice(EMPTY_BASKET);

    assertEquals(0, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithoutDiscountWithABasketWithOneBook() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket = givenBasketWithBooks(FIRST_BOOK);

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals(8, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithoutDiscountWithABasketWithTwoSameBooks() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket = givenBasketWithBooks(FIRST_BOOK, FIRST_BOOK);

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals(8 * 2, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithDiscountWithABasketWithTwoDifferentBooks() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket = givenBasketWithBooks(FIRST_BOOK, SECOND_BOOK);

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals(8 * 2 * 0.95f, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithDiscountWithABasketWithThreeBooksTwoDifferent() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket = givenBasketWithBooks(FIRST_BOOK, FIRST_BOOK, SECOND_BOOK);

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals((8 * 2 * 0.95f) + 8, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithDiscountWithABasketWithThreeBooksAllDifferent() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket = givenBasketWithBooks(FIRST_BOOK, SECOND_BOOK, THIRD_BOOK);

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals(8 * 3 * 0.90f, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithDiscountWithABasketWithFiveBooksThreeDifferents() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket =
        givenBasketWithBooks(FIRST_BOOK, SECOND_BOOK, FIRST_BOOK, THIRD_BOOK, SECOND_BOOK);

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals((8 * 3 * 0.90f) + (8 * 2 * 0.95f), amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithDiscountWithABasketWithSixBooksTwoDifferents() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket =
        givenBasketWithBooks(FIRST_BOOK, SECOND_BOOK, FIRST_BOOK, SECOND_BOOK, SECOND_BOOK,
            FIRST_BOOK);

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals((8 * 2 * 0.95f) + (8 * 2 * 0.95f) + (8 * 2 * 0.95f), amount, DELTA_ZERO);
  }

  private List<String> givenBasketWithBooks(String... books) {
    List<String> basket = new ArrayList<>();
    if (books != null) {
      for (String book : books) {
        basket.add(book);
      }
    }
    return basket;
  }
}