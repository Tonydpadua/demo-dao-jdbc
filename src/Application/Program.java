package Application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println("===TEST findById===");
		Department dep=new Department(1,"Books");
		Seller seller=new Seller(2, "Bob", "bob@gmail.com", new Date(), 1000, dep);

		SellerDao sd=DaoFactory.createSellerDao();
		
		System.out.println();
		System.out.println("===TEST findById===");
		Seller seller1=sd.findById(3);
		System.out.println(seller1);
		
		System.out.println();
		System.out.println("===TEST findByDepartment===");
		List<Seller> list=sd.findByDepartmentId(dep);
		for(Seller obj:list) {
			System.out.println(obj);
		}
		
		System.out.println();
		System.out.println("==TEST findAll===");
		list=sd.findAll();
		for(Seller obj:list) {
			System.out.println(obj);
		}
	}
	
	

}
