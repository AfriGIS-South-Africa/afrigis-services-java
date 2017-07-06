package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents AgeDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
class AgeDetails {

    private int Age0To9;

    public int getAge0To9() {
        return this.Age0To9;
    }

    public void setAge0To9(int Age0To9) {
        this.Age0To9 = Age0To9;
    }

    private int Age10To19;

    public int getAge10To19() {
        return this.Age10To19;
    }

    public void setAge10To19(int Age10To19) {
        this.Age10To19 = Age10To19;
    }

    private int Age20To29;

    public int getAge20To29() {
        return this.Age20To29;
    }

    public void setAge20To29(int Age20To29) {
        this.Age20To29 = Age20To29;
    }

    private int Age30To39;

    public int getAge30To39() {
        return this.Age30To39;
    }

    public void setAge30To39(int Age30To39) {
        this.Age30To39 = Age30To39;
    }

    private int Age40To49;

    public int getAge40To49() {
        return this.Age40To49;
    }

    public void setAge40To49(int Age40To49) {
        this.Age40To49 = Age40To49;
    }

    private int Age50To59;

    public int getAge50To59() {
        return this.Age50To59;
    }

    public void setAge50To59(int Age50To59) {
        this.Age50To59 = Age50To59;
    }

    private int Age60To60;

    public int getAge60To60() {
        return this.Age60To60;
    }

    public void setAge60To60(int Age60To60) {
        this.Age60To60 = Age60To60;
    }

    private int Age70To79;

    public int getAge70To79() {
        return this.Age70To79;
    }

    public void setAge70To79(int Age70To79) {
        this.Age70To79 = Age70To79;
    }

    private int Age80Plus;

    public int getAge80Plus() {
        return this.Age80Plus;
    }

    public void setAge80Plus(int Age80Plus) {
        this.Age80Plus = Age80Plus;
    }

    @Override
    public String toString() {
        return "AgeDetails{" + "Age0To9=" + Age0To9 + ", Age10To19=" + Age10To19 + ", Age20To29=" + Age20To29 + ", Age30To39=" + Age30To39 + ", Age40To49=" + Age40To49 + ", Age50To59=" + Age50To59 + ", Age60To60=" + Age60To60 + ", Age70To79=" + Age70To79 + ", Age80Plus=" + Age80Plus + '}';
    }

}

/**
 * <p>
 * Represents DwellingDetails obtained from AfriGIS Census Service call
 * </p>
 */
class DwellingDetails {

    private int CaravanTent;

    public int getCaravanTent() {
        return this.CaravanTent;
    }

    public void setCaravanTent(int CaravanTent) {
        this.CaravanTent = CaravanTent;
    }

    private int ClusterHouse;

    public int getClusterHouse() {
        return this.ClusterHouse;
    }

    public void setClusterHouse(int ClusterHouse) {
        this.ClusterHouse = ClusterHouse;
    }

    private int Flat;

    public int getFlat() {
        return this.Flat;
    }

    public void setFlat(int Flat) {
        this.Flat = Flat;
    }

    private int House;

    public int getHouse() {
        return this.House;
    }

    public void setHouse(int House) {
        this.House = House;
    }

    private int HouseInBackyard;

    public int getHouseInBackyard() {
        return this.HouseInBackyard;
    }

    public void setHouseInBackyard(int HouseInBackyard) {
        this.HouseInBackyard = HouseInBackyard;
    }

    private int InformalDwelling;

    public int getInformalDwelling() {
        return this.InformalDwelling;
    }

    public void setInformalDwelling(int InformalDwelling) {
        this.InformalDwelling = InformalDwelling;
    }

    private int InformalDwellingInBackyard;

    public int getInformalDwellingInBackyard() {
        return this.InformalDwellingInBackyard;
    }

    public void setInformalDwellingInBackyard(int InformalDwellingInBackyard) {
        this.InformalDwellingInBackyard = InformalDwellingInBackyard;
    }

    private int NotApplicable;

    public int getNotApplicable() {
        return this.NotApplicable;
    }

    public void setNotApplicable(int NotApplicable) {
        this.NotApplicable = NotApplicable;
    }

    private int Other;

    public int getOther() {
        return this.Other;
    }

    public void setOther(int Other) {
        this.Other = Other;
    }

    private int RoomOnAProperty;

    public int getRoomOnAProperty() {
        return this.RoomOnAProperty;
    }

