package com.cold.coldlauncher.infrastructure;

public class TesterPlyer {
    public static void main(String[] args) {
        Player player = new Player();
        System.out.println(player.validateName("test"));//true
        System.out.println(player.validateName("#badname"));//false
        System.out.println(player.validateName("test#test"));//false
        System.out.println(player.validateName("_test"));//true
        System.out.println(player.validateName("t1_e2_s3_T"));//true
        System.out.println(player.validateUUID("1234567890"));//true
        System.out.println(player.validateUUID("530fa97a357f3c1994d30c5c65c18fe8"));//true
        System.out.println(player.validateUUID("530fa97a-357f-3c19-94d3-0c5c65c18fe8"));//true
        System.out.println(player.validateUUID("530fa97a357f3c1994d30c5c65c18fe81"));//false
        System.out.println(player.validateUUID("bad_uuid"));//false
        System.out.println(player.validateUUID(""));//false
        System.out.println(player.validateUUID("1"));//true
        System.out.println(player.removeChar("123-456-789-0",'-'));//1234567890
    }
}
