/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.point;

public class Point3D extends Point2D {
    public int z;

    public Point3D() {
    }

    public Point3D(final int nx, final int ny, final int nz) {
	super(nx, ny);
	this.z = nz;
    }
}
