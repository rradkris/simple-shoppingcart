package com.simple.shopping.cart.service

/**
  * Created by r.radkris on 02/12/2016.
  */
import com.simple.shopping.cart.model.ShoppingCart

case class Checkout() {

  def checkout(cart: ShoppingCart): Double = {
    cart.products.view.map {
      case (product, numberOfProductInCart) => numberOfProductInCart * product.price
    }.sum
  }

  def checkoutWithOffers(cart: ShoppingCart):Double = {
    cart.products.view.map {
      case (product, numberOfProductInCart)
        if (product.name == "apple") => costOfApplesInCart(product.price, numberOfProductInCart)
      case (product, numberOfProductInCart)
        if (product.name == "orange") => costOfOrangesInCart(product.price, numberOfProductInCart)
    }.sum
  }

  def costOfApplesInCart(price: Double, numberOfApples: Long):Double = {
    ((numberOfApples / 2) + (numberOfApples % 2)) * price
  }

  def costOfOrangesInCart(price: Double, numberOfOranges: Long) = {
    numberOfOranges match {
      case numberOfOranges if (numberOfOranges % 3 == 0) => ((numberOfOranges / 3) * 2) * price
      case numberOfOranges => ((numberOfOranges % 3) * price) + ((numberOfOranges / 3) * 2) * price
    }
  }
}
