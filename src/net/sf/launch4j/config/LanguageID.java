package net.sf.launch4j.config;

public enum LanguageID {
	ALBANIAN(0x041C, Messages.getString("Language.albanian")),
    ARABIC(0x0401, Messages.getString("Language.arabic")),
    BAHASA(0x0421, Messages.getString("Language.bahasa")),
    DUTCH_BELGIAN(0x0813, Messages.getString("Language.belgian.dutch")),
    FRENCH_BELGIAN(0x080C, Messages.getString("Language.belgian.french")),
    BULGARIAN(0x0402, Messages.getString("Language.bulgarian")),
    FRENCH_CANADIAN(0x0C0C, Messages.getString("Language.canadian.french")),
    CASTILIAN_SPANISH(0x040A, Messages.getString("Language.castilian.spanish")),
    CATALAN(0x0403, Messages.getString("Language.catalan")),
    CROATO_SERBIAN_LATIN(0x041A, Messages.getString("Language.croato.serbian.latin")),
    CZECH(0x0405, Messages.getString("Language.czech")),
    DANISH(0x0406, Messages.getString("Language.danish")),
    DUTCH(0x0413, Messages.getString("Language.dutch")),
    ENGLISH_UK(0x0809, Messages.getString("Language.english.uk")),
    ENGLISH_US(0x0409, Messages.getString("Language.english.us")),
    FINNISH(0x040B, Messages.getString("Language.finnish")),
    FRENCH(0x040C, Messages.getString("Language.french")),
    GERMAN(0x0407, Messages.getString("Language.german")),
    GREEK(0x0408, Messages.getString("Language.greek")),
    HEBREW(0x040D, Messages.getString("Language.hebrew")),
    HUNGARIAN(0x040E, Messages.getString("Language.hungarian")),
    ICELANDIC(0x040F, Messages.getString("Language.icelandic")),
    ITALIAN(0x0410, Messages.getString("Language.italian")),
    JAPANESE(0x0411, Messages.getString("Language.japanese")),
    KOREAN(0x0412, Messages.getString("Language.korean")),
    NORWEGIAN_BOKMAL(0x0414, Messages.getString("Language.norwegian.bokmal")),
    NORWEGIAN_NYNORSK(0x0814, Messages.getString("Language.norwegian.nynorsk")),
    POLISH(0x0415, Messages.getString("Language.polish")),
    PORTUGUESE_BRAZIL(0x0416, Messages.getString("Language.portuguese.brazil")),
    PORTUGUESE_PORTUGAL(0x0816, Messages.getString("Language.portuguese.portugal")),
    RHAETO_ROMANIC(0x0417, Messages.getString("Language.rhaeto.romanic")),
    ROMANIAN(0x0418, Messages.getString("Language.romanian")),
    RUSSIAN(0x0419, Messages.getString("Language.russian")),
    SERBO_CROATIAN_CYRILLIC(0x081A, Messages.getString("Language.serbo.croatian.cyrillic")),
    SIMPLIFIED_CHINESE(0x0804, Messages.getString("Language.simplified.chinese")),
    SLOVAK(0x041B, Messages.getString("Language.slovak")),
    SPANISH_MEXICO(0x080A, Messages.getString("Language.spanish.mexico")),
    SWEDISH(0x041D, Messages.getString("Language.swedish")),
    FRENCH_SWISS(0x100C, Messages.getString("Language.swiss.french")),
    GERMAN_SWISS(0x0807, Messages.getString("Language.swiss.german")),
    ITALIAN_SWISS(0x0810, Messages.getString("Language.swiss.italian")),
    THAI(0x041E, Messages.getString("Language.thai")),
    TRADITIONAL_CHINESE(0x0404, Messages.getString("Language.traditional.chinese")),
    TURKISH(0x041F, Messages.getString("Language.turkish")),
    URDU(0x0420, Messages.getString("Language.urdu")),
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
