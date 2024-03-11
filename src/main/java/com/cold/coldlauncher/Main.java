package com.cold.coldlauncher;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        BigInteger highBitUUID = new BigInteger("4c34ae96f84641cca76500a0c91e6bf6",16);
        System.out.printf("%h\n",highBitUUID);
        BigInteger lowBitUUID = new BigInteger("a76500a0c91e6bf6",16);
        System.out.printf("%h\n",lowBitUUID);
        //BigInteger uuid=highBitUUID.shiftLeft(32).add(lowBitUUID);
        //System.out.printf("%h\n",uuid);
    }
}
