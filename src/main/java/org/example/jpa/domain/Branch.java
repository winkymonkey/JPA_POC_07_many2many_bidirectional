package org.example.jpa.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;


@Entity
public class Branch {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "BRANCH_ID")
	private int branchId;

	@Column(name = "BRANCH_NAME")
	private String branchName;

	@Column(name = "BRANCH_SHORT_NAME")
	private String branchShortName;

	@Column(name = "DESCRIPTION")
	private String description;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="BRANCH_SUBJECT", 
		joinColumns={@JoinColumn(name="BRANCH_ID")}, 
		inverseJoinColumns={@JoinColumn(name="SUBJECT_ID")}
	)
	private Set<Subject> subjects;
	
	
	
	/* *************************************************************** */
	public int getBranchId() {
		return this.branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getBranchName() {
		return this.branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public String getBranchShortName() {
		return this.branchShortName;
	}
	public void setBranchShortName(String branchShortName) {
		this.branchShortName = branchShortName;
	}
	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public void addSubject(Subject subject){
		this.subjects.add(subject);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + branchId;
		result = prime * result + ((branchName == null) ? 0 : branchName.hashCode());
		result = prime * result + ((branchShortName == null) ? 0 : branchShortName.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Branch other = (Branch) obj;
		if (branchId != other.branchId)
			return false;
		if (branchName == null) {
			if (other.branchName != null)
				return false;
		} else if (!branchName.equals(other.branchName))
			return false;
		if (branchShortName == null) {
			if (other.branchShortName != null)
				return false;
		} else if (!branchShortName.equals(other.branchShortName))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}
	
}