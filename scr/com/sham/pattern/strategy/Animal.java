package com.sham.pattern.strategy;

public class Animal {
	
	/**
	 * 
	 */
	private String name;
	private String height;
	private String favFood;
	private String sound;
	private Fly flyType;

	/**
	 * @return the flyType
	 */
	public Fly getFlyType() {
		return flyType;
	}

	/**
	 * @param flyType the flyType to set
	 */
	public void setFlyType(Fly flyType) {
		this.flyType = flyType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getFavFood() {
		return favFood;
	}

	public void setFavFood(String favFood) {
		this.favFood = favFood;
	}

	/**
	 * @return the sound
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * @param sound the sound to set
	 */
	public void setSound(String sound) {
		this.sound = sound;
	}

}
