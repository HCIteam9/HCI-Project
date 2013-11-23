package data;

public class userData {
	private boolean game_mode;
	private boolean room_maker;
	private String name;
	private boolean bgm;
	private boolean soundeffect;
	private int Single_high,Multy_high,Online_rank;
	private boolean ready;
	
	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}

	public static userData usr = new userData();
	
	
	public int getSingle_high() {
		return Single_high;
	}

	public void setSingle_high(int single_high) {
		Single_high = single_high;
	}

	public int getMulty_high() {
		return Multy_high;
	}

	public void setMulty_high(int multy_high) {
		Multy_high = multy_high;
	}

	public int getOnline_rank() {
		return Online_rank;
	}

	public void setOnline_rank(int online_rank) {
		Online_rank = online_rank;
	}

	public boolean isGame_mode() {
		return game_mode;
	}

	public void setGame_mode(boolean game_mode) {
		this.game_mode = game_mode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public userData()
	{
		bgm=true;
		soundeffect=true;
	}

	public boolean isBgm() {
		return bgm;
	}

	public void setBgm(boolean bgm) {
		this.bgm = bgm;
	}

	public boolean isSoundeffect() {
		return soundeffect;
	}

	public void setSoundeffect(boolean soundeffect) {
		this.soundeffect = soundeffect;
	}

	public boolean isRoom_maker() {
		return room_maker;
	}

	public void setRoom_maker(boolean room_maker) {
		this.room_maker = room_maker;
	}
}
