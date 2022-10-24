package com.shopx.manager.pojo;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 角色对象
 */

@Table(name="sys_role")
public class SysRole implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name ="name")
	private String name;
	@Column(name ="description")
	private String description;
	@Column(name = "created")
	private Date created;//创建时间

	@Column(name = "updated")
	private Date updated;//修改时间

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "SysRole{" +
				"name='" + name + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
