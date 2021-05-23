/*******************************************************************************
 * Copyright 2018, 2020 Jorel Ali (Skepter) - MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *******************************************************************************/
package dev.jorel.commandapi.wrappers;

import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;

/**
 * A representation of scoreboard display slots, as well as team colors for the sidebar
 */
public class ScoreboardSlot {

	private final DisplaySlot displaySlot;
	private final ChatColor teamColor;
	
	/**
	 * Determines the scoreboard slot value based on an internal Minecraft integer
	 * @param i the scoreboard slot value
	 */
	public ScoreboardSlot(int i) {
		//Initialize displaySlot
		displaySlot = switch(i) {
			case 0  -> DisplaySlot.PLAYER_LIST;
			case 1  -> DisplaySlot.SIDEBAR;
			case 2  -> DisplaySlot.BELOW_NAME;
			default -> DisplaySlot.SIDEBAR;
		};
		
		//Initialize teamColor
		teamColor = switch(i) {
			case 3  -> ChatColor.BLACK;
			case 4  -> ChatColor.DARK_BLUE;
			case 5  -> ChatColor.DARK_GREEN;
			case 6  -> ChatColor.DARK_AQUA;
			case 7  -> ChatColor.DARK_RED;
			case 8  -> ChatColor.DARK_PURPLE;
			case 9  -> ChatColor.GOLD;
			case 10 -> ChatColor.GRAY;
			case 11 -> ChatColor.DARK_GRAY;
			case 12 -> ChatColor.BLUE;
			case 13 -> ChatColor.GREEN;
			case 14 -> ChatColor.AQUA;
			case 15 -> ChatColor.RED;
			case 16 -> ChatColor.LIGHT_PURPLE;
			case 17 -> ChatColor.YELLOW;
			case 18 -> ChatColor.WHITE;
			default -> null;
		};
	}
	
	/**
	 * Constructs a ScoreboardSlot from a DisplaySlot
	 * @param slot the display slot to convert into a ScoreboardSlot
	 * @return a ScoreboardSlot from the provided DisplaySlot
	 */
	public static ScoreboardSlot of(DisplaySlot slot) {
		return switch(slot) {
		case PLAYER_LIST -> new ScoreboardSlot(0);
		case SIDEBAR     -> new ScoreboardSlot(1);
		case BELOW_NAME  -> new ScoreboardSlot(2);
		default          -> new ScoreboardSlot(1);
		};
	}
	
	/**
	 * Constructs a ScoreboardSlot from a ChatColor
	 * @param color the chat color to convert into a ScoreboardSlot
	 * @return a ScoreboardSlot from the provided ChatColor
	 */
	public static ScoreboardSlot ofTeamColor(ChatColor color) {
		return switch (color) {
		case BLACK        -> new ScoreboardSlot(3);
		case DARK_BLUE    -> new ScoreboardSlot(4);
		case DARK_GREEN   -> new ScoreboardSlot(5);
		case DARK_AQUA    -> new ScoreboardSlot(6);
		case DARK_RED     -> new ScoreboardSlot(7);
		case DARK_PURPLE  -> new ScoreboardSlot(8);
		case GOLD         -> new ScoreboardSlot(9);
		case GRAY         -> new ScoreboardSlot(10);
		case DARK_GRAY    -> new ScoreboardSlot(11);
		case BLUE         -> new ScoreboardSlot(12);
		case GREEN        -> new ScoreboardSlot(13);
		case AQUA         -> new ScoreboardSlot(14);
		case RED          -> new ScoreboardSlot(15);
		case LIGHT_PURPLE -> new ScoreboardSlot(16);
		case YELLOW       -> new ScoreboardSlot(17);
		case WHITE        -> new ScoreboardSlot(18);
		default           -> new ScoreboardSlot(1);
		};
	}
	
	/**
	 * Gets the display slot of this scoreboard slot.
	 * @return this scoreboard slot's display slot
	 */
	public DisplaySlot getDisplaySlot() {
		return this.displaySlot;
	}
	
	/**
	 * Gets the team color of this scoreboard slot.
	 * @return this scoreboard slot's team color, or null if a team color is not present
	 */
	public ChatColor getTeamColor() {
		return this.teamColor;
	}
	
	/**
	 * Returns whether this scoreboard slot has a team color.
	 * @return true if this scoreboard slot has a team color
	 */
	public boolean hasTeamColor() {
		return teamColor != null;
	}
	
	/**
	 * Returns the Minecraft string representation of this scoreboard slot
	 * @return the Minecraft string representation of this scoreboard slot
	 */
	@Override
	public String toString() {
		if(teamColor != null) {
			return "sidebar.team." + teamColor.name().toLowerCase();
		} else {
			return switch(displaySlot) {
			case PLAYER_LIST -> "list";
			case SIDEBAR     -> "sidebar";
			case BELOW_NAME  -> "belowName";
			default          -> "sidebar";
			};
		}
	}
}
