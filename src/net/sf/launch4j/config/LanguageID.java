package net.sf.launch4j.config;

public enum LanguageID {
    ARABIC(0x0401, Messages.getString("Language.arabic")),
    BULGARIAN(0x0402, Messages.getString("Language.bulgarian")),
    CATALAN(0x0403, Messages.getString("Language.catalan")),
    TRADITIONAL_CHINESE(0x0404, Messages.getString("Language.traditional.chinese")),
    CZECH(0x0405, Messages.getString("Language.czech")),
    DANISH(0x0406, Messages.getString("Language.danish")),
    GERMAN(0x0407, Messages.getString("Language.german")),
    GREEK(0x0408, Messages.getString("Language.greek")),
    ENGLISH_US(0x0409, Messages.getString("Language.english.us")),
    POLISH(0x0415, Messages.getString("Language.polish")),
    PORTUGUESE_BRAZIL(0x0416, Messages.getString("Language.portuguese.brazil")),
    RHAETO_ROMANIC(0x0417, Messages.getString("Language.rhaeto.romanic")),
    ROMANIAN(0x0418, Messages.getString("Language.romanian")),
    RUSSIAN(0x0419, Messages.getString("Language.russian")),
    CASTILIAN_SPANISH(0x040A, Messages.getString("Language.castilian.spanish")),
    FINNISH(0x040B, Messages.getString("Language.finnish")),
    FRENCH(0x040C, Messages.getString("Language.french")),
    HEBREW(0x040D, Messages.getString("Language.hebrew")),
    HUNGARIAN(0x040E, Messages.getString("Language.hungarian")),
    ICELANDIC(0x040F, Messages.getString("Language.icelandic")),
    ITALIAN(0x0410, Messages.getString("Language.italian")),
    JAPANESE(0x0411, Messages.getString("Language.japanese")),
    KOREAN(0x0412, Messages.getString("Language.korean")),
    DUTCH(0x0413, Messages.getString("Language.dutch")),
    NORWEGIAN_BOKMAL(0x0414, Messages.getString("Language.norwegian.bokmal")),
    CROATO_SERBIAN_LATIN(0x041A, Messages.getString("Language.croato.serbian.latin")),
    SLOVAK(0x041B, Messages.getString("Language.slovak")),
    ALBANIAN(0x041C, Messages.getString("Language.albanian")),
    SWEDISH(0x041D, Messages.getString("Language.swedish")),
    THAI(0x041E, Messages.getString("Language.thai")),
    TURKISH(0x041F, Messages.getString("Language.turkish")),
    URDU(0x0420, Messages.getString("Language.urdu")),
    BAHASA(0x0421, Messages.getString("Language.bahasa")),
    SIMPLIFIED_CHINESE(0x0804, Messages.getString("Language.simplified.chinese")),
    SWISS_GERMAN(0x0807, Messages.getString("Language.german.swiss")),
    ENGLISH_UK(0x0809, Messages.getString("Language.english.uk")),
    SPANISH_MEXICO(0x080A, Messages.getString("Language.spanish.mexico")),
    FRENCH_BELGIAN(0x080C, Messages.getString("Language.belgian.french")),
    FRENCH_CANADIAN(0x0C0C, Messages.getString("Language.canadian.french")),
    ITALIAN_SWISS(0x0810, Messages.getString("Language.swiss.italian")),
    DUTCH_BELGIAN(0x0813, Messages.getString("Language.belgian.dutch")),
    NORWEGIAN_NYNORSK(0x0814, Messages.getString("Language.norwegian.nynorsk")),
    PORTUGUESE_PORTUGAL(0x0816, Messages.getString("Language.portuguese.portugal")),
    SERBO_CROATIAN_CYRILLIC(0x081A, Messages.getString("Language.serbo.croatian.cyrillic")),
    FRENCH_SWISS(0x100C, Messages.getString("Language.french.swiss")),
    ;

    private final int id;
    private final String description;

    LanguageID(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
