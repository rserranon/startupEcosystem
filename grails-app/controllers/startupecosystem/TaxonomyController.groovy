package startupecosystem



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class TaxonomyController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Taxonomy.list(params), model:[taxonomyCount: Taxonomy.count()]
    }

    def show(Taxonomy taxonomy) {
        respond taxonomy
    }

    def create() {
        respond new Taxonomy(params)
    }

    @Transactional
    def save(Taxonomy taxonomy) {
        if (taxonomy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (taxonomy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond taxonomy.errors, view:'create'
            return
        }

        taxonomy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'taxonomy.label', default: 'Taxonomy'), taxonomy.id])
                redirect taxonomy
            }
            '*' { respond taxonomy, [status: CREATED] }
        }
    }

    def edit(Taxonomy taxonomy) {
        respond taxonomy
    }

    @Transactional
    def update(Taxonomy taxonomy) {
        if (taxonomy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (taxonomy.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond taxonomy.errors, view:'edit'
            return
        }

        taxonomy.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'taxonomy.label', default: 'Taxonomy'), taxonomy.id])
                redirect taxonomy
            }
            '*'{ respond taxonomy, [status: OK] }
        }
    }

    @Transactional
    def delete(Taxonomy taxonomy) {

        if (taxonomy == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        taxonomy.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'taxonomy.label', default: 'Taxonomy'), taxonomy.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'taxonomy.label', default: 'Taxonomy'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}