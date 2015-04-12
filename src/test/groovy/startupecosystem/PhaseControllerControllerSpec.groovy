package startupecosystem



import grails.test.mixin.*
import spock.lang.*

@TestFor(PhaseControllerController)
@Mock(PhaseController)
class PhaseControllerControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.phaseControllerList
            model.phaseControllerCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.phaseController!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def phaseController = new PhaseController()
            phaseController.validate()
            controller.save(phaseController)

        then:"The create view is rendered again with the correct model"
            model.phaseController!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            phaseController = new PhaseController(params)

            controller.save(phaseController)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/phaseController/show/1'
            controller.flash.message != null
            PhaseController.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def phaseController = new PhaseController(params)
            controller.show(phaseController)

        then:"A model is populated containing the domain instance"
            model.phaseController == phaseController
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def phaseController = new PhaseController(params)
            controller.edit(phaseController)

        then:"A model is populated containing the domain instance"
            model.phaseController == phaseController
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/phaseController/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def phaseController = new PhaseController()
            phaseController.validate()
            controller.update(phaseController)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.phaseController == phaseController

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            phaseController = new PhaseController(params).save(flush: true)
            controller.update(phaseController)

        then:"A redirect is issued to the show action"
            phaseController != null
            response.redirectedUrl == "/phaseController/show/$phaseController.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/phaseController/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def phaseController = new PhaseController(params).save(flush: true)

        then:"It exists"
            PhaseController.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(phaseController)

        then:"The instance is deleted"
            PhaseController.count() == 0
            response.redirectedUrl == '/phaseController/index'
            flash.message != null
    }
}