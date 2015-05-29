
package tr.gov.ptt.gr1kisiteluyg.bean;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;
import tr.gov.ptt.gr1kisiteluyg.entity.Giris;
import tr.gov.ptt.gr1kisiteluyg.service.GirisService;
import tr.gov.ptt.gr1kisiteluyg.util.JSFUtil;

@ManagedBean
@SessionScoped
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
            
            HttpSession session = JSFUtil.getSession();
            session.setAttribute("username", giris.getAd());
            
            JSFUtil.mesajEkle("Giriş başarılı.");
            System.out.println("session başlıyooooooor..." + session.getId());
            return "menu.xhtml?faces-redirect=true";
            
        } else {
            JSFUtil.hataMesajiEkle("Kullanıcı adı ya da şifre hatalı!");
            return "giris.xhtml?faces-redirect=true";
        }
    }
    
    public  String sessionBitir()
    {
        HttpSession session = JSFUtil.getSession();
        session.invalidate();
        System.out.println("session bitiyoooooooooooor..." + session.getId());
        return "giris.xhtml?faces-redirect=true";
    }
    
    
    
}
