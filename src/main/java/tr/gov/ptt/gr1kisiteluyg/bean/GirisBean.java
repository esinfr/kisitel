
package tr.gov.ptt.gr1kisiteluyg.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import tr.gov.ptt.gr1kisiteluyg.entity.Giris;
import tr.gov.ptt.gr1kisiteluyg.service.GirisService;
import tr.gov.ptt.gr1kisiteluyg.util.JSFUtil;

@ManagedBean
@RequestScoped
public class GirisBean {
    
    private Giris giris;
    
    @EJB
    private GirisService girisService;

    public GirisBean() {
        giris = new Giris();
    }

    public Giris getGiris() {
        return giris;
    }

    public void setGiris(Giris giris) {
        this.giris = giris;
    }
    
    public String girisKontrol()
    {
       boolean sonuc = girisService.girisKontrol(giris);
       
        if (sonuc) {
            JSFUtil.mesajEkle("Giriş başarılı.");
            return "menu.xhtml?faces-redirect=true";
        } else {
            JSFUtil.hataMesajiEkle("Kullanıcı adı ya da şifre hatalı!");
            return "giris.xhtml?faces-redirect=true";
        }
    }
    
    
    
}
