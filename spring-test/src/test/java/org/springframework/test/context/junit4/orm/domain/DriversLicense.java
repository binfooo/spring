

package org.springframework.test.context.junit4.orm.domain;

/**
 * DriversLicense POJO.
 *
 * @author Sam Brannen
 * @since 3.0
 */
public class DriversLicense {

	private Long id;

	private Long number;


	public DriversLicense() {
	}

	public DriversLicense(Long number) {
		this(null, number);
	}

	public DriversLicense(Long id, Long number) {
		this.id = id;
		this.number = number;
	}

	public Long getId() {
		return this.id;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	public Long getNumber() {
		return this.number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
