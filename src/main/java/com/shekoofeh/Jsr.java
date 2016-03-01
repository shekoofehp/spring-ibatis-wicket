package com.shekoofeh;

import java.io.Serializable;

public class Jsr implements Serializable
{  
    private String id;   
    private String name;
    private String description;
    private String specLead;
   
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    
    public String getSpecLead() {
		return specLead;
	}

	public void setSpecLead(String specLead) {
		this.specLead = specLead;
	}

	public String toString()
    {
        return "Id = " + id + ", Name = " + name +
            ", Description = " + description + ", Lead = " + specLead;
    }
}