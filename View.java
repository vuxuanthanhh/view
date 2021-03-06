/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.CategoryDAO;
import DAO.FoodDAO;
import Model.Category;
import Model.DropdownItem;
import Model.Food;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AD
 */
public final class View extends javax.swing.JFrame {

    /**
     * Creates new form FoodManagermentView
     */
    Boolean isEditing = false;
    DefaultTableModel model;
    DefaultComboBoxModel comboBox;
    ArrayList<Category> cate = new ArrayList<>();
    ArrayList<Food> food = new ArrayList<>();
    CategoryDAO cateDAO = new CategoryDAO();
    FoodDAO foodDAO = new FoodDAO();

    public View() throws Exception {
        initComponents();

        btnDeleteCate.setEnabled(false);
        btnDeleteFood.setEnabled(false);

        jPanel3.setBorder(BorderFactory.createTitledBorder("Main part"));
        jPanel4.setBorder(BorderFactory.createTitledBorder("Detailed part"));
        jPanel5.setBorder(BorderFactory.createTitledBorder("Main part"));
        jPanel6.setBorder(BorderFactory.createTitledBorder("Detailed part"));

        loadCategoryData();
        loadFoodData();
    }

    public void loadCategoryData() throws Exception {
        cate = cateDAO.getAllCategory();
        model = (DefaultTableModel) tblCategory.getModel();

        // Clear data table before get data      
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        cate.forEach(cateItem -> {
            String data[] = {
                cateItem.getCateId(),
                cateItem.getCateName(),
                cateItem.getDescription()};
            model.addRow(data);
        });
    }

    public void loadFoodData() throws Exception {
        food = foodDAO.getAllFood();
        getCategoryName();
        model = (DefaultTableModel) tblFood.getModel();
        // Clear data table before get data      
        for (int i = model.getRowCount() - 1; i >= 0; i--) {
            model.removeRow(i);
        }
        food.forEach((foodItem) -> {
            Object data[] = {
                foodItem.getFoodId(),
                foodItem.getFoodName(),
                foodItem.getUnit(),
                foodItem.getPrice(),
                foodItem.getQuantity(),
                foodItem.getCateID()
            };
            model.addRow(data);
        });
    }

    public void getCategoryName() throws Exception {
        comboBox = new DefaultComboBoxModel();
        cate.forEach(cateItem -> {
            comboBox.addElement(new DropdownItem(cateItem.getCateId(), cateItem.getCateName()));
        });
        cbCateName.setModel(comboBox);
    }

    public void clearCategoryData() {
        txtCateID.setEditable(true);
        isEditing = false;
        txtCateID.setText("");
        txtCateName.setText("");
        txtCateDescription.setText("");
    }

    public void clearFoodData() {
        txtFoodID.setEditable(true);
        isEditing = false;
        txtFoodID.setText("");
        txtFoodName.setText("");
        txtFoodUnit.setText("");
        txtFoodQuan.setText("");
        txtFoodPrice.setText("");
        cbCateName.setSelectedIndex(0);
    }

    public void findFoodByID(String id) {
        food.forEach(foodItem -> {
            if (foodItem.getFoodId().equals(id)) {
                txtFoodID.setText(foodItem.getFoodId());
                txtFoodName.setText(foodItem.getFoodName());
                txtFoodUnit.setText(foodItem.getUnit());
                txtFoodPrice.setText("" + foodItem.getPrice());
                txtFoodQuan.setText("" + foodItem.getQuantity());
                for (int i = 0; i < comboBox.getSize(); i++) {
                    if (((DropdownItem) comboBox.getElementAt(i)).getKey().equals(foodItem.getCateID())) {
                        cbCateName.setSelectedIndex(i);
                    }
                }
            }
        });
    }

