package startupecosystem

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MetaResourceController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond MetaResource.list(params), model:[metaResourceCount: MetaResource.count()]
    }

    def show(MetaResource metaResource) {
        respond metaResource
    }

    def create() {
        respond new MetaResource(params)
    }

    @Transactional
    def save(MetaResource metaResource) {
        if (metaResource == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (metaResource.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond metaResource.errors, view:'create'
            return
        }

        metaResource.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'metaResource.label', default: 'MetaResource'), metaResource.id])
                redirect metaResource
            }
            '*' { respond metaResource, [status: CREATED] }
        }
    }

    def edit(MetaResource metaResource) {
        respond metaResource
    }

    @Transactional
    def update(MetaResource metaResource) {
        if (metaResource == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (metaResource.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond metaResource.errors, view:'edit'
            return
        }

        metaResource.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'metaResource.label', default: 'MetaResource'), metaResource.id])
                redirect metaResource
            }
            '*'{ respond metaResource, [status: OK] }
        }
    }

    @Transactional
    def delete(MetaResource metaResource) {

        if (metaResource == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        metaResource.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'metaResource.label', default: 'MetaResource'), metaResource.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'metaResource.label', default: 'MetaResource'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
