/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.objectmodel;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Object model storage. Useful as a back-end for grids etc.
 */
public class ObjectModelStorage implements Serializable {
	private static final long serialVersionUID = 7722462288276213114L;
	// Fields
	/**
	 * The underlying ArrayList where data is stored.
	 */
	protected ArrayList<ObjectModel> dataStore;
	/**
	 * The shape of the data storage.
	 */
	protected int[] dataShape;
	/**
	 * Intermediate products used for location conversion.
	 */
	protected int[] interProd;

	// Constructors
	/**
	 * Serialization-related constructor.
	 */
	public ObjectModelStorage() {
	}

	/**
	 * Main constructor.
	 *
	 * @param shape simulated dimensions for the stored data
	 */
	public ObjectModelStorage(final int... shape) {
		this.dataShape = shape;
		this.interProd = new int[this.dataShape.length];
		var product = 1;
		for (var x = 0; x < this.dataShape.length; x++) {
			this.interProd[x] = product;
			product *= this.dataShape[x];
		}
		this.dataStore = new ArrayList<ObjectModel>(product);
		// Populate storage
		for (var x = 0; x < product; x++) {
			this.dataStore.add(null);
		}
	}

	/**
	 * Copy constructor.
	 *
	 * @param source the @self to make a copy of
	 */
	public ObjectModelStorage(final ObjectModelStorage source) {
		this.dataShape = source.dataShape;
		this.interProd = new int[this.dataShape.length];
		var product = 1;
		for (var x = 0; x < this.dataShape.length; x++) {
			this.interProd[x] = product;
			product *= this.dataShape[x];
		}
		this.dataStore = new ArrayList<>(source.dataStore);
	}

	/**
	 * Check for equality.
	 *
	 * @param other the other ObjectModel to check
	 * @return true if equal, false otherwise
	 */
	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (other == null || !(other instanceof final ObjectModelStorage instance)
				|| this.dataStore.equals(instance.dataStore)) {
			return false;
		}
		return true;
	}

	/**
	 * Fill the storage with the same data everywhere.
	 *
	 * @param value the data to fill with
	 */
	public final void fill(final ObjectModel value) {
		var limit = this.getRawLength();
		for (var x = 0; x < limit; x++) {
			this.dataStore.set(x, value);
		}
	}

	/**
	 * Get data at a given location in storage.
	 *
	 * @param location the location to get data from
	 * @return the data at that location
	 */
	public final ObjectModel getCell(final int... location) {
		final var rawLoc = this.ravelLocation(location);
		return this.dataStore.get(rawLoc);
	}

	/**
	 * Get data directly from the underlying array. To convert a simulated index to
	 * a raw index, use ravelLocation().
	 *
	 * @param rawLocation the index within the array to get data from
	 * @return the data at that index
	 */
	protected final ObjectModel getRawCell(final int rawLocation) {
		return this.dataStore.get(rawLocation);
	}

	/**
	 * Get the length of the underlying array.
	 *
	 * @return the underlying array length
	 */
	protected final int getRawLength() {
		return this.dataStore.size();
	}

	/**
	 * Get the underlying storage.
	 *
	 * @return the underlying storage
	 */
	public final ArrayList<ObjectModel> getDataStore() {
		return this.dataStore;
	}

	/**
	 * Get the shape (dimensions) of the storage.
	 *
	 * @return the shape, as an array of integers
	 */
	public final int[] getShape() {
		return this.dataShape;
	}

	/**
	 * Get the intermediate products, used for location conversion.
	 *
	 * @return the intermediate products, as an array of integers
	 */
	public final int[] getInterProd() {
		return this.interProd;
	}

	/**
	 * Set the underlying storage.
	 *
	 * @param value the new underlying storage
	 */
	public final void setDataStore(final ArrayList<ObjectModel> value) {
		this.dataStore = value;
	}

	/**
	 * Set the shape (dimensions) of the storage.
	 *
	 * @param value the new shape, as an array of integers
	 */
	public final void setShape(final int[] value) {
		this.dataShape = value;
	}

	/**
	 * Set the intermediate products, used for location conversion.
	 *
	 * @param value the intermediate products, as an array of integers
	 */
	public final void setInterProd(final int[] value) {
		this.interProd = value;
	}

	/**
	 * Hashing support.
	 */
	@Override
	public int hashCode() {
		final var prime = 31;
		final var result = 1;
		return prime * result + this.dataStore.hashCode();
	}

	/**
	 * Utility to convert simulated indexes to raw indexes.
	 *
	 * @param location a simulated index
	 * @return a raw index
	 */
	protected final int ravelLocation(final int... location) {
		var res = 0;
		// Sanity check #1
		if (location.length != this.interProd.length) {
			throw new IllegalArgumentException(Integer.toString(location.length));
		}
		for (var x = 0; x < this.interProd.length; x++) {
			// Sanity check #2
			if (location[x] < 0 || location[x] >= this.dataShape[x]) {
				throw new ArrayIndexOutOfBoundsException(location[x]);
			}
			res += location[x] * this.interProd[x];
		}
		return res;
	}

	/**
	 * Utility to change the shape.
	 *
	 * @param shape new simulated dimensions for the stored data
	 * @return a raw index
	 */
	protected final void reshape(final int... shape) {
		this.dataShape = shape;
		this.interProd = new int[this.dataShape.length];
		var product = 1;
		for (var x = 0; x < this.dataShape.length; x++) {
			this.interProd[x] = product;
			product *= this.dataShape[x];
		}
		this.dataStore = new ArrayList<ObjectModel>(product);
		// Populate storage
		for (var x = 0; x < product; x++) {
			this.dataStore.add(null);
		}
	}

	/**
	 * Change stored data at a given location.
	 *
	 * @param value    the new data value
	 * @param location the location to modify
	 */
	public final void setCell(final ObjectModel value, final int... location) {
		final var rawLoc = this.ravelLocation(location);
		this.dataStore.set(rawLoc, value);
	}

	/**
	 * Change stored data directly in the underlying array. To convert a simulated
	 * index to a raw index, use ravelLocation().
	 *
	 * @param value       the new data value
	 * @param rawLocation the index to modify
	 */
	protected final void setRawCell(final ObjectModel value, final int rawLocation) {
		this.dataStore.set(rawLocation, value);
	}
}
