package org.example.jpa.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "SUBJECT_ID")
	private int subjectId;
	
	@Column(name = "SUBJECT_NAME")
	private String subjectName;

	@Column(name = "SUBJECT_DESC")
	private String subjectDesc;

	@ManyToMany(mappedBy = "subjects", cascade = CascadeType.ALL)
	private Set<Branch> branches = new HashSet<Branch>();
	
	
	
	/* *************************************************************** */
	public int getSubjectId() {
		return this.subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return this.subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Set<Branch> getBranches() {
		return branches;
	}
	public String getSubjectDesc() {
		return this.subjectDesc;
	}
	public void setSubjectDesc(String subjectDesc) {
		this.subjectDesc = subjectDesc;
	}
	public void setBranches(Set<Branch> branches) {
		this.branches = branches;
	}
	public void addBranch(Branch branch){
		this.branches.add(branch);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subjectDesc == null) ? 0 : subjectDesc.hashCode());
		result = prime * result + subjectId;
		result = prime * result
				+ ((subjectName == null) ? 0 : subjectName.hashCode());
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
		Subject other = (Subject) obj;
		if (subjectDesc == null) {
			if (other.subjectDesc != null)
				return false;
		} else if (!subjectDesc.equals(other.subjectDesc))
			return false;
		if (subjectId != other.subjectId)
			return false;
		if (subjectName == null) {
			if (other.subjectName != null)
				return false;
		} else if (!subjectName.equals(other.subjectName))
			return false;
		return true;
	}
	
}