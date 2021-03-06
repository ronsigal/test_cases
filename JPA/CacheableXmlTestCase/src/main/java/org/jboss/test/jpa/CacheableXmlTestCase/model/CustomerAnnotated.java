package org.jboss.test.jpa.CacheableXmlTestCase.model;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Cacheable(true)
@Table(name = "CUSTOMER_ANNO")
public class CustomerAnnotated implements Serializable, ICustomer {

	@Id
	@GeneratedValue
	@Column(name = "CUST_ID")
	protected Long id;

	@NotNull
	@Size(min = 1, max = 25)
	@Pattern(regexp = "[A-Za-z ]*", message = "must contain only letters and spaces")
	@Column(name = "CUST_NAME")
	protected String name;

	@Column(name = "CUST_CREDIT")
	protected Integer availableCredit;

	public CustomerAnnotated() {

	}

	public CustomerAnnotated(String name, Integer credit) {
		this.name = name;
		this.availableCredit = credit;
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

	public Integer getAvailableCredit() {
		return availableCredit;
	}

	public void setAvailableCredit(Integer availableCredit) {
		this.availableCredit = availableCredit;
	}

	@Override
	public Class<?> getCustomerClass() {
		return this.getClass();
	}

	@Override
	public String getEntityTable() {
		return "CUSTOMER_ANNO";
	}
}