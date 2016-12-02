package com.simple.shopping.cart.service

import org.specs2.mutable.Specification

import com.simple.shopping.cart.model.ShoppingCart
import com.simple.shopping.cart.model.Product
import com.simple.shopping.cart.model.Apple
import com.simple.shopping.cart.model.Orange

/**
  * Created by r.radkris on 02/12/2016.
  */
class CheckoutSpec extends Specification {

  "when adding products to shopping cart should return correct count" should {
    "total must be 0 when cart is empty" in {
      Checkout().checkout(ShoppingCart()) mustEqual 0
    }

    "total cost must be 2.05 when two apples and one orange in the cart" in {
      val shoppingCart = ShoppingCart().addToCart(Apple)
        .addToCart(Apple)
        .addToCart(Orange)
        .addToCart(Apple)
      Checkout().checkout(shoppingCart) mustEqual 2.05
    }
  }
}

