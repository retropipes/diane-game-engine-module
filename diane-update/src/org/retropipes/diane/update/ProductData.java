/*  Diane Game Engine
Copyleft (C) 2019 Eric Ahnell

Any questions should be directed to the author via email at: support@puttysoftware.com
 */
package org.retropipes.diane.update;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ProductData {
    public static final int CODE_PRE_ALPHA = 0;
    public static final int CODE_ALPHA = 1;
    public static final int CODE_BETA = 2;
    public static final int CODE_RELEASE_CANDIDATE = 3;
    public static final int CODE_STABLE = 4;
    // Fields
    private final URL updateURL;
    private final URL newVersionURL;
    private final String versionString, shortVersionString;
    private final int majorVersion;
    private final int minorVersion;
    private final int bugfixVersion;
    private final int codeVersion;
    private final int prereleaseVersion;

    // Constructors
    public ProductData(final int major, final int minor, final int bugfix, final int code, final int beta) {
	String rt_vl, rt_vs;
	if (code == ProductData.CODE_PRE_ALPHA) {
	    if (beta > 0) {
		rt_vl = "-pre" + beta;
		rt_vs = "p" + beta;
	    } else {
		rt_vl = "-pre";
		rt_vs = "p";
	    }
	} else if (code == ProductData.CODE_ALPHA) {
	    if (beta > 0) {
		rt_vl = "-alpha" + beta;
		rt_vs = "a" + beta;
	    } else {
		rt_vl = "-alpha";
		rt_vs = "a";
	    }
	} else if (code == ProductData.CODE_BETA) {
	    if (beta > 0) {
		rt_vl = "-beta" + beta;
		rt_vs = "b" + beta;
	    } else {
		rt_vl = "-beta";
		rt_vs = "b";
	    }
	} else if (code == ProductData.CODE_RELEASE_CANDIDATE) {
	    if (beta > 0) {
		rt_vl = "-rc" + beta;
		rt_vs = "c" + beta;
	    } else {
		rt_vl = "-rc";
		rt_vs = "c";
	    }
	} else {
	    rt_vl = "";
	    rt_vs = "";
	}
	this.versionString = major + "." + minor + "." + bugfix + rt_vl;
	this.shortVersionString = major + "." + minor + "." + bugfix + rt_vs;
	this.updateURL = null;
	this.newVersionURL = null;
	this.majorVersion = major;
	this.minorVersion = minor;
	this.bugfixVersion = bugfix;
	this.codeVersion = code;
	this.prereleaseVersion = beta;
    }

    public ProductData(final String update, final String newVersion, final int major, final int minor, final int bugfix,
	    final int code, final int beta) throws MalformedURLException, URISyntaxException {
	String rt_url;
	String rt_vl, rt_vs;
	if (code == ProductData.CODE_PRE_ALPHA) {
	    if (beta > 0) {
		rt_vl = "-pre" + beta;
		rt_vs = "p" + beta;
	    } else {
		rt_vl = "-pre";
		rt_vs = "p";
	    }
	    rt_url = "pre_"; //$NON-NLS-1$
	} else if (code == ProductData.CODE_ALPHA) {
	    if (beta > 0) {
		rt_vl = "-alpha" + beta;
		rt_vs = "a" + beta;
	    } else {
		rt_vl = "-alpha";
		rt_vs = "a";
	    }
	    rt_url = "alpha_"; //$NON-NLS-1$
	} else if (code == ProductData.CODE_BETA) {
	    if (beta > 0) {
		rt_vl = "-beta" + beta;
		rt_vs = "b" + beta;
	    } else {
		rt_vl = "-beta";
		rt_vs = "b";
	    }
	    rt_url = "beta_"; //$NON-NLS-1$
	} else if (code == ProductData.CODE_RELEASE_CANDIDATE) {
	    if (beta > 0) {
		rt_vl = "-rc" + beta;
		rt_vs = "c" + beta;
	    } else {
		rt_vl = "-rc";
		rt_vs = "c";
	    }
	    rt_url = "rc_"; //$NON-NLS-1$
	} else {
	    rt_url = "stable_"; //$NON-NLS-1$
	    rt_vl = "";
	    rt_vs = "";
	}
	this.versionString = major + "." + minor + "." + bugfix + rt_vl;
	this.shortVersionString = major + "." + minor + "." + bugfix + rt_vs;
	final var updatetxt = "version.txt"; //$NON-NLS-1$
	this.updateURL = new URI(update + rt_url + updatetxt).toURL();
	this.newVersionURL = new URI(newVersion).toURL();
	this.majorVersion = major;
	this.minorVersion = minor;
	this.bugfixVersion = bugfix;
	this.codeVersion = code;
	this.prereleaseVersion = beta;
    }

    /**
     * Performs a check for updates.
     *
     * @return true if an update is available; false otherwise
     */
    public UpdateCheckResults checkForUpdates() throws IOException {
	if (this.updateURL != null && this.newVersionURL != null) {
	    var newMajor = this.majorVersion;
	    var newMinor = this.minorVersion;
	    var newBugfix = this.bugfixVersion;
	    var newPrerelease = this.prereleaseVersion;
	    try (var isr = new InputStreamReader(this.updateURL.openStream()); var br = new BufferedReader(isr)) {
		newMajor = Integer.parseInt(br.readLine());
		newMinor = Integer.parseInt(br.readLine());
		newBugfix = Integer.parseInt(br.readLine());
		newPrerelease = Integer.parseInt(br.readLine());
	    }
	    final var hasUpdate = new UpdateCheckResults(newMajor, newMinor, newBugfix, newPrerelease);
	    if (newMajor > this.majorVersion || newMajor == this.majorVersion && newMinor > this.minorVersion) {
		return hasUpdate;
	    }
	    if (newMajor == this.majorVersion && newMinor == this.minorVersion && newBugfix > this.bugfixVersion) {
		return hasUpdate;
	    }
	    if (newMajor == this.majorVersion && newMinor == this.minorVersion && newBugfix == this.bugfixVersion
		    && newPrerelease > this.prereleaseVersion) {
		return hasUpdate;
	    }
	}
	return new UpdateCheckResults();
    }

    /**
     * @return the bugfix version
     */
    public int getBugfixVersion() {
	return this.bugfixVersion;
    }

    /**
     * @return the code version
     */
    public int getCodeVersion() {
	return this.codeVersion;
    }

    /**
     * @return the major version
     */
    public int getMajorVersion() {
	return this.majorVersion;
    }

    /**
     * @return the minor version
     */
    public int getMinorVersion() {
	return this.minorVersion;
    }

    /**
     * @return the newVersionURL
     */
    public URL getNewVersionURL() {
	return this.newVersionURL;
    }

    /**
     * @return the prerelease version
     */
    public int getPrereleaseVersion() {
	return this.prereleaseVersion;
    }

    /**
     * @return the version as a short string
     */
    public String getShortVersionString() {
	return this.shortVersionString;
    }

    // Methods
    /**
     * @return the updateURL
     */
    public URL getUpdateURL() {
	return this.updateURL;
    }

    /**
     * @return the version as a string
     */
    public String getVersionString() {
	return this.versionString;
    }
}