    public void findCateByID(String id) {
        cate.forEach(cateItem -> {
            if (cateItem.getCateId().equals(id)) {
                txtCateID.setText(cateItem.getCateId());
                txtCateName.setText(cateItem.getCateName());
                txtCateDescription.setText(cateItem.getDescription());
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCateID = new javax.swing.JTextField();
        txtCateName = new javax.swing.JTextField();
        txtCateDescription = new javax.swing.JTextField();
        btnAddCate = new javax.swing.JButton();
        btnUpdateCate = new javax.swing.JButton();
        btnDeleteCate = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFood = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFoodID = new javax.swing.JTextField();
        txtFoodName = new javax.swing.JTextField();
        btnAddFood = new javax.swing.JButton();
        btnUpdateFood = new javax.swing.JButton();
        btnDeleteFood = new javax.swing.JButton();
        txtFoodPrice = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFoodUnit = new javax.swing.JTextField();
        txtFoodQuan = new javax.swing.JTextField();
        cbCateName = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setForeground(new java.awt.Color(0, 0, 153));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jPanel3.setForeground(new java.awt.Color(0, 0, 153));
        jPanel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        tblCategory.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCategory);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jPanel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Category Id:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Category Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Description:");

        txtCateID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtCateName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtCateDescription.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnAddCate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAddCate.setText("Add New");
        btnAddCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCateActionPerformed(evt);
            }
        });

