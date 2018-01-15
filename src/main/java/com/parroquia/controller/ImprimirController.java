package com.parroquia.controller;

import com.parroquia.model.Feligres;
import java.io.File;
import java.io.IOException;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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

@Named
@ViewScoped
public class ImprimirController implements Serializable {

    @Inject
    private BuscarController buscarController;
    private Feligres feligres;
    
    private int control;


    @PostConstruct
    public void init() {
        this.feligres = buscarController.getFeligres();
        this.control = feligres.getCodigo();
    }

    public Feligres getFeligres() {
        return feligres;
    }

    public void setFeligres(Feligres feligres) {
        this.feligres = feligres;
    }

        
public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException, ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException {

        Connection conexion;
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        conexion = DriverManager.getConnection("jdbc:mysql://:3306/parroquia", "root", "nb11001");

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
        


        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/Reportes/FeBautismos.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JREmptyDataSource());

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
    
}
