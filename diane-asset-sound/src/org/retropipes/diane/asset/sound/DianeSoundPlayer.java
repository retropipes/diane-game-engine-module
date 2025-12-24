/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.asset.sound;

import java.net.URL;

public final class DianeSoundPlayer {
    // Constants
    protected static final int EXTERNAL_BUFFER_SIZE = 4096; // 4Kb

    public static void play(final DianeSoundIndex index) {
	new SoundResource(index.getURL()).play();
    }

    public static void playSource(final URL source) {
	new SoundResource(source).play();
    }

    // Constructor
    protected DianeSoundPlayer() {
    }
}
