/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bill;
import static bill.dbconn.cn;
import java.util.Date;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.event.ComponentListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;
import java.awt.print.*;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Array;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.*;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static jdk.nashorn.internal.runtime.Debug.id;
import static jdk.nashorn.tools.ShellFunctions.input;
import static org.omg.CORBA.AnySeqHelper.id;

/**
 *
 * @author Sparrow
 */
public class billing extends javax.swing.JFrame {

    private Object jTextField36;
    private String total_amount;
    private Object jTextField37;
    private Object jTextField35;
    
    
    String gross;
        
     /**
     * Creates new form billing
     * 
     */
    
    
    dbconn cn1=new dbconn();
    DigitalClock dc = new DigitalClock();
    static void displayJFrame()
  {
 
// create our jframe as usual
     }   
    public billing() {
        initComponents();
        fetch();      
fetchdrink();
   tblsearch();
   
   
    }
    public void datedis(){
        
    }
    
    public void inserttempbill(){
             try{
         
                 Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
             String query="Insert into tempbill(item,price,qty,qtytotal,tablenum) values (?,?,?,?,?)";
             PreparedStatement ps = cn.prepareStatement(query);
             ps.setString(1,item.getText());
             ps.setString(2,price.getText());
             ps.setString(3,qty.getText());
             ps.setString(4,qtytotal.getText());
             
             ps.setString(5,tablenum.getText());
             ps.executeUpdate();
             
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
   
    }
    
    public void tblsearch(){
          try{

if (searchtblnum.getText().equals("")){
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
            
     
     
     String quer34="select *from tempbill";
     
 PreparedStatement   ptsearch34 = cn.prepareStatement(quer34);
 
  

 
  ResultSet rstsearch34 = ptsearch34.executeQuery();
         
            listtable.setModel(DbUtils.resultSetToTableModel(rstsearch34));
              

}                        
else{        
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
            
      String stable=searchtblnum.getText(); 
     
     String quer="select *from tempbill where tablenum='"+stable+"'";
     
 PreparedStatement   ptsearch23 = cn.prepareStatement(quer);
 
  

 
  ResultSet rstsearch23 = ptsearch23.executeQuery();
         
            listtable.setModel(DbUtils.resultSetToTableModel(rstsearch23));
        
        

int sum=0;
int rw2=listtable.getRowCount();
if(rw2>0){
        for(int i=0; i < rw2; i++){
      sum+=Integer.parseInt(listtable.getValueAt(i ,3).toString());
        
            
    } 
String nn=searchtblnum.getText();
        subtotal1.setText(String.valueOf(sum));
 tablenum.setText(nn);
}
else{
     subtotal1.setText("");
}  
}    
         
        }
       
        
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        
    }
        


        
    }
    
    public void cashrecieved(){
    }
   public void salesEntry(){
      int j=listtable.getRowCount();
        
        String salesgrandtot=subtotal1.getText();
                String salesdisc=discount.getText();
                Date myDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
String myDateString = sdf.format(myDate);
if(j==0){
    
   JOptionPane.showMessageDialog(null, "Empty recodrd can be manipulated"); 
return;
}             

if(j==1){
         try{
                            for(int l=0; l<j; l++){
      
                
        
                 String    itemsales= (String)listtable.getValueAt(l ,0).toString();
     String pricesales=(String)listtable.getValueAt(l ,1).toString();
    String qtysales=(String)listtable.getValueAt(l ,2).toString();
   String totalsales=(String)listtable.getValueAt(l ,3).toString();
                 String tabnum=(String)listtable.getValueAt(l ,4).toString();
                
                
  Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
   
       String querysales2="Insert into sales(Item,Price,Quantity,Price_Total,Discount,Grand_Total,tablenum,Date) values (?,?,?,?,?,?,?,?)";
             PreparedStatement pssales2 = cn.prepareStatement(querysales2);
    
      pssales2.setString(1, itemsales); //Invoice No
 pssales2.setString(2, pricesales); //Code
 pssales2.setString(3, qtysales); //Description
 pssales2.setString(4, totalsales);
 pssales2.setString(5, salesdisc);
 pssales2.setString(6, salesgrandtot);
 pssales2.setString(7, tabnum);
pssales2.setString(8, myDateString);

 
    pssales2.executeUpdate();
    } }
     catch(Exception ex)
 {
  JOptionPane.showMessageDialog(null, "Cannot save. "+ ex);
    }            }
                 
             else{
         try{
        
                for(int k=0; k<j; k++){
        
                 String    itemsales= (String)listtable.getValueAt(k ,0).toString();
     String pricesales=(String)listtable.getValueAt(k ,1).toString();
    String qtysales=(String)listtable.getValueAt(k ,2).toString();
   String totalsales=(String)listtable.getValueAt(k ,3).toString();
                            String tabnum1=(String)listtable.getValueAt(k ,4).toString();
                
                
  
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
    String querysales="Insert into sales(Item,Price,Quantity,Price_Total,tablenum,Date) values (?,?,?,?,?,?)";
             PreparedStatement pssales = cn.prepareStatement(querysales);
    
      pssales.setString(1, itemsales); //Invoice No
 pssales.setString(2, pricesales); //Code
 pssales.setString(3, qtysales); //Description
 pssales.setString(4, totalsales);
 pssales.setString(5, tabnum1);               
pssales.setString(6, myDateString);

 
    pssales.executeUpdate();
    } }
     catch(Exception ex)
 {
  JOptionPane.showMessageDialog(null, "Cannot save. "+ ex);
    }    
          try{      
    String querysales1="Insert into sales(Discount,Grand_Total,tablenum,Date) values (?,?,?,?)";
             PreparedStatement pssales1 = cn.prepareStatement(querysales1);
            
                   String tabnum=tablenum.getText();
 pssales1.setString(2,salesgrandtot); //Bonusable
pssales1.setString(1,salesdisc);
pssales1.setString(3,tabnum);
pssales1.setString(4,myDateString);
pssales1.executeUpdate();
          }
          catch(Exception ex)
 {
  JOptionPane.showMessageDialog(null, "Cannot save. "+ ex);
    }
   } }
    
