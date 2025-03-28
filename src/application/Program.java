package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		//assim o programa principal não vai conhecer a implementação, mas somente a interface
		System.out.println("______TEST 1: SELLER.FINDBYID________");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
	}

}
