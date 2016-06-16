package models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang3.builder.ToStringBuilder;

import play.data.validation.Constraints;

@Entity
public class Person extends com.avaje.ebean.Model {

	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	@Constraints.Required
	public String name;

	@Constraints.Required
	public String country;

	/**
	 * Generic query helper for entity Company with id Long
	 */
	public static Find<Long, Person> find = new Find<Long, Person>() {
	};

	public static List<Person> findAll(String filter) {
		return Person.find.where().ilike("name", "%" + filter + "%")
				.orderBy("id").findList();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
