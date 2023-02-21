# rest-client-exception-bug

This application demonstrates that a `WebApplicationException` thrown by the REST client is not
handled properly and results in the same status code being returned in the server response. The
behavior is reproduced in `GreetingResourceTest`: when `/hello` is hit, `GreetingResource` performs
a request using the REST client which gets a 400 back; at this point, the application returns a 
400 but I believe it should return a 500 (there was an error while processing the request; the
fact that the error happened because the application got a 400 while invoking an API is an
implementation detail)