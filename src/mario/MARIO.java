/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mario;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *
 * @author Mike
 */
public class MARIO extends JFrame implements Runnable {

    double count = 0;
    double count2 = 0;
    int pause = 1;
    int s, f;
    int imagecount = 0;
     int imagecount2 = 0;
    int zozo = 0;
    int zozo2 = 0;
    int right, left = 0;
       int right2, left2 = 0;
    int jumpvelocity = 40;
    int jumpvelocity2 = 0;
     int jumpvelocityy = 40;
       int jumpvelocity22 = 0;
    int jumpcount = 0;
     int jumpcount2 = 0;
    double bob;
        double bob2;
    int overlap = 0;
    String county = "" + count;
    private String operation;
    String message = "";
    String message1 = "";
    int x, y, w, z, life, ran, r, t,b,c;
    int a = 10;
    int speed;
    int time = 0;
    long initialtime;
    long currenttime;
    long timepassed;
    int points = 0;
    int q = 0;
    int player2=0;
    int grav = 0;
    int p = 0;
    int xDirection, yDirection, wdir, zdir, jumpdir;
    int xDirection2, yDirection2, wdir2, zdir2, jumpdir2;
    int xCord, yCord;
    int xCord2, yCord2;
    private Image dbImage;
    private Graphics dbg;
    private Image dbImage2;
    private Graphics dbg2;
    Image Ground, Sky, Pikachu, Pause, Pikachu2, Pikachu3, Pikachu4, block,Pikachuu, Pikachu22, Pikachu32, Pikachu42;
    Font font = new Font("Arial", Font.BOLD, 55);
    Font font2 = new Font("Arial", Font.BOLD, 90);
    Font font3 = new Font("Arial", Font.BOLD, 20);
    int i = 0;

    public MARIO() {

        ImageIcon i = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/pikachu2.gif");
        ImageIcon hurt = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/pikachu4.gif");
        ImageIcon ball = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/soccerball.gif");
        ImageIcon heart = new ImageIcon("C:/Users/Mike/Documents/NetBeansProjects/Gaming/src/gaming/heart.gif");

        addKeyListener(new MARIO.AL());
        addMouseListener(new MARIO.Mouse());
        setTitle("Java Game");
        setSize(1000, 630);
        setResizable(false);
        setVisible(true);
        //setBackground(Color.GREEN);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        x = 0;
        y = 510;
        xCord = 400;
        yCord = 400;
        w = 0;
        z = (int) (Math.random() * 100);
        life = 1000;
        r = 200;
        b = 300;
        t = y - 119;
        c = y-119;
        s = 1200;
        f = 400;

    }

    @Override
    public void run() {

        try {
            //life = Integer.parseInt(JOptionPane.showInputDialog(null,"LIFEPOINTS","ENTER THE AMOUNT OF LIFE POINTS",JOptionPane.INFORMATION_MESSAGE));
            initialtime = System.currentTimeMillis();

            while (true) {



               // blockoverlap();
                
                move();

                if (jumpcount == 1) {
                    count += .1;
                }
                if (jumpcount2 == 1) {
                    count2 += .1;
                }
                bob = Math.pow(count, 2);
                    bob2 = Math.pow(count2, 2);
                if (jumpcount == 1) {
                    t = 390 + ((int) ((4.9 * bob) - (jumpvelocity2 * count)));
                }
                if (jumpcount2 == 1) {
                    c = 390 + ((int) ((4.9 * bob2) - (jumpvelocity22 * count2)));
                }
                if (t > 390) {
                    t = 390;
                }
                if (c > 390) {
                    c = 390;
                }

                if (s <= -200) {
                    s = 1200;
                    f = ((int)(Math.random() * 200))+260;
                }
                if (w <= -240) {
                    w += 240;
                }
                if (x <= -403) {
                    x += 403;
                }


                if (t == y - 120) {
                    jumpcount = 0;
                }
                if (c == y - 120) {
                    jumpcount2 = 0;
                }
                if (jumpvelocity2 > 70) {
                    jumpvelocity2 = 70;
                }
                if (jumpvelocity22 > 70) {
                    jumpvelocity22 = 70;
                }
                while (p == 1) {
                    Thread.sleep(2);
                }
                if (xDirection > 0) {
                    if (zozo % 20 == 0) {
                        imagecount++;
                    }
                }
                if (xDirection2 > 0) {
                    if (zozo2 % 20 == 0) {
                        imagecount2++;
                    }
                }
                if (xDirection < 0) {
                    if (zozo % 20 == 0) {
                        imagecount++;
                    }
                    
                }
                if (xDirection2 < 0) {
                    if (zozo2 % 20 == 0) {
                        imagecount2++;
                    }
                    
                }
                zozo++;
                zozo++;
                if(time>0){time -=1;}
                //   if(r-(s-20)>=-4&&r-(s-20)<=4){if(t-(f-200)>=-10||t-(f-200)<=10){t=f-200;}}
                Thread.sleep(8);



            }
        } catch (Exception e) {
            System.out.print("error");
        }
    }

