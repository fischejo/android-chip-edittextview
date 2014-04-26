package de.pecheur.chips;

import android.os.Build;

public class ChipsUtil {

    /**
     * @return true when the caller can use Chips UI in its environment.
     */
    public static boolean supportsChipsUi() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH;
    }
}