 public void fetch(){
    try{
    String quer="select *from Foodmenu";
 PreparedStatement    ptnew = cn.prepareStatement(quer);
    ResultSet rsnew=ptnew.executeQuery();
    searchtable.setModel(DbUtils.resultSetToTableModel(rsnew));
}catch(Exception e){
    

}
    }
 public void deletetempbill(){
     try{
         
        if(searchtblnum.getText().equals(""))
        {
            
          String nn2=tablenum.getText();
          Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
             String query214="Delete from tempbill where tablenum='"+nn2+"'";
             PreparedStatement ps214 = cn.prepareStatement(query214);
             
             ps214.execute();
             
        } else{
        String nn1=searchtblnum.getText(); 
        
        Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
             String query24="Delete from tempbill where tablenum='"+nn1+"'";
             PreparedStatement ps24 = cn.prepareStatement(query24);
             
             ps24.execute();
        }
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
     
 }
 public void fetchdrink(){
    try{
    String quer="select *from drinkmenu";
 PreparedStatement    pt = cn.prepareStatement(quer);
    ResultSet rs=pt.executeQuery();
    searchtablenew.setModel(DbUtils.resultSetToTableModel(rs));
}catch(Exception e){
    

}
    }
 
 public PageFormat getPageFormat(PrinterJob pj)
{
   
    PageFormat pf = pj.defaultPage();
    Paper paper = pf.getPaper();    

    double middleHeight =8.0;  
    double headerHeight = 2.0;                  
    double footerHeight = 2.0;                  
    double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
    double height = convert_CM_To_PPI(headerHeight+middleHeight+footerHeight); 
    paper.setSize(width, height);
    paper.setImageableArea(                    
        0,
        10,
        width,            
        height - convert_CM_To_PPI(1)
    );   //define boarder size    after that print area width is about 180 points
            
    pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
    pf.setPaper(paper);    

    return pf;
}
    
    protected static double convert_CM_To_PPI(double cm) {            
	        return toPPI(cm * 0.393600787);            
}
 
protected static double toPPI(double inch) {            
	        return inch * 72d;            
}

    private Object showMessageDialog(String total_Amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static class URISyntaException {

        public URISyntaException() {
        }
    }






public class BillPrintable implements Printable {
    
   
    
    
  public int print(Graphics graphics, PageFormat pageFormat,int pageIndex) 
  throws PrinterException 
  {    
      
             Date myDate = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
String myDateString = sdf.format(myDate);
                
        
      int result = NO_SUCH_PAGE;    
        if (pageIndex == 0) {                    
        
            Graphics2D g2d = (Graphics2D) graphics;                    

            double width = pageFormat.getImageableWidth();                    
           
            g2d.translate((int) pageFormat.getImageableX(),(int) pageFormat.getImageableY()); 

            ////////// code by alqama//////////////

            FontMetrics metrics=g2d.getFontMetrics(new Font("Arial",Font.BOLD,6));
        //    int idLength=metrics.stringWidth("000000");
            //int idLength=metrics.stringWidth("00");
            int idLength=metrics.stringWidth("000");
            int amtLength=metrics.stringWidth("000000");
            int qtyLength=metrics.stringWidth("00000");
            int priceLength=metrics.stringWidth("000000");
            int prodLength=(int)width - idLength - amtLength - qtyLength - priceLength-17;

        //    int idPosition=0;
        //    int productPosition=idPosition + idLength + 2;
        //    int pricePosition=productPosition + prodLength +10;
        //    int qtyPosition=pricePosition + priceLength + 2;
        //    int amtPosition=qtyPosition + qtyLength + 2;
            
            int productPosition = 0;
            int discountPosition= prodLength+5;
            int pricePosition = discountPosition +idLength+10;
            int qtyPosition=pricePosition + priceLength + 4;
            int amtPosition=qtyPosition + qtyLength;
            
      String recv=subtotal1.getText();
                  
             
    
              
        try{
            /*Draw Header*/
            int y=20;
            int yShift = 10;
            int headerRectHeight=10;
            int headerRectHeighta=20;
            
            
            String  pn1a;
            
                
                String pn2a;
                String pn3a=subtotal1.getText();
                String pn4a=discount.getText();
                String cash=cashdisc.getText();
                String disamt11=disamt1.getText();
String pn5a;
                String pn6a;
                
                
                String tblnum=tablenum.getText();
            ///////////////// Product names Get ///////////
                            
            
            ///////////////// Product price Get ///////////
                /////// ////////// Product price Get ///////////
                
             g2d.setFont(new Font("Monospaced",Font.ITALIC,6));
            g2d.drawString("------------------------------------- ",12,y);y+=yShift;
            g2d.drawString("      Restaurant Bill Receipt         ",12,y);y+=yShift;
            g2d.drawString("------------------------",12,y);y+=headerRectHeight;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("Table Num: "+tblnum+"   ",10,y);y+=yShift;
            g2d.drawString("Date:"+myDateString+" ",10,y);y+=yShift;
            g2d.drawString(" Food   Price   Qty   Total",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
              for(int i=0; i<listtable.getRowCount(); i++){
      pn2a=listtable.getValueAt(i ,0).toString();
      pn1a=listtable.getValueAt(i ,1).toString();
       pn5a=listtable.getValueAt(i ,2).toString();
        pn6a=listtable.getValueAt(i ,3).toString();
         int cnt=i+1;
            g2d.drawString(""+cnt+" "+pn2a+"  "+pn1a+" "+pn5a+"  "+pn6a+" ",12,y);y+=yShift;
           }g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("Gross amount: "+gross+"",10,y);y+=yShift;
            g2d.drawString("Discount:"+pn4a+"%                         ",10,y);y+=yShift;
           g2d.drawString("Cashdiscount:"+cash+"                         ",10,y);y+=yShift;
            g2d.drawString("Discouned Amount:"+disamt11+"                         ",10,y);y+=yShift;
           g2d.drawString("------------------------",10,y);y+=yShift;
           g2d.drawString("Net amount: "+pn3a+"",10,y);y+=yShift;
            g2d.drawString("-------------------------------------",10,y);y+=yShift;
            g2d.drawString("          Good Food Good Mood        ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
            g2d.drawString("       THANKS PLEASE VISIT AGAIN   ",10,y);y+=yShift;
            g2d.drawString("*************************************",10,y);y+=yShift;
                   
           
             
            
//            g2d.setFont(new Font("Monospaced",Font.BOLD,10));
//            g2d.drawString("Customer Shopping Invoice", 30,y);y+=yShift; 
          
 
    }
    catch(Exception r){
    r.printStackTrace();
    }

              result = PAGE_EXISTS;    
          }    
          return result;    
      }
   }
  
    
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox1 = new javax.swing.JCheckBox();
        search1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        searchtable1 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        summary = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        disamt = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField1 = new javax.swing.JTextField();
        textArea1 = new java.awt.TextArea();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        panel2 = new java.awt.Panel();
        jRadioButton2 = new javax.swing.JRadioButton();
        search2 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        searchtablenew = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabletable = new javax.swing.JTable();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        menuBar2 = new java.awt.MenuBar();
        menu3 = new java.awt.Menu();
        menu4 = new java.awt.Menu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        date = new javax.swing.JLabel();
        date1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        discount = new javax.swing.JTextField();
        calculate = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        checkbox = new javax.swing.JCheckBox();
        jScrollPane7 = new javax.swing.JScrollPane();
        listtable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        qty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ok = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        search = new javax.swing.JTextField();
        qtytotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        searchtable = new javax.swing.JTable();
        subtotal1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tablenum = new javax.swing.JTextField();
        cashdisc = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cashdiscount = new javax.swing.JCheckBox();
        id = new javax.swing.JTextField();
        searchtblnum = new javax.swing.JTextField();
        disamt1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        item = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        billtablenum = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu30 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu37 = new javax.swing.JMenu();

        jCheckBox1.setText("jCheckBox1");

        search1.setText("                  DRINK");
        search1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search1KeyTyped(evt);
            }
        });

        jLabel3.setText("jLabel3");

        searchtable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "CATEGORY", "DRINK"
            }
        ));
        searchtable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchtable1KeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(searchtable1);

        jLabel4.setText("jLabel4");

        summary.setColumns(20);
        summary.setRows(5);
        jScrollPane4.setViewportView(summary);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane6.setViewportView(jTable2);

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        jMenu3.setText("jMenu3");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu4.setText("jMenu4");

        jButton1.setText("dis clal");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jRadioButton1.setText("jRadioButton1");

        jTextField1.setText("print");

        jMenuItem3.setText("jMenuItem3");

        jMenu6.setText("jMenu6");

        jMenuItem4.setText("jMenuItem4");

        jRadioButton2.setText("jRadioButton2");
        jRadioButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButton2MouseClicked(evt);
            }
        });
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        search2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                search2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                search2KeyTyped(evt);
            }
        });

        searchtablenew.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DRINKNAME", "CATEGORY"
            }
        ));
        searchtablenew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchtablenewMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(searchtablenew);

        jLabel9.setText("DRINK");

        jButton2.setText("print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panel1.add(jButton2);

        jButton3.setText("insert");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane5.setViewportView(jTable1);

        tabletable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tableno"
            }
        ));
        jScrollPane8.setViewportView(tabletable);

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        menu3.setLabel("File");
        menuBar2.add(menu3);

        menu4.setLabel("Edit");
        menuBar2.add(menu4);

        jMenu5.setText("File");
        jMenuBar2.add(jMenu5);

        jMenu7.setText("Edit");
        jMenuBar2.add(jMenu7);

        jMenu8.setText("File");
        jMenuBar3.add(jMenu8);

        jMenu9.setText("Edit");
        jMenuBar3.add(jMenu9);

        jLabel2.setText("jLabel2");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setMaximumSize(new java.awt.Dimension(1400, 800));
        jLabel2.setMinimumSize(new java.awt.Dimension(1400, 800));
        jLabel2.setPreferredSize(new java.awt.Dimension(1400, 800));

        jPanel3.add(jPanel4);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new.jpg"))); // NOI18N
        jLabel11.setText("Devloped By Eagle Eye Corp");
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 18)); // NOI18N
        jLabel1.setText("                                  FOOD 'O' CLOCK  RESTAURANT  ");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1380, 800));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jDesktopPane1.setBackground(new java.awt.Color(0, 204, 204));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(1400, 800));
        jDesktopPane1.setPreferredSize(new java.awt.Dimension(400, 400));

        discount.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                discountComponentAdded(evt);
            }
        });
        discount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                discountActionPerformed(evt);
            }
        });
        discount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                discountKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                discountKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                discountKeyTyped(evt);
            }
        });
        jDesktopPane1.add(discount);
        discount.setBounds(520, 300, 70, 30);

        calculate.setText("calculate");
        calculate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calculateMouseClicked(evt);
            }
        });
        calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                calculateActionPerformed(evt);
            }
        });
        jDesktopPane1.add(calculate);
        calculate.setBounds(480, 380, 90, 30);

        jLabel10.setText("dis %");
        jDesktopPane1.add(jLabel10);
        jLabel10.setBounds(390, 310, 60, 20);

        checkbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxActionPerformed(evt);
            }
        });
        checkbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                checkboxKeyPressed(evt);
            }
        });
        jDesktopPane1.add(checkbox);
        checkbox.setBounds(430, 310, 29, 20);

        listtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item", "price", "quantity", "total", "Table", "ID"
            }
        ));
        listtable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        listtable.setMinimumSize(new java.awt.Dimension(60, 60));
        listtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listtableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(listtable);
        if (listtable.getColumnModel().getColumnCount() > 0) {
            listtable.getColumnModel().getColumn(2).setMinWidth(30);
            listtable.getColumnModel().getColumn(2).setPreferredWidth(30);
            listtable.getColumnModel().getColumn(2).setMaxWidth(30);
            listtable.getColumnModel().getColumn(3).setMinWidth(30);
            listtable.getColumnModel().getColumn(3).setPreferredWidth(30);
            listtable.getColumnModel().getColumn(3).setMaxWidth(30);
            listtable.getColumnModel().getColumn(4).setMinWidth(30);
            listtable.getColumnModel().getColumn(4).setPreferredWidth(30);
            listtable.getColumnModel().getColumn(4).setMaxWidth(30);
            listtable.getColumnModel().getColumn(5).setMinWidth(30);
            listtable.getColumnModel().getColumn(5).setPreferredWidth(30);
            listtable.getColumnModel().getColumn(5).setMaxWidth(30);
        }

        jDesktopPane1.add(jScrollPane7);
        jScrollPane7.setBounds(610, 70, 370, 350);

        jLabel8.setText("Search Item");
        jDesktopPane1.add(jLabel8);
        jLabel8.setBounds(40, 100, 120, 20);

        qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtyActionPerformed(evt);
            }
        });
        qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtyKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                qtyKeyReleased(evt);
            }
        });
        jDesktopPane1.add(qty);
        qty.setBounds(460, 180, 70, 30);

        jLabel7.setText("QTY");
        jDesktopPane1.add(jLabel7);
        jLabel7.setBounds(390, 180, 40, 20);

        ok.setText("ok");
        ok.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                okStateChanged(evt);
            }
        });
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        jDesktopPane1.add(ok);
        ok.setBounds(540, 180, 49, 29);

        jLabel6.setText("PRICE");
        jDesktopPane1.add(jLabel6);
        jLabel6.setBounds(390, 150, 60, 20);

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jDesktopPane1.add(price);
        price.setBounds(460, 140, 120, 30);

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchKeyTyped(evt);
            }
        });
        jDesktopPane1.add(search);
        search.setBounds(110, 90, 140, 30);

        qtytotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                qtytotalActionPerformed(evt);
            }
        });
        qtytotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                qtytotalKeyPressed(evt);
            }
        });
        jDesktopPane1.add(qtytotal);
        qtytotal.setBounds(460, 220, 130, 30);

        searchtable.setBackground(new java.awt.Color(102, 102, 255));
        searchtable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ITEMNAME", "CATEGORY"
            }
        ));
        searchtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(searchtable);
        if (searchtable.getColumnModel().getColumnCount() > 0) {
            searchtable.getColumnModel().getColumn(0).setMinWidth(40);
            searchtable.getColumnModel().getColumn(0).setPreferredWidth(40);
            searchtable.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jDesktopPane1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 130, 340, 280);

        subtotal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotal1ActionPerformed(evt);
            }
        });
        subtotal1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                subtotal1KeyPressed(evt);
            }
        });
        jDesktopPane1.add(subtotal1);
        subtotal1.setBounds(460, 260, 130, 30);

        jLabel12.setText("Table NO");
        jDesktopPane1.add(jLabel12);
        jLabel12.setBounds(390, 70, 60, 20);

        tablenum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tablenumKeyReleased(evt);
            }
        });
        jDesktopPane1.add(tablenum);
        tablenum.setBounds(460, 60, 120, 30);

        cashdisc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashdiscActionPerformed(evt);
            }
        });
        cashdisc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashdiscKeyReleased(evt);
            }
        });
        jDesktopPane1.add(cashdisc);
        cashdisc.setBounds(460, 340, 130, 30);

        jLabel13.setText("dis cash");
        jDesktopPane1.add(jLabel13);
        jLabel13.setBounds(380, 350, 60, 20);

        cashdiscount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cashdiscountActionPerformed(evt);
            }
        });
        jDesktopPane1.add(cashdiscount);
        cashdiscount.setBounds(430, 350, 29, 20);

        id.setEnabled(false);
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        jDesktopPane1.add(id);
        id.setBounds(610, 30, 40, 30);

        searchtblnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchtblnumActionPerformed(evt);
            }
        });
        searchtblnum.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchtblnumKeyReleased(evt);
            }
        });
        jDesktopPane1.add(searchtblnum);
        searchtblnum.setBounds(860, 30, 120, 30);

        disamt1.setEditable(false);
        disamt1.setEnabled(false);
        disamt1.setRequestFocusEnabled(false);
        jDesktopPane1.add(disamt1);
        disamt1.setBounds(460, 300, 50, 30);

        jLabel5.setText("ITEM");
        jDesktopPane1.add(jLabel5);
        jLabel5.setBounds(390, 100, 100, 30);

        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActionPerformed(evt);
            }
        });
        jDesktopPane1.add(item);
        item.setBounds(460, 100, 120, 30);

        jLabel15.setText("Qtytotal");
        jDesktopPane1.add(jLabel15);
        jLabel15.setBounds(390, 220, 60, 30);

        jLabel16.setText("Total");
        jDesktopPane1.add(jLabel16);
        jLabel16.setBounds(390, 260, 60, 30);

        jLabel17.setText("Search Table Number");
        jDesktopPane1.add(jLabel17);
        jLabel17.setBounds(860, 10, 170, 30);

        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton8);
        jButton8.setBounds(680, 20, 60, 40);

        jButton9.setText("Delete");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jDesktopPane1.add(jButton9);
        jButton9.setBounds(750, 20, 90, 40);

        jPanel1.add(jDesktopPane1);
        jDesktopPane1.setBounds(-30, -10, 1080, 430);
        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 410, 960, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 80, 960, 440);
        getContentPane().add(billtablenum);
        billtablenum.setBounds(790, 10, 40, 14);

        jPanel5.setLayout(null);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cropone.png"))); // NOI18N
        jButton4.setText("category");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4);
        jButton4.setBounds(0, 80, 120, 40);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/listitem.png"))); // NOI18N
        jButton5.setText("Edit Item");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5);
        jButton5.setBounds(0, 140, 120, 40);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon-Foodnew.png"))); // NOI18N
        jButton6.setText("View Item");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6);
        jButton6.setBounds(0, 200, 120, 40);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jButton7.setText("Sales Report");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7);
        jButton7.setBounds(0, 273, 120, 40);

        getContentPane().add(jPanel5);
        jPanel5.setBounds(1040, 80, 120, 400);

        jLabel14.setFont(new java.awt.Font("Tekton Pro Ext", 1, 18)); // NOI18N
        jLabel14.setText(" Billing Part");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(300, 0, 350, 80);

        jMenu30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cropone.png"))); // NOI18N
        jMenu30.setText("Category");
        jMenu30.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu30MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu30);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/listitem.png"))); // NOI18N
        jMenu1.setText("Item");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Icon-Foodnew.png"))); // NOI18N
        jMenu2.setText("ViewItem");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jMenu37.setText("Sales Report");
        jMenu37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu37MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu37);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyPressed
        // TODO add your handling code here:
        
      


        
        
    }//GEN-LAST:event_searchKeyPressed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyTyped
        // TODO add your handling code here:

       
        
        



    }//GEN-LAST:event_searchKeyTyped

    private void search1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search1KeyTyped

        // TODO add your handling code here:

    }//GEN-LAST:event_search1KeyTyped

    private void searchtable1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtable1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtable1KeyTyped

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased

        // TODO add your handling code here:

                try{
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
            
      String st=search.getText(); 
     String quer="select *from foodmenu where Itemname like '"+st+"%'";
     
 PreparedStatement   ptsearch = cn.prepareStatement(quer);
 
  

 
  ResultSet rstsearch = ptsearch.executeQuery();
         
            searchtable.setModel(DbUtils.resultSetToTableModel(rstsearch));
        
        
        
           
       
         
         
        }
       
        
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        
    }
        



