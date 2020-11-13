package com.chiques.models;

import static java.text.MessageFormat.format;

import java.util.HashMap;
import java.util.List;

import com.chiques.shared.AbstractRequest;

public class Request extends AbstractRequest {

    private String entity;
    List<String> columnsToEncrypt;

    public Request(String entity, HashMap<String, HashMap<String, Object>> configs) {
        this.entity = entity;
    }

	public String getEntity() {
		return this.entity;
	}

    public void setEntity(String entity) {
        this.entity = entity;
    }

    @Override
    public String toString() {
        return format("entity: {0}", this.entity);
    }

	public List<String> getColumnsToEncrypt() {
		return this.columnsToEncrypt;
	}

	public String getMigrationId() {
        //TODO: implement if corresponds
		return null;
	}

}
