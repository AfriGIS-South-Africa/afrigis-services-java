package com.afrigis.services.geocode.impl;

import com.afrigis.services.geocode.Metadata;
import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Please see
 * <a href="https://developers.afrigis.co.za/portfolio/search/#details">the
 * documentation</a> for information about this.
 * </p>
 * 
 * @author hendrikc
 *
 */
public class MetadataImpl implements Metadata {
    @SerializedName("point_of_observation")
    private String pointOfObservation;
    @SerializedName("address_type")
    private String addressType;
    @SerializedName("lifecycle_stage")
    private String lifecycleStage;
    @SerializedName("official_status")
    private String officialStatus;

    @SerializedName("feature_type")
    private String featureType;

    @SerializedName("dataprovider")
    private String dataProvider;
    private String source;

    @SerializedName("valid_from_date")
    private String validFromDate;
    
    @SerializedName("valid_to_date")
    private String validToDate;

    @SerializedName("thumb_nail_image")
    private String thumbNailImage;

    
    @Override
    public String getPointOfObservation() {
        return pointOfObservation;
    }

    /**
     * Sets the point of observation.
     * @param pointofobservation the point of observation.
     */
    public void setPointOfObservation(String pointofobservation) {
        this.pointOfObservation = pointofobservation;
    }

   
    @Override
    public String getAddressType() {
        return addressType;
    }

    /**
     * Sets the address type.
     * @param addresstype the address type.
     */
    public void setAddressType(String addresstype) {
        this.addressType = addresstype;
    }

    
    @Override
    public String getLifecycleStage() {
        return lifecycleStage;
    }

    /**
     * Sets the life cycle stage.
     * @param lifecyclestage the life cycle stage
     */
    public void setLifecycleStage(String lifecyclestage) {
        this.lifecycleStage = lifecyclestage;
    }

    
    @Override
    public String getOfficialStatus() {
        return officialStatus;
    }

    /**
     * Sets the official status.
     * @param officialstatus the offcial status.
     */
    public void setOfficialStatus(String officialstatus) {
        this.officialStatus = officialstatus;
    }

   
    @Override
    public String getFeatureType() {
        return featureType;
    }

    
    /**
     * Sets the feature type.
     * @param featuretype the feature type
     */
    public void setFeatureType(String featuretype) {
        this.featureType = featuretype;
    }

 
    @Override
    public String getDataProvider() {
        return dataProvider;
    }

    /**
     * The data provider to set.
     * @param dataproviderIn the dataProvider
     */
    public void setDataProvider(String dataproviderIn) {
        this.dataProvider = dataproviderIn;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.impl.MetadataInterface#getSource()
     */
    @Override
    public String getSource() {
        return source;
    }

    /**
     * Sets the source of the data.
     * @param sourceIn the source
     */
    public void setSource(String sourceIn) {
        this.source = sourceIn;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.impl.MetadataInterface#getValidFromDate()
     */
    @Override
    public String getValidFromDate() {
        return validFromDate;
    }
    
    /**
     * Sets the valid from date.
     * @param validFromDateIn valid from date
     */
    public void setValidFromDate(String validFromDateIn) {
        this.validFromDate = validFromDateIn;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.impl.MetadataInterface#getValidToDate()
     */
    @Override
    public String getValidToDate() {
        return validToDate;
    }
    
    /**
     * Sets the valid to date.
     * @param validToDate valid to date
     */
    public void setValidToDate(String validToDate) {
        this.validToDate = validToDate;
    }


    /*
     * (non-Javadoc)
     * 
     * @see com.afrigis.services.impl.MetadataInterface#getThumb_nail_image()
     */
    @Override
    public String getThumbNailImage() {
        return thumbNailImage;
    }

    /**
     * Sets the thumbnail image uri.
     * @param thumbnailimage the uri for a thumnail.
     */
    public void setThumbNailImage(String thumbnailimage) {
        this.thumbNailImage = thumbnailimage;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("MetadataImpl [\n\tpoint_of_observation=");
        builder.append(pointOfObservation);
        builder.append(", \n\taddress_type=");
        builder.append(addressType);
        builder.append(", \n\tlifecycle_stage=");
        builder.append(lifecycleStage);
        builder.append(", \n\tofficial_status=");
        builder.append(officialStatus);
        builder.append(", \n\tfeature_type=");
        builder.append(featureType);
        builder.append(", \n\tdataprovider=");
        builder.append(dataProvider);
        builder.append(", \n\tsource=");
        builder.append(source);
        builder.append(", \n\tvalid_from_date=");
        builder.append(validFromDate);
        builder.append(", \n\tvalid_to_date=");
        builder.append(validToDate);
        builder.append(", \n\tthumb_nail_image=");
        builder.append(thumbNailImage);
        builder.append("\n]");
        return builder.toString();
    }

}
