package com.afrigis.services.internal.saas.api2.intiendoLS.parsedData;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.afrigis.services.ConfidenceLevel;
import com.afrigis.services.Coordinate;
import com.afrigis.services.geocode.LocationResult;
import com.afrigis.services.geocode.impl.AddressComponent;
import com.afrigis.services.geocode.impl.GeometryImpl;
import com.google.gson.annotations.SerializedName;

/**
 * A single record returned by the query. Query response will contain an array
 * of these.
 * 
 * @author sydney
 *
 */
public class SearchResult implements LocationResult {
    private String docid;
    private String seoid;
    @SerializedName("formatted_address")
    private String formattedAddress;
    private Integer confidence;
    private GeometryImpl geometry;
    private List<String> types;
    
    
    @SerializedName("address_components")
    private List<AddressComponent> addressComponents;

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("SearchResult [\n\tdocid=");
        builder.append(docid);
        builder.append(", \n\tseoid=");
        builder.append(seoid);
        builder.append(", \n\tformatted_address=");
        builder.append(formattedAddress);
        builder.append(", \n\tconfidence=");
        builder.append(confidence);
        builder.append(", \n\tgeometry=");
        builder.append(geometry);
        builder.append(", \n\ttypes=");
        builder.append(types);
        builder.append(", \n\taddress_components=");
        builder.append(addressComponents);
        builder.append("\n]");
        return builder.toString();
    }

    @Override
    public String getSeoId() {
        return seoid;
    }

    

    @Override
    public GeometryImpl getGeometry() {
        return geometry;
    }

    @Override
    public String getFormattedAddress() {
        return this.formattedAddress;
    }

    @Override
    public ConfidenceLevel getConfidence() {
        try {
            final ConfidenceLevel[] confArr = ConfidenceLevel.values();
            // Maps anything out of range to ConfidenceLevel#unknown
            return confidence >= confArr.length || confidence < 0 ? confArr[0]
                    : confArr[confidence % confArr.length];
        } catch (Exception e) {
            log().trace(
                    "Failed to convert numeric confidence to ConfidenceLevel",
                    e);
            return null;
        }
    }

    @Override
    public Integer getLevel() {
        return confidence;
    }

    private Logger log() {
        return LoggerFactory.getLogger(getClass());
    }

    @Override
    public Coordinate getLocation() {
        return geometry;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((confidence == null) ? 0 : confidence.hashCode());
        result = prime * result + ((docid == null) ? 0 : docid.hashCode());
        result = prime * result + ((formattedAddress == null) ? 0
                : formattedAddress.hashCode());
        result = prime * result
                + ((geometry == null) ? 0 : geometry.hashCode());
        result = prime * result + ((seoid == null) ? 0 : seoid.hashCode());
        return result;
    }

  //CHECKSTYLE:OFF: CyclomaticComplexity
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SearchResult other = (SearchResult) obj;
        if (confidence == null) {
            if (other.confidence != null) {
                return false;
            }
        } else if (!confidence.equals(other.confidence)) {
            return false;
        }
        if (docid == null) {
            if (other.docid != null) {
                return false;
            }
        } else if (!docid.equals(other.docid)) {
            return false;
        }
        if (formattedAddress == null) {
            if (other.formattedAddress != null) {
                return false;
            }
        } else if (!formattedAddress.equals(other.formattedAddress)) {
            return false;
        }
        if (geometry == null) {
            if (other.geometry != null) {
                return false;
            }
        } else if (!geometry.equals(other.geometry)) {
            return false;
        }
        if (seoid == null) {
            if (other.seoid != null) {
                return false;
            }
        } else if (!seoid.equals(other.seoid)) {
            return false;
        }
        return true;
    }    
    //CHECKSTYLE:ON: CyclomaticComplexity

    @Override
    public String getDocId() {
        return docid;
    }

    @Override
    public List<String> getTypes() {
        return types;
    }

    /**
     * <p>
     * Setter for types.
     * </p>
     * 
     * @param theTypes
     *            the types to set. List is NOT copied.
     */
    public void setTypes(List<String> theTypes) {
        this.types = theTypes;
    }

   

    /**
     * <p>
     * Not intended to be used directly, instead intended to be use by
     * deserializing code.
     * </p>
     * 
     * @param addresscomponents
     *            {@link List} of {@link AddressComponent} objects
     */
    public final void setAddressComponents(
            List<AddressComponent> addresscomponents) {
        this.addressComponents = addresscomponents;
    }

    @Override
    public List<AddressComponent> getAddressComponents() {
        return addressComponents;
    }

}
