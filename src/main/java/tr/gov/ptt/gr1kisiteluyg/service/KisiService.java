/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tr.gov.ptt.gr1kisiteluyg.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import tr.gov.ptt.gr1kisiteluyg.entity.Kisi;
import tr.gov.ptt.gr1kisiteluyg.facade.KisiFacade;

@Stateless
public class KisiService {
    
    @EJB
    private KisiFacade kisiFacade;
    
    public  void kisiEkle(Kisi p_kisi)
    {
        kisiFacade.create(p_kisi);
        
    }
    
    public  void kisiGuncelle(Kisi p_kisi)
    {
        kisiFacade.edit(p_kisi);
        
    }
    
    public  List<Kisi> kisiListele()
    {
        return kisiFacade.kisiListeleSirali();
    }
    
    
}
