package com.ingenium.tsp.model;

public class Person extends PropertyRecord {

    public enum Role {
	LEADER_GROUP("Lider de grupo"), LEADER_PLANNING("Lider de planeacion"), LEADER_SUPPORT("Lider de soporte"), LEADER_QUALITY("Lider de calidad"), LEADER_DEVELOPMENT(
	        "Lider de desarrollo");

	private String roleName;

	Role(String roleName) {
	    this.roleName = roleName;
	}

	public String getRoleName() {
	    return roleName;
	}
    }

    String name;
    String role;

    public Person(){
    }
    
    public Person(String encoded) {
	decodeData(encoded);
    }


    @Override
    public String encodeData() {
	StringBuffer encoded = new StringBuffer();
	encoded.append(id);
	encoded.append(SEPARATOR);
	encoded.append(name);
	encoded.append(SEPARATOR);
	encoded.append(role);
	return encoded.toString();
    }

    @Override
    public void decodeData(String encodedData) {
	String[] decoded = encodedData.split(SEPARATOR);
	id = decoded[0];
	name = decoded[1];
	role = decoded[2];
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getRole() {
	return role;
    }

    public void setRole(String role) {
	this.role = role;
    }

}
