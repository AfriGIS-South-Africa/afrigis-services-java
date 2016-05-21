/**
 * <p>
 * These classes provide a default implementation of calls to SaaS, allowing for
 * SaaS services to be called with custom parameters. The default response just
 * pipes through the results from the server.
 * </p>
 * 
 * <pre>
 * SaasClient proxy = new SaasClient("https://saas.afrigis.co.za/rest/2");
 * proxy.setSaasService("intiendols.basic.geocode.address");
 * proxy.setSaasClient(""ClientUUID");
 * proxy.setSharedKey(new String("Secret").getBytes());
 * 
 * List&lt;KeyValue&gt; params = new ArrayList&lt;KeyValue&gt;();
 * params.add(new KeyValue(&quot;ils_location&quot;, &quot;hatfield, pretoria&quot;));
 * params.add(new KeyValue(&quot;ils_result_start&quot;, &quot;0&quot;));
 * params.add(new KeyValue(&quot;ils_result_count&quot;, &quot;1&quot;));
 * params.add(new KeyValue(&quot;ils_result_count&quot;, &quot;3&quot;));
 * proxy.setRequestParams(params);
 * 
 * GenericResponse response = new GenericResponse();
 * proxy.execute(response);
 * </pre>
 * 
 * <p>
 * Once a response is received, it will either contain error data or result
 * data. Check whether the response is an error before attempting to extract
 * results from it.
 * </p>
 * 
 * <pre>
 * if (response.isError() || response.getError() != null) {
 * 	ParsedErrorData error = response.getError();
 * 	String errorMessage = error.getMessage();
 * }
 * else {
 * 	JSONObject obj = new JSONObject(new String(defResp.getRawData()));
 * 	JSONArray arr = obj.getJSONArray(&quot;results&quot;);
 * }
 * </pre>
 * 
 * @author Sydney
 *
 */
package com.afrigis.services.internal.saas.api2;

