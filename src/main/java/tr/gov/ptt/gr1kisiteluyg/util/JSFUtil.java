
package tr.gov.ptt.gr1kisiteluyg.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class JSFUtil {
    
    public static void mesajEkle(String mesaj)
    {
    FacesContext.getCurrentInstance()
      .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, mesaj, mesaj));
    FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
    }
    
    public static void hataMesajiEkle(String mesaj)
    {
    FacesContext.getCurrentInstance()
      .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, mesaj, mesaj));
    FacesContext.getCurrentInstance()
            .getExternalContext().getFlash().setKeepMessages(true);
    }
    
}
