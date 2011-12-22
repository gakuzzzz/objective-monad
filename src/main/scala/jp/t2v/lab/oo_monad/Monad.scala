package jp.t2v.lab.oo_monad

trait Monad[+A, M[A] <: Monad[A, M]] extends Applicative[A, M] {

  def flatMap[B](f: A => M[B]): M[B]

  def >>=[B] = flatMap[B] _

  def `return`[B] = pure[B] _

  def <*>[B >: A, C](fm: M[B => C]): M[C] =
    fm flatMap {f => this flatMap {v => pure(f(v))}}
//    fm >>= {f => this >>= {v => `return`(f(v))}}

}
