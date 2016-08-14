package hero.cat

import grails.plugins.rest.client.RestResponse

/**
 * Created by johnunderwood on 8/14/16.
 */
class HeroCatException extends RuntimeException {
    private RestResponse restResponse

    public HeroCatException(RestResponse restResponse) {
        super(restResponse.json.message)
        this.restResponse = restResponse
    }
}
