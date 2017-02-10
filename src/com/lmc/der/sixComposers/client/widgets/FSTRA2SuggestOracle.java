package com.lmc.der.sixComposers.client.widgets;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.IsSerializable;
import com.google.gwt.user.client.ui.SuggestOracle;

public class FSTRA2SuggestOracle extends SuggestOracle {
	
	public static class FSTRA2Suggestion implements Suggestion, IsSerializable {
	    private String displayString;
	    private String replacementString;

	    /**
	     * Constructor used by RPC.
	     */
	    public FSTRA2Suggestion() {
	    }

	    /**
	     * Constructor for <code>MultiWordSuggestion</code>.
	     *
	     * @param replacementString the string to enter into the SuggestBox's text
	     *          box if the suggestion is chosen
	     * @param displayString the display string
	     */
	    public FSTRA2Suggestion(String replacementString, String displayString) {
	      this.replacementString = replacementString;
	      this.displayString = displayString;
	    }

	    public String getDisplayString() {
	      return displayString;
	    }

	    public String getReplacementString() {
	      return replacementString;
	    }
	  }

	
	
	private String [] SuggestionsArray;
	private String pullListChars;
	
	public FSTRA2SuggestOracle (String [] SArray,String pullChars){
		SuggestionsArray = SArray;
		pullListChars = pullChars;
	}
	
	@Override
	public boolean isDisplayStringHTML() {
	    return true;
	}
	
	@Override
	public void requestDefaultSuggestions(Request request, Callback callback) {	
		int suggNumber = Math.min(SuggestionsArray.length, request.getLimit());
		ArrayList<FSTRA2Suggestion> suggestions = new ArrayList<FSTRA2Suggestion>();
		for (int indexSA=0;indexSA<suggNumber;indexSA++)			
			suggestions.add(new FSTRA2Suggestion(unescape(SuggestionsArray[indexSA]),
					SuggestionsArray[indexSA]));
		Response response = new Response(suggestions);
		response.setMoreSuggestionsCount(SuggestionsArray.length - suggNumber);
	    callback.onSuggestionsReady(request, response);		
	}
	
	@Override
	public void requestSuggestions(Request request, Callback callback) {
		int limit = request.getLimit();
		String query = request.getQuery();
		int queryStartIndex = 0;
		if (pullListChars.length()>0){
			String [] devidedQuery = query.split('['+pullListChars+"][^"+pullListChars+"]*$",2);
	//		System.out.println(devidedQuery.length);		
			queryStartIndex = (devidedQuery.length==2)?
					devidedQuery[0].length()+1:0;
		}
//		System.out.println(queryStartIndex);
		String realQueryLolwer = query.substring(queryStartIndex).toLowerCase();
//		System.out.println(realQueryLolwer);
		int queryLength = realQueryLolwer.length();
		FSTRA2Suggestion sugg = null;
		ArrayList<FSTRA2Suggestion> suggestions = new ArrayList<FSTRA2Suggestion>();
		for (int indexSA=0;indexSA<SuggestionsArray.length;indexSA++){
			if (SuggestionsArray[indexSA].length() >= queryLength &&
					SuggestionsArray[indexSA].substring(0, queryLength).toLowerCase().equals(realQueryLolwer)){
				sugg = new FSTRA2Suggestion(query.substring(0, queryStartIndex)+
						unescape(SuggestionsArray[indexSA]),
						"<b>"+SuggestionsArray[indexSA].substring(0, queryLength)+
						"</b>"+SuggestionsArray[indexSA].substring(queryLength));
				suggestions.add(sugg);
				if (suggestions.size()==limit) break;
			}
		}
		Response response = new Response(suggestions);
//	    response.setMoreSuggestionsCount(numberTruncated);
	    callback.onSuggestionsReady(request, response);
	}
	private String unescape(String InStr){
//		StringBuilder InSB = new StringBuilder(InStr);
//		int indexSB = 0;
//		int endEscapedSymbol;
//		while ((indexSB = InSB.indexOf("&#",indexSB))>0){
//			endEscapedSymbol = InSB.indexOf(";",indexSB);
//			InSB.replace(indexSB, endEscapedSymbol+1,
//					(char)Integer.parseInt(InSB.substring(indexSB+2, endEscapedSymbol))+"");
//		}
//		return InSB.toString();
		return InStr;
	}
}
