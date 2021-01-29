

package org.springframework.ui.context;

import org.springframework.lang.Nullable;

/**
 * Sub-interface of ThemeSource to be implemented by objects that
 * can resolve theme messages hierarchically.
 *
 * @author Jean-Pierre Pawlak
 * @author Juergen Hoeller
 */
public interface HierarchicalThemeSource extends ThemeSource {

	/**
	 * Set the parent that will be used to try to resolve theme messages
	 * that this object can't resolve.
	 * @param parent the parent ThemeSource that will be used to
	 * resolve messages that this object can't resolve.
	 * May be {@code null}, in which case no further resolution is possible.
	 */
	void setParentThemeSource(@Nullable ThemeSource parent);

	/**
	 * Return the parent of this ThemeSource, or {@code null} if none.
	 */
	@Nullable
	ThemeSource getParentThemeSource();

}
