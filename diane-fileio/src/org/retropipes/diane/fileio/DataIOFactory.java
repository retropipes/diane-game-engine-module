/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.fileio;

import java.io.File;
import java.io.IOException;

public final class DataIOFactory {
    private static final String CUSTOM_XML = "customxml";

    public static DataIOReader createReader(final File file) throws IOException {
	return createReader(DataMode.XML, file);
    }

    public static DataIOWriter createWriter(final File file) throws IOException {
	return createWriter(DataMode.XML, file);
    }

    public static DataIOReader createReader(final String filename) throws IOException {
	return createReader(DataMode.XML, filename);
    }

    public static DataIOWriter createWriter(final String filename) throws IOException {
	return createWriter(DataMode.XML, filename);
    }

    public static DataIOReader createReader(final DataMode mode, final File file) throws IOException {
	return switch (mode) {
	case BINARY -> new BinaryDataReader(file);
	case CUSTOM_XML -> new XDataReader(file, DataIOFactory.CUSTOM_XML);
	case GAME_IO -> new GameIODataReader(file);
	case TEXT -> new TextDataReader(file);
	case XML -> new XMLDataReader(file);
	default -> throw new IllegalArgumentException();
	};
    }

    public static DataIOReader createReader(final DataMode mode, final String filename) throws IOException {
	var file = new File(filename);
	return switch (mode) {
	case BINARY -> new BinaryDataReader(file);
	case CUSTOM_XML -> new XDataReader(file, DataIOFactory.CUSTOM_XML);
	case GAME_IO -> new GameIODataReader(file);
	case TEXT -> new TextDataReader(file);
	case XML -> new XMLDataReader(file);
	default -> throw new IllegalArgumentException();
	};
    }

    public static DataIOWriter createWriter(final DataMode mode, final File file) throws IOException {
	return switch (mode) {
	case BINARY -> new BinaryDataWriter(file);
	case CUSTOM_XML -> new XDataWriter(file, DataIOFactory.CUSTOM_XML);
	case GAME_IO -> new GameIODataWriter(file);
	case TEXT -> new TextDataWriter(file);
	case XML -> new XMLDataWriter(file);
	default -> throw new IllegalArgumentException();
	};
    }

    public static DataIOWriter createWriter(final DataMode mode, final String filename) throws IOException {
	var file = new File(filename);
	return switch (mode) {
	case BINARY -> new BinaryDataWriter(file);
	case CUSTOM_XML -> new XDataWriter(file, DataIOFactory.CUSTOM_XML);
	case GAME_IO -> new GameIODataWriter(file);
	case TEXT -> new TextDataWriter(file);
	case XML -> new XMLDataWriter(file);
	default -> throw new IllegalArgumentException();
	};
    }

    public static DataIOReader createTagReader(final String filename, final String tag) throws IOException {
	return new XDataReader(new File(filename), tag);
    }

    public static DataIOWriter createTagWriter(final String filename, final String tag) throws IOException {
	return new XDataWriter(new File(filename), tag);
    }

    private DataIOFactory() {
	// Do nothing
    }
}