    public void setRoomOnAProperty(int RoomOnAProperty) {
        this.RoomOnAProperty = RoomOnAProperty;
    }

    private int SemiDetachedHouse;

    public int getSemiDetachedHouse() {
        return this.SemiDetachedHouse;
    }

    public void setSemiDetachedHouse(int SemiDetachedHouse) {
        this.SemiDetachedHouse = SemiDetachedHouse;
    }

    private int Townhouse;

    public int getTownhouse() {
        return this.Townhouse;
    }

    public void setTownhouse(int Townhouse) {
        this.Townhouse = Townhouse;
    }

    private int TraditionalDwelling;

    public int getTraditionalDwelling() {
        return this.TraditionalDwelling;
    }

    public void setTraditionalDwelling(int TraditionalDwelling) {
        this.TraditionalDwelling = TraditionalDwelling;
    }

    private int TraditionalResidential;

    public int getTraditionalResidential() {
        return this.TraditionalResidential;
    }

    public void setTraditionalResidential(int TraditionalResidential) {
        this.TraditionalResidential = TraditionalResidential;
    }

    private int Unspecified;

    public int getUnspecified() {
        return this.Unspecified;
    }

    public void setUnspecified(int Unspecified) {
        this.Unspecified = Unspecified;
    }

    @Override
    public String toString() {
        return "DwellingDetails{" + "CaravanTent=" + CaravanTent + ", ClusterHouse=" + ClusterHouse + ", Flat=" + Flat + ", House=" + House + ", HouseInBackyard=" + HouseInBackyard + ", InformalDwelling=" + InformalDwelling + ", InformalDwellingInBackyard=" + InformalDwellingInBackyard + ", NotApplicable=" + NotApplicable + ", Other=" + Other + ", RoomOnAProperty=" + RoomOnAProperty + ", SemiDetachedHouse=" + SemiDetachedHouse + ", Townhouse=" + Townhouse + ", TraditionalDwelling=" + TraditionalDwelling + ", TraditionalResidential=" + TraditionalResidential + ", Unspecified=" + Unspecified + '}';
    }

}

/**
 * <p>
 * Represents HouseholdIncomeDetails obtained from AfriGIS Census Service call
 * </p>
 */
class HouseholdIncomeDetails {

    private int NoIncome;

    public int getNoIncome() {
        return this.NoIncome;
    }

    public void setNoIncome(int NoIncome) {
        this.NoIncome = NoIncome;
    }

    private int LessThan4800;

    public int getLessThan4800() {
        return this.LessThan4800;
    }

    public void setLessThan4800(int LessThan4800) {
        this.LessThan4800 = LessThan4800;
    }

    private int MoreThan4800LessThan9600;

    public int getMoreThan4800LessThan9600() {
        return this.MoreThan4800LessThan9600;
    }

    public void setMoreThan4800LessThan9600(int MoreThan4800LessThan9600) {
        this.MoreThan4800LessThan9600 = MoreThan4800LessThan9600;
    }

    private int MoreThan9600LessThan19600;

    public int getMoreThan9600LessThan19600() {
        return this.MoreThan9600LessThan19600;
    }

    public void setMoreThan9600LessThan19600(int MoreThan9600LessThan19600) {
        this.MoreThan9600LessThan19600 = MoreThan9600LessThan19600;
    }

    private int MoreThan19600LessThan38200;

    public int getMoreThan19600LessThan38200() {
        return this.MoreThan19600LessThan38200;
    }

    public void setMoreThan19600LessThan38200(int MoreThan19600LessThan38200) {
        this.MoreThan19600LessThan38200 = MoreThan19600LessThan38200;
    }

    private int MoreThan38200LessThan76400;

    public int getMoreThan38200LessThan76400() {
        return this.MoreThan38200LessThan76400;
    }

    public void setMoreThan38200LessThan76400(int MoreThan38200LessThan76400) {
        this.MoreThan38200LessThan76400 = MoreThan38200LessThan76400;
    }

    private int MoreThan76400LessThan153800;

    public int getMoreThan76400LessThan153800() {
        return this.MoreThan76400LessThan153800;
    }

    public void setMoreThan76400LessThan153800(int MoreThan76400LessThan153800) {
        this.MoreThan76400LessThan153800 = MoreThan76400LessThan153800;
    }

    private int MoreThan153800LessThan307600;

