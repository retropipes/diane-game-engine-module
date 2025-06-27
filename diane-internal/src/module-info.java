module org.retropipes.diane.internal {
    requires transitive java.desktop;

    exports org.retropipes.diane;
    exports org.retropipes.diane.internal to org.retropipes.diane, org.retropipes.diane.asset.ogg,
            org.retropipes.diane.gameshell, org.retropipes.diane.gui;
}