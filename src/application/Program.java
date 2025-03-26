package application;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department obj = new Department(1, "Books");
		
		Seller seller = new Seller(21, "Anderson", "anderson@gmail.com", new Date(), 3000.,obj);
		
		SellerDao sellerdao = DaoFactory.createSellerDao();
		//assim o programa principal não vai conhecer a implementação, mas somente a interface

		
		System.out.println(seller);
	
	}

}