    public void move() {
        if(pause ==1){s-=1;
        x-=1;
        w-=1;
        r-=1;
         b-=1;
        }

        r += xDirection;
          b += xDirection2;
        t += yDirection;
         c += yDirection2;
        jumpvelocity2 += jumpdir;
        jumpvelocity22 += jumpdir2;
       // if (r-s>-45 && r-s<55 && t+80-f>-50 && t+80-f<40){t=y-220;}
      
        
         //if (r-s>-45 && r-s<55 && t+80-(f-100)>-50 && t+80-(f-100)<40){t=y-220;}
     
        
        if (t > y - 120) {
            t = y - 120;
        }
        if (c > y - 120) {
            c = y - 120;
        }
        if (r < 0) {
            r = 0;
        }
        if (b < 0) {
            b = 0;
        }
        if (r > 880) {
            r = 880;
        }
        if (b > 880) {
            b = 880;
        }
        if (r-s>-45 && r-s<-20 && t+80-f>-50 && t+80-f<40){r=s-45;}
        if (r-s>0 && r-s<55 && t+80-f>-50 && t+80-f<40){r=s+55;}
        
         if (r-s>-45 && r-s<-20 && t+80-(f-100)>-50 && t+80-(f-100)<40){r=s-45;}
        if (r-s>0 && r-s<55 && t+80-(f-100)>-50 && t+80-(f-100)<40){r=s+55;}
        
           if (b-s>-45 && b-s<-20 && c+80-f>-50 && c+80-f<40){b=s-45;}
        if (b-s>0 && b-s<55 && c+80-f>-50 && c+80-f<40){b=s+55;}
        
         if (b-s>-45 && b-s<-20 && c+80-(f-100)>-50 && c+80-(f-100)<40){b=s-45;}
        if (b-s>0 && b-s<55 && c+80-(f-100)>-50 && c+80-(f-100)<40){b=s+55;}
          //if (r-s>-45 && r-s<55 && t+80-f>-50 && t+80-f<40){t=f-130;}

    }

  //   public void blockoverlap (){
    // if(r-s>-45 && r-s<55 && t+80-f>-50 && t+80-f<40){overlap=1;}
    // else {overlap=0;}
   // }
     
    public void setXDirection(int xDir) {
        xDirection = xDir;
    }
    public void setXDirection2(int xDir) {
        xDirection2 = xDir;
    }

    public void setYDirection(int yDir) {
        yDirection = yDir;
    }
 public void setYDirection2(int yDir) {
        yDirection2 = yDir;
    }
    public void setWDirection(int wDir) {
        wdir = wDir;
    }

    public void setZDirection(int zDir) {
        zdir = zDir;
    }

    public void setJumpAmount(int jDir) {
        jumpdir = jDir;
    }
   public void setJumpAmount2(int jDir) {
        jumpdir2 = jDir;
    }
    public class AL extends KeyAdapter {

