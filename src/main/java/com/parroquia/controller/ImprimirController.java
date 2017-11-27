
package com.parroquia.controller;

import com.parroquia.model.Feligres;
import com.parroquia.model.Feligress;
import java.io.File;
import java.io.IOException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Named
@ViewScoped
public class ImprimirController implements Serializable{
    
    
    
    @Inject
    private BuscarController buscarController;
    private Feligres feligres;
    
   /* private List<Feligres> feligress = new ArrayList<Feligres>();

    public List<Feligres> getFeligress() {
        Feligress fel = new Feligress();
        fel.setNombres(this.feligres.getNombres());
        fel.setApellidos(this.feligres.getApellidos());
        fel.setFechaBautizo(this.feligres.getFechaBautizo());
        fel.setFechaNacimiento(this.feligres.getFechaNacimiento());
        fel.setLugar(this.feligres.getLugar());
        fel.setLugarNacimiento(this.feligres.getLugarNacimiento());
        fel.setNomMadrina(this.feligres.getNomMadrina());
        fel.setNomMama(this.feligres.getNomMama());
        fel.setNomPadrino(this.feligres.getNomPadrino());
        fel.setNomPapa(this.feligres.getNomPapa());
        fel.setNomParroco(this.feligres.getNomParroco());
        fel.setNumLibro(this.feligres.getNumLibro());
        fel.setNumPagina(this.feligres.getNumPagina());
        fel.setCodigo(this.feligres.getCodigo());
        
        return feligress;
    }

    public void setFeligress(List<Feligres> feligress) {
        this.feligress = feligress;
    }*/

   
    
    
    
    @PostConstruct
    public void init(){
        this.feligres = buscarController.getFeligres();
    }

    public Feligres getFeligres() {
        return feligres;
    }

    public void setFeligres(Feligres feligres) {
        this.feligres = feligres;
    }
    
    
    
   /* public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException{
        
        /*JasperPrint reportPrint = JasperFillManager.fillReport(
        this.getClass().getClassLoader().getResourceAsStream("/FeBautismo.jasper"),
            new HashMap<String,Object>(), 
                 new JRBeanArrayDataSource(new Feligres[]{feligres}));
        
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("feligres", feligres);

        JasperPrint reportPrint = JasperFillManager.fillReport(
                this.getClass().getClassLoader().getResourceAsStream("C:\\Users\\valer\\Documents\\NetBeansProjects\\Parroquia\\src\\main\\java\\reportesPDF\\FeBautismo.jasper"),
                params, new JREmptyDataSource());
        
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(reportPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    
    }*/
    
    /*
    public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException{
		
		
		File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/FeBautismo.jasper"));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),null, new JRBeanCollectionDataSource(this.getFeligress()));
		
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.addHeader("Content-disposition","attachment; filename=jsfReporte.pdf");
		ServletOutputStream stream = response.getOutputStream();
		
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		
		stream.flush();
		stream.close();
		FacesContext.getCurrentInstance().responseComplete();
	}
    */

    
    
    
    
}
