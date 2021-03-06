/*
* GoGrinder - a program to practice Go problems
* Copyright (c) 2004-2006 Tim Kington
* timkington@users.sourceforge.net
*
* This program is free software; you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation; either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program; if not, write to the Free Software
* Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*
*/

package GoGrinder.editor;

import java.awt.Point;

import GoGrinder.Main;
import GoGrinder.WGFController;
import GoGrinder.sgf.NodeLabel;
import GoGrinder.sgf.NodeMark;
import GoGrinder.sgf.SGFParseException;
import GoGrinder.sgf.SimpleMark;

/**
 * @author tkington
 */
public class LetterTool extends EditTool {
	public LetterTool(WGFController controller) {
		super(controller);
	}
	
	public boolean mouseClicked(int x, int y, int modifiers) {
		try {
			SimpleMark m = controller.getSimpleMark(x, y, NodeMark.LABEL);
			if(m != null)
				controller.removeMark(m);
			else controller.addMark(new NodeLabel(controller.getNextLabel(),
													new Point(x, y)));
		}
		catch(SGFParseException e) {
			Main.log(e);
		}
		
		return true;
	}
}
