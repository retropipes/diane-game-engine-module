/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.fileio;

import java.io.DataInput;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class DataIOUtilities {
	public static String decodeWindowsStringData(final byte[] data) {
		return Charset.forName("ISO-8859-1").decode(ByteBuffer.wrap(data)).toString();
	}

	public static long readUnsignedInt(final DataInput data) throws IOException {
		long val = data.readInt();
		if (val < 0) {
			val += 0X100000000L;
		}
		return val;
	}

	public static int unsignedShortByteArrayToInt(final byte[] d) {
		if (d == null || d.length != 2) {
			return 0x0;
		}
		return 0xff & d[0] | (0xff & d[1]) << 8;
	}
}
