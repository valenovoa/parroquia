package com.parroquia.controller;

import com.parroquia.model.Feligres;
import com.parroquia.model.Feligress;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Named
@ViewScoped
public class ImprimirController implements Serializable {

    @Inject
    private BuscarController buscarController;
    private Feligres feligres;

    private HttpServletResponse response;
    private FacesContext context;
    private ByteArrayOutputStream baos;
    private InputStream stream;

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
    public void init() {
        this.feligres = buscarController.getFeligres();
    }

    public Feligres getFeligres() {
        return feligres;
    }

    public void setFeligres(Feligres feligres) {
        this.feligres = feligres;
    }

    public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException {
       // HashMap parametros = new HashMap();
        Map<String,Object> parametros= new HashMap<>();
        parametros.put("numLibro", feligres.getNumLibro());
        parametros.put("numFolio", feligres.getNumPagina());
        parametros.put("nombres", feligres.getNombres());
        parametros.put("apellidos", feligres.getApellidos());
        parametros.put("nomMama", feligres.getNomMama());
        parametros.put("nomPapa", feligres.getNomPapa());
        parametros.put("lugarNacimiento", feligres.getLugarNacimiento());
        parametros.put("fechaNacimiento", feligres.getFechaNacimiento());
        parametros.put("fechaBautizo", feligres.getFechaBautizo());
        parametros.put("lugar", feligres.getLugar());
        parametros.put("nomParroco", feligres.getNomParroco());
        parametros.put("nomMadrina", feligres.getNomMadrina());
        parametros.put("nomPadrino", feligres.getNomPadrino());

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportesPDF/FeBautismo.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JREmptyDataSource());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

/*    public void getRelatorio() {
        stream = this.getClass().getResourceAsStream("/reportesPDF/FeBautismo.jasper");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("numLibro", feligres.getNumLibro());
        parametros.put("numFolio", feligres.getNumPagina());
        parametros.put("nombres", feligres.getNombres());
        parametros.put("apellidos", feligres.getApellidos());
        parametros.put("nomMama", feligres.getNomMama());
        parametros.put("nomPapa", feligres.getNomPapa());
        parametros.put("lugarNacimiento", feligres.getLugarNacimiento());
        parametros.put("fechaNacimiento", feligres.getFechaNacimiento());
        parametros.put("fechaBautizo", feligres.getFechaBautizo());
        parametros.put("lugar", feligres.getLugar());
        parametros.put("nomParroco", feligres.getNomParroco());
        parametros.put("nomMadrina", feligres.getNomMadrina());
        parametros.put("nomPadrino", feligres.getNomPadrino());
        baos = new ByteArrayOutputStream();

        try {

            JasperReport report = (JasperReport) JRLoader.loadObject(stream);

            /*Para usar JavaBeanDataSource defina: new JRBeanCollectionDataSource(lista)
            mude a string do getResourceAsStream("/report/reportPessoaJavaBeanDS.jasper")
             *//*
            JasperPrint print = JasperFillManager.fillReport(report, parametros, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfStream(print, baos);

            response.reset();
            response.setContentType("application/pdf");
            response.setContentLength(baos.size());
            response.setHeader("Content-disposition", "inline; filename=relatorio.pdf");
            response.getOutputStream().write(baos.toByteArray());
            response.getOutputStream().flush();
            response.getOutputStream().close();

            context.responseComplete();
            

        } catch (IOException | JRException e) {
            //mensaje
        } 
    }*/

}
