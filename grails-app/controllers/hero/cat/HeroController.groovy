package hero.cat


import grails.rest.*
import grails.converters.*

class HeroController {
    def marvelApiService

    def proxy() {
        String location = request.forwardURI.substring("/${controllerName}/".length())

        def response =  marvelApiService.call(location)
        render status: response.status, text: response.json, contentType: "application/json"
    }

    def handleHeroCatException(HeroCatException e) {
        def response = e.restResponse;
        render status: response.status, text: response.json, contentType: "application/json"
    }
}
