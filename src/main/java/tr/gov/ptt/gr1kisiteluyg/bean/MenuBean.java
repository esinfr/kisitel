/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
@SessionScoped
public class MenuBean {
    
    private MenuModel model;

   public MenuBean() {
       
       model = new DefaultMenuModel();
       //First submenu
       DefaultSubMenu firstSubmenu = new DefaultSubMenu("Kişi İşlemleri");
       DefaultMenuItem item = new DefaultMenuItem("Kişi Ekle");
       item.setUrl("kisiEkle.xhtml?faces-redirect=true");
       //item.setIcon("ui-icon-home");
       firstSubmenu.addElement(item);
       
       item  = new DefaultMenuItem("Kişi Listele");
       item.setUrl("kisiListele.xhtml?faces-redirect=true");
       //item.setIcon("ui-icon-home");
       firstSubmenu.addElement(item);
       
       item  = new DefaultMenuItem("İsim Tamamla");
       item.setUrl("kisiAra.xhtml?faces-redirect=true");
       //item.setIcon("ui-icon-home");
       firstSubmenu.addElement(item);
       
       model.addElement(firstSubmenu);

       //Second submenu
       DefaultSubMenu secondSubmenu = new DefaultSubMenu("Giriş-Çıkış İşlemleri");
       item = new DefaultMenuItem("Giriş");
       //item.setIcon("ui-icon-disk");
       item.setUrl("giris.xhtml?faces-redirect=true");
       secondSubmenu.addElement(item);
       
       item = new DefaultMenuItem("Çıkış");
       //item.setIcon("ui-icon-search");
       item.setCommand("#{girisBean.sessionBitir()}");
       secondSubmenu.addElement(item);
       model.addElement(secondSubmenu);
   }

   public MenuModel getModel() {
       return model;
   }
}