    public int getMoreThan153800LessThan307600() {
        return this.MoreThan153800LessThan307600;
    }

    public void setMoreThan153800LessThan307600(int MoreThan153800LessThan307600) {
        this.MoreThan153800LessThan307600 = MoreThan153800LessThan307600;
    }

    private int MoreThan307600LessThan614400;

    public int getMoreThan307600LessThan614400() {
        return this.MoreThan307600LessThan614400;
    }

    public void setMoreThan307600LessThan614400(int MoreThan307600LessThan614400) {
        this.MoreThan307600LessThan614400 = MoreThan307600LessThan614400;
    }

    private int MoreThan614400LessThan1228800;

    public int getMoreThan614400LessThan1228800() {
        return this.MoreThan614400LessThan1228800;
    }

    public void setMoreThan614400LessThan1228800(int MoreThan614400LessThan1228800) {
        this.MoreThan614400LessThan1228800 = MoreThan614400LessThan1228800;
    }

    private int MoreThan1228800LessThan2457600;

    public int getMoreThan1228800LessThan2457600() {
        return this.MoreThan1228800LessThan2457600;
    }

    public void setMoreThan1228800LessThan2457600(int MoreThan1228800LessThan2457600) {
        this.MoreThan1228800LessThan2457600 = MoreThan1228800LessThan2457600;
    }

    private int MoreThan2457600;

    public int getMoreThan2457600() {
        return this.MoreThan2457600;
    }

    public void setMoreThan2457600(int MoreThan2457600) {
        this.MoreThan2457600 = MoreThan2457600;
    }

    private int Unspecified;

    public int getUnspecified() {
        return this.Unspecified;
    }

    public void setUnspecified(int Unspecified) {
        this.Unspecified = Unspecified;
    }

    @Override
    public String toString() {
        return "HouseholdIncomeDetails{" + "NoIncome=" + NoIncome + ", LessThan4800=" + LessThan4800 + ", MoreThan4800LessThan9600=" + MoreThan4800LessThan9600 + ", MoreThan9600LessThan19600=" + MoreThan9600LessThan19600 + ", MoreThan19600LessThan38200=" + MoreThan19600LessThan38200 + ", MoreThan38200LessThan76400=" + MoreThan38200LessThan76400 + ", MoreThan76400LessThan153800=" + MoreThan76400LessThan153800 + ", MoreThan153800LessThan307600=" + MoreThan153800LessThan307600 + ", MoreThan307600LessThan614400=" + MoreThan307600LessThan614400 + ", MoreThan614400LessThan1228800=" + MoreThan614400LessThan1228800 + ", MoreThan1228800LessThan2457600=" + MoreThan1228800LessThan2457600 + ", MoreThan2457600=" + MoreThan2457600 + ", Unspecified=" + Unspecified + '}';
    }

}

/**
 * <p>
 * Represents IndividualIncomeDetails obtained from AfriGIS Census Service call
 * </p>
 */
class IndividualIncomeDetails {

    private int NoIncome;

    public int getNoIncome() {
        return this.NoIncome;
    }

    public void setNoIncome(int NoIncome) {
        this.NoIncome = NoIncome;
    }

    private int LessThan400;

    public int getLessThan400() {
        return this.LessThan400;
    }

    public void setLessThan400(int LessThan400) {
        this.LessThan400 = LessThan400;
    }

    private int MoreThan400LessThan800;

    public int getMoreThan400LessThan800() {
        return this.MoreThan400LessThan800;
    }

    public void setMoreThan400LessThan800(int MoreThan400LessThan800) {
        this.MoreThan400LessThan800 = MoreThan400LessThan800;
    }

    private int MoreThan800LessThan1600;

    public int getMoreThan800LessThan1600() {
        return this.MoreThan800LessThan1600;
    }

    public void setMoreThan800LessThan1600(int MoreThan800LessThan1600) {
        this.MoreThan800LessThan1600 = MoreThan800LessThan1600;
    }

    private int MoreThan1600LessThan3200;

    public int getMoreThan1600LessThan3200() {
        return this.MoreThan1600LessThan3200;
    }

    public void setMoreThan1600LessThan3200(int MoreThan1600LessThan3200) {
        this.MoreThan1600LessThan3200 = MoreThan1600LessThan3200;
    }

    private int MoreThan3200LessThan6400;

