package startupecosystem

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProjectStageController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond ProjectStage.list(params), model:[projectStageCount: ProjectStage.count()]
    }

    def show(ProjectStage projectStage) {
        respond projectStage
    }

    def create() {
        respond new ProjectStage(params)
    }

    @Transactional
    def save(ProjectStage projectStage) {
        if (projectStage == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (projectStage.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond projectStage.errors, view:'create'
            return
        }

        projectStage.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'projectStage.label', default: 'ProjectStage'), projectStage.id])
                redirect projectStage
            }
            '*' { respond projectStage, [status: CREATED] }
        }
    }

    def edit(ProjectStage projectStage) {
        respond projectStage
    }

    @Transactional
    def update(ProjectStage projectStage) {
        if (projectStage == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (projectStage.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond projectStage.errors, view:'edit'
            return
        }

        projectStage.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'projectStage.label', default: 'ProjectStage'), projectStage.id])
                redirect projectStage
            }
            '*'{ respond projectStage, [status: OK] }
        }
    }

    @Transactional
    def delete(ProjectStage projectStage) {

        if (projectStage == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        projectStage.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'projectStage.label', default: 'ProjectStage'), projectStage.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'projectStage.label', default: 'ProjectStage'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