        public void keyPressed(KeyEvent e) {

            int keyCode = e.getKeyCode();

            if (keyCode == e.VK_LEFT) {

                setXDirection(-5);
                if (left == 0) {
                    left = 1;
                }
                if (right != 0) {
                    right = 0;
                }
            }

           
            
             if (keyCode == e.VK_A) {

                setXDirection2(-5);
                if (left2 == 0) {
                    left2 = 1;
                }
                if (right2 != 0) {
                    right2 = 0;
                }
            }
            
            if (keyCode == e.VK_RIGHT) {
                setXDirection(5);
                if (right == 0) {
                    right = 1;
                }
                if (left != 0) {
                    left = 0;
                }}

if (keyCode == e.VK_D) {
                setXDirection2(5);
                if (right2 == 0) {
                    right2 = 1;
                }
                if (left2 != 0) {
                    left2 = 0;
                }

            }

            
                if (keyCode == e.VK_ESCAPE) {
                if (p == 0) {
                    p = 1;
                    q = 0;
                } else {
                    p = 0;
                    q = 1;
                }


            }

    
   

            if (keyCode == e.VK_DOWN) {
                setYDirection(10);
            }


            if (keyCode == e.VK_CONTROL) {
                setYDirection(-10);
            }
            if (keyCode == e.VK_UP) {
                if (jumpcount == 0 && t == y - 120) {
                    jumpvelocity2 = jumpvelocity;
                    setJumpAmount(1);
                    count = 0;
                    bob = 0;
                    jumpcount++;
                }

            }
            
            if (keyCode == e.VK_W) {
                if (jumpcount2 == 0 && c == y - 120) {
                    jumpvelocity22 = jumpvelocityy;
                    setJumpAmount2(1);
                    count2 = 0;
                    bob2 = 0;
                    jumpcount2++;
                }

            }
            
                if (keyCode == e.VK_2) {
               if (pause == 0) {
                    pause = 1;
                   
                } else {
                   pause =0;
                }
            }

            if (keyCode == e.VK_1) {
               if (player2 == 0) {
                    player2 = 1;
                   
                } else {
                   player2 =0;
                }
            }
            if(player2==0){
                 if (keyCode == e.VK_SPACE) {
                  message = message + ' '; 
            }
                        if (keyCode == e.VK_U) {
                message = message + 'u';
            }
            if (keyCode == e.VK_G) {
                message = message + 'g';
            }

            if (keyCode == e.VK_A) {
                message = message + 'a';
              
            }
            if (keyCode == e.VK_B) {
                message = message + 'b';
            }
            if (keyCode == e.VK_C) {
                message = message + 'c';
            }
            if (keyCode == e.VK_D) {
                message = message + 'd';
            }
            if (keyCode == e.VK_E) {
                message = message + 'e';
            }
            if (keyCode == e.VK_F) {
                message = message + 'f';
            }
            if (keyCode == e.VK_H) {
                message = message + 'h';
            }
            if (keyCode == e.VK_Y) {
                message = message + 'y';
            }
            if (keyCode == e.VK_R) {
                message = message + 'r';
            }
            if (keyCode == e.VK_I) {
                message = message + 'i';
            }
            if (keyCode == e.VK_K) {
                message = message + 'k';
            }
            if (keyCode == e.VK_M) {
                message = message + 'm';
            }
            if (keyCode == e.VK_N) {
                message = message + 'n';
            }
            if (keyCode == e.VK_T) {
                message = message + 't';
            }
            if (keyCode == e.VK_W) {
                message = message + 'w';
            }
            if (keyCode == e.VK_Q) {
                message = message + 'q';
            }
            if (keyCode == e.VK_S) {
                message = message + 's';
            }
            if (keyCode == e.VK_J) {
                message = message + 'j';
            }
            if (keyCode == e.VK_L) {
                message = message + 'l';
            }
            if (keyCode == e.VK_Z) {
                message = message + 'z';
            }
            if (keyCode == e.VK_V) {
                message = message + 'v';
            }
            if (keyCode == e.VK_P) {
                message = message + 'p';
               
             
            }
            

            if (keyCode == e.VK_ENTER) {
                message1 = message;
                message = "";
                time += 400;
            }
            if (keyCode == e.VK_BACK_SPACE) {
                message = message.substring(0, (message.length() - 1));
            }


            if (keyCode == e.VK_O) {
                life += 100;
                message = message + 'o';
            }
        

            }}
        public void keyReleased(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if (keyCode == e.VK_LEFT) {

                setXDirection(0);

            }

            if (keyCode == e.VK_A) {

                setXDirection2(0);

            }
            
            if (keyCode == e.VK_RIGHT) {
                setXDirection(0);


            }
            
             if (keyCode == e.VK_D) {
                setXDirection2(0);


            }


            if (keyCode == e.VK_UP) {

                 setJumpAmount(0);
                jumpvelocity = 40;

            }
            
              if (keyCode == e.VK_W) {

                 setJumpAmount2(0);
                jumpvelocityy = 40;

            }
            

            if (keyCode == e.VK_DOWN) {
                setYDirection(0);
            }

            if (keyCode == e.VK_SPACE) {
                setJumpAmount(0);
                jumpvelocity = 40;

            }



        }
    }

    public class Mouse extends MouseAdapter {

        public void mousePressed(MouseEvent e) {
            xCord = e.getX();
            yCord = e.getY();

        }

        public void mouseReleased(MouseEvent e) {
        }
    }

    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbg = dbImage.getGraphics();
        paintComponent(dbg);

