package services

import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ExecutionContextInjectedService @Inject() (implicit ec: ExecutionContext) {
  def execute(): Future[Unit] = Future {
    println(s" [ Implicit ec ] ${Thread.currentThread().getName} with a hash code of : ${Thread.currentThread().hashCode()}")
  }
}
