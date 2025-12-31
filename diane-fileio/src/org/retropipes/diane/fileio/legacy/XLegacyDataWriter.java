package org.retropipes.diane.fileio.legacy;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class XLegacyDataWriter implements AutoCloseable {
    // Fields
    private final BufferedWriter bw;
    private final File file;
    private final String docTag;
    private static final String END_OF_LINE = "\r\n";

    // Constructors
    public XLegacyDataWriter(final String filename, final String newDocTag) throws IOException {
	this.bw = new BufferedWriter(new FileWriter(filename));
	this.file = new File(filename);
	this.docTag = newDocTag;
	this.writeXMLHeader();
	this.writeOpeningDocTag();
    }

    // Methods
    public File getFile() {
	return this.file;
    }

    @Override
    public void close() throws IOException {
	this.writeClosingDocTag();
	this.bw.close();
    }

    public void writeInt(final int i) throws IOException {
	this.bw.write("<" + XLegacyDataConstants.INT_TAG + ">" + Integer.toString(i) + "</" + XLegacyDataConstants.INT_TAG + ">"
		+ XLegacyDataWriter.END_OF_LINE);
    }

    public void writeLong(final long l) throws IOException {
	this.bw.write("<" + XLegacyDataConstants.LONG_TAG + ">" + Long.toString(l) + "</" + XLegacyDataConstants.LONG_TAG + ">"
		+ XLegacyDataWriter.END_OF_LINE);
    }

    public void writeByte(final byte b) throws IOException {
	this.bw.write("<" + XLegacyDataConstants.BYTE_TAG + ">" + Byte.toString(b) + "</" + XLegacyDataConstants.BYTE_TAG + ">"
		+ XLegacyDataWriter.END_OF_LINE);
    }

    public void writeBoolean(final boolean b) throws IOException {
	this.bw.write("<" + XLegacyDataConstants.BOOLEAN_TAG + ">" + Boolean.toString(b) + "</"
		+ XLegacyDataConstants.BOOLEAN_TAG + ">" + XLegacyDataWriter.END_OF_LINE);
    }

    public void writeString(final String s) throws IOException {
	this.bw.write("<" + XLegacyDataConstants.STRING_TAG + ">" + s + "</" + XLegacyDataConstants.STRING_TAG + ">"
		+ XLegacyDataWriter.END_OF_LINE);
    }

    private void writeXMLHeader() throws IOException {
	this.bw.write(XLegacyDataConstants.X_HEADER + XLegacyDataWriter.END_OF_LINE);
    }

    private void writeOpeningDocTag() throws IOException {
	this.bw.write("<" + this.docTag + ">" + XLegacyDataWriter.END_OF_LINE);
    }

    private void writeClosingDocTag() throws IOException {
	this.bw.write("</" + this.docTag + ">");
    }
}
