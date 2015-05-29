/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.bean;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.gr1kisiteluyg.entity.Kisi;
import tr.gov.ptt.gr1kisiteluyg.entity.Telefon;
import tr.gov.ptt.gr1kisiteluyg.service.KisiService;

@ManagedBean
@RequestScoped
public class KisiBean {
    
    private Kisi kisi;
    private Telefon evtel;
    private Telefon cepTel;

    @EJB
    private KisiService kisiService;
    
    public KisiBean() {
        kisi    = new Kisi();
        evtel   = new Telefon();
        cepTel  = new Telefon();
    }
    
    public Kisi getKisi() {
        return kisi;
    }

    public void setKisi(Kisi kisi) {
        this.kisi = kisi;
    }

    public Telefon getEvtel() {
        return evtel;
    }

    public void setEvtel(Telefon evtel) {
        this.evtel = evtel;
    }

    public Telefon getCepTel() {
        return cepTel;
    }

    public void setCepTel(Telefon cepTel) {
        this.cepTel = cepTel;
    }

    public  String kisiEkle()
    {
        List<Telefon> telefonListe = new ArrayList<Telefon>();
        telefonListe.add(evtel);
        telefonListe.add(cepTel);
        
        kisi.setTelefonList(telefonListe);
        evtel.setKisi(kisi);
        cepTel.setKisi(kisi);
        
        kisiService.kisiEkle(kisi);
        
        return "kisiListele.xhtml?faces-redirect=true";
    }
    
}
