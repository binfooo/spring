

package org.springframework.web.jsf;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseListener;
import javax.faces.lifecycle.Lifecycle;

/**
 * @author Juergen Hoeller
 * @since 29.01.2006
 */
public class MockLifecycle extends Lifecycle {

	@Override
	public void addPhaseListener(PhaseListener phaseListener) {
	}

	@Override
	public void execute(FacesContext facesContext) throws FacesException {
	}

	@Override
	public PhaseListener[] getPhaseListeners() {
		return null;
	}

	@Override
	public void removePhaseListener(PhaseListener phaseListener) {
	}

	@Override
	public void render(FacesContext facesContext) throws FacesException {
	}

}