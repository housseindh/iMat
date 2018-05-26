package org.imat.wordnet;

import java.util.ArrayList;
import java.util.Collection;

import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;

public class WordNet {

	private WordNetDatabase database;

	public WordNet() {
		setDatabase(WordNetDatabase.getFileInstance());
	}

	public boolean hasMeaning(String s) {
		Synset[] synsets = getDatabase().getSynsets(s, SynsetType.NOUN);
		if (synsets.length > 0)
			return true;
		else
			return false;
	}

	public boolean isComposedOfNouns(String s) {
		String[] split = s.split(" ");
		int cpt = 0;
		for (String i : split) {
			if (this.isNoun(i))
				cpt++;
		}
		if (cpt == split.length)
			return true;
		else
			return false;
	}

	public boolean isInstance1(String s) {
		Synset[] synsets = getDatabase().getSynsets(s, SynsetType.NOUN, false);
		if (synsets.length == 0)
			return false;
		NounSynset n = ((NounSynset) synsets[0]);
		if (n.getInstanceHypernyms().length > 0)
			return true;
		if (n.getInstanceHyponyms().length > 0)
			return false;
		if (!(n.getHyponyms().length > 0))
			return true;
		else
			return false;
	}

	public boolean isInstance(String s) {
		Synset[] synsets = getDatabase().getSynsets(s, SynsetType.NOUN, false);
		if (synsets.length == 0)
			return false;
		NounSynset n = ((NounSynset) synsets[0]);
		if (n.getInstanceHypernyms().length > 0)
			return true;
		if (n.getInstanceHyponyms().length > 0)
			return false;
		if ((n.getHyponyms().length > 0)) {
			System.out.println("noun:" + s + " is instance? " + n);
			NounSynset[] nounSynset = n.getHypernyms();
			if (isSynonymInstance(nounSynset))
				return true;
			else
				return false;
		}

		else
			return true;
	}

	private boolean isSynonymInstance(NounSynset[] nounSynset) {
		int counterInstSyn = 0;
		if (nounSynset.length == 0)
			return false;
		NounSynset n = ((NounSynset) nounSynset[0]);
		for (NounSynset nounSynset2 : n.getHyponyms()) {
			if (isAInstance(nounSynset2))
				counterInstSyn++;
		}
		double avgInstance = (double) counterInstSyn / n.getHyponyms().length;
		System.out.println("avgInstance for " + n + " = " + avgInstance);
		if (avgInstance > 0.7)
			return true;
		return false;
	}

	private boolean isAInstance(NounSynset n) {

		if (n.getInstanceHypernyms().length > 0)
			return true;
		if (n.getInstanceHyponyms().length > 0)
			return false;
		if (!(n.getHyponyms().length > 0))
			return true;
		else
			return false;
	}

	public boolean isNoun(String s) {
		Synset[] synsets = getDatabase().getSynsets(s, SynsetType.NOUN);
		if (!(synsets.length > 0))
			return false;
		NounSynset n = ((NounSynset) synsets[0]);
		if (n.getHypernyms().length > 0)
			return true;
		else
			return false;
	}

	public Collection<String> getTypes(String s) {
		ArrayList<String> res = new ArrayList<String>();
		Synset[] synsets = getDatabase().getSynsets(s, SynsetType.NOUN);

		NounSynset n = ((NounSynset) synsets[0]);
		synsets = n.getInstanceHypernyms();
		if (synsets.length > 0) {
			n = ((NounSynset) synsets[0]);
			for (String noun : n.getWordForms()) {
				//System.out.println(noun + ": " + n.getTagCount(i) );
				res.add(noun.trim().replace(" ", "_").toLowerCase());
			}
		} else {
			synsets = n.getHypernyms();
			n = ((NounSynset) synsets[0]);
			for (String noun : n.getWordForms()) {
				//System.out.println(i + ": " + n.getTagCount(i) );				
				res.add(noun.trim().replace(" ", "_").toLowerCase());
			}
		}
		return res;
	}

	public WordNetDatabase getDatabase() {
		return database;
	}

	public void setDatabase(WordNetDatabase database) {
		this.database = database;
	}
}
