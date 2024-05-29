module org.retropipes.diane.vorbis {
	requires transitive java.desktop;
	requires transitive java.logging;

	provides javax.sound.sampled.spi.AudioFileReader
			with org.retropipes.diane.vorbis.vorbis.sampled.spi.VorbisAudioFileReader;
	provides javax.sound.sampled.spi.FormatConversionProvider
			with org.retropipes.diane.vorbis.vorbis.sampled.spi.VorbisFormatConversionProvider;
}