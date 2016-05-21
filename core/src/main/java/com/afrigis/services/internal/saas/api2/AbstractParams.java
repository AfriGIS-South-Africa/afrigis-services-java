package com.afrigis.services.internal.saas.api2;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.KeyValue;
import com.afrigis.services.Request;
import com.afrigis.services.impl.AbstractRequest;

/**
 * <p>
 * High level definition of request parameters.
 * </p>
 * 
 * @author hendrikc
 * @see AbstractRequest
 * @see Request
 *
 */
public abstract class AbstractParams extends AbstractRequest
        implements Request {

    /**
     * Please see the
     * <a href="https://developers.afrigis.co.za/portfolio/search/#geov2">the
     * documentation</a>.
     */
    protected static final String ILS_GROUPS = "ils_groups";
    private static final String OUTPUT = "output";
    /**
     * Please see the
     * <a href="https://developers.afrigis.co.za/portfolio/search/#geov2">the
     * documentation</a>.
     */
    protected static final String CALLBACK = "callback";
    /**
     * Please see the
     * <a href="https://developers.afrigis.co.za/portfolio/search/#geov2">the
     * documentation</a>.
     */
    protected static final String INDENT = "indent";

    private String output;

    /**
     * 
     * @return Output format to return
     */
    public String getOutput() {
        return output;
    }

    /**
     * Specify the output type for response.
     * 
     * @param theOutput
     *            (Optional) Output format to return e.g. JSON or XML
     */
    public void setOutput(String theOutput) {
        this.output = theOutput;
    }

    @Override
    public Collection<KeyValue> getRequestParameters() {
        final Collection<KeyValue> params = getParametersInternal();
        completeRequestParamList(params);

        setOptionals(this, params);

        return params;
    }

    private void setOptionals(final AbstractParams params,
            Collection<KeyValue> parameterMap) {

        if (params.getIndent()) {
            parameterMap.add(new KeyValue(INDENT, getIndent().toString()));
        }

        if (params.getOutput() != null) {
            parameterMap.add(new KeyValue(OUTPUT, params.getOutput()));
        }

        if (getCallBack() != null && getCallBack().trim().length() > 0) {
            parameterMap.add(new KeyValue(CALLBACK, getCallBack()));
        }
    }

    /**
     * <p>
     * Adds a request parameter key-value pair.
     * </p>
     * <p>
     * <code>null</code> key or values will be silently ignored.
     * </p>
     * 
     * @param key
     *            the key (name) of the parameter (unencoded)
     * @param val
     *            the value (unencoded) of the parameter
     * @param collection
     *            the {@link Collection} to add it to.
     */
    protected void addKeyValParam(String key, String val,
            Collection<KeyValue> collection) {
        final boolean valueCheckOk =
                val != null && val.trim().length() > 0 && !"null".equals(val);
        final boolean keyCheckOk =
                key != null && key.trim().length() > 0 && !"null".equals(key);

        if (valueCheckOk && keyCheckOk) {
            collection.add(new KeyValue(key, val));
        } else {
            log().trace("NULL key({})/value({}) found, not allowed.", key, val);
        }
    }

    @Override
    protected Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

}