    public int getMoreThan3200LessThan6400() {
        return this.MoreThan3200LessThan6400;
    }

    public void setMoreThan3200LessThan6400(int MoreThan3200LessThan6400) {
        this.MoreThan3200LessThan6400 = MoreThan3200LessThan6400;
    }

    private int MoreThan6400LessThan12800;

    public int getMoreThan6400LessThan12800() {
        return this.MoreThan6400LessThan12800;
    }

    public void setMoreThan6400LessThan12800(int MoreThan6400LessThan12800) {
        this.MoreThan6400LessThan12800 = MoreThan6400LessThan12800;
    }

    private int MoreThan12800LessThan25600;

    public int getMoreThan12800LessThan25600() {
        return this.MoreThan12800LessThan25600;
    }

    public void setMoreThan12800LessThan25600(int MoreThan12800LessThan25600) {
        this.MoreThan12800LessThan25600 = MoreThan12800LessThan25600;
    }

    private int MoreThan25600LessThan51200;

    public int getMoreThan25600LessThan51200() {
        return this.MoreThan25600LessThan51200;
    }

    public void setMoreThan25600LessThan51200(int MoreThan25600LessThan51200) {
        this.MoreThan25600LessThan51200 = MoreThan25600LessThan51200;
    }

    private int MoreThan51200LessThan102400;

    public int getMoreThan51200LessThan102400() {
        return this.MoreThan51200LessThan102400;
    }

    public void setMoreThan51200LessThan102400(int MoreThan51200LessThan102400) {
        this.MoreThan51200LessThan102400 = MoreThan51200LessThan102400;
    }

    private int MoreThan102400LessThan204800;

    public int getMoreThan102400LessThan204800() {
        return this.MoreThan102400LessThan204800;
    }

    public void setMoreThan102400LessThan204800(int MoreThan102400LessThan204800) {
        this.MoreThan102400LessThan204800 = MoreThan102400LessThan204800;
    }

    private int MoreThan204800;

    public int getMoreThan204800() {
        return this.MoreThan204800;
    }

    public void setMoreThan204800(int MoreThan204800) {
        this.MoreThan204800 = MoreThan204800;
    }

    private int Unspecified;

    public int getUnspecified() {
        return this.Unspecified;
    }

    public void setUnspecified(int Unspecified) {
        this.Unspecified = Unspecified;
    }

    private int NotApplicable;

    public int getNotApplicable() {
        return this.NotApplicable;
    }

    public void setNotApplicable(int NotApplicable) {
        this.NotApplicable = NotApplicable;
    }

    @Override
    public String toString() {
        return "IndividualIncomeDetails{" + "NoIncome=" + NoIncome + ", LessThan400=" + LessThan400 + ", MoreThan400LessThan800=" + MoreThan400LessThan800 + ", MoreThan800LessThan1600=" + MoreThan800LessThan1600 + ", MoreThan1600LessThan3200=" + MoreThan1600LessThan3200 + ", MoreThan3200LessThan6400=" + MoreThan3200LessThan6400 + ", MoreThan6400LessThan12800=" + MoreThan6400LessThan12800 + ", MoreThan12800LessThan25600=" + MoreThan12800LessThan25600 + ", MoreThan25600LessThan51200=" + MoreThan25600LessThan51200 + ", MoreThan51200LessThan102400=" + MoreThan51200LessThan102400 + ", MoreThan102400LessThan204800=" + MoreThan102400LessThan204800 + ", MoreThan204800=" + MoreThan204800 + ", Unspecified=" + Unspecified + ", NotApplicable=" + NotApplicable + '}';
    }

}

/**
 * <p>
 * Represents EmploymentStatusDetails obtained from AfriGIS Census Service call
 * </p>
 */
class EmploymentStatusDetails {

    private int AgeLessThan15Years;

    public int getAgeLessThan15Years() {
        return this.AgeLessThan15Years;
    }

    public void setAgeLessThan15Years(int AgeLessThan15Years) {
        this.AgeLessThan15Years = AgeLessThan15Years;
    }

    private int DiscouragedWorkSeeker;

    public int getDiscouragedWorkSeeker() {
        return this.DiscouragedWorkSeeker;
    }

    public void setDiscouragedWorkSeeker(int DiscouragedWorkSeeker) {
        this.DiscouragedWorkSeeker = DiscouragedWorkSeeker;
    }

    private int Employed;

    public int getEmployed() {
        return this.Employed;
    }

