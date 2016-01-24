package com.flipper83.katapotter;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasketCalculatorTest {
  private static final List<String> EMPTY_BASKET = new ArrayList<>();

  @Test
  public void shouldReturnZeroPriceForAnEmptyBasket() {
    BasketCalculator basketCalculator = new BasketCalculator();

    int amount = basketCalculator.calculatePrice(EMPTY_BASKET);

    assertEquals(0, amount);
  }
}
