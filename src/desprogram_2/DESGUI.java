
package desprogram_2;

import java.awt.*;
import static java.awt.Font.BOLD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DESGUI extends JFrame{
   private  JButton encrypt,decrypt;
   private  JLabel  label1,label2;
   private Container c;
   private String key;
   private JTextField txt;
   private JButton openencrypt;
   private JButton openoriginalfile;
   private String path;
   private File f;
   public DESGUI(){
       
       this.setSize(500, 400);
       c=new Container();
       this.setContentPane(c);
       encrypt=new JButton("Encypt");
       decrypt=new JButton("Decrypt");
       openencrypt=new JButton(" open encrypted file");
       openencrypt.setBounds(150, 210, 200, 30);
       openoriginalfile=new JButton(" open decrypted file ");
       openoriginalfile.setBounds(150, 255, 200, 30);
       label1=new JLabel("");
       label2=new JLabel("");
       txt=new JTextField();
       encrypt.setBounds(200, 120, 100, 30);
       decrypt.setBounds(200, 165, 100, 30);
       txt.setBounds(150, 60, 200, 30);
       label1.setBounds(150, 30, 200, 30);
       label1.setText("Enter the key:");
       c.add(encrypt);
       c.add(label1);
       c.add(decrypt);
       c.add(label2);
       c.add(txt);
       c.add(openencrypt);
       c.add(openoriginalfile);
        
       encrypt.addActionListener(new ActionListener(){

            @Override
        public void actionPerformed(ActionEvent e) {
         try{

         key=txt.getText();
        // System.out.print(key);
        JFileChooser fc=new JFileChooser();


        fc.showOpenDialog(null);


         path=fc.getSelectedFile().getAbsolutePath();


       // label1.setText(path);


         f=fc.getSelectedFile();


        FileInputStream fis=new FileInputStream(f);


        FileOutputStream fos=new FileOutputStream("encrypted.txt");


        Thread.sleep(2000);
       
        DESAlgo.encrypt(key, fis, fos);

        //label2.setText("encrypted.txt");


        } catch(Exception e2)


        {


            System.out.print("Exception in Encyption");


        }



                
            }

          });
       decrypt.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{


      /* JFileChooser fc=new JFileChooser();


      //  fc.setCurrentDirectory(new File());


        fc.showOpenDialog(null);


         path=fc.getSelectedFile().getAbsolutePath();


        //label1.setText(path);


        File f=fc.getSelectedFile();*/
      
        


        FileInputStream fis=new FileInputStream("encrypted.txt");


        FileOutputStream fos=new FileOutputStream("decrypted.txt");


        DESAlgo.decrypt(key, fis, fos);


        Thread.sleep(2000);


        //label2.setText("C:\\Users\\raks\\Documents\\NetBeansProjects\\DESEncryption\\decrypted.txt");


        }catch(Exception e2)


        {


            System.out.print("Exception in Decryption");


        }

            }

          });
       openencrypt.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               Runtime runtime=Runtime.getRuntime();


        try {


            runtime.exec("explorer.exe encrypted.txt");


        } catch (IOException ex) {


            Logger.getLogger(DESAlgo.class.getName()).log(Level.SEVERE, null, ex);     


       }


           }
       });
       openoriginalfile.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent e) {
               Runtime runtime=Runtime.getRuntime();


        try {


            runtime.exec("explorer.exe decrypted.txt");


        } catch (IOException ex) {


            Logger.getLogger(DESAlgo.class.getName()).log(Level.SEVERE, null, ex);     


       }


           }
       });
     }
    
}
