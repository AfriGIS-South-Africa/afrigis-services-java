package com.afrigis.services.search.extension;

/**
 * <p>
 * Represents LanguageDetails obtained from AfriGIS Census Service call
 * </p>
 *
 * @author Takalani
 */
public class LanguageDetails {

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
        final StringBuilder builder = new StringBuilder();
        builder.append("LanguageDetails{Afrikaans=");
        builder.append(Afrikaans);
        builder.append(", English=");
        builder.append(English);
        builder.append(", Isindebele=");
        builder.append(Isindebele);
        builder.append(", Isixhosa=");
        builder.append(Isixhosa);
        builder.append(", Isizulu=");
        builder.append(Isizulu);
        builder.append(", Sepedi=");
        builder.append(Sepedi);
        builder.append(", Sesotho=");
        builder.append(Sesotho);
        builder.append(", Setswana=");
        builder.append(Setswana);
        builder.append(", SignLanguage=");
        builder.append(SignLanguage);
        builder.append(", Siswati=");
        builder.append(Siswati);
        builder.append(", Tshivenda=");
        builder.append(Tshivenda);
        builder.append(", Xitsonga=");
        builder.append(Xitsonga);
        builder.append(", Unspecified=");
        builder.append(Unspecified);
        builder.append(", NotApplicable=");
        builder.append(NotApplicable);
        builder.append("}");
        return builder.toString();
    }

}
