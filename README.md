The application is using Grails 3.1.X for the backend and Angular 1.5.X for the front end.

Building And Running

Update grails-app/conf/application.yml with Marvel API Keys

marvel:
    domain: gateway.marvel.com
    #Replace with values from http://developer.marvel.com/documentation/authorization
    publicKey: publicKey
    privateKey: privateKey

./gradlew bootRun to run the Application

Navigate to http://localhost:8080

The server application basically is just a proxy for the Marvel API.  It will cache results from previous API calls and
return results from the cache for repeated calls.  The Marvel API is somewhat slow until you filter with three or so
characters so initially it can be a bit slow.  I might think about eagerly fetching some of the results in order to
speed up initial responses if I took this further.

I didn't bother with doing any serializing of the requests on the back end.  I just proxy exactly what Marvel returns.
As a result all the links that between resources that Marvel responds with show up in the responses.  If I were to take
this project further I would likely map the Marvel responses to my own JSON structure and fix the links.


