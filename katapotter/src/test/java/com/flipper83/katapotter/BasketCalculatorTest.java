package com.flipper83.katapotter;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketCalculatorTest {
  private static final List<String> EMPTY_BASKET = new ArrayList<>();
  private static final String FIRST_BOOK = "Philosopher stone";
  private static final String SECOND_BOOK = "The chamber of secrets";
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
    List<String> basket = givenBasketWithOneBook();

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals(8, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithoutDiscountWithABasketWithTwoSameBooks() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket = givenBasketWithTwoSameBooks();

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals(8 * 2, amount, DELTA_ZERO);
  }

  @Test
  public void shouldReturnPriceWithDiscountWithABasketWithTwoDifferentBooks() {
    BasketCalculator basketCalculator = new BasketCalculator();
    List<String> basket = givenBasketWithTwoDifferentBooks();

    float amount = basketCalculator.calculatePrice(basket);

    assertEquals(8 * 2 * 0.95, amount, DELTA_ZERO);
  }

  private List<String> givenBasketWithTwoDifferentBooks() {
    List<String> basket = new ArrayList<>();
    basket.add(FIRST_BOOK);
    basket.add(SECOND_BOOK);
    return basket;
  }

  private List<String> givenBasketWithTwoSameBooks() {
    List<String> basket = new ArrayList<>();
    basket.add(FIRST_BOOK);
    basket.add(FIRST_BOOK);
    return basket;
  }

  private List<String> givenBasketWithOneBook() {
    List<String> basket = new ArrayList<>();
    basket.add(FIRST_BOOK);
    return basket;
  }
}