if(searchtable.getRowCount()==0){
            
                        try{
            
      
     String st1=search.getText(); 
     String quer="select *from drinkmenu where Drinkname like '"+st1+"%'";
    
 PreparedStatement   ptsearch = cn.prepareStatement(quer);
 
  

 
  ResultSet rstsearch = ptsearch.executeQuery();
         
            searchtable.setModel(DbUtils.resultSetToTableModel(rstsearch));
        
        
        
           
       
         
         
        }
       
        
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        
    }
        






        }
       


    }//GEN-LAST:event_searchKeyReleased

    private void searchtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtableMouseClicked
try{
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
        
     int row =searchtable.getSelectedRow();
     String table_click=(searchtable.getValueAt(row, 1).toString());
     String table_click1=(searchtable.getValueAt(row, 0).toString());
    String quer="select *from foodmenu where ID='"+table_click1+"' and Itemname='"+table_click+"'";
  PreparedStatement   pts = cn.prepareStatement(quer);
   ResultSet rst=pts.executeQuery();
     
     if(rst.next()){
         
         
         String add2 = rst.getString("Itemname");
         item.setText(add2);
         
         String add3 = rst.getString("Price");
         price.setText(add3);
 
        
     
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
try{
        
     int row1 =searchtable.getSelectedRow();
     String table_click=(searchtable.getValueAt(row1, 1).toString());
     String table_click1=(searchtable.getValueAt(row1, 0).toString());
    String quer="select *from drinkmenu where ID='"+table_click1+"' and Drinkname='"+table_click+"'";
  PreparedStatement   pts = cn.prepareStatement(quer);
   ResultSet rst=pts.executeQuery();
     
     if(rst.next()){
         
         
         String add2 = rst.getString("Drinkname");
         item.setText(add2);
         
         String add3 = rst.getString("Price");
         price.setText(add3);
 
        
     
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
         // TODO add your handling code here:
    }//GEN-LAST:event_searchtableMouseClicked

    private void search2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyTyped
        // TODO add your handling code here:
            try{
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
            
      
     String quer="select *from drinkmenu where Drinkname=?";
     
 PreparedStatement   ptsearch = cn.prepareStatement(quer);
 
  ptsearch.setString(1, search2.getText());

 
  ResultSet rstsearch = ptsearch.executeQuery();
         
            searchtable.setModel(DbUtils.resultSetToTableModel(rstsearch));
        
        
        
           
       
         
         
        }
       
        
         
            
        
    catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        
    }
        







        
    }//GEN-LAST:event_search2KeyTyped

    private void search2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_search2KeyReleased

    private void search2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_search2KeyPressed

    private void itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    private void searchtablenewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchtablenewMouseClicked
        // TODO add your handling code here:
        
        

        
    }//GEN-LAST:event_searchtablenewMouseClicked

    private void qtytotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtytotalActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_qtytotalActionPerformed

    private void qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_qtyActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_qtyActionPerformed

    private void qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyKeyPressed

    private void qtyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtyKeyReleased
        // TODO add your handling code here:
     
         try{
   
             if(qty.getText().length()>4){
          JOptionPane.showMessageDialog(null, "Only 4 digits are allowed","ERROR",JOptionPane.ERROR_MESSAGE);
          qty.setText(null);
        }
             
        char c=evt.getKeyChar();
               if (!Character.isDigit(c)) {
         
            
                JOptionPane.showMessageDialog(null, "Invalid quantaty No.");
                
             
        
             }
        else{
        String quantityget = qty.getText();
        String price_get = price.getText();
     int quantity = Integer.parseInt(quantityget);
     int prize = Integer.parseInt(price_get);
     int amt = (quantity * prize);
    qtytotal.setText(String.valueOf(amt));
   
             
        }
        }catch(HeadlessException | NumberFormatException e){
             }
        

    }//GEN-LAST:event_qtyKeyReleased

    @SuppressWarnings("empty-statement")
    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        // TODO add your handling code here:

        try{
if(qty.getText().equals("")){
            
   
String price_get1 = price.getText();

    qtytotal.setText(String.valueOf(price_get1));
   String  dq="1"; 
    qty.setText(dq);
    
        }
        if (tablenum.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Insert Tablenumber");
            return;
        }

DefaultTableModel Model=(DefaultTableModel)listtable.getModel();
Model.addRow(new Object[]{item.getText(),price.getText(),qty.getText(),qtytotal.getText(),tablenum.getText()});


int sum=0;
        for(int i=0; i < listtable.getRowCount(); i++){
      sum+=Integer.parseInt(listtable.getValueAt(i ,3).toString());
        
            
    } 

        subtotal1.setText(String.valueOf(sum));

            

           
                    }
           

      catch(Exception e){
    

}
        inserttempbill();
        qty.setText("");
                   qtytotal.setText("");
   
         
    }//GEN-LAST:event_okActionPerformed

    private void subtotal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotal1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotal1ActionPerformed

    private void calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_calculateActionPerformed
        

        
        
        

         

    }//GEN-LAST:event_calculateActionPerformed

    private void okStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_okStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_okStateChanged

    private void listtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listtableMouseClicked
        // TODO add your handling code here:
        
        try{
     Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
        
     int row1 =listtable.getSelectedRow();
     String table_click1=(listtable.getValueAt(row1, 5).toString());
    String quer007="select *from tempbill where id='"+table_click1+"'";
  PreparedStatement   pts007 = cn.prepareStatement(quer007);
   ResultSet rst007=pts007.executeQuery();
     
     if(rst007.next()){
         
         String add19 = rst007.getString("id");
         id.setText(add19);
         
         String add20 = rst007.getString("item");
         item.setText(add20);
         
         String add21 = rst007.getString("price");
         price.setText(add21);
 
         String add22 = rst007.getString("qty");
         qty.setText(add22);
 
     String add23 = rst007.getString("tablenum");
         tablenum.setText(add23);
 
     }
            
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
        
        
        
    }//GEN-LAST:event_listtableMouseClicked

    private void discountKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyTyped
        // TODO add your handling code here:
    
                      
    }//GEN-LAST:event_discountKeyTyped

    private void discountKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyReleased
    
