package com.jeecg.p3.system.entity;

import java.io.Serializable;

public class MenuMutex
  implements Serializable
{
  private static final long serialVersionUID = 1L;
  private Menu menu;
  private Menu mutexMenu;

  public Menu getMenu()
  {
    return this.menu; }

  public void setMenu(Menu menu) {
    this.menu = menu; }

  public Menu getMutexMenu() {
    return this.mutexMenu; }

  public void setMutexMenu(Menu mutexMenu) {
    this.mutexMenu = mutexMenu;
  }

  public String toString() {
    return "MenuMutex [menu=" + this.menu + ", mutexMenu=" + this.mutexMenu + "]";
  }
}