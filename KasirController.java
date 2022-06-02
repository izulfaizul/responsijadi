/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import model.KasirModel;
import view.KasirView;
/**
 *
 * @author Hewlett-Packard
 */
public class KasirController {
    KasirModel kasirmodel;
    KasirView kasirview;
     Object header[] = {"ID", "Nama Barang", "Nama kasir", "Quantity", "Price per Quantity", "Discount", "Price Total"};
  


    public KasirController(KasirModel kasirmodel, KasirView kasirview) {
        this.kasirmodel = kasirmodel;
        this.kasirview = kasirview;
        
        if (kasirmodel.getKasirdata()!=0) {
            String dataMovie[][] = kasirmodel.tampilKasir();
            kasirview.table.setModel((new JTable(dataMovie, header)).getModel());
        }
        else {
            JOptionPane.showMessageDialog(null, "No Data");
        }
        
        kasirview.btnAdd.addActionListener(new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = kasirview.getId();
                String nama_barang = kasirview.getNamabarang();
                String nama_kasir = kasirview.getNama_kasir();
                String qty = kasirview.getQty();
                String priceperqty = kasirview.getPrice_per_qty();
                String discount = kasirview.getDiscount();
               
                
                
                kasirmodel.insertKasir( id,  nama_barang,  nama_kasir,  qty,  priceperqty,  discount);
                String dataMovie[][] = kasirmodel.tampilKasir();
                kasirview.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        kasirview.btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                 String id = kasirview.getId();
                String nama_barang = kasirview.getNamabarang();
                String nama_kasir = kasirview.getNama_kasir();
                String qty = kasirview.getQty();
                String priceperqty = kasirview.getPrice_per_qty();
                String discount = kasirview.getDiscount();
          
                kasirmodel.updateKasir( id,  nama_barang,  nama_kasir,  qty,  priceperqty,  discount);
                String dataMovie[][] = kasirmodel.tampilKasir();
                kasirview.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        kasirview.btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                String id = kasirview.getId();
                
                kasirmodel.deleteKasir(id);
                String dataMovie[][] = kasirmodel.tampilKasir();
                kasirview.table.setModel((new JTable(dataMovie, header)).getModel());
            }
        });
        
        kasirview.btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                kasirview.setId();
                kasirview.setNamabarang();
                kasirview.setNamakasir();
                kasirview.setQty();
                kasirview.setPrice_per_qty();
                kasirview.setDiscount();
                
               
            }
        });
        
         kasirview.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mousePressed(e);
                int rows = kasirview.table.getSelectedRow();

                String id = kasirview.table.getValueAt(rows, 0).toString();
               String nama_barang = kasirview.table.getValueAt(rows, 1).toString();
                 String nama_kasir =  kasirview.table.getValueAt(rows, 2).toString();
               String qty = kasirview.table.getValueAt(rows, 3).toString();
              String priceperqty = kasirview.table.getValueAt(rows, 4).toString();
                String discount = kasirview.table.getValueAt(rows, 5).toString();
              
             

                kasirview.tfId.setText(id);
                kasirview.tfNama_barang.setText(nama_barang);
                kasirview.tfNama_kasir.setText(nama_kasir);
                kasirview.tfQty.setText(qty);
                kasirview.tfPrice_per_qty.setText(priceperqty);
                kasirview.tfDiscount.setText(discount);
            }
        });
        
        
    }
}
