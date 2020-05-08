package com.generic.dao.models;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Video extends SortedObject implements Serializable {

	
	private Integer id;

	
	private String videoURL;

	
	private String videoName;

	private String videoDescription;

	
	private Category category;

	
	protected Date dateCreated;

	public Video() {
		dateCreated = new Date();
		type = TYPE.TYPE_VIDEO;
	}

	public Video(String videoURL, String videoName, String videoDescription) {
		this();
		this.videoURL = videoURL;
		this.videoName = videoName;
		this.videoDescription = videoDescription;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the videoURL
	 */
	public String getVideoURL() {
		return videoURL;
	}

	/**
	 * @param videoURL
	 *            the videoURL to set
	 */
	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	/**
	 * @return the videoName
	 */
	public String getVideoName() {
		return videoName;
	}

	/**
	 * @param videoName
	 *            the videoName to set
	 */
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	/**
	 * @return the videoDescription
	 */
	public String getVideoDescription() {
		return videoDescription;
	}

	/**
	 * @param videoDescription
	 *            the videoDescription to set
	 */
	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}

	/**
	 * @return the category
	 */
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * @return the dateCreated
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated
	 *            the dateCreated to set
	 */
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return getVideoName();
	}

	@Override
	public String getName() {
		return getVideoName();
	}

}