        g.drawImage(dbImage, 0, 0, this);

    }

    public void paintComponent(Graphics g) {


        
        Ground = createImage("/mario/marioground.gif");
        Sky = createImage("/mario/mariosky.gif");
        
        Pikachu = createImage("/mario/pikaright2.gif");
        
        Pikachu2 = createImage("/mario/pikaright1.gif");
        Pikachu3 = createImage("/mario/pikaleft1.gif");
        
        Pikachu4 = createImage("/mario/pikaleft2.gif");
        
        /*this for 2nd pikachu*/
        Pikachuu = createImage("/mario/pikaright2.gif");
        
        Pikachu22 = createImage("/mario/pikaright1.gif");
        Pikachu32 = createImage("/mario/pikaleft1.gif");
        
        Pikachu42 = createImage("/mario/pikaleft2.gif");

        Pause = createImage("/mario/paused.gif");
        
        block = createImage("/mario/block.gif");
       
        g.drawImage(Ground, x, y, this);
        g.drawImage(Ground, x + 403, y, this);
        g.drawImage(Ground, x + 806, y, this);
        g.drawImage(Ground, x + 1209, y, this);
        g.drawImage(Ground, x + 1612, y, this);
        g.drawImage(Sky, w, 0, this);
        g.drawImage(Sky, w + 240, 0, this);
        g.drawImage(Sky, w + 480, 0, this);
        g.drawImage(Sky, w + 720, 0, this);
        g.drawImage(Sky, w + 960, 0, this);
        g.drawImage(Sky, w + 1200, 0, this);
        g.drawImage(Sky, w - 120, 240, this);
        g.drawImage(Sky, w + 240 - 120, 240, this);
        g.drawImage(Sky, w + 480 - 120, 240, this);
        g.drawImage(Sky, w + 720 - 120, 240, this);
        g.drawImage(Sky, w + 960 - 120, 240, this);
        g.drawImage(Sky, w + 1200 - 120, 240, this);

        g.drawImage(block, s, f, this);
        g.drawImage(block, s, f-100, this);
        
        if (xDirection > 0) {
            if (imagecount % 2 == 0) {
                g.drawImage(Pikachu, r, t + 80, this);
            } else {
                g.drawImage(Pikachu2, r, t + 80, this);
            }
        }
        
        
        if (xDirection < 0) {
            if (imagecount % 2 == 0) {
                g.drawImage(Pikachu3, r, t + 80, this);
            } else {
                g.drawImage(Pikachu4, r, t + 80, this);
            }
        }
        
      
        
        if (xDirection == 0) {
            if (left == 1) {
                g.drawImage(Pikachu3, r, t + 80, this);
            } else {
                g.drawImage(Pikachu2, r, t + 80, this);
            }
        }
        if(player2==1){       
        if (xDirection2 > 0) {
            if (imagecount2 % 2 == 0) {
                g.drawImage(Pikachuu, b, c + 80, this);
            } else {
                g.drawImage(Pikachu22, b, c + 80, this);
            }
        }
  if (xDirection2 < 0) {
            if (imagecount2 % 2 == 0) {
                g.drawImage(Pikachu32, b, c + 80, this);
            } else {
                g.drawImage(Pikachu42, b, c + 80, this);
            }
        }
         if (xDirection2 == 0) {
            if (left2 == 1) {
                g.drawImage(Pikachu32, b, c + 80, this);
            } else {
                g.drawImage(Pikachu22, b, c + 80, this);
            }
        }}
        
        g.setColor(Color.BLACK);
       // g.drawString(count + " " + jumpvelocity, 200, 200);
       // g.drawString(overlap + "", 400, 400);
     
         //g.drawString("r-s is"+ (r-s) + "t+80-f is" + (t+80-f) + "random shit" + (int)(Math.random() * 600), 400, 500);
       
if(time>1){g.drawString(message1, r+5, t+60);}
 g.setColor(Color.RED);
g.fillRect(295, 535, 510, 60);
 g.setColor(Color.WHITE);
g.fillRect(300, 540, 500, 50);
 g.setColor(Color.BLUE);
g.drawString(message, 320, 565);
 g.setColor(Color.RED);
g.fillRect(85, 535, 150, 60); 
g.setColor(Color.WHITE);
 
g.fillRect(90, 540, 140, 50);
 g.setColor(Color.BLACK);
        g.drawString("ESCAPE FOR PAUSE", 100, 560);
            if(player2==0){ g.drawString("KEY 1 FOR 2 PLAYER", 100, 580);}
            else{g.drawString("KEY 1 TO REMOVE P2", 100, 580);}
        if (p == 1) {
            g.drawImage(Pause, 0, 300, this);
        }

        repaint();

    }

    public static void main(String[] args) {
        //new JavaGame();


        //(Operate("hi")).start();

        MARIO m = new MARIO();
        Thread t = new Thread(m);
        t.start();;
        //Operate.O("moveSky").start();

    }
    
    protected Image createImage(String path)

{

    java.net.URL imgURL = getClass().getResource(path);

    if (imgURL != null) 
    {

       return new ImageIcon(imgURL).getImage();

    } 
    
    else 
    {

       System.err.println("Couldn't find file: " + path);

       return null;

    }

}
}