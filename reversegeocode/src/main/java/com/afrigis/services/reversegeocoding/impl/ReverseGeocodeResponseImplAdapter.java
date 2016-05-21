package com.afrigis.services.reversegeocoding.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.internal.saas.api2.impl.ParsedErrorData;
import com.afrigis.services.internal.saas.api2.reverseGeocoding.parsedObjects.ReverseGeocodeResult;
import com.afrigis.services.internal.saas.api2.reverseGeocoding.response.ReverseGeocodeResponseSaaSImpl;
import com.afrigis.services.reversegeocoding.AddressResult;
import com.afrigis.services.reversegeocoding.ReverseGeocodeResponse;

/**
 * Adapter class to make legacy code digestable for the new regime.
 * 
 * @author hendrikc
 * @see ReverseGeocodeResponse
 * @see AddressResult
 *
 */
public class ReverseGeocodeResponseImplAdapter extends AbstractResponse
        implements ReverseGeocodeResponse {
    private ReverseGeocodeResponseSaaSImpl source;

    private final List<AddressResult> addressResults;

    /**
     * Intended for the case where we are not in control of instantiation.
     */
    public ReverseGeocodeResponseImplAdapter() {
        source = new ReverseGeocodeResponseSaaSImpl();
        addressResults = new ArrayList<>();
    }

    /**
     * Intended for the case when we can a
     * {@link ReverseGeocodeResponseSaaSImpl} in hand.
     * 
     * @param sauce
     *            the source {@link com.afrigis.services.Response} object
     */
    public ReverseGeocodeResponseImplAdapter(
            ReverseGeocodeResponseSaaSImpl sauce) {
        source = sauce;
        addressResults = new ArrayList<>();
    }

    @Override
    public List<AddressResult> listResults() {
        if (addressResults.isEmpty()) {
            final Collection<ReverseGeocodeResult> resultResults =
                    source.results();
            for (ReverseGeocodeResult reverseGeocodeResult : resultResults) {
                addressResults
                        .add(new AddressResultAdapter(reverseGeocodeResult));
            }
        }

        final ArrayList<AddressResult> ret = new ArrayList<>();
        ret.addAll(addressResults);
        return ret;

    }

    @Override
    public void setTimesCalled(int timesCalled) {
        if (source != null) {
            source.setTimesCalled(timesCalled);
        }
    }

    @Override
    public int getTimesCalled() {
        return source != null ? source.getTimesCalled() : 0;
    }

    @Override
    public ParsedErrorData getError() {
        return source != null ? source.getError() : null;

    }

    @Override
    public void setError(ParsedErrorData error) {
        if (source != null) {
            source.setError(error);
        }

    }

    @Override
    public void consume(InputStream fin, int httpStatusCode) {
        super.consume(fin, httpStatusCode);
        source = new ReverseGeocodeResponseSaaSImpl();
        source.consume(new ByteArrayInputStream(getByteArrayInternal()),
                httpStatusCode);
    }

    @Override
    public boolean isError() {
        return source != null ? source.isError() : false;
    }

    @Override
    public String getErrorMessage() {
        return source != null ? source.getErrorMessage() : "";
    }

    @Override
    public int getHttpStatusCode() {
        return source != null ? source.getHttpStatusCode() : 0;
    }

    @Override
    protected void completeBuild(byte[] input) {
        source.completeBuild();

    }

    @Override
    public Integer getCount() {
        return source.getCount();
    }

    @Override
    public Integer getQtime() {
        return source.getQtime();
    }

    @Override
    public String getResponseMessage() {
        return source.getResponseMessage();
    }

    @Override
    public Integer getResponseCode() {
        return source.getResponseCode();
    }

}
