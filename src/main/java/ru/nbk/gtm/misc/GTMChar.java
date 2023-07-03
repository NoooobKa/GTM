package ru.nbk.gtm.misc;

public enum GTMChar {

    SMALL_SQUARE("▫"),
    FILLED_SMALL_SQUARE("▪"),
    RELOAD_CHAR("ᴿ"),
    RELOAD_LINE("┋┋┋┋┋┋┋┋┋┋┋┋┋┋┋┋┋┋┋┋");

    private String chart;

    private GTMChar(String chart) {
        this.chart = chart;
    }

    public String toString() {
        return chart;
    }

}
