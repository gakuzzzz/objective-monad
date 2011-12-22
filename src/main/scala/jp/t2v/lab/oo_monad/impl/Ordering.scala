package jp.t2v.lab.oo_monad.impl

import jp.t2v.lab.oo_monad._

sealed trait Ordering extends Monoid0[Ordering] {

  def zero: Ordering = EQ

}
case object LT extends Ordering {

  def append(a: Ordering): Ordering = this

}
case object EQ extends Ordering {

  def append(a: Ordering): Ordering = a

}
case object GT extends Ordering {

  def append(a: Ordering): Ordering = this

}
