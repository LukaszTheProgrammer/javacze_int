public enum Symbols {

    BIEDRONKA("Bi"),
    KONICZYNA("Ko"),
    KAKTUS("Ka"),
    ZEGAR("Ze"),
    BOMBA("Bo"),
    IGLO("Ig"),
    OKULARY("Ok"),
    KLUCZ("Kl"),
    LUDZIK("Lu"),
    CZASZKA("Cz"),
    PLAMA("Pl"),
    DOBLE("Do"),
    SNIEZKA("Sn"),
    SWIECA("Sw"),
    KOTWICA("Kotw"),
    ZAKAZ("Za"),
    USTA("Us"),
    KROPLA("Kr"),
    LISC("Li"),
    OGIEN("Og"),
    ZOLW("Zo"),
    WIOLINOWY("Wi"),
    RUMIANEK("Ru"),
    WYKRZYKNIK("Wy"),
    AUTO("Au"),
    KLODKA("Klo"),
    LOD("Lo"),
    BUTELKA("Bu"),
    PIES("Pi"),
    SERCE("Se"),
    KSIEZYC("Ks"),
    DUCH("Du"),
    SLONCE("Sl"),
    PAJECZYNA("Paj"),
    CEL("Cel"),
    JINJANG("JJ"),
    DELFIN("De"),
    NOZYCZKI("Noz"),
    KLAUN("Klau"),
    SER("Ser"),
    SMOK("Sm"),
    PAJAK("Paja"),
    KURCZAK("Kur"),
    ZAROWKA("Zar"),
    MARCHEWKA("Mar"),
    BALWAN("Bal"),
    ZNAK_ZAPYTANIA("ZZ"),
    JABLKO("JB"),
    KONIK("KON"),
    PTAK("PT"),
    DRZEWO("DRZ"),
    OKO("OKO"),
    OLOWEK("OLO"),
    DINOZAUR("DINO"),
    KOT("KOT");
    private String symbol;
    Symbols(String skrot) {
    this.symbol=skrot;
    }

    public String getSymbol() {
        return symbol;
    }
}