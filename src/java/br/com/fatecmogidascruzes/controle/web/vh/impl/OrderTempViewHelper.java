/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableOrder;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.test.PaginationDate;
import br.com.fatecmogidascruzes.domain.impl.test.TableOrderTemp;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class OrderTempViewHelper implements IViewHelper {
    
    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        
        PaginationDate pagination = new PaginationDate();
        TableOrderTemp order = new TableOrderTemp();
        
        // Intervalo de datas para busca:
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");        
        try {
            order.setDateAdded(sdf.parse(request.getParameter("stard-date") + " 00:00:00"));
            order.setDateModified(sdf.parse(request.getParameter("end-date") + " 23:00:00"));
        } catch (ParseException ex) {
            Logger.getLogger(CustomerViewHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
       
        List<TableOrderTemp> orderList = (List<TableOrderTemp>)(List<?>) resultado.getEntidades();
        // request.setAttribute("orderList", orderList);
        Integer index = 1;
        String orderData = "";  
        if(!orderList.isEmpty()){            
        
            Calendar cal = Calendar.getInstance();        
            cal.setTime(orderList.get(0).getDateAdded());
            int currentDay = Calendar.DAY_OF_MONTH;
            BigDecimal total = new BigDecimal(0.0);
            for (TableOrderTemp orderTemp: orderList){ 
                cal.setTime(orderTemp.getDateAdded());
                int day = cal.get(Calendar.DAY_OF_MONTH);
                if (currentDay == day){
                    total = total.add(orderTemp.getTotal());                
                }else{
                    total = total.add(orderTemp.getTotal()); 
                    currentDay = day;
                    cal.setTime(orderTemp.getDateAdded());
                    orderData += ",[new Date(" + 
                        cal.get(Calendar.YEAR) + "," +
                        cal.get(Calendar.MONTH) + "," +
                        cal.get(Calendar.DAY_OF_MONTH) + ")," +                

                    total + "]\n";
                    index++;
                    total = new BigDecimal(0.0);
                }
            }
            orderData = "[" + orderData.substring(1) + "]";
        }
        
        request.setAttribute("orderData", orderData);
        request.setAttribute("date", "Data, hora");
        request.setAttribute("value", "Valor do pedido");
    }
}
