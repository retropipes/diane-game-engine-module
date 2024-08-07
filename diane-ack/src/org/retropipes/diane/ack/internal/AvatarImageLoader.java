/*  Diane Game Engine
Copyleft (C) 2019-present Eric Ahnell
Any questions should be directed to the author via email at: support@puttysoftware.com */
package org.retropipes.diane.ack.internal;

import org.retropipes.diane.ack.AvatarImageModel;
import org.retropipes.diane.asset.image.BufferedImageIcon;
import org.retropipes.diane.asset.image.ColorReplaceRules;
import org.retropipes.diane.asset.image.DianeImageLoader;
import org.retropipes.diane.asset.image.ImageCompositor;

public class AvatarImageLoader {
    public static BufferedImageIcon load(final int familyID, final ColorReplaceRules rules) {
	final var imageExt = ".png";
	final var name = "/asset/ack/avatar/" + Integer.toHexString(familyID).toUpperCase() + imageExt;
	return rules.applyAll(DianeImageLoader.load(name, AvatarImageLoader.class.getResource(name)));
    }

    public static BufferedImageIcon loadAccessory(final int accessoryID, final ColorReplaceRules rules) {
	final var imageExt = ".png";
	final var name = "/asset/ack/accessory/" + Integer.toHexString(accessoryID).toUpperCase() + imageExt;
	return rules.applyAll(DianeImageLoader.load(name, AvatarImageLoader.class.getResource(name)));
    }

    public static BufferedImageIcon loadFromModel(final AvatarImageModel model) {
	final var imageExt = ".png";
	final var name = "/asset/ack/avatar/" + Integer.toHexString(model.getAvatarFamilyID()).toUpperCase() + imageExt;
	var image = DianeImageLoader.load(name, AvatarImageLoader.class.getResource(name));
	image = model.getRules().applyAll(image);
	final var weaponImage = AvatarImageLoader.loadWeapon(model.getAvatarWeaponID(), model.getWeaponRules());
	final var accessoryImage = AvatarImageLoader.loadAccessory(model.getAvatarAccessoryID(),
		model.getAccessoryRules());
	return ImageCompositor.composite(name, image, accessoryImage, weaponImage);
    }

    public static BufferedImageIcon loadWeapon(final int weaponID, final ColorReplaceRules rules) {
	final var imageExt = ".png";
	final var name = "/asset/ack/weapon/" + Integer.toHexString(weaponID).toUpperCase() + imageExt;
	return rules.applyAll(DianeImageLoader.load(name, AvatarImageLoader.class.getResource(name)));
    }
}
