/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.point;

public class Point4D extends Point3D {
    public int w;

    public Point4D() {
    }

    public Point4D(final int nx, final int ny, final int nz, final int nw) {
	super(nx, ny, nz);
	this.w = nw;
    }
}
