package net.sf.launch4j.config;

public enum CharsetID {
    /** 0x0000 */
    ASCII(0, Messages.getString("Charset.ascii")),
    /** 0x04E8 */
    ARABIC(1256, Messages.getString("Language.arabic")),
    /** 0x04E3 */
    CYRILLIC(1251, Messages.getString("Charset.cyrillic")),
    /** 0x04E5 */
    GREEK(1253, Messages.getString("Language.greek")),
    /** 0x04E7 */
    HEBREW(1255, Messages.getString("Language.hebrew")),
    /** 0x03A4 */
    SHIFT_JIS(932, Messages.getString("Charset.shift.jis")),
    /** 0x03B5 */
    SHIFT_KSC(949, Messages.getString("Charset.shift.ksc")),
    /** 0x04E2 */
    LATIN2(1250, Messages.getString("Charset.latin2")),
    /** 0x04E4 */
    MULTILINGUAL(1252, Messages.getString("Charset.multilingual")),
    /** 0x0B63 */
    BIG5(950, Messages.getString("Charset.big5")),
    /** 0x04E6 */
    TURKISH(1254, Messages.getString("Language.turkish")),
    /** 0x04B0 */
    UNICODE(1200, Messages.getString("Charset.unicode")),
    ;

    private final int id;
    private final String description;

    CharsetID(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return description;
    }
}
