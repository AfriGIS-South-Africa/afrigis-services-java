/**
 * <h1>
 * AfriGIS Services
 * </h1>
 * 
 * <h2>
 * Quick Start
 * </h2>
 * <h3>
 * Geocoding
 * </h3>
 * <pre>
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.geocode.GeocodeResponse;
import com.afrigis.services.Address;
import com.afrigis.services.impl.Coordinate;
import com.afrigis.services.ConfidenceLevel;



public class Example {
	public static void main (String [] args) {
	    ServiceCallFactory factory = AfriGISServices.instance("Key", "Secret");
        GeocodeResponse addressResponse = factory.get( (GeocodeParamatersImpl.build("446 Rigel") ) );

        List&lt;Address&gt; addresses = addressResponse.listResults();

        Address firstMatch =  addresses.get(0);
        Coordinate coordinate = address.getLocation();
        String formattedAddress = firstMatch.getAddress();
        ConfidenceLevel confLevel = address.getConfidence();
        String seoid = address.getSeoid();
	}
}

 * </pre>
 * <h3>
 * Reverse Geocoding
 * </h3>
 * <pre>
import com.afrigis.services.AfriGISServices;
import com.afrigis.services.ServiceCallFactory;
import com.afrigis.services.reversegeocoding.ReverseGeocodeParameters;
import com.afrigis.services.reversegeocoding.impl.ReverseGeocodeParametersImpl;
import com.afrigis.services.reversegeocoding.ReverseGeocodeAddress;

public class Example {
	public static void main (String [] args) {
		ServiceCallFactory serviceFactory = AfriGISServices.instance("Key","Secret");
        ReverseGeocodeParameters request = new ReverseGeocodeParametersImpl(-25.806426f,28.248292f);
        
        ReverseGeocodeResponse response = serviceFactory.get(request);


        for (ReverseGeocodeAddress address : response.listResults()) {
            //Do something with the results!!
        }
	}
}
 * </pre>
 * @author hendrikc
 *
 */
package com.afrigis.services;


