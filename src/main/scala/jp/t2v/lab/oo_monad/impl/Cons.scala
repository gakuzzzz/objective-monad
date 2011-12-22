package jp.t2v.lab.oo_monad.impl

import jp.t2v.lab.oo_monad._

sealed trait Cons[+A] extends MonadPlus[A, Cons] {

  def ::[B >: A](b: B): Cons[B] = Cell(b, this)

  def pure[B](b: B): Cons[B] = b :: Empty

  def ++[B >: A] = append[B] _

  def append[B >: A](a: Cons[B]): Cons[B]

  def zero[B >: A]: Cons[B] = Empty

}

case class Cell[+A](head: A, tail: Cons[A]) extends Cons[A] {

  def flatMap[B](f: A => Cons[B]): Cons[B] = f(head) ++ (tail flatMap f)

  def append[B >: A](a: Cons[B]): Cons[B] = head :: tail ++ a

}
case object Empty extends Cons[Nothing] {

  def flatMap[B](f: Nothing => Cons[B]): Cons[B] = Empty

  def append[B >: Nothing](a: Cons[B]): Cons[B] = a

}
