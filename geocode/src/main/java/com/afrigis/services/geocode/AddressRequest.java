package com.afrigis.services.geocode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Request;
import com.afrigis.services.Response;
import com.afrigis.services.geocode.impl.GeocodeResponseImpl;
import com.afrigis.services.internal.saas.api2.intiendoLS.params.SearchParams;

/**
 * <p>
 * Class that contains the optional parameters for
 * a Geocode service call on a {@link com.afrigis.services.ServiceCallFactory} instance.
 * </p>
 * 
 * @author hendrikc
 *
 */
public class AddressRequest extends SearchParams
        implements Request {
    
    private Collection<KeyValue> addressRequestParameters;
    
    private boolean parametersFinalized;

    /**
     * Null constructor.
     */
    protected AddressRequest() {
        super();
        addressRequestParameters = new ArrayList<>();
        parametersFinalized = false;
    }

    // See
    // http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
    private volatile Set<GeocodeGroupOption> geocodeGroupOptions;

    /**
     * <p>
     * Constructor.
     * </p>
     * @param searchText the string you wish to search (geocode) for
     */
    public AddressRequest(String searchText) {
        this();
        setSearchText(searchText);
    }

    private Collection<GeocodeGroupOption> getGeocodeGroups() {
        // See
        // http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
        if (geocodeGroupOptions == null) {

            synchronized (GeocodeGroupOption.class) {
                if (geocodeGroupOptions == null) {
                    geocodeGroupOptions = new HashSet<GeocodeGroupOption>();
                }
            }
        }

        return geocodeGroupOptions;
    }

    
    /**
     * Adds a group to the request. Please see the <a href="https://developers.afrigis.co.za/portfolio/search/">documentation</a> for details.
     * @param group the {@link GeocodeGroupOption group option} to add to the request
     */
    public void addGroup(GeocodeGroupOption group) {
        getGeocodeGroups().add(group);

    }


    /**
     * Retrieves a copy of the current set of group options. 
     * @return a copy of the current set of group options
     */
    public Collection<GeocodeGroupOption> getGroups() {
        // This prevents dodgy calling code from messing with our internals
        return new ArrayList<GeocodeGroupOption>(getGeocodeGroups());
    }

    /**
     * 
     * @return true if the {@link GeocodeGroupOption#metadata} option has been requested
     */
    protected boolean getMetadataGroup() {
        return getGeocodeGroups().contains(GeocodeGroupOption.metadata);
    }

    /**
     * 
     * @return true if the {@link GeocodeGroupOption#addressComponent} option has been requested
     */
    protected boolean getAddressComponentGroup() {
        return getGeocodeGroups().contains(GeocodeGroupOption.addressComponent);
    }

    /**
     * 
     * @return true if the {@link GeocodeGroupOption#geometry} option has been requested
     */
    protected boolean getGeometryGroup() {
        return getGeocodeGroups().contains(GeocodeGroupOption.geometry);
    }

    /**
     * 
     * @param searchTerm the text term to search for
     * @return a {@link Request} implementation suitable for geocoding
     */
    public static Request build(String searchTerm) {        
        return new AddressRequest(searchTerm);
    }

    @Override
    public Class<? extends Response> getResponseType() {
        return GeocodeResponseImpl.class;
    }

   

    @Override
    protected void completeRequestParamList(Collection<KeyValue> input) {
        if (parametersFinalized) {
            return;
        }
        super.completeRequestParamList(input);
        if (getMetadataGroup()) {
            addKeyValParam(ILS_GROUPS, "metadata", input);

        }
        if (getGeometryGroup()) {
            addKeyValParam(ILS_GROUPS, "geometry", input);
        }
        if (getAddressComponentGroup()) {
            addKeyValParam (ILS_GROUPS, "address_component", input);
        }
        
        parametersFinalized = true;
        
        log().trace("In addressRequest complete we got {}", input);
    }

    @Override
    protected Collection<KeyValue> getParametersInternal() {
        return addressRequestParameters;
    }
    
    

}
