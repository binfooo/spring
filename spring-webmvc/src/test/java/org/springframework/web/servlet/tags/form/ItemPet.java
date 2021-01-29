

package org.springframework.web.servlet.tags.form;

import java.beans.PropertyEditorSupport;

/**
 * @author Juergen Hoeller
 */
public class ItemPet {

	private String name;

	public ItemPet(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return this.name.toUpperCase();
	}

	@Override
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ItemPet)) {
			return false;
		}
		ItemPet otherPet = (ItemPet) other;
		return (this.name != null && this.name.equals(otherPet.getName()));
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}


	public static class CustomEditor extends PropertyEditorSupport {

		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(new ItemPet(text));
		}

		@Override
		public String getAsText() {
			return ((ItemPet) getValue()).getName();
		}
	}

}
