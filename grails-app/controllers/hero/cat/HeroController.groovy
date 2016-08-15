package hero.cat

class HeroController {
    def marvelApiService

    def proxy() {
        String path = request.forwardURI.substring("/${controllerName}/".length())
        String query = request.queryString;
        def response = marvelApiService.call(path, query)
        render status: response.status, text: response.json, contentType: "application/json"
    }

    def handleHeroCatException(HeroCatException e) {
        def response = e.restResponse;
        render status: response.status, text: response.json, contentType: "application/json"
    }
}
