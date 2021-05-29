/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intt.steuerungslogik;

import intt.datenlogik.Inventory;
import intt.datenlogik.Products;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author inttentwickler
 */
@ManagedBean
public class ChartView implements Serializable {

    
    private PieChartModel pieModel;
    private BarChartModel barModel;
    private LineChartModel animatedModel;
    
    @EJB
    private intt.geschaeftslogik.ProductsFacade productFacade;
    @EJB
    private intt.geschaeftslogik.InventoryFacade inventoryFacade;
    
    @PostConstruct
    public void init(){
    
        createPieModels();
        createBarModels();
        createAnimatedModels();
    }
    
    
    /*Tortendiagramm*/
     public PieChartModel getPieModel(){
        
      return pieModel;
    }
    
    private void createPieModels(){
        
        createPieModel();
    }
    
    /*Anteile eines Produktes am Gesamtlagerbestand*/
    
    private void createPieModel(){
        
        pieModel = new PieChartModel();
        
        List<Products> inventoryList = productFacade.allProducts();
        
        Iterator<Products> iterator = inventoryList.iterator();
        while(iterator.hasNext()){
            
            Products prod = (Products) iterator.next();
            pieModel.set(prod.getName(), getSelectedProductAmount(prod.getProductID()));        
            
        }
        
        pieModel.setTitle("Anteile eines Produktes am Gesamtlagerbestand");
        pieModel.setLegendPosition("e");                //geht nach Himmelsreichtungen, e= east
        pieModel.setFill(true);                         //ob Diagramm gefüllt sein soll bzw. das Diagrammfeld (Tortenstück)
        pieModel.setShowDataLabels(true);               
        pieModel.setDiameter(150);                      //größe des Diagramms
    }
    
    /*Balkendiagramm*/
    public BarChartModel getBarModel(){
        
      return barModel;
    }
    
    private void createBarModels(){
        
        createBarModel();
    }
    
    private void createBarModel(){
        
        barModel = initBarModel();
        
        barModel.setTitle("Produktinformationen");
        barModel.setLegendPosition("ne");                   //Legende wird Nordöstlich angesiedelt
        
        Axis xAxis = barModel.getAxis(AxisType.X);
        xAxis.setLabel("Produkte");
        
        Axis yAxis = barModel.getAxis(AxisType.Y);
        yAxis.setLabel("Preise/Kosten");
        yAxis.setMin(0);                                    //Preise bewegen sich zwischen 0 und 4€
        yAxis.setMax(4);
        
        
    }
    
    
    private BarChartModel initBarModel(){
        
        BarChartModel model = new BarChartModel();
        
        ChartSeries price = new ChartSeries();              //hier werden die verschiedenen Balken pro Einheit definiert (welche Sachen will man vergleichen )
        price.setLabel("Preis");
        
        ChartSeries cost = new ChartSeries();
        cost.setLabel("Herstellerkosten");
        
        List<Products> inventoryList = productFacade.allProducts();
        
        Iterator<Products> iterator = inventoryList.iterator();
        while(iterator.hasNext()){
        
            Products prod = (Products) iterator.next();
            price.set(prod.getName(), prod.getPrice());         //Preis befüllen
            
            //Zufallsgenerator, da wir in der DB keine Herstellerkosten haben
            String randomnumber = "";
            Random randomgenerator = new Random();
            
            for(int i = 0; i<1; i++){                           //Eurobetrag
                
                int zahl = randomgenerator.nextInt(2);          //soll nicht größer 2 werden
                randomnumber +=zahl;
            }
            
            for(int i=0; i<1; i++){                             //Centbetrag
                
                int zahl = randomgenerator.nextInt(99);
                randomnumber += "." + zahl;
                
            }
            
            cost.set(prod.getName(), Float.parseFloat(randomnumber));       //Kosten befüllen
            
        }
        
        model.addSeries(price);                                             //BarChartModel befüllen
        model.addSeries(cost);
        
        
        return model;
    }
    
    
    /*Animiertes Diagramm*/
    
    public LineChartModel getAnimatedModel(){
        
        return animatedModel;
    }
    
    private void createAnimatedModels(){
        
        animatedModel = initLinearModel();
        animatedModel.setTitle("Line Chart");
        animatedModel.setAnimate(true);
        animatedModel.setLegendPosition("se");
        Axis yAxis = animatedModel.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(10);
    }
    
    private LineChartModel initLinearModel(){
        
        LineChartModel model = new LineChartModel();
        
        LineChartSeries series1 = new LineChartSeries();
        series1.setLabel("Series 1");
        
        series1.set(1, 2);
        series1.set(2, 1);
        series1.set(3, 3);
        series1.set(4, 6);
        series1.set(5, 8);
        
        LineChartSeries series2 = new LineChartSeries();
        series2.setLabel("Series 2");
        
        series2.set(1, 6);
        series2.set(2, 3);
        series2.set(3, 2);
        series2.set(4, 7);
        series2.set(5, 9);
        
        model.addSeries(series1);
        model.addSeries(series2);
        
        return model;
        
    }
    
    
    
    /*Selektorimplementierung (macht Diagramm interaktiver -> wenn man klickt bekommt man Rückgabewert) */
    
    public void itemSelect (ItemSelectEvent event){
        
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "item.selected", "Item Index: " + event.getItemIndex() + " Series Index: " + event.getSeriesIndex());
        
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
    } 
    
    
     public Integer getSelectedProductAmount(java.lang.Integer productID){
    
    
        List<Inventory> inventoryList = inventoryFacade.inventoryByProduct(productID);
        
        int amount = 0;
        
        Iterator<Inventory> iterator = inventoryList.iterator();
        
        while(iterator.hasNext())
        {
            Inventory inv = (Inventory) iterator.next();
            amount += inv.getCurrentAmount();
        
        }
        
        return amount;
    
    }
    
    
}