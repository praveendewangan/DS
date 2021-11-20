import java.util.*;

public class _35MinJumpWithPlusIMinusIJump {
  // ~~~~~~~~~~~~User Section~~~~~~~~~~~
  public static int minJumps(int target) {
    target = Math.abs(target);
    int jump = 1;
    int s = 0;
    while(s < target) {
        s += jump;
        jump++;
    }
    
    if((s - target) % 2 == 0) {
        return jump-1;
    } else if((s + jump - target) % 2 == 0) {
        return jump;
    } else {
        return jump + 1;
    }
}

  public static int minJumps1(int target) {
    target = Math.abs(target);
    int jump = 0;
    int s = 0;
    while(s < target) {
        jump++;
        s += jump;
    }
    
    if(s == target) {
        return jump;
    } else if((s - target) % 2 == 0) {
        return jump;
    } else if((s + jump + 1 - target) % 2 == 0) {
        return jump + 1;
    } else {
        return jump + 2;
    }
  }

  //~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();

    int jumps = minJumps(x);
    System.out.println(jumps);
  }
}