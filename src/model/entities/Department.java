package model.entities;

import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable{
	/*
	 * A interface Serializable permite que os objetos sejam transformados em bits
	 * ou seja, para que possamos gravar em arquivos ou enviados pela rede por exemplo 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	public Department() {
	}
	public Department(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//relembrando que os dois métodos abaixo servem para que os objetos possam ser comparados pelo
	//conteúdo não pela referência de ponteiros
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
}