char c1=evt.getKeyChar();
               if (!Character.isDigit(c1)) {
         
            
                JOptionPane.showMessageDialog(null, "Invalid Discount No.");
                
             
        }   
        

            
        
        // TODO add your handling code here:
    }//GEN-LAST:event_discountKeyReleased

    private void checkboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxActionPerformed
                             
try{
  
         //   System.out.println("Deselected!");
    

if(checkbox.isSelected()){
    
   
    String subtotaldis = subtotal1.getText();
    int disctotal;
    String discount1 = discount.getText();
    
    int dis = Integer.parseInt(discount1);
    int subttl = Integer.parseInt(subtotaldis);
    
    disctotal= subttl * dis/100;
    double finalamt = subttl-disctotal;

    int famt =(int) finalamt;
    int gm=famt+disctotal;
    gross=Integer.toString(gm);
    subtotal1.setText(String.valueOf(famt));
       disamt1.setText(String.valueOf(disctotal));

}
        }
            catch(Exception e){
                             
            }
                   
                
 
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
             pj.print();
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }
     

    }//GEN-LAST:event_jButton2ActionPerformed

    private void discountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_discountActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_discountActionPerformed

    private void discountComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_discountComponentAdded
        // TODO add your handling code here:

                             

    }//GEN-LAST:event_discountComponentAdded

    private void discountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_discountKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_discountKeyPressed

    private void checkboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_checkboxKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkboxKeyPressed

    private void qtytotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_qtytotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_qtytotalKeyPressed

    private void subtotal1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_subtotal1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotal1KeyPressed

    private void jRadioButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButton2MouseClicked
        // TODO add your handling cod


    }//GEN-LAST:event_jRadioButton2MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void calculateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calculateMouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:

       int sum3=0;
