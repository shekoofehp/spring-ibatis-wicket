package com.shekoofeh;

import java.util.List;

public interface JsrDAO  
{
     
    public List<Jsr> selectAllJsrs();
    public Jsr selectJsrById(String jsrID);

    public void insertJsr(Jsr insertJsr);
    public void deleteJsr(String jsrId);
    public void updateJsr(Jsr jsrWithNewValues);

}