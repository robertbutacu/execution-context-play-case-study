package controllers

import javax.inject.Inject
import play.api.mvc.{AbstractController, ControllerComponents}
import services.{ExecutionContextImplicitlyService, ExecutionContextInjectedService}

import scala.concurrent.{ExecutionContext, Future}

class CaseStudyController @Inject()(injectedEC: ExecutionContextInjectedService,
                                    implicitEC: ExecutionContextImplicitlyService,
                                    cc: ControllerComponents)(implicit executionContext: ExecutionContext) extends AbstractController(cc) {
  def firstCase() = Action.async {
    implicit request =>
      Future {
        println(s" [Controller][Injected ec] ${Thread.currentThread().getName} with a hash code of : ${Thread.currentThread().hashCode()}")
        injectedEC.execute()
        Ok("")
      }
  }

  def secondCase() = Action.async {
    implicit request =>
      Future {
        println(s" [Controller][Implicit ec] ${Thread.currentThread().getName} with a hash code of : ${Thread.currentThread().hashCode()}")
        implicitEC.execute()
        Ok("")
      }
  }
}
