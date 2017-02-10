package com.lmc.der.sixComposers.client.widgets.tables.fstra;

public class FSTRATable16 extends FSTRASeverityTable {
	
	public FSTRATable16(){
		columns=28;HeaderedCols=12;//16 added	
		BasePath="FSTRA||ResultsAndDiscussion>>AddlMaleHistopatology>>ResultsSeverityTable";
		this.setHTML(0, 0, "Treatment<br/>(mg a.i../L)<br/>[measured]");		
		this.setHTML(0, 1, "Additional Diagnostic Observations<SUP>1</SUP>");
		
		this.setHTML(1, 0, "Sev<br/>erity");
		this.setHTML(1, 1, "Decreased<br/>Proportion of<br/>Spermatogonia");
		this.setHTML(1, 2, "Increased Vascular<br/>or Interstitial<br/>Proteinaceous Fluid");
		this.setHTML(1, 3, "Asynchronous<br/>Gondal<br/>Development");
		this.setHTML(1, 4, "Altered Proportions<br/>of Spermatocytes<br/>or Spermatids");
		this.setHTML(1, 5, "Granulomatous<br/>Inflammation");
		
		completeTable();
	}
}
