package Languages;

import java.util.ArrayList;

import Units.Unit;

public class TurkishLanguage extends Language{

	public TurkishLanguage(ArrayList<Unit> units) {
		super(units,LanguageName.Turkish);
	}
	public TurkishLanguage() {
		super(LanguageName.Turkish);
	}
}
