package jp.t2v.lab.oo_monad

trait Applicative[+A, M[A] <: Applicative[A, M]] extends Functor[A, M] with Pointed[M] {

  def <*>[B >: A, C](fm: M[B => C]): M[C]

  def <*>:[B >: A, C] = <*>[B, C] _

  def map[B](f: A => B): M[B] = this <*> pure(f)

  def `<$>`[B] = map[B] _

  def `<$>:`[B] = map[B] _

}
