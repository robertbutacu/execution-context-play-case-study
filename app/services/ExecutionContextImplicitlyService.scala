package services

import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ExecutionContextImplicitlyService @Inject() () {
  def execute()(implicit ec: ExecutionContext): Future[Unit] = Future {
    Thread.sleep(3000)
    println(s" [ Implicit ec ] ${Thread.currentThread().getName} with a hash code of : ${Thread.currentThread().hashCode()}")
  }
}