    public void setEmployed(int Employed) {
        this.Employed = Employed;
    }

    private int EmploymentNotApplicable;

    public int getEmploymentNotApplicable() {
        return this.EmploymentNotApplicable;
    }

    public void setEmploymentNotApplicable(int EmploymentNotApplicable) {
        this.EmploymentNotApplicable = EmploymentNotApplicable;
    }

    private int OtherNotEconomicallyActive;

    public int getOtherNotEconomicallyActive() {
        return this.OtherNotEconomicallyActive;
    }

    public void setOtherNotEconomicallyActive(int OtherNotEconomicallyActive) {
        this.OtherNotEconomicallyActive = OtherNotEconomicallyActive;
    }

    private int Unemployed;

    public int getUnemployed() {
        return this.Unemployed;
    }

    public void setUnemployed(int Unemployed) {
        this.Unemployed = Unemployed;
    }

    @Override
    public String toString() {
        return "EmploymentStatusDetails{" + "AgeLessThan15Years=" + AgeLessThan15Years + ", DiscouragedWorkSeeker=" + DiscouragedWorkSeeker + ", Employed=" + Employed + ", EmploymentNotApplicable=" + EmploymentNotApplicable + ", OtherNotEconomicallyActive=" + OtherNotEconomicallyActive + ", Unemployed=" + Unemployed + '}';
    }

}

/**
 * <p>
 * Represents GenderDetails obtained from AfriGIS Census Service call
 * </p>
 */
class GenderDetails {

    private int Male;

    public int getMale() {
        return this.Male;
    }

    public void setMale(int Male) {
        this.Male = Male;
    }

    private int Female;

    public int getFemale() {
        return this.Female;
    }

    public void setFemale(int Female) {
        this.Female = Female;
    }

    @Override
    public String toString() {
        return "GenderDetails{" + "Male=" + Male + ", Female=" + Female + '}';
    }

}

/**
 * <p>
 * Represents LandUseDetails obtained from AfriGIS Census Service call
 * </p>
 */
class LandUseDetails {

    private int Collective;

    public int getCollective() {
        return this.Collective;
    }

    public void setCollective(int Collective) {
        this.Collective = Collective;
    }

    private int Commercial;

    public int getCommercial() {
        return this.Commercial;
    }

    public void setCommercial(int Commercial) {
        this.Commercial = Commercial;
    }

    private int Farms;

    public int getFarms() {
        return this.Farms;
    }

    public void setFarms(int Farms) {
        this.Farms = Farms;
    }

    private int FormalResidential;

    public int getFormalResidential() {
        return this.FormalResidential;
    }

    public void setFormalResidential(int FormalResidential) {
        this.FormalResidential = FormalResidential;
    }

    private int Industrial;

    public int getIndustrial() {
        return this.Industrial;
    }

    public void setIndustrial(int Industrial) {
        this.Industrial = Industrial;
    }

    private int InformalResidential;

    public int getInformalResidential() {
        return this.InformalResidential;
    }

    public void setInformalResidential(int InformalResidential) {
        this.InformalResidential = InformalResidential;
    }

    private int ParksAndRecreation;

    public int getParksAndRecreation() {
        return this.ParksAndRecreation;
    }

    public void setParksAndRecreation(int ParksAndRecreation) {
        this.ParksAndRecreation = ParksAndRecreation;
    }

    private int SmallHoldings;

    public int getSmallHoldings() {
        return this.SmallHoldings;
    }

    public void setSmallHoldings(int SmallHoldings) {
        this.SmallHoldings = SmallHoldings;
    }

    private int TradionalResidential;

    public int getTradionalResidential() {
        return this.TradionalResidential;
    }

    public void setTradionalResidential(int TradionalResidential) {
        this.TradionalResidential = TradionalResidential;
    }

    private int Vacant;

    public int getVacant() {
        return this.Vacant;
    }

    public void setVacant(int Vacant) {
        this.Vacant = Vacant;
    }

    @Override
    public String toString() {
        return "LandUseDetails{" + "Collective=" + Collective + ", Commercial=" + Commercial + ", Farms=" + Farms + ", FormalResidential=" + FormalResidential + ", Industrial=" + Industrial + ", InformalResidential=" + InformalResidential + ", ParksAndRecreation=" + ParksAndRecreation + ", SmallHoldings=" + SmallHoldings + ", TradionalResidential=" + TradionalResidential + ", Vacant=" + Vacant + '}';
    }

}

