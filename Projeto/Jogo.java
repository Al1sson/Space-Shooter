/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


/**
 *
 * @author EU
 */
public class Jogo
        implements GLEventListener, INave, KeyListener {
    
    GLU glu = new GLU();
    GLUT glut = new GLUT();
    
     public static void main(String args[])
    {
        new Jogo();
    }
     
     private double g;
     private double g1;
     private double g2;
     private double incG=0.2;
     private boolean left;
     private boolean right;
     private boolean tiro;
     
     public Jogo()
    {
        GLJPanel canvas = new GLJPanel();
        canvas.addGLEventListener(this);
        
        JFrame frame = new JFrame("Space Shooter");
        frame.setSize(600,600);
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        frame.addKeyListener(this);
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                new Thread(new Runnable () {
                    public void run(){
                        System.exit(0);
                    }
                }).start();
            }
        });
    }
    
       @Override
    public void init(GLAutoDrawable glAuto) {
        Animator a = new Animator(glAuto);
        a.start();
        GL gl = glAuto.getGL();
        gl.glClearColor(0, 0, 0, 0);
        gl.glEnable(GL.GL_DEPTH_TEST);
    }
    
       @Override
    public void display(GLAutoDrawable glAuto) {

        GL2 gl = glAuto.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT |
                   GL.GL_DEPTH_BUFFER_BIT
        );
        
        
        gl.glLoadIdentity();
        gl.glTranslated(0,-2.5,-8);
        
        g1=g1+incG;
        
        
       desenhar(gl); 
      desenhar_plano(gl);
       if(right && g <= 2)
           g = g + incG;
       else
           if(left && g >= -2)
               g = g - incG;
    }
    
    
    
    
    public void reshape(GLAutoDrawable gLAutoDrawable, int x, int y, int w, int h) {
  
        GL2 gl = gLAutoDrawable.getGL().getGL2(); 
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(60,1,1,300);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glTranslated(0,0,-10);
    }
    
    
   public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
      
    }

    public void dispose(GLAutoDrawable glad) {

    }

    @Override
    public void desenhar(GL2 gl) {
       gl.glPushMatrix();
       gl.glColor3f(1, 1, 1);
       gl.glTranslated(g, 0.5, 0);
            gl.glScaled(2,0.75,2);
            glut.glutWireCube(1);
      gl.glPopMatrix();
      gl.glPushMatrix();
      gl.glTranslated(g, 0.5, 0);
            gl.glScaled(0.5,0.5,0.5);
            gl.glColor3f(0, 0, 1);
            glut.glutWireCube(1);
      gl.glPopMatrix();
    }
    
    public void desenhar_plano(GL2 gl){
        gl.glPushMatrix();
        gl.glColor3f(1, 1, 1);
        gl.glScaled(7,0,70);
        glut.glutWireCube(1);
        gl.glPopMatrix();
        
        gl.glPushMatrix();
        gl.glTranslated(0, 8, 0);
        gl.glColor3f(1, 1, 1);
        gl.glScaled(7,0,50);
        glut.glutWireCube(1);
        gl.glPopMatrix();
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
            
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            tiro = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = false;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            right = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            tiro = false;
    }
    
    }
    
}
