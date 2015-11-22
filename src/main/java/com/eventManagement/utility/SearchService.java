package com.eventManagement.utility;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventManagement.entity.EventUser;
import com.eventManagement.enums.OperatorType;

@Service
public class SearchService {
	
	private String className;
	
	private Map<String,Object> criteria;
	
	private OperatorType operatorType;
	
	@Autowired
	 private SessionFactory sessionFactory;

	 public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	 public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public OperatorType getOperatorType() {
		return operatorType;
	}

	public void setOperatorType(OperatorType operatorType) {
		this.operatorType = operatorType;
	}

	/*public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}*/

	/**
	  * 
	  * @param className
	  * @param criteria
	  * @param operatorType
	  */
	public void setSearchParams(String className,Map<String,Object> criteria,OperatorType operatorType){
		 this.className=className;
		 this.criteria=criteria;
		 this.operatorType=operatorType;
		 
	 }
	 
	 
	 public List<EventUser> doSearch(){
		 List<EventUser> list = null;
			try {
				String hql=" From "+this.getClassName();
				
				if(this.getCriteria()!=null){
					hql+=" WHERE ";
					for (String parameterName : this.getCriteria().keySet()) {
						hql+= " "+ parameterName +" = :"+ parameterName + " " + this.operatorType.toString() ;
					}
					hql=hql.substring(0, hql.length()-4);
				}
				Session session = this.sessionFactory.getCurrentSession();
				Transaction trans=session.beginTransaction();
				Query temQuery = session.createQuery(hql);
				if(this.getCriteria()!=null){
					for (String parameterName : this.getCriteria().keySet()) {
						temQuery.setParameter(parameterName, this.getCriteria().get(parameterName));
					}
				}
		         list = temQuery.list();
		         trans.commit();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			return list;
	 }

	public Map<String,Object> getCriteria() {
		return criteria;
	}

	public void setCriteria(Map<String,Object> criteria) {
		this.criteria = criteria;
	}
}
