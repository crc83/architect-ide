/*
 * generated by Xtext 2.16.0
 */
package org.sbelei.archide.web

import com.google.inject.Guice
import com.google.inject.Injector
import org.eclipse.xtext.util.Modules2
import org.sbelei.archide.ProjectWbsRuntimeModule
import org.sbelei.archide.ProjectWbsStandaloneSetup
import org.sbelei.archide.ide.ProjectWbsIdeModule

/**
 * Initialization support for running Xtext languages in web applications.
 */
class ProjectWbsWebSetup extends ProjectWbsStandaloneSetup {
	
	override Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new ProjectWbsRuntimeModule, new ProjectWbsIdeModule, new ProjectWbsWebModule))
	}
	
}
