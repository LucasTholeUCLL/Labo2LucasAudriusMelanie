package domain;

public enum DecoderStrategyType {
	CEZAR ("domain.strategys.CezarCode"),
	BACKCODE ("domain.strategys.BackCode"),
	TEST ("domain.strategys.testCode"),
	RANDOM ("domain.strategys.RandomCypherAdapter");
  
	private final String klasseNaam; 
		
	DecoderStrategyType(String klasseNaam) {
	    this.klasseNaam = klasseNaam;
	}
		
	public String getKlasseNaam() { return klasseNaam; }
}
