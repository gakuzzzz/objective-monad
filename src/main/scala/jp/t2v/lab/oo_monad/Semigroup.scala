package jp.t2v.lab.oo_monad

trait Semigroup0[M <: Semigroup0[M]] {

  def append(a: M): M

}
trait Semigroup1[+A, M[A] <: Semigroup1[A, M]] {

  def append[B >: A](a: M[B]): M[B]

}
