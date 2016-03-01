package com.shekoofeh;

import java.sql.SQLException;
import java.util.List;
import com.ibatis.sqlmap.client.SqlMapClient;
//import org.springframework.orm.ibatis.SqlMapClientTemplate;
//import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapClient;

public class JsrDAOImpl implements  JsrDAO
{  
	    
	protected SqlMapClient sqlMapClient;

	public SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}


	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}


	public SqlMapClient getTemplate() {
		return sqlMapClient;
	}


	

	public List<Jsr> selectAllJsrs()
    {
     //   SqlMapClientTemplate template = getSqlMapClientTemplate();
        try {
        	return 	(List<Jsr>)getTemplate().queryForList("jsrmap.selectAllJsrs");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
    }


    public Jsr selectJsrById(String jsrID)
    {
       // SqlMapClientTemplate template = getSqlMapClientTemplate();
        Object objectJsr;
		try {
			objectJsr = getTemplate().queryForObject("jsrmap.selectJsrById", jsrID);
			return objectJsr instanceof Jsr ? ((Jsr)objectJsr) : null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
        
    }
    

    public void insertJsr(Jsr insertJsr)
    {
       // SqlMapClientTemplate template = getSqlMapClientTemplate();
    	try {
			getTemplate().insert("jsrmap.insertJsr", insertJsr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

  
    public void deleteJsr(String jsrId)
    {
        //SqlMapClientTemplate template = getSqlMapClientTemplate();
        try {
			getTemplate().delete("jsrmap.deleteJsr", jsrId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

 
    public void updateJsr(Jsr jsrWithNewValues)
    {
      // SqlMapClientTemplate template = getSqlMapClientTemplate();
        try {
			getTemplate().update("jsrmap.updateJsr", jsrWithNewValues);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	
}