package com.lmc.der.sixComposers.client.communication;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.Window;
import com.lmc.der.sixComposers.client.entrypoint.IntegerSC;
import com.lmc.der.sixComposers.client.widgets.tables.FSTRA2FlexTable;

public class ServCommFSTRA2 implements RequestCallback {
	
	private final String			Path;	
	private final IntegerSC			AddValue;
	private final FSTRA2FlexTable	Table;
	public static final RequestBuilder FetchRequestBuilder;
	
	static	
	{
		FetchRequestBuilder = new RequestBuilder(RequestBuilder.POST , "/DERServer/" + "FetchServlet");		
	}

	public ServCommFSTRA2(String path,IntegerSC addValue,FSTRA2FlexTable table) {
		Path = path;AddValue = addValue;Table = table;
		callFetchServlet();
	}
	
	private final void callFetchServlet(){
		FetchRequestBuilder.setRequestData(Path + "#DEFAULT_VALUE#0");
		FetchRequestBuilder.setCallback(this);
		try {
			FetchRequestBuilder.send();			
		}catch (RequestException e) {
			Window.alert("Failed to send the request: " + e.getMessage());
		}
	}

	@Override
	public void onResponseReceived(Request request, Response response) {
		String svrResponse = response.getText();
		if (svrResponse.equals("##RETRY##")) 
			callFetchServlet();
		else{
			AddValue.set(Integer.parseInt(svrResponse));
			for(int i=0;i<AddValue.get();i++) Table.addRow(0);		
		}
	}

	@Override
	public void onError(Request request, Throwable exception) {
		Window.alert("Fail to receive the response from DERServer/FetchServelet\r\n"+
				"Requested by ServCommFSTRA2\r\n"+
				exception.getMessage() + "\r\n" +
				exception.toString());		
	}

}
