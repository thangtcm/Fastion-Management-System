/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Form.Product;

import DatabaseDao.Category_Dao;
import DatabaseDao.Product_Dao;
import DatabaseDaoImpl.Category_DaoImpl;
import DatabaseDaoImpl.Product_DaoImpl;
import Enum.TypeFunction;
import Model.Categories;
import Model.Products;
import Model.User;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLayeredPane;
import javax.swing.table.DefaultTableModel;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import swing.TableBuild.EventAction;
import swing.TableBuild.EventAction_Main;


/**
 *
 * @author YAN
 */
public class ProductList extends javax.swing.JPanel {

    private User user;
    private JLayeredPane body;
    public ProductList() {
        initComponents();
    }
    
    public ProductList(JLayeredPane body, User user) {
        initComponents();
        this.body = body;
        this.user = user;
        table.fixTable(jScrollPane1);
        init();
        initTable(new Products(null, null));
        DataUser();
    }
    
    private void init()
    {
        //Xử lí Search
        Category_Dao category_Dao = new Category_DaoImpl();
        ArrayList<Categories> categoryList = category_Dao.getCategoryList();
        DefaultComboBoxModel<Categories> modelCategory = new DefaultComboBoxModel<>();
        modelCategory.addAll(categoryList);
        modelCategory.insertElementAt(new Categories("Chọn sản phẩm"), 0);
        JType.setModel(modelCategory);
        JType.setSelectedIndex(0);
    }
    
    private void initTable(Products products)
    {
        //Xử lí table
        EventAction eventAction = new EventAction_Main(this.body, this.table, user);
        //int i = 1;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("<html><div style = 'text-align : center'>#</div></html>");
        model.addColumn("<html><div style = 'text-align : center'>Tên Sản Phẩm</div></html>");
        model.addColumn("<html><div style = 'text-align : center'>Trạng Thái</div></html>");
        model.addColumn("<html><div style = 'text-align : center'>Giảm Giá</div></html>");
        model.addColumn("<html><div style = 'text-align : center'>Số Lượng</div></html>");
        model.addColumn("<html><div style = 'text-align : center'>Chức Năng</div></html>");
        Product_Dao product_Dao = new Product_DaoImpl();
        ArrayList<Products> productList = product_Dao.getProductList(products);
        for(Products obj : productList )
        {
            model.addRow(obj.toRowTable(eventAction));
        }
        table.setModel(model);
        table.setDefaultEditor(Object.class, null);
    }

    private void DataUser()
    {
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        headerBody1.init(null, 
                this.user, "User Management", null, this.body);
    }
    
    private void HandleSearch()
    {
        Products products;
        System.out.println("Form.Product.ProductList.HandleSearch() + " + txtName.getText().trim());
        if(JType.getSelectedIndex() != 0)
        {
            products = new Products(txtName.getText().trim(), ((Categories)JType.getSelectedItem()).getID());
            
        }
        else
        {
            products = new Products(txtName.getText().trim(), null);
        }
        initTable(products);   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new swing.TableBuild.Table();
        headerBody1 = new Components.HeaderBody();
        txtName = new swing.Field.TextField();
        btnSearch = new swing.Button.ButtonEdit();
        btnAdd = new swing.Button.ButtonEdit();
        JType = new swing.Combobox.ComboBoxSuggestion();

        setOpaque(false);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "New Product", "Product Name", "Product Type", "Price", "Quantity", "Status", "Edit"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        txtName.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
        txtName.setLabelText("Product's Name");

        btnSearch.setBackground(new java.awt.Color(23, 34, 56));
        btnSearch.setText("Search");
        btnSearch.setBackgroundColor(new java.awt.Color(23, 34, 56));
        btnSearch.setBorderColor(new java.awt.Color(23, 34, 56));
        btnSearch.setColorHover(new java.awt.Color(23, 34, 56));
        btnSearch.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btnSearch.setRadius(15);
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(23, 34, 56));
        btnAdd.setText("Create");
        btnAdd.setBackgroundColor(new java.awt.Color(23, 34, 56));
        btnAdd.setBorderColor(new java.awt.Color(23, 34, 56));
        btnAdd.setColorHover(new java.awt.Color(23, 34, 56));
        btnAdd.setFont(new java.awt.Font("Inter", 1, 14)); // NOI18N
        btnAdd.setRadius(15);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        JType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "A", "B", "C", "D", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(headerBody1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 958, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(JType, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerBody1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 39, Short.MAX_VALUE)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 39, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JType, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        showForm(new ManagementProduct(this.body, this.user, TypeFunction.Create, this, null));
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        HandleSearch();
    }//GEN-LAST:event_btnSearchActionPerformed

    
    private void showForm(Component com) {
        body.removeAll();
        body.add(com);
        body.repaint();
        body.revalidate();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.Combobox.ComboBoxSuggestion JType;
    private swing.Button.ButtonEdit btnAdd;
    private swing.Button.ButtonEdit btnSearch;
    private Components.HeaderBody headerBody1;
    private javax.swing.JScrollPane jScrollPane1;
    private swing.TableBuild.Table table;
    private swing.Field.TextField txtName;
    // End of variables declaration//GEN-END:variables
}
