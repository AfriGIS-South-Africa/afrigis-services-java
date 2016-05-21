/**
 * <p>
 * These classes manage all calls to Reverse Geocoding AfriGIS services.
 * </p>
 * 
 *
 * Sample Use:
 * <pre>
 *      import com.afrigis.services.AfriGISServices;
 *      import com.afrigis.services.ServiceCallFactory;
 *      import com.afrigis.services.reversegeocoding.ReverseGeocodeRequest;
 *      import com.afrigis.services.reversegeocoding.ReverseGeocodeResponse;
 *      import com.afrigis.services.reversegeocoding.AddressResult;
 *      
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
 * 
 * 
 * <p>
 * Once a response is received, it will either contain error data or result
 * data. Check whether the response is an error before attempting to extract
 * results from it.
 * </p>
 * 
 * 
 * @author Sydney
 * @author hendrikc
 *
 */

package com.afrigis.services.reversegeocoding;
