package com.cube.model.dto;

public class EmployeesDto extends DepartmentsDto{
	
   private String employee_id;
   private String department_id;
   private String grade_id;
   private String pass;
   private String name;
   private String gender;
   private String hp1;
   private String hp2;
   private String hp3;
   private String email1;
   private String email2;
   private String working;
   private String garde_name;
   private int myhappyday;
   private String group_standard;
   private String save_picture;
   private String save_folder;

   
   
public String getSave_folder() {
	return save_folder;
}
public void setSave_folder(String save_folder) {
	this.save_folder = save_folder;
}
public void setSave_picture(String save_picture) {
	this.save_picture = save_picture;
}
public String getSave_picture() {
	return save_picture;
}
public int getMyhappyday() {
	return myhappyday;
}
public void setMyhappyday(int myhappyday) {
	this.myhappyday = myhappyday;
}

public String getGarde_name() {
      return garde_name;
   }
   public void setGarde_name(String garde_name) {
      this.garde_name = garde_name;
   }
   public String getEmployee_id() {
      return employee_id;
   }
   public void setEmployee_id(String employee_id) {
      this.employee_id = employee_id;
   }
   public String getDepartment_id() {
      return department_id;
   }
   public void setDepartment_id(String department_id) {
      this.department_id = department_id;
   }
   public String getGrade_id() {
      return grade_id;
   }
   public void setGrade_id(String grade_id) {
      this.grade_id = grade_id;
   }
   public String getPass() {
      return pass;
   }
   public void setPass(String pass) {
      this.pass = pass;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public String getGender() {
      return gender;
   }
   public void setGender(String gender) {
      this.gender = gender;
   }
   public String getHp1() {
      return hp1;
   }
   public void setHp1(String hp1) {
      this.hp1 = hp1;
   }
   public String getHp2() {
      return hp2;
   }
   public void setHp2(String hp2) {
      this.hp2 = hp2;
   }
   public String getHp3() {
      return hp3;
   }
   public void setHp3(String hp3) {
      this.hp3 = hp3;
   }
   public String getEmail1() {
      return email1;
   }
   public void setEmail1(String email1) {
      this.email1 = email1;
   }
   public String getEmail2() {
      return email2;
   }
   public void setEmail2(String email2) {
      this.email2 = email2;
   }
   public String getWorking() {
      return working;
   }
   public void setWorking(String working) {
      this.working = working;
   }
	public String getGroup_standard() {
		return group_standard;
	}
	public void setGroup_standard(String group_standard) {
		this.group_standard = group_standard;
	}

}