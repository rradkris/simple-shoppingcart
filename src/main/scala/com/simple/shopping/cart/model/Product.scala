package com.simple.shopping.cart.model

/**
  * Created by r.radkris on 29/11/2016.
  */

trait Product {
  def name: String
  def price: Double
}

object Orange extends Product {
  override def name: String = "Orange"
  override def price: Double = 0.25
}

object Apple extends Product {
  override def name: String = "Apple"
  override def price: Double = 0.60
}
