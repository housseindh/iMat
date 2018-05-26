package org.imat.dbpedia;

import java.util.Comparator;

public class DBPediaTypeComparator implements Comparator<DBPediaType> {
	@Override
	public int compare(DBPediaType x, DBPediaType y) {		
		return x.getSubTypeCount()-y.getSubTypeCount();
	}
}
