package cn.bigruili.server;

public class Entity {
  private String name;
  private String clz;
  
public Entity() {
}
public Entity(String name, String clz) {
	super();
	this.name = name;
	this.clz = clz;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getClz() {
	return clz;
}
public void setClz(String clz) {
	this.clz = clz;
}
}