        btnUpdateCate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnUpdateCate.setText("Update");
        btnUpdateCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateCateActionPerformed(evt);
            }
        });

        btnDeleteCate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDeleteCate.setText("Delete");
        btnDeleteCate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteCateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAddCate)
                        .addGap(88, 88, 88)
                        .addComponent(btnUpdateCate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(btnDeleteCate))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCateName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                            .addComponent(txtCateID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCateDescription))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtCateID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtCateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCateDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(92, 92, 92)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCate)
                    .addComponent(btnDeleteCate)
                    .addComponent(btnUpdateCate))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Category", jPanel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jPanel5.setForeground(new java.awt.Color(0, 0, 153));
        jPanel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        tblFood.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tblFood.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Unit", "Price", "Quantity", "Cate ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFood.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFoodMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblFood);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 153)));
        jPanel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Food Id:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("Food name:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Quantity:");

        txtFoodID.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtFoodName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnAddFood.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAddFood.setText("Add New");
        btnAddFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFoodActionPerformed(evt);
            }
        });

        btnUpdateFood.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnUpdateFood.setText("Update");
        btnUpdateFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateFoodActionPerformed(evt);
            }
        });

        btnDeleteFood.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDeleteFood.setText("Delete");
        btnDeleteFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteFoodActionPerformed(evt);
            }
        });

        txtFoodPrice.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Unit:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("Category Name:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Price:");

        txtFoodUnit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtFoodQuan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cbCateName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnAddFood)
                        .addGap(88, 88, 88)
                        .addComponent(btnUpdateFood)
                        .addGap(94, 94, 94)
                        .addComponent(btnDeleteFood))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addComponent(cbCateName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addComponent(txtFoodUnit, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFoodQuan, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtFoodPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtFoodID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cbCateName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFoodUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFoodQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(31, 31, 31)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtFoodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFood)
                    .addComponent(btnDeleteFood)
                    .addComponent(btnUpdateFood))
                .addGap(86, 86, 86))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Food", jPanel2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Food Management Software");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCateActionPerformed
        clearCategoryData();
    }//GEN-LAST:event_btnAddCateActionPerformed

    private void btnUpdateCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateCateActionPerformed
        String id = txtCateID.getText();
        String name = txtCateName.getText();
        String desc = txtCateDescription.getText();
        if (!isEditing) {
            try {
                if (cateDAO.addNewCategory(id, name, desc) == 1) {
                    JOptionPane.showMessageDialog(null, "Add Successfully!");
                    loadCategoryData();
                    clearCategoryData();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Add Fail");
            }
        } else {
            try {
                if (cateDAO.updateCategory(id, name, desc) == 1) {
                    JOptionPane.showMessageDialog(null, "Edit Successfully!");
                    loadCategoryData();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Edit Fail");
            }
        }
    }//GEN-LAST:event_btnUpdateCateActionPerformed

    private void btnDeleteCateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteCateActionPerformed
        String id = txtCateID.getText();
        int dialogButton = JOptionPane.showConfirmDialog(null, "Do you want to remove " + id, "Delete Category!", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION) {
            try {
                if (cateDAO.deleteCategory(id) == 1) {
                    JOptionPane.showMessageDialog(null, "Delete Successfully!");
                    loadCategoryData();
                    clearCategoryData();
                } else {
                    JOptionPane.showMessageDialog(null, "Delete Fail! Please delete all food have categoryID is " + id);
                }
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnDeleteCateActionPerformed

    private void btnAddFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFoodActionPerformed
        clearFoodData();
    }//GEN-LAST:event_btnAddFoodActionPerformed

    private void btnUpdateFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateFoodActionPerformed
        String id = txtFoodID.getText();
        String name = txtFoodName.getText();
        String unit = txtFoodUnit.getText();
        String price = txtFoodPrice.getText();
        String quantity = txtFoodQuan.getText();
        String cateID = ((DropdownItem) cbCateName.getSelectedItem()).getKey();

        if (!isEditing) {
            try {
                if (foodDAO.addNewFood(id, name, unit, price, quantity, cateID) == 1) {
                    JOptionPane.showMessageDialog(null, "Add Successfully!");
                    loadFoodData();
                    clearFoodData();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Add Fail");
            }
        } else {
            try {
                if (foodDAO.updateFood(id, name, unit, price, quantity, cateID) == 1) {
                    JOptionPane.showMessageDialog(null, "Edit Successfully!");
                    loadFoodData();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Edit Fail");
            }
        }
    }//GEN-LAST:event_btnUpdateFoodActionPerformed

    private void btnDeleteFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteFoodActionPerformed
        String id = txtFoodID.getText();
        int dialogButton = JOptionPane.showConfirmDialog(null, "Do you want to remove " + id, "Delete Food!", JOptionPane.YES_NO_OPTION);
        if (dialogButton == JOptionPane.YES_OPTION) {
            try {
                if (foodDAO.deleteFood(id) == 1) {
                    JOptionPane.showMessageDialog(null, "Delete Successfully!");
                    loadFoodData();
                    clearFoodData();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Delete Fail");
            }
        }
    }//GEN-LAST:event_btnDeleteFoodActionPerformed

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked
        btnDeleteCate.setEnabled(true);
        model = (DefaultTableModel) tblCategory.getModel();
        int selectRowIndex = tblCategory.getSelectedRow();
        isEditing = true;
        txtCateID.setEditable(false);
        findCateByID(model.getValueAt(selectRowIndex, 0).toString());
    }//GEN-LAST:event_tblCategoryMouseClicked

    private void tblFoodMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFoodMouseClicked
        btnDeleteFood.setEnabled(true);
        model = (DefaultTableModel) tblFood.getModel();
        int selectRowIndex = tblFood.getSelectedRow();
        isEditing = true;
        txtFoodID.setEditable(false);
        findFoodByID(model.getValueAt(selectRowIndex, 0).toString());
    }//GEN-LAST:event_tblFoodMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new View().setVisible(true);
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCate;
    private javax.swing.JButton btnAddFood;
    private javax.swing.JButton btnDeleteCate;
    private javax.swing.JButton btnDeleteFood;
    private javax.swing.JButton btnUpdateCate;
    private javax.swing.JButton btnUpdateFood;
    private javax.swing.JComboBox<String> cbCateName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCategory;
    private javax.swing.JTable tblFood;
    private javax.swing.JTextField txtCateDescription;
    private javax.swing.JTextField txtCateID;
    private javax.swing.JTextField txtCateName;
    private javax.swing.JTextField txtFoodID;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtFoodPrice;
    private javax.swing.JTextField txtFoodQuan;
    private javax.swing.JTextField txtFoodUnit;
    // End of variables declaration//GEN-END:variables

}
