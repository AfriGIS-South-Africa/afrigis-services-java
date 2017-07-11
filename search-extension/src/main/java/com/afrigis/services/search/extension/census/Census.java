package com.afrigis.services.search.extension.census;

/**
 * <p>
 * Represents Census obtained from AfriGIS Census Service call. Root object from
 * JSON response, contains other typed class object from JSON response as
 * variables.
 * </p>
 */
public class Census {

    private int AgId;

    public int getAgId() {
        return this.AgId;
    }

    public void setAgId(int AgId) {
        this.AgId = AgId;
    }

    private int SpCode;

    public int getSpCode() {
        return this.SpCode;
    }

    public void setSpCode(int SpCode) {
        this.SpCode = SpCode;
    }

    private String Name;

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    private AgeDetails AgeDetails;

    public AgeDetails getAgeDetails() {
        return this.AgeDetails;
    }

    public void setAgeDetails(AgeDetails AgeDetails) {
        this.AgeDetails = AgeDetails;
    }

    private DwellingDetails DwellingDetails;

    public DwellingDetails getDwellingDetails() {
        return this.DwellingDetails;
    }

    public void setDwellingDetails(DwellingDetails DwellingDetails) {
        this.DwellingDetails = DwellingDetails;
    }

    private HouseholdIncomeDetails HouseholdIncomeDetails;

    public HouseholdIncomeDetails getHouseholdIncomeDetails() {
        return this.HouseholdIncomeDetails;
    }

    public void setHouseholdIncomeDetails(HouseholdIncomeDetails HouseholdIncomeDetails) {
        this.HouseholdIncomeDetails = HouseholdIncomeDetails;
    }

    private IndividualIncomeDetails IndividualIncomeDetails;

    public IndividualIncomeDetails getIndividualIncomeDetails() {
        return this.IndividualIncomeDetails;
    }

    public void setIndividualIncomeDetails(IndividualIncomeDetails IndividualIncomeDetails) {
        this.IndividualIncomeDetails = IndividualIncomeDetails;
    }

    private EmploymentStatusDetails EmploymentStatusDetails;

    public EmploymentStatusDetails getEmploymentStatusDetails() {
        return this.EmploymentStatusDetails;
    }

    public void setEmploymentStatusDetails(EmploymentStatusDetails EmploymentStatusDetails) {
        this.EmploymentStatusDetails = EmploymentStatusDetails;
    }

    private GenderDetails GenderDetails;

    public GenderDetails getGenderDetails() {
        return this.GenderDetails;
    }

    public void setGenderDetails(GenderDetails GenderDetails) {
        this.GenderDetails = GenderDetails;
    }

    private LandUseDetails LandUseDetails;

    public LandUseDetails getLandUseDetails() {
        return this.LandUseDetails;
    }

    public void setLandUseDetails(LandUseDetails LandUseDetails) {
        this.LandUseDetails = LandUseDetails;
    }

    private LanguageDetails LanguageDetails;

    public LanguageDetails getLanguageDetails() {
        return this.LanguageDetails;
    }

    public void setLanguageDetails(LanguageDetails LanguageDetails) {
        this.LanguageDetails = LanguageDetails;
    }

    private PopulationGroupDetails PopulationGroupDetails;

    public PopulationGroupDetails getPopulationGroupDetails() {
        return this.PopulationGroupDetails;
    }

    public void setPopulationGroupDetails(PopulationGroupDetails PopulationGroupDetails) {
        this.PopulationGroupDetails = PopulationGroupDetails;
    }

    private WaterDetails WaterDetails;

    public WaterDetails getWaterDetails() {
        return this.WaterDetails;
    }

    public void setWaterDetails(WaterDetails WaterDetails) {
        this.WaterDetails = WaterDetails;
    }

    private String GeoJson;

    public String getGeoJson() {
        return this.GeoJson;
    }

    public void setGeoJson(String GeoJson) {
        this.GeoJson = GeoJson;
    }

    private int Latitude;

    public int getLatitude() {
        return this.Latitude;
    }

    public void setLatitude(int Latitude) {
        this.Latitude = Latitude;
    }

    private int Longitude;

    public int getLongitude() {
        return this.Longitude;
    }

    public void setLongitude(int Longitude) {
        this.Longitude = Longitude;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Census{AgId=");
        builder.append(AgId);
        builder.append(", SpCode=");
        builder.append(SpCode);
        builder.append(", Name=");
        builder.append(Name);
        builder.append(", AgeDetails=");
        builder.append(AgeDetails);
        builder.append(", DwellingDetails=");
        builder.append(DwellingDetails);
        builder.append(", HouseholdIncomeDetails=");
        builder.append(HouseholdIncomeDetails);
        builder.append(", IndividualIncomeDetails=");
        builder.append(IndividualIncomeDetails);
        builder.append(", EmploymentStatusDetails=");
        builder.append(EmploymentStatusDetails);
        builder.append(", GenderDetails=");
        builder.append(GenderDetails);
        builder.append(", LandUseDetails=");
        builder.append(LandUseDetails);
        builder.append(", LanguageDetails=");
        builder.append(LanguageDetails);
        builder.append(", PopulationGroupDetails=");
        builder.append(PopulationGroupDetails);
        builder.append(", WaterDetails=");
        builder.append(WaterDetails);
        builder.append(", GeoJson=");
        builder.append(GeoJson);
        builder.append(", Latitude=");
        builder.append(Latitude);
        builder.append(", Longitude=");
        builder.append(Longitude);
        builder.append("}");
        return builder.toString();
    }
}
