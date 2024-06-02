module org.retropipes.diane.asset.ogg {
	requires transitive java.desktop;
	requires org.retropipes.diane.vorbis;
	requires org.retropipes.diane.internal;

	exports org.retropipes.diane.asset.ogg;

	uses javax.sound.sampled.spi.AudioFileReader;
	uses javax.sound.sampled.spi.FormatConversionProvider;
}