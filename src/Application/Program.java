package Application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department dep=new Department(1,"Books");
		
		System.out.println(dep);
		
		Seller seller=new Seller(2, "Bob", "bob@gmail.com", new Date(), 1000, dep);
		
		System.out.println(seller);

		SellerDao sd=DaoFactory.createSellerDao();
	}

}
