package com.lmc.der.sixComposers.client.entrypoint;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.gwt.der.lib.client.DERSymbolMenu;
import com.gwt.der.lib.client.handlers.ServerRequestsFactory;
import com.gwt.der.lib.client.menu.ControlPanel;
import com.gwt.der.lib.client.upload.UploadPanel;
import com.lmc.der.sixComposers.client.ui.AMA_UI;
import com.lmc.der.sixComposers.client.ui.DER_UI;
import com.lmc.der.sixComposers.client.ui.FSTRA_UI;
import com.lmc.der.sixComposers.client.ui.Hersh_UI;
import com.lmc.der.sixComposers.client.ui.PA_UI;
import com.lmc.der.sixComposers.client.ui.Utero_UI;


public class SixComposersEntryPoint implements EntryPoint{	
	
	private  DER_UI UIObj;
	private  String DERName;	
	
	public SixComposersEntryPoint() {
		String hashName=Window.Location.getHash().toLowerCase();
		DERName = (hashName.length()==0)?"ama":hashName.substring(1);
		if (DERName.equals("utero")) DERName = "ua";
		if (DERName.equals("hersh")) DERName = "ha";
		
		Window.setTitle(DERName.toUpperCase());		
			
				if(DERName.equals("ama")){			
					UIObj = new AMA_UI();
				}else if(DERName.equals("fstra")){
						UIObj = new FSTRA_UI();
					}else if(DERName.equals("mpa")){
							UIObj = new PA_UI('M');
						}else if(DERName.equals("fpa")){
								UIObj = new PA_UI('F');
							}else if(DERName.equals("ha")){
									UIObj = new Hersh_UI();
								}else if(DERName.equals("ua")){
										UIObj = new Utero_UI();
									}else UIObj = null;
				Grid attGrid = new Grid(1,2);
				attGrid.setWidget(0, 0, new UploadPanel(DERName.toUpperCase()));
				Label attHintLabel =
						new Label("Only files with one of the following extentions will be rendered in the generated docx:" +
								" .txt, .rtf, .htm, .html, .xht, .xhtml, .mht, .docx," +
								" .dotx, .docm, .dotm, .jpg, .gif, .tiff, .bmp, .png." +
								" Please, use only correct files, otherwise a corrupted docx will be produced. ");
				attHintLabel.setWidth("50ex");
				attGrid.setWidget(0, 1, attHintLabel);
				UIObj.add(attGrid,"Attachments");
			
	}	
	
	@Override
	public void onModuleLoad() {
//		setDERTypeInHtml();
		RootPanel root = RootPanel.get("rootPanel");
		Grid rootGrid = new Grid(2,1);
		rootGrid.setWidget(0,0,new ControlPanel(DERName.toUpperCase(), "Version 1.10"));
		rootGrid.setWidget(1,0,UIObj);		
		ServerRequestsFactory.initiateSession(root, rootGrid);
		DERSymbolMenu symMenu = new DERSymbolMenu();
		symMenu.addStyleName("menuSym");
		root.add(symMenu);
		
	}
//		
//	private native void	setDERTypeInHtml()/*-{
//		var DERName =
//			this.@com.lmc.der.sixComposers.client.entrypoint.SixComposersEntryPoint::DERName;
//		DERName = DERName.toUpperCase();   
//		$doc.getElementById("derTypeInput").value=DERName;
//		$doc.getElementById("saveAnchor").href += DERName;		
//		$doc.getElementById("docAnchor").href += DERName;
//		$doc.getElementById("clearAnchor").href += DERName;
//		//$doc.getElementById("rootPanel").innerHTML="DERName: "+$doc.getElementById("docAnchor").href;	
//	 }-*/;
	

}
