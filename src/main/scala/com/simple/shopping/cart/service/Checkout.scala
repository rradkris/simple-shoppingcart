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
}