int rw3=listtable.getRowCount();
if(rw3>0){
        for(int i=0; i < rw3; i++){
      sum3+=Integer.parseInt(listtable.getValueAt(i ,3).toString());
        
            
    } 

      gross=String.valueOf(sum3);
 
}
   salesEntry();
 PrinterJob pj = PrinterJob.getPrinterJob();        
        pj.setPrintable(new BillPrintable(),getPageFormat(pj));
        try {
             pj.print();
             pj.print();
        }
         catch (PrinterException ex) {
                 ex.printStackTrace();
        }
deletetempbill();
        DefaultTableModel model = (DefaultTableModel) listtable.getModel();
model.setRowCount(0);
item.setText("");
price.setText("");
subtotal1.setText("");
discount.setText("");
cashdisc.setText("");
searchtblnum.setText("");
disamt1.setText("");


    }//GEN-LAST:event_calculateMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:




    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
 
        Desktop browser=Desktop.getDesktop();
        try{
            
            browser.browse(new URI("http://www.eagleeyecorporation.com"));
        }
        catch(IOException err){
            
        }
        
         catch (URISyntaxException ex) {
            Logger.getLogger(billing.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jMenu30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu30MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        category ct=new category();
        ct.setVisible(true);
    }//GEN-LAST:event_jMenu30MouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        // TODO add your handling code here:
        this.setVisible(false);
        menuupdate mn=new menuupdate();
        mn.setVisible(true);
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        viewitem vw=new viewitem();
        vw.setVisible(true);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu37MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu37MouseClicked
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.setVisible(false);
        NewJFrame jf=new NewJFrame();
        jf.setVisible(true);
    }//GEN-LAST:event_jMenu37MouseClicked

    private void cashdiscountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashdiscountActionPerformed
        // TODO add your handling code here:

