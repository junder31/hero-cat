package hero.cat

import grails.plugins.rest.client.RestBuilder
import grails.transaction.Transactional

@Transactional
class MarvelApiService {
    final RestBuilder rest = new RestBuilder()

    def serviceMethod() {

    }
}
