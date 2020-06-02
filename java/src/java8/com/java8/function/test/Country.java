package com.java8.function.test;
/**
 * 
 * 
 * @author EMAIL:vuquangtin@gmail.com , tel:0377443333
 * @version 1.0.0
 * @see <a href="https://github.com/vuquangtin/frameworks">https://github.com/
 *      vuquangtin/frameworks</a>
 *
 */
public class Country {

	private String name;
	
 	private Long population;
 	
 	private String continent;
 	
 	

	public Country(String name, Long population,String continent) {
		super();
		this.name = name;
		this.population = population;
		this.continent= continent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	@Override
	public String toString() {
		return "Country [name=" + name + ", population=" + population + ", continent=" + continent + "]";
	}

	 
 	
}