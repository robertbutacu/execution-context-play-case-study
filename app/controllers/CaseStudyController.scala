package controllers

import javax.inject.Inject
import play.api.mvc.{Action, Controller}
import services.{ExecutionContextImplicitlyService, ExecutionContextInjectedService}

import scala.concurrent.Future

class CaseStudyController @Inject()(injectedEC: ExecutionContextInjectedService,
                                    implicitEC: ExecutionContextImplicitlyService) extends Controller {
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
