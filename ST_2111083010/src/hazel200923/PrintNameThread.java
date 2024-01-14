package hazel200923;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author FA506IC
 */
class PrintNameThread extends Thread {
    PrintNameThread(String name) {
        super(name);
        // menjalankan thread dengan satu kali instantiate
        start();
    }

    public void run() {
        String name = getName();
        for (int i = 0; i < 100; i++) {
            System.out.print(name);
        }
    }
}
