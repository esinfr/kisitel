/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;
import tr.gov.ptt.gr1kisiteluyg.entity.Kisi;
import tr.gov.ptt.gr1kisiteluyg.entity.Telefon;
import tr.gov.ptt.gr1kisiteluyg.service.KisiService;
import tr.gov.ptt.gr1kisiteluyg.util.JSFUtil;

@ManagedBean
@ViewScoped
public class KisiBean implements Serializable{

    private Kisi kisi;
    private Telefon evtel;
    private Telefon cepTel;

    private List<Kisi> kisiListe;

    @EJB
    private KisiService kisiService;

    public KisiBean() {

        kisi = new Kisi();
        evtel = new Telefon();
        cepTel = new Telefon();
        kisiListe = new ArrayList<Kisi>();
    }

    public Kisi getKisi() {
        return kisi;
    }

    public List<Kisi> getKisiListe() {

        if (kisiListe.size()==0) {
            kisiListe = kisiService.kisiListele();
        }
        
        return kisiListe;
    }

    public void setKisiListe(List<Kisi> kisiListe) {
        this.kisiListe = kisiListe;
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

    public String kisiEkle() {
        List<Telefon> telefonListe = new ArrayList<Telefon>();
        telefonListe.add(evtel);
        telefonListe.add(cepTel);

        kisi.setTelefonList(telefonListe);
        evtel.setKisi(kisi);
        cepTel.setKisi(kisi);

        kisiService.kisiEkle(kisi);

        return "kisiListele.xhtml?faces-redirect=true";
    }

    public void onRowEdit(RowEditEvent event) {
        
        Kisi kisi = (Kisi) event.getObject();
        kisiService.kisiGuncelle(kisi);
        JSFUtil.mesajEkle("Kişi güncellendi: " +kisi.getNo()+"-"+kisi.getAd());
        
    }

    public void onRowCancel(RowEditEvent event) {
        
        Kisi kisi = (Kisi) event.getObject();
        JSFUtil.mesajEkle("Kişi güncelleme iptal edildi: " +kisi.getNo()+"-"+kisi.getAd());
    }

    public List<String> adTamamla(String sorgu)
    {
        List<String> uygunAdlar = new ArrayList<String>();
        List<Kisi> kisiListesi  = kisiService.kisiListele();
        
        for (Kisi kisi : kisiListesi) {
            
            if (kisi.getAd().toUpperCase().startsWith(sorgu.toUpperCase())) {
                
                uygunAdlar.add(kisi.getAd());
            }
        }
        
        
        return uygunAdlar;
        
        
    }
}
