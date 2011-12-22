package jp.t2v.lab.oo_monad

trait Monoid0[M <: Monoid0[M]] extends Semigroup0[M] {

  def zero: M

}
trait Monoid1[+A, M[A] <: Monoid1[A, M]] extends Semigroup1[A, M] {

  def zero[B >: A]: M[B]

}
