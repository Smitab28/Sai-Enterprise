package com.jbk.DaoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.dao.CountryDao;
import com.jbk.entity.Country;

@Repository
public class CountryDaoIMPL implements CountryDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public String addCountry(Country country) {
		Session session = null;
		String msg = null;
		try {
			session = sf.openSession();
			Transaction tr = session.beginTransaction();
			session.save(country);
			tr.commit();
			msg="Country "+country.getCountryName()+" saved successfully";
		}catch(PersistenceException e) {
			msg= country.getCountryName()+" already exist";
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public String updateCountry(Country country) {
		Session session = null;
		String msg = null;
		try {
			session = sf.openSession();
			Transaction tr = session.beginTransaction();
			Country updateCountry= session.get(Country.class, country.getCountryId());
			if(updateCountry!=null) {
				updateCountry=country;
				session.save(updateCountry);
				tr.commit();
				msg="Country "+country.getCountryName()+" saved successfully";
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			msg= "something went wrong whilw updating";
		}
		return msg;
	}

	@Override
	public String deleteCountryById(long countryId) {
		Session session= null;
		Country deleteCountry= null;
		String msg = null;
		try {
			session= sf.openSession();
			deleteCountry = session.get(Country.class, countryId);
			if(deleteCountry!=null) {
				session.delete(deleteCountry);
				msg= "Country with name "+deleteCountry.getCountryName()+" is deleted successfully";
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			msg=" unable to delete";
		}
		return msg;
	}

	@Override
	public Country getCountryByID(long countryId) {
		Session session= null;
		Country country= null;
		try {
			session= sf.openSession();
			country = session.get(Country.class, countryId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}

	@Override
	public String deleteCountryByName(String countryName) {
		Session session= null;
		Country country= null;
		String msg = null;
		try {
			session= sf.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			List<Country> countryList = criteria.list();
			for (Country country2 : countryList) {
				if(country2.getCountryName().equals(countryName)) {
					country = country2;
				}
			}
			if(country!=null) {
				session.delete(country);
				msg= "Country with name "+countryName+" is deleted successfully";
			}else
				msg= "Country already deleted or doesnot exist";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Override
	public List<Country> getAllcountry() {
		Session session= null;
		Country country= null;
		List<Country> countryList = null;
		try {
			session= sf.openSession();
			Criteria criteria = session.createCriteria(Country.class);
			 countryList = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryList;
	}

}
