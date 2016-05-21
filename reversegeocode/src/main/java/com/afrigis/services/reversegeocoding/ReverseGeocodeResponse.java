package com.afrigis.services.reversegeocoding;

import com.afrigis.services.Response;

/**
 * <p>
 * Interface for object that encapsulate the responses received from the service
 * for reverseGeocoding calls.
 * </p>
 * Sample use:
 * <pre>
 *      ServiceCallFactory serviceFactory = AfriGISServices.instance("SomeKey", "SomeSeret");
 *               
 *      ReverseGeocodeRequest params = new ReverseGeocodeRequest(new Coordinate(-26.099082946777344d, 28.063194d));
 *      params.setLayer(Layer.STREETS.toString());
 *
 *      ReverseGeocodeResponse response = serviceFactory.get(params);
 *      List &lt;AddressResult&gt; results = response.listResults();
 *      
 *      for (AddressResult reverseGeocodeAddress : results) {
 *          System.out.println(reverseGeocodeAddress.getDocId());
 *      }
 * </pre>
 * @author hendrikc
 * @see <a href="https://developers.afrigis.co.za/portfolio/reverse-geocoding/">https://developers.afrigis.co.za/portfolio/reverse-geocoding/</a>
 *
 */
public interface ReverseGeocodeResponse extends Response {
    
    /**
     * 
     * @return Number of results returned for position (Integer). Example: 2
     */
    Integer getCount();
    
    /**
     * 
     * @return Number of milliseconds the request took to execute on the server (Integer). Example: 59
     */
    Integer getQtime();
    
    /**
     * 
     * @return Descriptive message for the response code (String). Example: Invalid attribute
     */
    String getResponseMessage ();
    
    /**
     * 
     * @return  Integer result code. 0 = success, error codes
     */
    Integer getResponseCode ();

}
