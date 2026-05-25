package views.base;

import java.awt.*;

/**
 * Centralized theme configuration.
 */
public final class BaseTheme {

    public static final Color PRIMARY = new Color(33, 150, 243);

    public static final Color SUCCESS = new Color(76, 175, 80);

    public static final Color DANGER = new Color(244, 67, 54);

    public static final Color BACKGROUND = new Color(245, 245, 245);

    public static final Font DEFAULT_FONT = new Font(
            "SansSerif",
            Font.PLAIN,
            14
    );

    private BaseTheme() {
    }
}