/**
 * <p>
 * Represents LanguageDetails obtained from AfriGIS Census Service call
 * </p>
 */
class LanguageDetails {

    private int Afrikaans;

    public int getAfrikaans() {
        return this.Afrikaans;
    }

    public void setAfrikaans(int Afrikaans) {
        this.Afrikaans = Afrikaans;
    }

    private int English;

    public int getEnglish() {
        return this.English;
    }

    public void setEnglish(int English) {
        this.English = English;
    }

    private int Isindebele;

    public int getIsindebele() {
        return this.Isindebele;
    }

    public void setIsindebele(int Isindebele) {
        this.Isindebele = Isindebele;
    }

    private int Isixhosa;

    public int getIsixhosa() {
        return this.Isixhosa;
    }

    public void setIsixhosa(int Isixhosa) {
        this.Isixhosa = Isixhosa;
    }

    private int Isizulu;

    public int getIsizulu() {
        return this.Isizulu;
    }

    public void setIsizulu(int Isizulu) {
        this.Isizulu = Isizulu;
    }

    private int Sepedi;

    public int getSepedi() {
        return this.Sepedi;
    }

    public void setSepedi(int Sepedi) {
        this.Sepedi = Sepedi;
    }

    private int Sesotho;

    public int getSesotho() {
        return this.Sesotho;
    }

    public void setSesotho(int Sesotho) {
        this.Sesotho = Sesotho;
    }

    private int Setswana;

    public int getSetswana() {
        return this.Setswana;
    }

    public void setSetswana(int Setswana) {
        this.Setswana = Setswana;
    }

    private int SignLanguage;

    public int getSignLanguage() {
        return this.SignLanguage;
    }

    public void setSignLanguage(int SignLanguage) {
        this.SignLanguage = SignLanguage;
    }

    private int Siswati;

    public int getSiswati() {
        return this.Siswati;
    }

    public void setSiswati(int Siswati) {
        this.Siswati = Siswati;
    }

    private int Tshivenda;

    public int getTshivenda() {
        return this.Tshivenda;
    }

    public void setTshivenda(int Tshivenda) {
        this.Tshivenda = Tshivenda;
    }

    private int Xitsonga;

    public int getXitsonga() {
        return this.Xitsonga;
    }

    public void setXitsonga(int Xitsonga) {
        this.Xitsonga = Xitsonga;
    }

    private int Other;

    public int getOther() {
        return this.Other;
    }

    public void setOther(int Other) {
        this.Other = Other;
    }

    private int Unspecified;

    public int getUnspecified() {
        return this.Unspecified;
    }

    public void setUnspecified(int Unspecified) {
        this.Unspecified = Unspecified;
    }

    private int NotApplicable;

    public int getNotApplicable() {
        return this.NotApplicable;
    }

    public void setNotApplicable(int NotApplicable) {
        this.NotApplicable = NotApplicable;
    }

    @Override
    public String toString() {
        return "LanguageDetails{" + "Afrikaans=" + Afrikaans + ", English=" + English + ", Isindebele=" + Isindebele + ", Isixhosa=" + Isixhosa + ", Isizulu=" + Isizulu + ", Sepedi=" + Sepedi + ", Sesotho=" + Sesotho + ", Setswana=" + Setswana + ", SignLanguage=" + SignLanguage + ", Siswati=" + Siswati + ", Tshivenda=" + Tshivenda + ", Xitsonga=" + Xitsonga + ", Other=" + Other + ", Unspecified=" + Unspecified + ", NotApplicable=" + NotApplicable + '}';
    }

}

/**
 * <p>
 * Represents PopulationGroupDetails obtained from AfriGIS Census Service call
 * </p>
 */
class PopulationGroupDetails {

    private int BlackAfrican;

    public int getBlackAfrican() {
        return this.BlackAfrican;
    }

    public void setBlackAfrican(int BlackAfrican) {
        this.BlackAfrican = BlackAfrican;
    }

    private int Coloured;

    public int getColoured() {
        return this.Coloured;
    }

    public void setColoured(int Coloured) {
        this.Coloured = Coloured;
    }

    private int IndianOrAsian;

    public int getIndianOrAsian() {
        return this.IndianOrAsian;
    }

