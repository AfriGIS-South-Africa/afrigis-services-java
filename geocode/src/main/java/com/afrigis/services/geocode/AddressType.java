package com.afrigis.services.geocode;

public enum AddressType {
    
    /**
     * Enum for street_address.
     */
    streetAddress("street_address"),
    
    /**
     * Enum for route
     */
    route("route"),
    
    /**
     * Enum for intersection.
     */
    intersection("intersection"),
    
    /**
     * Enum for country.
     */
    country("country"),
    
    /**
     * Enum for administrative_area_level_1.
     */
    administrativeAreaLevel1("administrative_area_level_1"),
    
    /**
     * Enum for administrative_area_level_2.
     */
    administrativeAreaLevel2("administrative_area_level_2"),
    
    /**
     * Enum for administrative_area_level_3.
     */
    administrativeAreaLevel3("administrative_area_level_3"),
    
    /**
     * Enum for administrative_area_level_4.
     */
    administrativeAreaLevel4("administrative_area_level_4"),
    
    /**
     * Enum for administrative_area_level_5.
     */
    administrativeAreaLevel5("administrative_area_level_5"),
    
    /**
     * Enum for colloquial_area.
     */
    colloquialArea("colloquial_area"),
    
    /**
     * Enum for locality.
     */
    locality("locality"),
    
    /**
     * Enum for sublocality.
     */
    sublocality("sublocality"),
    
    /**
     * Enum for postcode_locality.
     */
    postcodeLocality("postcode_locality"),
    
    /**
     * Enum for point_of_interest.
     */
    pointOfInterest("point_of_interest"),
    
    /**
     * Enum for building.
     */
    building("building"),
    
    /**
     * Enum for building_level_1.
     */
    buildingLevel1("building_level_1"),
    
    /**
     * Enum for building_level_2.
     */
    buildingLevel2("building_level_2"),
    
    /**
     * Enum for site.
     */
    site("site"),
    
    /**
     * Enum for site_level_1.
     */
    siteLevel1("site_level_1"),
    
    /**
     * Enum for site_level_2.
     */
    siteLevel2("site_level_2"),
    
    /**
     * Enum for site_level_3.
     */
    siteLevel3("site_level_3"),
    
    /**
     * Enum for site_level_4.
     */
    siteLevel4("site_level_4"),
    
    /**
     * Enum for site_level_5.
     */
    siteLevel5("site_level_5"),
    
    /**
     * Enum for site_level_6.
     */
    siteLevel6("site_level_6");
    
    private final String type;
    
    AddressType(String id) {
        type = id;
    }
    
    public String toString() {
        return type;
    }
}