try{
  
         //   System.out.println("Deselected!");
      
 
if(cashdiscount.isSelected()){
    
    
    String subtotaldis1 = subtotal1.getText();
    int discounter;
    String discount2 = cashdisc.getText();
    
    int dis1 = Integer.parseInt(discount2);
    int subtt2 = Integer.parseInt(subtotaldis1);
    
    
    int finalamt1 = subtt2-dis1;
int gm1=finalamt1+dis1;
    gross=Integer.toString(gm1);
    int famt1 =(int) finalamt1;
    subtotal1.setText(String.valueOf(famt1));
}
        }
            catch(Exception e){
                             
            }




    }//GEN-LAST:event_cashdiscountActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_idActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        viewitem vw=new viewitem();
        vw.setVisible(true);


    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        category ct=new category();
        ct.setVisible(true);

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        this.setVisible(false);
        menuupdate mn=new menuupdate();
        mn.setVisible(true);

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        NewJFrame jf=new NewJFrame();
        jf.setVisible(true);

    }//GEN-LAST:event_jButton7ActionPerformed

    private void searchtblnumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchtblnumKeyReleased
        // TODO add your handling code here:
            
tblsearch();        
        
    }//GEN-LAST:event_searchtblnumKeyReleased

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        
                if (item.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Please Insert item");
            return;
        }
        
        
        if (price.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please insert price");
            return;
        }
        
        if (qty.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "please insert Quantity");
            return;
        }
        else{
        
        
        try {
        String value5 = id.getText();
        String value6 = item.getText();
        String value7 = price.getText();
        String value8 = qty.getText();
        String value9 = qtytotal.getText();
         String value10 = tablenum.getText();
         Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
        
        
      String querynews="update tempbill set id='"+value5+"', item='"+value6+"',price='"+value7+"',qty='"+value8+"',qtytotal='"+value9+"',tablenum='"+value10+"' where  id='"+value5+"'";
       PreparedStatement psnews = cn.prepareStatement(querynews);
            psnews.executeUpdate();
             
       
        }
        catch(Exception e){
            
        }

tblsearch();        
        
        qty.setText("");
        price.setText("");
                   tablenum.setText("");
                   qtytotal.setText("");
   
             id.setText("");
                   item.setText("");
   
        }        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:


        try{
             Class.forName("com.mysql.jdbc.Driver");
             cn=DriverManager.getConnection("jdbc:mysql://localhost/billing", "root", "lbef");
             String querydel="Delete from  tempbill where id=?";
             PreparedStatement psdel = cn.prepareStatement(querydel);
             psdel.setString(1,id.getText());
             psdel.execute();
            
        }
        catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        tblsearch();
        


