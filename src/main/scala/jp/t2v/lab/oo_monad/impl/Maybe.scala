package jp.t2v.lab.oo_monad.impl

import jp.t2v.lab.oo_monad._

sealed trait Maybe[+A] extends MonadPlus[A, Maybe] {

  def pure[B](b: B): Maybe[B] = if (b == null) Not else Just(b)

  def zero[B >: A]: Maybe[B] = Not

}

case class Just[+A](value: A) extends Maybe[A] {

  def flatMap[B](f: A => Maybe[B]): Maybe[B] = f(value)

  def append[B >: A](a: Maybe[B]): Maybe[B] = this

}

case object Not extends Maybe[Nothing] {

  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = Not

  def append[B >: Nothing](a: Maybe[B]): Maybe[B] = a

}
