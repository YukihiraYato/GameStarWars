
import java.awt.HeadlessException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;


public class starWarsProject extends JFrame {

    final static int ARow = 5,ACol = 0, BRow = 0,BCol = 4,CRow = 0,CCol = 12,DRow = 5,DCol = 13,ERow = 10,ECol = 4;

    public starWarsProject(String title) throws HeadlessException {
        super(title);

    }

    public static ArrayList<Character> chr = new ArrayList<Character>();

//   chr sẽ lưu lại các nhân vật trong game
//   vị trí cuối cùng của danh sách chr sẽ lưu nhân vật mà người sẽ chọn
   
    public ArrayList<Character> getCharacters() {
        return starWarsProject.chr;
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        File harita = new File("harita.txt");
        int row = 0, i, j = 0;
        byte stormtrooperNum = 0, darthVaderNum = 0, kyloRenNum = 0;
        int[][] map = new int[11][14];
        String[] output = null;

        if (!harita.exists()) {
            System.out.println(harita.getName() + " Không tìm thấy tập tin.");
            System.exit(0);
        }

        BufferedReader reader = null;
    
        FileReader forMap = null;

        try {
            reader = new BufferedReader(new FileReader(harita));
            forMap = new FileReader("harita.txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(starWarsProject.class.getName()).log(Level.SEVERE, null, ex);
        }

        String line = reader.readLine();/*biến line sẽ lưu lại chuỗi trên mỗi dòng*/

        while (!(line.startsWith("0") || line.startsWith("1"))) {
// trong vòng lặp này sẽ lấy 3 dòng đầu trong file harita.txt
// để lấy thông tin 3 kẻ địch kèm vị trí bắt đầu của 3 kẻ địch ở cửa nào
// để vẽ lên trên mê cung giao diện đồ họa game
// sau khi lấy xong 3 dòng đầu trong harita.txt, vòng lặp sẽ kết thúc

            if (line.length() > 0) {
                row++;
                output = line.split("[,:]");
                System.out.println(output[1]);/*tên nhân vật*/
                System.out.println(output[3]);/*vị trí cửa của kẻ địch */

                if (output[1].equalsIgnoreCase("stormtrooper")) {
                    if (output[3].equalsIgnoreCase("a")) {
                        chr.add(new Stormtrooper("Stormtrooper" + stormtrooperNum, "kotu", ARow, ACol,ARow, ACol));
                        stormtrooperNum++;
                    } else if (output[3].equalsIgnoreCase("b")) {
                        chr.add(new Stormtrooper("Stormtrooper" + stormtrooperNum, "kotu", BRow, BCol, BRow, BCol));
                        stormtrooperNum++;
                    } else if (output[3].equalsIgnoreCase("c")) {
                        chr.add(new Stormtrooper("Stormtrooper" + stormtrooperNum, "kotu", CRow, CCol, CRow, CCol));
                       
                        stormtrooperNum++;
                        
                    } else if (output[3].equalsIgnoreCase("d")) {
                        chr.add(new Stormtrooper("Stormtrooper" + stormtrooperNum, "kotu", DRow, DCol,DRow, DCol));
                        stormtrooperNum++;
                    } else if (output[3].equalsIgnoreCase("e")) {
                        chr.add(new Stormtrooper("Stormtrooper" + stormtrooperNum, "kotu", ERow, ECol,ERow, ECol));
                        stormtrooperNum++;
                    }

                } else if (output[1].equalsIgnoreCase("darth vader")) {
                      darthVaderNum++;
                    if (output[3].equalsIgnoreCase("a")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", ARow, ACol, ARow, ACol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("b")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", BRow, BCol, BRow, BCol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("c")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", CRow, CCol,CRow, CCol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("d")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", DRow, DCol,DRow, DCol));
                        darthVaderNum++;
                    } else if (output[3].equalsIgnoreCase("e")) {
                        chr.add(new DarthVader("DarthVader" + darthVaderNum, "kotu", ERow, ECol, ERow, ECol));
                        darthVaderNum++;
                    }

                } else if (output[1].equalsIgnoreCase("kylo ren")) {
                  if (output[3].equalsIgnoreCase("a")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", ARow, ACol, ARow, ACol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("b")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", BRow, BCol, BRow, BCol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("c")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", CRow, CCol, CRow, CCol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("d")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", DRow, DCol,DRow, DCol));
                        kyloRenNum++;
                    } else if (output[3].equalsIgnoreCase("e")) {
                        chr.add(new KyloRen("KyloRen" + kyloRenNum, "kotu", ERow, ECol,ERow, ECol));
                        kyloRenNum++;
                    }
                }
            }
            line = reader.readLine();
        }

        try {
// biến say sẽ đếm số kí tự trên mỗi dòng, bắt đầu từ dòng thứ 4 của harita.txt
// biến value sẽ nhận mỗi kí tự từ harita.txt bắt đầu từ dòng thứ 4
            int value, say = 1;
           
            i = 0;
            while ((value = forMap.read()) != -1) {
                /*Vòng lặp while sẽ kết thúc khi hàm read ko còn tìm thấy kí tự từ forMap*/

            	
            	
//            	Nếu value bằng kí tự 0 hoặc 1 sẽ 1 trong 2 giá trị này cho biến map
                if (value == '0' || value == '1') {
                    //System.out.print((char)value+"\t"); SILINECEK
                    if (value == 48) /*Mã ASCII của 0 là 48*/ {
                        map[i][j] = 0;
                        
                    } else {
                        map[i][j] = 1;
                    }

                    say++;
                  
                    j++;
// Khi say =15 sẽ chuyển tiếp dòng tiếp theo để tiếp tục lấy giá trị gán cho biến map
                    if (say == 15) {
                        say = 1;
                        j = 0;
                        
                        i++;
                       
                    }
                }

            }
        } finally {
            forMap.close();
           
        }

        /*Sysout ra biến map*/
        for (i = 0; i < 11; i++) {
            for (j = 0; j < 14; j++) {
                System.out.print(map[i][j] + "\t");
            }
            System.out.println();
        }


      
       

        System.out.println("Chọn M để sử dụng nhân vật MasterYoda. Chọn S để sử dụng nhân vật LukeSkywalker");
        System.out.println("Lựa chọn của bạn là:");
        String gamerchr = input.nextLine();

        if (gamerchr.equalsIgnoreCase("m")) {
            chr.add(new MasterYoda("MasterYoda", "Iyi", 6,5,6,5,6));

        } else if (gamerchr.equalsIgnoreCase("s")) {
            chr.add(new LukeSkywalker("LukeSkywalker", "Iyi", 3,5,6,5,6));
        } else {
            while (!(gamerchr.equalsIgnoreCase("m") || gamerchr.equalsIgnoreCase("s"))) {
                System.out.println("Làm ơn hãy bấm S hoặc M");
                gamerchr = input.nextLine();
                if (gamerchr.equalsIgnoreCase("m")) {
                    chr.add(new MasterYoda("MasterYoda", "Iyi", 6,5,6,5,6));
                } else if (gamerchr.equalsIgnoreCase("s")) {
                    chr.add(new LukeSkywalker("LukeSkywalker", "Iyi", 3,5,6,5,6));
                }
            }

        }

        Graphic graphic = new Graphic();
      
        graphic.grphcChr = chr;
       
        graphic.grphcMap = map;
        

        starWarsProject screen = new starWarsProject("Star Wars");
        screen.setSize(700, 700);
        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       
        graphic.requestFocus();
        
        graphic.addKeyListener(graphic);
               graphic.setFocusable(true);
       
        graphic.setFocusTraversalKeysEnabled(false);
        

      
        screen.add(graphic);
        screen.setVisible(true);
      
        screen.setResizable(true);
      

        graphic.choosenCharacter = gamerchr;
//       Vòng lặp này sẽ cho 3 kẻ thù tìm đến vị trí người chơi ngắn nhất bằng thuật toán thuật toán Lee dựa trên BFS
        for(i=0;i<chr.size()-1;i++)
        {
        	chr.get(i).shortestPath(map, chr.get(i).location.getMatrixRow(),chr.get(i).location.getMatrixCol(), chr.get(chr.size() - 1).getLocation().matrixRow, chr.get(chr.size() - 1).getLocation().matrixCol);
        }
    }
}
