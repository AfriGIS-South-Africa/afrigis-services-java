package com.afrigis.services.reversegeocoding;

import com.afrigis.services.Coordinate;
import com.afrigis.services.Request;
import com.afrigis.services.Response;
import com.afrigis.services.internal.saas.api2.reverseGeocoding.params.ReverseGeocodeParams;
import com.afrigis.services.reversegeocoding.impl.ReverseGeocodeResponseImplAdapter;

/**
 * Interface for objects that wish to supply the
 * reverse geocoding service calls with more parameters.
 * 
 * @author hendrikc
 * 
 *
 */
public class ReverseGeocodeRequest extends ReverseGeocodeParams
        implements  Request {

    /**
     * <p>
     * Constructor.
     * </p>
     * @param latitude
     *            the decimal latitude
     * @param longitude
     *            the decimal longitude
     */
    public ReverseGeocodeRequest(Double latitude, Double longitude) {
        super();
        setLatitude(latitude);
        setLongitude(longitude);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * @param coordinate the {@link Coordinate}'s to use.
     */
    public ReverseGeocodeRequest(Coordinate coordinate) {
        setLatitude(coordinate.getLatitude());
        setLongitude(coordinate.getLongitude());
    }

    @Override
    public final Class<? extends Response> getResponseType() {
        return ReverseGeocodeResponseImplAdapter.class;
    }

}
