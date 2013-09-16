package org.openmrs.module.coreapps.page.controller.findpatient;

import org.openmrs.api.context.Context;
import org.openmrs.module.appframework.domain.AppDescriptor;
import org.openmrs.ui.framework.page.PageModel;
import org.openmrs.util.OpenmrsConstants;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 */
public class FindPatientPageController {
	
	/**
	 * This page is built to be shared across multiple apps. To use it, you must pass an "app"
	 * request parameter, which must be the id of an existing app that is an instance of
	 * coreapps.template.findPatient
	 * 
	 * @param model
	 * @param app
	 */
	public void get(PageModel model, @RequestParam("app") AppDescriptor app) {
		model.addAttribute("afterSelectedUrl", app.getConfig().get("afterSelectedUrl").getTextValue());
		model.addAttribute("heading", app.getConfig().get("label").getTextValue());
		model.addAttribute("label", app.getConfig().get("label").getTextValue());
		model.addAttribute("minSearchCharacters",
		    Context.getAdministrationService()
		            .getGlobalProperty(OpenmrsConstants.GLOBAL_PROPERTY_MIN_SEARCH_CHARACTERS, "1"));
	}
	
}
