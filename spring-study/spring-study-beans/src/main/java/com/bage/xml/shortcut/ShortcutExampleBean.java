package com.bage.xml.shortcut;

public class ShortcutExampleBean {

	private String name;
	private String email;
	private Foo shortcutFoo;
	private Bar shortcutBar;
	private Baz shortcutBaz;
	
	public ShortcutExampleBean(String name, Foo shortcutFoo, Bar shortcutBar, Baz shortcutBaz) {
		super();
		this.name = name;
		this.shortcutFoo = shortcutFoo;
		this.shortcutBar = shortcutBar;
		this.shortcutBaz = shortcutBaz;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Foo getShortcutFoo() {
		return shortcutFoo;
	}
	public void setShortcutFoo(Foo shortcutFoo) {
		this.shortcutFoo = shortcutFoo;
	}
	public Bar getShortcutBar() {
		return shortcutBar;
	}
	public void setShortcutBar(Bar shortcutBar) {
		this.shortcutBar = shortcutBar;
	}
	public Baz getShortcutBaz() {
		return shortcutBaz;
	}
	public void setShortcutBaz(Baz shortcutBaz) {
		this.shortcutBaz = shortcutBaz;
	}
	@Override
	public String toString() {
		return "ShortcutExampleBean [name=" + name + ", email=" + email + ", shortcutFoo=" + shortcutFoo
				+ ", shortcutBar=" + shortcutBar + ", shortcutBaz=" + shortcutBaz + "]";
	}
	
	
}
