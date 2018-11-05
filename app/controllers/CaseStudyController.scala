package controllers

import javax.inject.Inject
import play.api.mvc.{Action, Controller}
import services.{ExecutionContextImplicitlyService, ExecutionContextInjectedService}

class CaseStudyController @Inject()(injectedEC: ExecutionContextInjectedService,
                                    implicitEC: ExecutionContextImplicitlyService) extends Controller {
  def firstCase() = Action {
    implicit request =>
      injectedEC.execute()
      Ok("")
  }

  def secondCase() = Action {
    implicit request =>
      implicitEC.execute()
      Ok("")
  }
}
