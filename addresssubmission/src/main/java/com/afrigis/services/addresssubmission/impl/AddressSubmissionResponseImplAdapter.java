package com.afrigis.services.addresssubmission.impl;

import com.afrigis.services.addresssubmission.AddressSubmissionResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.afrigis.services.impl.AbstractResponse;

import com.afrigis.services.internal.saas.api2.impl.ParsedErrorData;
import com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.paresdObjects.SubmissionResult;
import com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.response.AddressSubmissionResponseSaasImpl;
import com.afrigis.services.addresssubmission.AddressSubmissionResult;

/**
 *
 * @author Pieterv
 */
public class AddressSubmissionResponseImplAdapter extends AbstractResponse
        implements AddressSubmissionResponse {

    private AddressSubmissionResponseSaasImpl source;

    private final List<AddressSubmissionResult> addressSubmissionResults;

    
    public AddressSubmissionResponseImplAdapter() {
        source = new AddressSubmissionResponseSaasImpl();
        addressSubmissionResults = new ArrayList<>();
    }

   /**
    * 
    * @param src 
    */
    public AddressSubmissionResponseImplAdapter(
            AddressSubmissionResponseSaasImpl src) {
        source = src;
        addressSubmissionResults = new ArrayList<>();
    }
/**
 * 
 * @return 
 */
    @Override
    public List<AddressSubmissionResult> listResults() {
        if (addressSubmissionResults.isEmpty()) {
            final Collection<SubmissionResult> resultResults
                    = source.results();
            for (SubmissionResult addressSubmissionResult : resultResults) {
                addressSubmissionResults
                        .add(new AddressSubmissionResultAdapter(addressSubmissionResult));
            }
        }

        final ArrayList<AddressSubmissionResult> ret = new ArrayList<>();
        ret.addAll(addressSubmissionResults);
        return ret;

    }

    
    /**
     * Set Times called
     * @param timesCalled 
     */
    @Override
    public void setTimesCalled(int timesCalled) {
        if (source != null) {
            source.setTimesCalled(timesCalled);
        }
    }
    /**
     * 
     * @return Time called
     */
    @Override
    public int getTimesCalled() {
        return source != null ? source.getTimesCalled() : 0;
    }
    /**
     * 
     * @return Error
     */
    @Override
    public ParsedErrorData getError() {
        return source != null ? source.getError() : null;

    }
    /**
     * Set Error
     * @param error 
     */
    @Override
    public void setError(ParsedErrorData error) {
        if (source != null) {
            source.setError(error);
        }

    }
    /**
     * 
     * @param fin 
     * @param httpStatusCode 
     */
    @Override
    public void consume(InputStream fin, int httpStatusCode) {
        super.consume(fin, httpStatusCode);
        source = new AddressSubmissionResponseSaasImpl();
        source.consume(new ByteArrayInputStream(getByteArrayInternal()),
                httpStatusCode);
    }
    /**
     * 
     * @return If error occurred.
     */
    @Override
    public boolean isError() {
        return source != null ? source.isError() : false;
    }
    /**
     * 
     * @return Error message
     */
    @Override
    public String getErrorMessage() {
        return source != null ? source.getErrorMessage() : "";
    }
    /**
     * 
     * @return HTTP status code
     */
    @Override
    public int getHttpStatusCode() {
        return source != null ? source.getHttpStatusCode() : 0;
    }
    /**
     * 
     * @param input 
     */
    @Override
    protected void completeBuild(byte[] input) {
        source.completeBuild();

    }
    /**
     * 
     * @return Response message
     */
    @Override
    public String getResponseMessage() {
        return source != null ? source.getResponseMessage() : "";
    }
    /**
     * 
     * @return Source 
     */
    @Override
    public String getSource() {
        return source != null ? source.getSource() : "";
    }
    /**
     * 
     * @return Response code
     */
    @Override
    public Integer getResponseCode() {
        return (Integer) (source != null ? source.getResponseCode() : "");
    }

}
