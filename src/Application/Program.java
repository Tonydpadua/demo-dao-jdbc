package Application;

import java.util.Date;

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
		
		Seller seller1=sd.findById(3);
		System.out.println(seller1);
	}

}
