package com.guo.school.webdataeditor;

import java.beans.PropertyEditorSupport;

public class IntegerEditor extends PropertyEditorSupport{
	
	@Override
    public String getAsText() {
       
        return (String) getValue();
    }

    //text: 201801--10
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if("".equals(text)||null==text) {
        	setValue(0);
        }
        try {

            //设置属性值
            setValue(Integer.parseInt(text));
        }catch (Exception e){
        	setValue(0);
            System.out.println("ParseException....................");
        }
    }
}
