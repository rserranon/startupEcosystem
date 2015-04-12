package startupecosystem



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PhaseControllerController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PhaseController.list(params), model:[phaseControllerCount: PhaseController.count()]
    }

    def show(PhaseController phaseController) {
        respond phaseController
    }

    def create() {
        respond new PhaseController(params)
    }

    @Transactional
    def save(PhaseController phaseController) {
        if (phaseController == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (phaseController.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond phaseController.errors, view:'create'
            return
        }

        phaseController.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'phaseController.label', default: 'PhaseController'), phaseController.id])
                redirect phaseController
            }
            '*' { respond phaseController, [status: CREATED] }
        }
    }

    def edit(PhaseController phaseController) {
        respond phaseController
    }

    @Transactional
    def update(PhaseController phaseController) {
        if (phaseController == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (phaseController.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond phaseController.errors, view:'edit'
            return
        }

        phaseController.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'phaseController.label', default: 'PhaseController'), phaseController.id])
                redirect phaseController
            }
            '*'{ respond phaseController, [status: OK] }
        }
    }

    @Transactional
    def delete(PhaseController phaseController) {

        if (phaseController == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        phaseController.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'phaseController.label', default: 'PhaseController'), phaseController.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'phaseController.label', default: 'PhaseController'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}