package jp.t2v.lab.oo_monad

trait Pointed[M[_] <: Pointed[M]] {

  def pure[A](a: A): M[A]

}
