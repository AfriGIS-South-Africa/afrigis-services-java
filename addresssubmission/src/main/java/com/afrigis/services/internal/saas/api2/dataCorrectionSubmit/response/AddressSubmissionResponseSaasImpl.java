package com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.response;

import java.util.List;
import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.afrigis.services.Response;
import com.afrigis.services.impl.AbstractResponse;
import com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.paresdObjects.SubmissionResult;
import com.afrigis.services.internal.saas.api2.dataCorrectionSubmit.paresdObjects.ParsedAddressSubmissionData;
import com.google.gson.Gson;
import java.util.ArrayList;

/**
 *
 * @author Pieterv
 */
public class AddressSubmissionResponseSaasImpl extends AbstractResponse
        implements Response {

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("AddressSubmissionResponseSaasImpl [httpStatusCode=");
        builder.append(getHttpStatusCode());
        builder.append(", errMesg=");
        builder.append(getErrorMessage());
        builder.append(", results=");
        builder.append(results);
        builder.append(", error=");
        builder.append(getError());
        builder.append("]");
        return builder.toString();
    }

    private ParsedAddressSubmissionData results;

    private ParsedAddressSubmissionData getResults() {
        return results;
    }

    protected Logger getLog() {
        return LoggerFactory.getLogger(getClass());
    }

    public List<SubmissionResult> results() {
        final SubmissionResult[] retResults = getResults().getResults();

        if (retResults == null) {
            return new ArrayList<>();
        }

        final List<SubmissionResult> tmp = new ArrayList<>(retResults.length);
        for (SubmissionResult reverseGeocodeAddress : retResults) {
            tmp.add(reverseGeocodeAddress);
        }

        return tmp;

    }

    @Override
    public List<SubmissionResult> listResults() {
        return results();
    }

    @Override
    public void completeBuild() {
        this.completeBuild(getByteArrayInternal());

    }

    @Override
    protected void completeBuild(byte[] input) {
        final Gson gson = new Gson();
        try {
            results = gson.fromJson(StringUtils.newStringUtf8(input),
                    ParsedAddressSubmissionData.class);
        } catch (Exception e) {
            getLog().debug("Error in fromJson {}", e);
        }

    }

    public Integer getResponseCode() {
        return results.getResponseCode();
    }

    public String getResponseMessage() {
        return results.getResponseMessage();
    }

    public String getSource() {
        return results.getSource();
    }

}
