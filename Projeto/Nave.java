/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Projeto;

import com.jogamp.opengl.util.gl2.GLUT;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GL2;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author EU
 */
public class Nave  implements KeyListener {
    
    GLUT glut = new GLUT();
    private double g;
    private double incG=0.2;
    private boolean tiro;
    private boolean left;
    private boolean right;

    
    public void desenhar_nave(GL2 gl) {
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
      
      gl.glPushMatrix();
      gl.glTranslated(g, 0.5, 0);
            gl.glScaled(0.25,0.25,0.25);
            gl.glColor3f(1, 0, 1);
            glut.glutWireCube(1);
      gl.glPopMatrix();
            
    }
    
    public void mover_nave(){
        
        if(right  && g <= 2)
           g = g + incG;
       else
           if(left && g >= -2)
               g = g - incG;
    }
    
    
     @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            left = true;
            System.out.println("entrou");
            
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
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            tiro=true;
        }
    
    }
    
    
}