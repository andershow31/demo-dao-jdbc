package model.dao;

import db.DB;
import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	public static SellerDao createSellerDao()
{
	return new SellerDaoJDBC(DB.getConnection());
		}
}
//para instanciar um SellerDao, faremos da forma abaixo, assim o programa principal não vai conhecer a implementação, mas somente a interface
//SellerDao sellerdao = DaoFactory.createSellerDao();
