package com.afrigis.services.geocode;

/**
* <p>
* Please see <a href="https://developers.afrigis.co.za/portfolio/search/#details"> this link for information about this.</a>
* </p>
* @author hendrikc
*
*/
public interface Metadata {

    /**
     * Return the point of observation.
     * @return the point of observation
     */
    String getPointOfObservation();

    /**
     * Return the address type.
     * @return the address type.
     */
    String getAddressType();

    /**
     * Return the life cycle stage.
     * @return the life cycle stage
     */
    String getLifecycleStage();

    /**
     * Return the official status.
     * @return the official status
     */
    String getOfficialStatus();

    /**
     * Return the feature type.
     * @return the feature type
     */
    String getFeatureType();

    /**
     * Return the data provider.
     * @return the data provider
     */
    String getDataProvider();

    /**
     * Return the source.
     * @return the source
     */
    String getSource();

    /**
     * Return valid from date.
     * @return valid from date
     */
    String getValidFromDate();
    
    /**
     * Return valid to date.
     * @return valid to date
     */
    String getValidToDate();

    /**
     * Return URI of the a thumbnail image.
     * @return URI of the a thumbnail image.
     */
    String getThumbNailImage();

}

