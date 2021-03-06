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

package GoGrinder;

import GoGrinder.ui.*;

/**
 *
 * @author  tkington
 */
public abstract class Controller
{
    protected Board board;
    protected GobanPanel panel;
    
    public abstract void mouseClicked(int x, int y, int modifiers);
    public abstract void mouseWheelMoved(int numClicks);
    
    public void setPanel(GobanPanel p) { panel = p; }
    public void setBoard(Board b) { board = b; }
    public Board getBoard() { return board; }
}
