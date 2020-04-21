# Test application with implementation basic security. 

### Start application
Use maven command for start:
        
    mvn clean install

application will start on standard port: localhost:8080

endpoints: 
 - "/login" - redirect all not authenticated users to this endpoint.
 - "/registration"
 - "/" or "/welcome"
 
 ### Registration.
 Validation of username and password by length. It mustn't be less than 4 symbols and more than 32 symbols.
 
 