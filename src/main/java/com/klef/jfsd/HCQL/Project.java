package com.klef.jfsd.HCQL;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Project_Table")
public class Project
{
	@Id
	@Column(name = "fid")
    private int id;
	@Column(name="fprojectname",length = 50,nullable = false)
    private String Projectname;
		@Column(name="fteamlead",length = 30,nullable = false)
    private String Teamlead;
	@Column(name="fbudget",nullable = false)
    private double Budget;
	@Column(name="fduration",length = 20,nullable = false,unique = true)
    private String Duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProjectname() {
		return Projectname;
	}
	public void setProjectname(String projectname) {
		Projectname = projectname;
	}
	public String getTeamlead() {
		return Teamlead;
	}
	public void setTeamlead(String teamlead) {
		Teamlead = teamlead;
	}
	public double getBudget() {
		return Budget;
	}
	public void setBudget(double budget) {
		Budget = budget;
	}
	public String getDuration() {
		return Duration;
	}
	public void setDuration(String duration) {
		Duration = duration;
	}
	
}