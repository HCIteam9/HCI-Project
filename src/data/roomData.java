package data;

import java.util.ArrayList;

public class roomData {
	private int max_size;
	private ArrayList<String> players;
	private String psswd;
	private String gamename;
	private boolean selected;
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}

	public static roomData rdat = new roomData(0,"","",new ArrayList<String>());
	
	public roomData(int max_size,String psswd,String gamename,ArrayList<String> players)
	{
		this.max_size=max_size;
		this.psswd=psswd;
		this.gamename=gamename;
		this.players = players;
	}
	public roomData getInstance()
	{
		return rdat;
	}
	public void setInstance(String gamename,int max_size,String psswd,ArrayList<String> players)
	{
		this.gamename=gamename;
		this.max_size=max_size;
		this.psswd=psswd;
		this.players = players;
	}

	public int getMax_size() {
		return max_size;
	}

	public void setMax_size(int max_size) {
		this.max_size = max_size;
	}

	public ArrayList<String> getPlayer() {
		return players;
	}

	public void setPlayer(ArrayList<String> player) {
		this.players = player;
	}

	public String getPsswd() {
		return psswd;
	}

	public void setPsswd(String psswd) {
		this.psswd = psswd;
	}
}
