package startupecosystem

import grails.test.mixin.*
import spock.lang.*

@TestFor(TaxonomyController)
@Mock(Taxonomy)
class TaxonomyControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.taxonomyList
            model.taxonomyCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.taxonomy!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def taxonomy = new Taxonomy()
            taxonomy.validate()
            controller.save(taxonomy)

        then:"The create view is rendered again with the correct model"
            model.taxonomy!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            taxonomy = new Taxonomy(params)

            controller.save(taxonomy)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/taxonomy/show/1'
            controller.flash.message != null
            Taxonomy.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def taxonomy = new Taxonomy(params)
            controller.show(taxonomy)

        then:"A model is populated containing the domain instance"
            model.taxonomy == taxonomy
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def taxonomy = new Taxonomy(params)
            controller.edit(taxonomy)

        then:"A model is populated containing the domain instance"
            model.taxonomy == taxonomy
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/taxonomy/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def taxonomy = new Taxonomy()
            taxonomy.validate()
            controller.update(taxonomy)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.taxonomy == taxonomy

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            taxonomy = new Taxonomy(params).save(flush: true)
            controller.update(taxonomy)

        then:"A redirect is issued to the show action"
            taxonomy != null
            response.redirectedUrl == "/taxonomy/show/$taxonomy.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/taxonomy/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def taxonomy = new Taxonomy(params).save(flush: true)

        then:"It exists"
            Taxonomy.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(taxonomy)

        then:"The instance is deleted"
            Taxonomy.count() == 0
            response.redirectedUrl == '/taxonomy/index'
            flash.message != null
    }
}
