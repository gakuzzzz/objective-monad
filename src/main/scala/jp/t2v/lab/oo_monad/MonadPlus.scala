package jp.t2v.lab.oo_monad

trait MonadPlus[+A, M[A] <: MonadPlus[A, M]] extends Monad[A, M] with Monoid1[A, M]
