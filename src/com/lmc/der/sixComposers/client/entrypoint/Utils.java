package com.lmc.der.sixComposers.client.entrypoint;

import com.google.gwt.user.client.Element;

public class Utils {
	
	public static native Element findActiveElement()/*-{
		return $doc.activeElement;
	}-*/;

}
