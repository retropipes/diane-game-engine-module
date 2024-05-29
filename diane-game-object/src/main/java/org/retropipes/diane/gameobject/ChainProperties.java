/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.gameobject;

import java.util.Objects;

import org.retropipes.diane.direction.DirectionQuery;
import org.retropipes.diane.storage.FlagStorage;

class ChainProperties {
	// Properties
	private final FlagStorage chainData;

	// Constructors
	public ChainProperties() {
		this.chainData = new FlagStorage(DirectionQuery.values().length);
	}

	@Override
	public boolean equals(final Object obj) {
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		final var other = (ChainProperties) obj;
		if (!Objects.equals(this.chainData, other.chainData)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final var hash = 3;
		return 89 * hash + Objects.hashCode(this.chainData);
	}

	public boolean isDirectionallyChainReacting(final DirectionQuery dir) {
		try {
			if (dir != DirectionQuery.NONE) {
				return this.chainData.getCell(dir.ordinal());
			}
			return false;
		} catch (final ArrayIndexOutOfBoundsException aioob) {
			return false;
		}
	}

	public void setDirectionallyChainReacting(final DirectionQuery dir, final boolean value) {
		this.chainData.setCell(value, dir.ordinal());
	}
}
