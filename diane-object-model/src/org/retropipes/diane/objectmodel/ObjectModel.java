/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.objectmodel;

import java.io.Serializable;
import java.util.List;
import java.util.Collections;
import java.util.Objects;

public final class ObjectModel implements Serializable {
    private static final long serialVersionUID = -2268558531513356337L;
    private ObjectId id;
    private List<Integer> counters;
    private List<Boolean> flags;

    public ObjectModel() {
    }

    public final void addCounters(final int count) {
        this.counters.addAll(Collections.nCopies(count, 0));
    }

    public final void addFlags(final int count) {
        this.flags.addAll(Collections.nCopies(count, false));
    }

    public final void addOneCounter() {
        this.counters.add(0);
    }

    public final void addOneFlag() {
        this.flags.add(false);
    }

    public final void decrementCounter(final int index) {
        if (index >= 0 && index < this.counters.size()) {
            this.counters.set(index, this.counters.get(index) - 1);
        }
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof final ObjectModel other)) {
            return false;
        }
        return Objects.equals(this.counters, other.counters) && Objects.equals(this.flags, other.flags)
                && this.id == other.id;
    }

    public final int getCounter(final int index) {
        if (index >= 0 && index < this.counters.size()) {
            return this.counters.get(index);
        }
        return 0;
    }

    public final List<Integer> getCounters() {
        return this.counters;
    }

    public final boolean getFlag(final int index) {
        if (index >= 0 && index < this.flags.size()) {
            return this.flags.get(index);
        }
        return false;
    }

    public final List<Boolean> getFlags() {
        return this.flags;
    }

    public final ObjectId getId() {
        return this.id;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(this.counters, this.flags, this.id);
    }

    public final void incrementCounter(final int index) {
        if (index >= 0 && index < this.counters.size()) {
            this.counters.set(index, this.counters.get(index) + 1);
        }
    }

    public final int maxCounters() {
        return this.counters.size();
    }

    public final int maxFlags() {
        return this.flags.size();
    }

    public final void offsetCounter(final int index, final int value) {
        if (index >= 0 && index < this.counters.size()) {
            this.counters.set(index, this.counters.get(index) + value);
        }
    }

    public final void setCounter(final int index, final int value) {
        if (index >= 0 && index < this.counters.size()) {
            this.counters.set(index, value);
        }
    }

    public final void setCounters(final List<Integer> value) {
        this.counters = value;
    }

    public final void setFlag(final int index, final boolean value) {
        if (index >= 0 && index < this.flags.size()) {
            this.flags.set(index, value);
        }
    }

    public final void setFlags(final List<Boolean> value) {
        this.flags = value;
    }

    public final void setId(ObjectId newId) {
        this.id = newId;
    }

    public final void toggleFlag(final int index) {
        if (index >= 0 && index < this.flags.size()) {
            this.flags.set(index, !this.flags.get(index));
        }
    }
}
