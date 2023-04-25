package grails_bihar_22_23

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured

@Secured('isFullyAuthenticated()')
class ApiController {

    // User Singleton
    // Disponible sur l'url /api/user/id
    // Gestion de GET, PUT, PATCH, DELETE
    def user() {
        switch (request.getMethod()) {
            case "GET":
                if (!params.id)
                    return response.status = 400
                def userInstance = User.get(params.id)
                if (!userInstance)
                    return response.status = 404
                renderThis(userInstance, request.getHeader('Accept'))
                break
            case "PUT":
                if (!params.id)
                    return response.status = 400
                def userInstance = User.get(params.id)
                if (!userInstance)
                    return response.status = 404
                // Update user instance with new data from request body
                def data = request.JSON
                userInstance.properties = data
                if (userInstance.save()) {
                    renderThis(userInstance, request.getHeader('Accept'))
                } else {
                    return response.status = 500
                }
                break
            case "PATCH":
                if (!params.id)
                    return response.status = 400
                def userInstance = User.get(params.id)
                if (!userInstance)
                    return response.status = 404
                // Update user instance with new data from request body
                def data = request.JSON
                userInstance.properties = data
                if (userInstance.save()) {
                    renderThis(userInstance, request.getHeader('Accept'))
                } else {
                    return response.status = 500
                }
                break
            case "DELETE":
                if (!params.id)
                    return response.status = 400
                def userInstance = User.get(params.id)
                if (!userInstance)
                    return response.status = 404
                // Delete user instance
                if (userInstance.delete()) {
                    return response.status = 200
                } else {
                    return response.status = 500
                }
                break
            default:
                break
        }
    }
    // User Collection
    // Gestion de GET, POST
    def users() {
        switch (request.getMethod()) {
            case "GET":
                def users = User.list()
                renderThis(users, request.getHeader('Accept'))
                break
            case "POST":
                // Create new user instance with data from request body
                def data = request.JSON
                def userInstance = new User(data)
                if (userInstance.save()) {
                    renderThis(userInstance, request.getHeader('Accept'))
                } else {
                    return response.status = 500
                }
                break
            default:
                break
        }
    }
    // Annonce Singleton
    def annonce() {
        switch (request.getMethod()) {
            case "GET":
                if (!params.id)
                    return response.status = 400
                def annonceInstance = Annonce.get(params.id)
                if (!annonceInstance)
                    return response.status = 404
                renderThis(annonceInstance, request.getHeader('Accept'))
                break
            case "PUT":
                if (!params.id)
                    return response.status = 400
                def annonceInstance = Annonce.get(params.id)
                if (!annonceInstance)
                    return response.status = 404
                // Update annonce instance with new data from request body
                def data = request.JSON
                annonceInstance.properties = data
                if (annonceInstance.save()) {
                    renderThis(annonceInstance, request.getHeader('Accept'))
                } else {
                    return response.status = 500
                }
                break
            case "PATCH":
                if (!params.id)
                    return response.status = 400
                def annonceInstance = Annonce.get(params.id)
                if (!annonceInstance)
                    return response.status = 404
                // Update annonce instance with new data from request body
                def data = request.JSON
                annonceInstance.properties = data
                if (annonceInstance.save()) {
                    renderThis(annonceInstance, request.getHeader('Accept'))
                } else {
                    return response.status = 500
                }
                break
            case "DELETE":
                if (!params.id)
                    return response.status = 400
                def annonceInstance = Annonce.get(params.id)
                if (!annonceInstance)
                    return response.status = 404
                // Delete annonce instance
                if (annonceInstance.delete()) {
                    return response.status = 200
                } else {
                    return response.status = 500
                }
                break
            default:
                break
        }
    }

    def annonces() {
        switch (request.getMethod()) {
            case "GET":
                def annonces = Annonce.list()
                renderThis(annonces, request.getHeader('Accept'))
                break
            case "POST":
                // Create new annonce instance with data from request body
                def data = request.JSON
                def annonceInstance = new Annonce(data)
                if (annonceInstance.save()) {
                    renderThis(annonceInstance, request.getHeader('Accept'))
                } else {
                    return response.status = 500
                }
                break
            default:
                break
        }
    }

    def renderThis(Object object, String accept) {
        switch (accept) {
            case "application/xml":
            case "text/xml":
            case "xml":
                render object as XML
                break
            case "application/json":
            case "text/json":
            case "json":
            default:
                render object as JSON
                break
        }
    }

}