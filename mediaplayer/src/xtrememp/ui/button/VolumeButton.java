/**
 * Xtreme Media Player a cross-platform media player.
 * Copyright (C) 2005-2010 Besmir Beqiri
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package xtrememp.ui.button;

import java.awt.Dimension;
import org.pushingpixels.substance.api.SubstanceLookAndFeel;
import xtrememp.ui.button.shaper.RoundSquareButtonShaper;
import xtrememp.util.Utilities;

/**
 *
 * @author Besmir Beqiri
 */
public final class VolumeButton extends PopupButton {
    
    private int min = 0;
    private int max = 0;
    
    public VolumeButton(int min, int max, int value, boolean muted) {
        this.min = min;
        this.max = max;
        if (muted) {
            this.setVolumeMutedIcon();
        } else {
            this.setVolumeIcon(value);
        }
        this.setPreferredSize(new Dimension(24, 24));
        this.putClientProperty(SubstanceLookAndFeel.BUTTON_SHAPER_PROPERTY, new RoundSquareButtonShaper());
    }
    
    public void setVolumeIcon(int volume) {
        if (volume <= max) {
            this.setIcon(Utilities.AUDIO_VOLUME_HIGH_ICON);
        }
        if (volume <= Math.round(2.0f * (max - min) / 3.0f)) {
            this.setIcon(Utilities.AUDIO_VOLUME_MEDIUM_ICON);
        }
        if (volume <= Math.round((max - min) / 3.0f)) {
            this.setIcon(Utilities.AUDIO_VOLUME_LOW_ICON);
        }
        if (volume == min) {
            setVolumeMutedIcon();
        }
    }
    
    public void setVolumeMutedIcon() {
        this.setIcon(Utilities.AUDIO_VOLUME_MUTED_ICON);
    }
}