    public void setIndianOrAsian(int IndianOrAsian) {
        this.IndianOrAsian = IndianOrAsian;
    }

    private int Other;

    public int getOther() {
        return this.Other;
    }

    public void setOther(int Other) {
        this.Other = Other;
    }

    private int TotalPopulation;

    public int getTotalPopulation() {
        return this.TotalPopulation;
    }

    public void setTotalPopulation(int TotalPopulation) {
        this.TotalPopulation = TotalPopulation;
    }

    private int White;

    public int getWhite() {
        return this.White;
    }

    public void setWhite(int White) {
        this.White = White;
    }

    @Override
    public String toString() {
        return "PopulationGroupDetails{" + "BlackAfrican=" + BlackAfrican + ", Coloured=" + Coloured + ", IndianOrAsian=" + IndianOrAsian + ", Other=" + Other + ", TotalPopulation=" + TotalPopulation + ", White=" + White + '}';
    }
}

/**
 * <p>
 * Represents WaterDetails obtained from AfriGIS Census Service call
 * </p>
 */
class WaterDetails {

    private int Borehole;

    public int getBorehole() {
        return this.Borehole;
    }

    public void setBorehole(int Borehole) {
        this.Borehole = Borehole;
    }

    private int DamPoolStagnantWater;

    public int getDamPoolStagnantWater() {
        return this.DamPoolStagnantWater;
    }

    public void setDamPoolStagnantWater(int DamPoolStagnantWater) {
        this.DamPoolStagnantWater = DamPoolStagnantWater;
    }

    private int Other;

    public int getOther() {
        return this.Other;
    }

    public void setOther(int Other) {
        this.Other = Other;
    }

    private int RainWaterTank;

    public int getRainWaterTank() {
        return this.RainWaterTank;
    }

    public void setRainWaterTank(int RainWaterTank) {
        this.RainWaterTank = RainWaterTank;
    }

    private int RiverStream;

    public int getRiverStream() {
        return this.RiverStream;
    }

    public void setRiverStream(int RiverStream) {
        this.RiverStream = RiverStream;
    }

    private int ServicedWater;

    public int getServicedWater() {
        return this.ServicedWater;
    }

    public void setServicedWater(int ServicedWater) {
        this.ServicedWater = ServicedWater;
    }

    private int Spring;

    public int getSpring() {
        return this.Spring;
    }

    public void setSpring(int Spring) {
        this.Spring = Spring;
    }

    private int TotalHouseholds;

    public int getTotalHouseholds() {
        return this.TotalHouseholds;
    }

    public void setTotalHouseholds(int TotalHouseholds) {
        this.TotalHouseholds = TotalHouseholds;
    }

    private int WaterTanker;

    public int getWaterTanker() {
        return this.WaterTanker;
    }

    public void setWaterTanker(int WaterTanker) {
        this.WaterTanker = WaterTanker;
    }

    private int WaterVendor;

    public int getWaterVendor() {
        return this.WaterVendor;
    }

    public void setWaterVendor(int WaterVendor) {
        this.WaterVendor = WaterVendor;
    }

    @Override
    public String toString() {
        return "WaterDetails{" + "Borehole=" + Borehole + ", DamPoolStagnantWater=" + DamPoolStagnantWater + ", Other=" + Other + ", RainWaterTank=" + RainWaterTank + ", RiverStream=" + RiverStream + ", ServicedWater=" + ServicedWater + ", Spring=" + Spring + ", TotalHouseholds=" + TotalHouseholds + ", WaterTanker=" + WaterTanker + ", WaterVendor=" + WaterVendor + '}';
    }

}

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
        return "Census{" + "AgId=" + AgId + ", SpCode=" + SpCode + ", Name=" + Name + ", AgeDetails=" + AgeDetails + ", DwellingDetails=" + DwellingDetails + ", HouseholdIncomeDetails=" + HouseholdIncomeDetails + ", IndividualIncomeDetails=" + IndividualIncomeDetails + ", EmploymentStatusDetails=" + EmploymentStatusDetails + ", GenderDetails=" + GenderDetails + ", LandUseDetails=" + LandUseDetails + ", LanguageDetails=" + LanguageDetails + ", PopulationGroupDetails=" + PopulationGroupDetails + ", WaterDetails=" + WaterDetails + ", GeoJson=" + GeoJson + ", Latitude=" + Latitude + ", Longitude=" + Longitude + '}';
    }
}
