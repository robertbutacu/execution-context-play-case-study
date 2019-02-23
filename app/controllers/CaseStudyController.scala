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
        injectedEC.execute()
        Ok("")
      }
  }

  def secondCase() = Action.async {
    implicit request =>
      Future {
        implicitEC.execute()
        Ok("")
      }
  }
}
