/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.drawgrid;

import org.retropipes.diane.asset.image.BufferedImageIcon;
import org.retropipes.diane.storage.ObjectStorage;

public class DrawGrid extends ObjectStorage<BufferedImageIcon> {
    public DrawGrid(final int numSquares) {
        super(numSquares, numSquares);
    }

    public BufferedImageIcon getImageCell(final int row, final int col) {
        return this.getCell(row, col);
    }

    public void setImageCell(final BufferedImageIcon bii, final int row, final int col) {
        this.setCell(bii, row, col);
    }
}
