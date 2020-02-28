package Application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DepartmentDao dd=DaoFactory.createDepartmentDao();		
		int id=1;
		Department d=dd.findById(id);
		
		
		Department updateDep=dd.findById(2);
		
		//updateDep.setName("Food");
		
		//dd.update(updateDep);
		System.out.println("Update Complete");
		
		Department deletDep=dd.findById(4);
		//dd.deletById(5);
		System.out.println("Deleted successfully");
		
		//Department insertDep=new Department(null, "Cars");
		//dd.insert(insertDep);
		System.out.println("Inserted");
		
		System.out.println(dd.findAll());
		
		
	}

}
