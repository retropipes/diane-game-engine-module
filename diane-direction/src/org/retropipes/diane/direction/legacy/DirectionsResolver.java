package org.retropipes.diane.direction.legacy;

public class DirectionsResolver {
    public static final int resolve(final int dirX, final int dirY) {
	int fdX = (int) Math.signum(dirX);
	int fdY = (int) Math.signum(dirY);
	if (fdX == 0 && fdY == 0) {
	    return -1;
	} else if (fdX == 0 && fdY == -1) {
	    return 1;
	} else if (fdX == 0 && fdY == 1) {
	    return 5;
	} else if (fdX == -1 && fdY == 0) {
	    return 7;
	} else if (fdX == 1 && fdY == 0) {
	    return 3;
	} else if (fdX == 1 && fdY == 1) {
	    return 4;
	} else if (fdX == -1 && fdY == 1) {
	    return 6;
	} else if (fdX == -1 && fdY == -1) {
	    return 0;
	} else {
	    return fdX == 1 && fdY == -1 ? 2 : -2;
	}
    }

    public static final int[] unresolve(final int dir) {
	int[] res = new int[2];
	if (dir == -1) {
	    res[0] = 0;
	    res[1] = 0;
	} else if (dir == 1) {
	    res[0] = 0;
	    res[1] = -1;
	} else if (dir == 5) {
	    res[0] = 0;
	    res[1] = 1;
	} else if (dir == 7) {
	    res[0] = -1;
	    res[1] = 0;
	} else if (dir == 3) {
	    res[0] = 1;
	    res[1] = 0;
	} else if (dir == 4) {
	    res[0] = 1;
	    res[1] = 1;
	} else if (dir == 6) {
	    res[0] = -1;
	    res[1] = 1;
	} else if (dir == 0) {
	    res[0] = -1;
	    res[1] = -1;
	} else if (dir == 2) {
	    res[0] = 1;
	    res[1] = -1;
	} else {
	    res = null;
	}
	return res;
    }

    private DirectionsResolver() {
    }
}
