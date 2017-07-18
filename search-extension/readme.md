# Introduction
Implements various AfriGIS Search Extension Services

[Census Report](https://developers.afrigis.co.za/portfolio/census/)  
[Postal Code Report](https://developers.afrigis.co.za/portfolio/afrigis-postal-codes-report/)  
[Suburb Risk Profile Report](https://developers.afrigis.co.za/portfolio/afrigis-risk/)

# Building
`mvn clean package`

# Use as dependency
```xml
<dependency>
	<groupId>com.afrigis.services</groupId>
	<artifactId>search-extension</artifactId>
	<version>3.0.1</version>
</dependency>
```
<div id="getCensusReportJavaAPI">  

# How do I get Census Report using Java API?  

You can get the [Census Report](https://developers.afrigis.co.za/portfolio/census/) using either know location SEOID or combination of latitude and longitude  

### using SEOID
```java
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.search.extension.census.Census;
import com.afrigis.services.search.extension.intiendoLS.api2.params.CensusParams;
import com.afrigis.services.search.extension.CensusGetType;
import com.afrigis.services.search.extension.CensusResponse;
import com.afrigis.services.search.extension.census.AgeDetails;
import com.afrigis.services.search.extension.census.WaterDetails;

public static void main(String [] args) {
	String key = "key";
	String secret = "secret";
	String email = "clientemail@example.com";
	String seoid = "Yze36F_iqn3043538";
	
	ServiceCallFactory serviceFactory = AfriGISServices.instance(key, secret);  
	CensusParams censusParams = new CensusParams(email, seoid, 
	CensusGetType.JSON);  
	CensusResponse response = serviceFactory.get(censusParams);
	
	Census census = response.getResult();
	
	// A breakdown of all persons in the subplace, based on their age group
	AgeDetails ageDetails = census.getAgeDetails();
	// A breakdown of the primary source of potable water per household
	WaterDetails waterDetails = census.getWaterDetails();
	
	System.out.println(ageDetails.getAge0to9());
	System.out.println(ageDetails.getAge70to90());
	
	System.out.println(waterDetails.getRiverStream());
	System.out.println(waterDetails.getServicedWater());
}
```

### using latitude and longitude  
The code is same as above, except use different constructor for CensusParams

```java
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.search.extension.census.Census;
import com.afrigis.services.search.extension.intiendoLS.api2.params.CensusParams;
import com.afrigis.services.search.extension.CensusGetType;
import com.afrigis.services.search.extension.CensusResponse;
import com.afrigis.services.search.extension.census.AgeDetails;
import com.afrigis.services.search.extension.census.WaterDetails;

String key = "key";
String secret = "secret";
String email = "clientemail@example.com";
String latitude = "-25.748627182067";
String longitude = "28.2350855";

ServiceCallFactory serviceFactory = AfriGISServices.instance(key, secret);  
CensusParams censusParams = new CensusParams(email, latitude, longitude, CensusGetType.JSON);  

CensusResponse response = serviceFactory.get(censusParams);
Census census = response.getResult();

...
```

The same can be achieved using java.util.concurrent.Future

```java
// Add imports as above
import java.util.concurrent.Future

String key = "key";
String secret = "secret";
String email = "clientemail@example.com";
String seoid = "Yze36F_iqn3043538";

CensusParams censusParams = new CensusParams(email, seoid, CensusGetType.JSON);
Future<CensusResponse> resultFuture = serviceFactory.getAsync(censusParams);

CensusResponse response = resultFuture.get();
Census census = response.getResult();
...

```
</div>
<div id="getCensusReportPdfFormat">

# How do I get Census Report in PDF format?

This can be done using SEIOD or combination of latitude and longitude.  

Simply change the last parameter of ```CensusParams``` from ```CensusGetType.JSON``` to ```CensusGetType.PDF```.  
Then use the ```getByteArray()``` method from CensusResponse which returns ```byte[]``` which can be used to save the PDF

```java
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.search.extension.census.Census;
import com.afrigis.services.search.extension.intiendoLS.api2.params.CensusParams;
import com.afrigis.services.search.extension.CensusGetType;
import com.afrigis.services.search.extension.CensusResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Future;

CensusParams censusParams = new CensusParams(email, seoid, CensusGetType.PDF);
Future<CensusResponse> resultFuture = serviceFactory.getAsync(censusParams);

CensusResponse response = resultFuture.get();

String fileName = "CensusReport.pdf";

// Using Java try-with-resources statement, ensuring that fos is closed after try block
try (FileOutputStream fos = new FileOutputStream(fileName)) {
	// Write byte[] result to file
	fos.write(response.getByteArray());
} catch (IOException ioException) {
	System.err.println(ioException.getMessage());
}
```

The same can be done using latitude and longitude


```CensusParams censusParams = new CensusParams(email, latitude, longitude, CensusGetType.PDF);```

</div>

# How do I get Postal Code Report?

All of the above code applies using SEOID or combination of latitude and longitude.

### using SEOID

```java 
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.search.extension.postalcode.PostalCode;
import com.afrigis.services.search.extension.intiendoLS.api2.params.PostalCodeParams;
import com.afrigis.services.search.extension.PostalCodeGetType;
import com.afrigis.services.search.extension.PostalCodeResponse;
import com.afrigis.services.search.extension.postalcode.CommercialActivities;

String key = "key";
String secret = "secret";
String email = "clientemail@example.com";
String seoid = "Yze36F_iqn3043538";

ServiceCallFactory serviceFactory = AfriGISServices.instance(key, secret);  
PostalCodeParams postalCodeParams = new PostalCodeParams(email, seoid, 
PostalCodeGetType.JSON);
PostalCodeResponse response = serviceFactory.get(postalCodeParams);

PostalCode postalCode = response.getResult();

// This summarises the commercial activities within the street code
CommercialActivities activities = postalCode.getCommercialActivities();

int fillingStationsCount = activities.getFillingStations();
System.out.println("Filling stations count: " + fillingStationsCount);

```

### using latitude and longitude

```java
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.search.extension.postalcode.PostalCode;
import com.afrigis.services.search.extension.intiendoLS.api2.params.PostalCodeParams;
import com.afrigis.services.search.extension.PostalCodeGetType;
import com.afrigis.services.search.extension.PostalCodeResponse;
import com.afrigis.services.search.extension.postalcode.CommercialActivities;

String key = "key";
String secret = "secret";
String email = "clientemail@example.com";
String latitude = "-25.748627182067";
String longitude = "28.2350855";

ServiceCallFactory serviceFactory = AfriGISServices.instance(key, secret);  
PostalCodeParams postalCodeParams = new PostalCodeParams(email, latitude, longitude, 
PostalCodeGetType.JSON);
PostalCodeResponse response = serviceFactory.get(postalCodeParams);

PostalCode postalCode = response.getResult();

// This summarises the commercial activities within the street code
CommercialActivities activities = postalCode.getCommercialActivities();

int fillingStationsCount = activities.getFillingStations();
System.out.println("Filling stations count: " + fillingStationsCount);
...
```


# How do I get Postal Code PDF Report?

Use same procedure as seen in section <b><big><a href="#getCensusReportPdfFormat">How to get Census Report in PDF format?</a></big></b>

In place of ```CensusGetType.PDF``` use ```com.afrigis.services.search.extension.PostalCodeGetType.PDF```  

In place of ```CensusResponse``` use ```com.afrigis.services.search.extension.PostalCodeResponse```

# How do I get Suburb Risk Profile Report?

Use the same procedure as used in <b><big><a href="#getCensusReportJavaAPI">How do I get Census Report using Java API?</a></big></b>  
For PDF report use same procedure as used in <b><big><a href="#getCensusReportPdfFormat">How to get Census Report in PDF format?</a></big></b>

sample code used for Suburb Risk Profile Report

```java
import com.afrigis.services.search.extension.SuburbRiskProfileResponse;
import com.afrigis.services.search.extension.SuburbRiskTotalResponse;
import com.afrigis.services.search.extension.intiendoLS.api2.params.SuburbRiskProfileParams;
import com.afrigis.services.search.extension.risk.SuburbRiskProfile;
import com.afrigis.services.search.extension.risk.Suburb;

String key = "key";
String secret = "secret";
String email = "clientemail@example.com";
String seoid = "Yze36F_iqn3043538";


ServiceCallFactory serviceFactory = AfriGISServices.instance(key, secret);

SuburbRiskProfileParams searchParams = new SuburbRiskProfileParams(email, seoid, RiskGetType.JSON);
SuburbRiskProfileResponse response = serviceFactory.get(searchParams);
SuburbRiskProfile result = response.getResult();

Suburb suburbStats = result.getSuburb();

int numberOfStands = suburbStats.getNumberOfStands();
int populationCount = suburbStats.getPopulationCount();

System.out.println("Number of stands: " + numberOfStands);
System.out.println("Population count: " + populationCount);

```