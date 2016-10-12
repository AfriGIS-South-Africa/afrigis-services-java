# Introduction

# Getting Started

Before you do anything with the AfriGIS Services, you will need to [sign up for an account.](https://developers.afrigis.co.za/sign-up/).

## Java

### Download
Binaries are distributed via [mvnrepository.com.](http://mvnrepository.com/search?q=com.afrigis)

### Building from source
This is a [Maven](https://maven.apache.org/what-is-maven.html) based project.

In order for the unit tests to pass, you will need to provide valid AfriGIS Services
credentials via your environment variables.
OR you can skip the tests. Both options demonstrated below.

#### Building with valid credentials:

`mvn -Dag.services.test.key=xxx -Dag.services.test.secret=yyy clean package` 

It is also possible to provide the credentials through your operating systems specific environment mechanisms.

#### Building by [skipping tests](http://maven.apache.org/surefire/maven-surefire-plugin/examples/skipping-test.html):

`mvn -Dmaven.test.skip=true -DskipTests clean package`

The compiled JAR files will be found under the relevant `target` folders.

### Quick start
The basic workflow goes like this:

- Obtain a `ServiceCallFactory` instance: `AfriGISServices.instance("Key","Secret");`
- Use the `ServiceCallFactory` instance to access AfriGIS Services - easy, no?

The factory and services instances are intended to be kept around for the duration of your application.
BUT, if you do not want do to that, you don't HAVE to, but performance will be better if you do.

More concrete example (Geocoding aka "Search"):

Add the dependency:
```xml
<dependency>
	<groupId>com.afrigis.services</groupId>
	<artifactId>geocode</artifactId>
	<version>2.0.0</version>
</dependency>
``` 

```java

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.geocode.AddressRequest;
import com.afrigis.services.geocode.AddressResponse;
import com.afrigis.services.geocode.GeocodeGroupOption;
import com.afrigis.services.geocode.LocationResult;

public static void main(String[] args) throws InterruptedException, ExecutionException {
        String key = "<your key here>";
        String secret = "<your secret here>";

       // Construct the services factory - keep this instance around!
       ServiceCallFactory factory = AfriGISServices.instance(key, secret);

       // Create a Geocode Address request with your searchText
       AddressRequest request = new AddressRequest("Hatfield, Pretoria");

       // Adding a group will enforce the service to add grouping to the result
       // array
       request.addGroup(GeocodeGroupOption.geometry);

       // Make a blocking asynchronous request to get a typed response
       Future<AddressResponse> resultsFuture = factory.getAsync(request);
       AddressResponse result = resultsFuture.get();

       // Display formatted address, latitude and longitude of the result array
       for (LocationResult address : result.listResults()) {
           System.out.printf("Formatted Address:\t%s\n", address.getFormattedAddress());
           System.out.printf("Latitude:\t\t%2.6f\n", address.getGeometry().getLocation().getLatitude());
           System.out.printf("Longitude:\t\t%2.6f\n\n", address.getGeometry().getLocation().getLongitude());
       }
       System.exit(0);
    }

```

# Advanced

## How do I Geocode (Search)?
First,add the Geocode module to your project dependencies:

```xml
<dependency>
	<groupId>com.afrigis.services</groupId>
	<artifactId>geocode</artifactId>
	<version>2.0.0</version>
</dependency>
```

### Simple
```java
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.geocode.AddressRequest;
import com.afrigis.services.geocode.AddressResponse;
import com.afrigis.services.geocode.GeocodeGroupOption;
import com.afrigis.services.geocode.LocationResult;
import com.afrigis.services.ConfidenceLevel;
import com.afrigis.services.geocode.Geometry;
import com.afrigis.services.Coordinate;
import com.afrigis.services.ConfidenceLevel;
import java.util.List;

ServiceCallFactory factory = AfriGISServices.instance("Key", "Secret");
AddressResponse addressResponse = factory.get( (AddressRequest.build("446 Rigel") ) );

List<LocationResult> addresses = addressResponse.listResults();

LocationResult firstMatch =  addresses.get(0);
Coordinate coordinate = firstMatch.getLocation();
String formattedAddress = firstMatch.getFormattedAddress();
ConfidenceLevel confLevel = firstMatch.getConfidence();
String seoid = firstMatch.getSeoId();
```

The same can be achieved asynchronously via the `java.util.concurrent.Future` API.

```java
//Add some extra imports
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//Use the getAsync call to obtain a Future promise object. This does NOT block
Future<AddressResponse> addressResponse = factory.getAsync(AddressRequest.build("446 Rigel"));

//Do some other stuff

//Now we really need the response, so request it, allowing 30 seconds 
//before timeout. This call DOES block.
AddressResponse realResponse = addressResponse.get(30, TimeUnit.SECONDS);

//Do stuff with your response object
```

### Complex
TODO

## How do I Reverse Geocode?
First,add the Reverse Geocode module to your project dependencies:

```xml
<dependency>
	<groupId>com.afrigis.services</groupId>
	<artifactId>reversegeocode</artifactId>
	<version>2.0.0</version>
</dependency>
```

### Simple
```java
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.Coordinate;
import com.afrigis.services.KeyValue;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.reversegeocoding.AddressResult;
import com.afrigis.services.reversegeocoding.Layer;
import com.afrigis.services.reversegeocoding.Level;
import com.afrigis.services.reversegeocoding.ReverseGeocodeRequest;
import com.afrigis.services.reversegeocoding.ReverseGeocodeResponse;

ServiceCallFactory serviceFactory = AfriGISServices.instance("Key","Secret");
ReverseGeocodeRequest reverseGeocodeRequest = new ReverseGeocodeRequest(-25.806426d,28.248292d);
ReverseGeocodeResponse reverseGeocodeResponse = factory.get(reverseGeocodeRequest);
        
List<AddressResult> addresses = reverseGeocodeResponse.listResults();
for (AddressResult address : addresses) {
    System.out.printf("DocID: %s", address.getDocId());
    System.out.printf("Description: %s\n", address.getDescription());
    System.out.printf("Latitude: %2.6f\n", address.getLocation().getLatitude());
    System.out.printf("Longitude: %2.6f\n\n", address.getLocation().getLongitude());            
            
}
```

### Complex
TODO

## How do I do use Auto complete ?
"Autocomplete" it self is not implemented here, since it is intended for Webclient.

What IS implemented here, is the "get token" part, that autocomplete functionality 
requires to function.

Add the dependency:

```xml
<dependency>
	<groupId>com.afrigis.services</groupId>
	<artifactId>core</artifactId>
	<version>2.0.0</version>
</dependency>
```

```java
import com.afrigis.services.token.TokenResponse;
import com.afrigis.services.token.impl.DefaultTokenParameters;
import com.afrigis.services.token.impl.DefaultTokenResponse;
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;

ServiceCallFactory factory = AfriGISServices.instance("Key","Secret");

TokenResponse response = factory.get(new DefaultTokenParameters());
System.out.println (response.getTheToken());
```

## How do I check my remaining credits?
Add the dependency:

```xml
<dependency>
	<groupId>com.afrigis.services</groupId>
	<artifactId>core</artifactId>
	<version>2.0.0</version>
</dependency>
```

```java
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;

ServiceCallFactory testFactory = AfriGISServices.instance("Key", "Secret");
Integer credits = testFactory.getCreditBalance();
System.out.println ("Remaining Credit balance is: " +credits);
```


