/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.gameobject;

import org.retropipes.diane.storage.ObjectStorage;

public class GameObjectMap {
	// Properties
	private final ObjectStorage<GameObject> data;

	// Constructors
	public GameObjectMap(final int... dimensions) {
		this.data = new ObjectStorage<>(dimensions);
	}

	public void fill(final GameObject with) {
		this.data.fill(with);
	}

	public GameObject getCell(final int... location) {
		return (GameObject) this.data.getCell(location);
	}

	public int getSize(final int dimension) {
		return this.data.getShape()[dimension];
	}

	public void setCell(final GameObject o, final int... location) {
		this.data.setCell(o, location);
	}
}
