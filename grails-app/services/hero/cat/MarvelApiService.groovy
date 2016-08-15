package hero.cat

import grails.plugin.cache.Cacheable
import grails.plugins.rest.client.RestBuilder
import grails.plugins.rest.client.RestResponse
import grails.transaction.Transactional
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus

@Transactional
class MarvelApiService {
    final RestBuilder rest = new RestBuilder()

    @Value('${marvel.domain}')
    private String domain;
    @Value('${marvel.publicKey}')
    private String publicKey;
    @Value('${marvel.privateKey}')
    private String privateKey;

    @Cacheable("marvelApiResponseCache")
    RestResponse call(String path, String query) {
        URL url = constructUrl(path, query)

        log.info("Calling Marvel API with url: ${url}")
        RestResponse response = rest.get("${url}")

        if (response.status != HttpStatus.OK.value()) {
            throw new HeroCatException(response)
        } else {
            return response
        }
    }

    private URL constructUrl(String path, String query) {
        long ts = System.currentTimeMillis()
        String hash = "${ts}${privateKey}${publicKey}".encodeAsMD5()
        String auth = "ts=${ts}&apikey=${publicKey}&hash=${hash}"

        query = query ? "${query}&${auth}" : auth

        return new URL("http://${domain}/${path}?${query}")
    }
}
