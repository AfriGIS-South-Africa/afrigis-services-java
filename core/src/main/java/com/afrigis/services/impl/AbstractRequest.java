package com.afrigis.services.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;

import com.afrigis.services.KeyValue;
import com.afrigis.services.LibMode;
import com.afrigis.services.Request;

/**
 * <p>
 * Abstract base implementation of {@link Request}.
 * </p>
 * <p>
 * Extenders of the library can consider extending this class to build support
 * for additional services.
 * </p>
 * 
 * @author hendrikc
 *
 */
public abstract class AbstractRequest implements Request {

    private LibMode libMode;
    
    private final Collection<KeyValue> parameters;

    private Boolean indent = Boolean.FALSE;

    private String callBack;

    /**
     * Constructor.
     */
    public AbstractRequest() {
        super();
        this.parameters = new ArrayList<>();
    }

    /**
     * Constructor.
     * 
     * @param parametersIn
     *            will copy this list to internal data structure.
     */
    public AbstractRequest(Collection<KeyValue> parametersIn) {
        super();
        this.parameters = new ArrayList<>(parametersIn);
    }

    @Override
    public Collection<KeyValue> getRequestParameters() {
        return parameters;
    }

    @Override
    public void setExtraParameters(Collection<KeyValue> input) {
        parameters.addAll(input);
    }

    @Override
    public String toQueryString() {
        final StringBuffer buf = new StringBuffer();
        for (KeyValue keyVal : getRequestParameters()) {
            if (buf.length() > 0) {
                buf.append("&");
            }
            final String encKey = urlEncode(keyVal.getKey());
            final String encVal = urlEncode(keyVal.getValue());
            buf.append(encKey).append("=").append(encVal);
        }
        return buf.toString();
    }

    /**
     * URL Encoding util method.
     * 
     * @param param
     *            the string to encode
     * @return encoded string.
     */
    private String urlEncode(String param) {
        try {
            return URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            log().warn("URL Encoding failed on '" + param + "'", e);
            return param;
        }
    }

    /**
     * Supplies {@link Logger} instance.
     * 
     * @return {@link Logger} instance.
     */
    protected Logger log() {
        return org.slf4j.LoggerFactory.getLogger(getClass());
    }

    @Override
    public LibMode getLibMode() {
        return libMode;
    }

    /**
     * <p>
     * This is not the method you are looking for.
     * </p>
     * 
     * @param libModeIn
     *            allows for overriding the reported libmode to the server
     */
    @Override
    public void setLibMode(LibMode libModeIn) {
        this.libMode = libModeIn;
    }

    /**
     * <p>
     * Gives a subclass a chance to add any additional parameters required for
     * the request.
     * </p>
     * 
     * @param input
     *            the current list of {@link KeyValue} items. Add to this list
     *            if required
     */
    protected abstract   
            void completeRequestParamList(Collection<KeyValue> input);

    /**
     * Return true if server should indent(format) output.
     * @return true if server should indent(format) output
     */
    public Boolean getIndent() {
        return indent;
    }

    /**
     *  Specifies how the results must be indented.
     * @param indentOrNot
     *            (Optional) Specifies how the results must be indented
     */
    @Override
    public void setIndent(boolean indentOrNot) {
        this.indent = indentOrNot;
    }

    /**
     * Return the current callback function name.
     * @return the current callback function name
     */
    public String getCallBack() {
        return callBack;
    }

    /**
     * <p>
     * Sets the callback function to be used to wrap the response.
     * </p>
     * <p>
     * This is primarily use full for JSONP scenarios.
     * </p>
     * <p>
     * WARNING: specifying a value here makes will mean that the deserializing
     * calls will NOT work. You can in this case only use the methods that
     * return <code>String</code> or <code>byte []</code>
     * </p>
     * 
     * @param callBackFuncName
     *            the function name to use to wrap the returned JSON
     */
    @Override
    public void setCallBack(String callBackFuncName) {
        this.callBack = callBackFuncName;
    }
    
    /**
     * Return the Collection of parameters directly (NOT a copy of the collection).
     * @return return the Collection of parameters directly (NOT a copy of the collection).
     */
    protected Collection<KeyValue> getParametersInternal () {
        return parameters;
    }

}
