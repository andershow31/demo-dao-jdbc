package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		//assim o programa principal não vai conhecer a implementação, mas somente a interface
		System.out.println("______TEST 1: SELLER.FINDBYID________");
		Seller seller = sellerDao.findById(3);
		
		System.out.println(seller);
		System.out.println("______TEST 2: SELLER.FINDBYDEPARTMENT________");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("______TEST 3: SELLER.FINDALL________");
		list = sellerDao.findAll();
		for (Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println("______TEST 4: SELLER.NEWSELLER________");
		Seller newSeller = new Seller(null, "Nome do cara", "abc@gmail.com", new Date(), 4000., dep);
		sellerDao.insert(newSeller);
		System.out.println("Inserido, id: " + newSeller.getId());
		
		System.out.println("______TEST 5: SELLER.UPDATE________");
		seller = sellerDao.findById(1);
		seller.setName("Martha Waine");
		sellerDao.update(seller);
		System.out.println("Update completed");
		
		System.out.println("\n______TEST 6: SELLER.DELETE________");
		System.out.println("ID for delete test: ");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();
	}

}
