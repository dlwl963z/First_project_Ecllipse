package store;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.Customer;

public class CustomerStoreLogic {

	private static final String resource = "config.xml";

	private SqlSessionFactory getSessionFactory() {
		Reader reader = null;

		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new SqlSessionFactoryBuilder().build(reader);

	}

	public int registCustomer(Customer customer) {

		SqlSession sqlSession = getSessionFactory().openSession();

		try {

			int result = sqlSession.insert("insertCustomer", customer); // 지금은
																		// id로
																		// 구분
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
			return result;

		} finally {
			sqlSession.close();
		}
	}

	public List<Customer> searchAll() {

		SqlSession sqlSession = getSessionFactory().openSession();

		try {
			return sqlSession.selectList("selectAll");
		} finally {
			sqlSession.close();
		}
	}

	public void updateCustomer(Customer cus) {

		SqlSession sqlSession = getSessionFactory().openSession();

		try {
			sqlSession.update("updateCustomer", cus);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	public void deleteCustomer(int CustomerId) {

		SqlSession sqlSession = getSessionFactory().openSession();

		try {
			sqlSession.delete("deleteCustomer", CustomerId);
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
	}

	public Customer selectById(int ID) {

		SqlSession sqlSession = getSessionFactory().openSession();

		try {

		 return sqlSession.selectOne("selectById", ID);

		} finally {
			sqlSession.close();
		}

	}

}
