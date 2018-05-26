package org.imat.dbpedia;

public class DBPediaType implements Comparable<DBPediaType>{
	private String name;	
	private int subTypeCount;
	
	
	
	public DBPediaType(String name, int subTypeCount) {
		super();
		this.name = name;
		this.subTypeCount = subTypeCount;
	}	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSubTypeCount() {
		return subTypeCount;
	}

	public void setSubTypeCount(int subTypeCount) {
		this.subTypeCount = subTypeCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DBPediaType other = (DBPediaType) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(DBPediaType o) {
		// TODO Auto-generated method stub
		return this.getSubTypeCount() - o.getSubTypeCount();
	}

	@Override
	public String toString() {
		return "DBPediaType [name=" + name + ", subTypeCount=" + subTypeCount + "]";
	}
	
	
	
}
