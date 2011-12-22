package jp.t2v.lab.oo_monad

trait Functor[+A, M[A] <: Functor[A, M]] {

  def map[B](f: A => B): M[B]

  def fmap[B] = map[B] _

}