qty.setText("");
        price.setText("");
                   tablenum.setText("");
                   qtytotal.setText("");
   
             id.setText("");
                   item.setText("");
   


    }//GEN-LAST:event_jButton9ActionPerformed

    private void cashdiscKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashdiscKeyReleased
        // TODO add your handling code here:



    }//GEN-LAST:event_cashdiscKeyReleased

    private void tablenumKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablenumKeyReleased
        // TODO add your handling code here:
gross=subtotal1.getText();


    }//GEN-LAST:event_tablenumKeyReleased

    private void cashdiscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cashdiscActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cashdiscActionPerformed

    private void searchtblnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchtblnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchtblnumActionPerformed
    
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
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        billing frame = new billing();
frame.setVisible(true);
frame.setSize(1400,800);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel billtablenum;
    private javax.swing.JButton calculate;
    private javax.swing.JTextField cashdisc;
    private javax.swing.JCheckBox cashdiscount;
    private javax.swing.JCheckBox checkbox;
    private javax.swing.JLabel date;
    private javax.swing.JTextField date1;
    private javax.swing.JTextField disamt;
    private javax.swing.JTextField disamt1;
    private javax.swing.JTextField discount;
    private javax.swing.JTextField id;
    private javax.swing.JTextField item;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu30;
    private javax.swing.JMenu jMenu37;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listtable;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.Menu menu4;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    private javax.swing.JButton ok;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private javax.swing.JTextField price;
    private javax.swing.JTextField qty;
    private javax.swing.JTextField qtytotal;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JTextField search2;
    private javax.swing.JTable searchtable;
    private javax.swing.JTable searchtable1;
    private javax.swing.JTable searchtablenew;
    private javax.swing.JTextField searchtblnum;
    private javax.swing.JTextField subtotal1;
    private javax.swing.JTextArea summary;
    private javax.swing.JTextField tablenum;
    private javax.swing.JTable tabletable;
    private java.awt.TextArea textArea1;
    // End of variables declaration//GEN-END:variables
}
