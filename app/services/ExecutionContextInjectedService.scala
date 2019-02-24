package services

import javax.inject.{Inject, Singleton}

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class ExecutionContextInjectedService @Inject() (implicit ec: ExecutionContext) {
  def execute(): Future[Unit] = Future {
    Thread.sleep(3000)
    println(s" [Service][Injected ec] ${Thread.currentThread().getName} with a hash code of : ${Thread.currentThread().hashCode()}")
  }
}
