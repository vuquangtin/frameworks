package com.swing.download.observer;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/

 *      vuquangtin/frameworks</a>
 *
 */

public class ProgressRenderer extends JProgressBar implements TableCellRenderer {
	// Constructor for ProgressRenderer.
	public ProgressRenderer(int min, int max) {
		super(min, max);
	}

	/*
	 * Returns this JProgressBar as the renderer for the given table cell.
	 */
	public Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column) {
		// Set JProgressBar's percent complete value.
		setValue((int) ((Float) value).floatValue());
		return this;
	}
}