package org.retropipes.diane.objectmodel;

import java.io.Serializable;

/**
 * A simple interface meant to be implemented by an enumeration representing an
 * object identifier.
 */
public interface ObjectId extends Serializable {

	int ordinal();
}
