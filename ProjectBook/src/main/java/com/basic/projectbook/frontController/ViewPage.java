package com.basic.projectbook.frontController;

public class ViewPage {
	public static String makeView(String controllerAction) {
		return "/WEB-INF/" + controllerAction + ".jsp";
	}
}
