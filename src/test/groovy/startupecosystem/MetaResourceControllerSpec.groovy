package startupecosystem



import grails.test.mixin.*
import spock.lang.*

@TestFor(MetaResourceController)
@Mock(MetaResource)
class MetaResourceControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.metaResourceList
            model.metaResourceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.metaResource!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def metaResource = new MetaResource()
            metaResource.validate()
            controller.save(metaResource)

        then:"The create view is rendered again with the correct model"
            model.metaResource!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            metaResource = new MetaResource(params)

            controller.save(metaResource)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/metaResource/show/1'
            controller.flash.message != null
            MetaResource.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def metaResource = new MetaResource(params)
            controller.show(metaResource)

        then:"A model is populated containing the domain instance"
            model.metaResource == metaResource
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def metaResource = new MetaResource(params)
            controller.edit(metaResource)

        then:"A model is populated containing the domain instance"
            model.metaResource == metaResource
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/metaResource/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def metaResource = new MetaResource()
            metaResource.validate()
            controller.update(metaResource)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.metaResource == metaResource

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            metaResource = new MetaResource(params).save(flush: true)
            controller.update(metaResource)

        then:"A redirect is issued to the show action"
            metaResource != null
            response.redirectedUrl == "/metaResource/show/$metaResource.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/metaResource/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def metaResource = new MetaResource(params).save(flush: true)

        then:"It exists"
            MetaResource.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(metaResource)

        then:"The instance is deleted"
            MetaResource.count() == 0
            response.redirectedUrl == '/metaResource/index'
            flash.message != null
    }
}