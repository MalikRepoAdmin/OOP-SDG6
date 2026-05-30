package views.utils;

import javax.swing.*;

/**
 * Placeholder for future animation utilities.
 *
 * Can later be expanded for:
 * - fade animation
 * - loading transition
 * - notification slide
 */
public final class UIAnimator {

    private UIAnimator() {
    }

    public static void flashComponent(JComponent component) {

        component.repaint();
    }
}