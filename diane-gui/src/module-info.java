module org.retropipes.diane.gui {
	requires transitive java.desktop;
	requires transitive org.retropipes.diane.asset.image;
	requires transitive org.retropipes.diane.asset.music;
	requires transitive org.retropipes.diane.fileio;
	requires transitive org.retropipes.diane.storage;
	requires transitive org.retropipes.diane.utility;
	requires org.retropipes.diane.internal;

	exports org.retropipes.diane.gui;
	exports org.retropipes.diane.gui.dialog;
}