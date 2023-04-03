package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Seller;

public class Program1 {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TEST #1: seller findById ===");
		Seller seller = sellerDao.findById(2);
		System.out.println(seller);


	}

}