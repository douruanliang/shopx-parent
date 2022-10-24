package com.shopx.manager.pojo;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 资源权限对象
 */

@Table(name="sys_permission")
public class SysPermission implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	private Integer parentId;
	@Column(name ="name")
	private String name;
	private String css;
	private String href;
	private Integer type;
	private String permission;
	private Integer sort;

	private List<SysPermission> child;

	@Override
	public String toString() {
		return "SysPermission{" +
				"parentId=" + parentId +
				", name='" + name + '\'' +
				", css='" + css + '\'' +
				", href='" + href + '\'' +
				", type=" + type +
				", permission='" + permission + '\'' +
				", sort=" + sort +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCss() {
		return css;
	}

	public void setCss(String css) {
		this.css = css;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public List<SysPermission> getChild() {
		return child;
	}

	public void setChild(List<SysPermission> child) {
		this.child = child;
	}
}
