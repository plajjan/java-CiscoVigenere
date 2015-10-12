package net.spritelink;

import java.util.Random;

/*
 * This thing will encrypt and decrypt Cisco 
 */
public class CiscoVigenere {
	// Cisco super secret key
	private final static String ikey = "dsfd;kfoA,.iyewrkldJKDHSUBsgvca69834ncxv9873254k;fg87";

    public static void main(String[] args) {
        String ori = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String enc = encrypt(ori);
        System.out.println(enc);
        System.out.println(decrypt(enc));
    }
 
    static String encrypt(String m) {
		Random rand = new Random();
		return encrypt(m, rand.nextInt(15));
	}

    static String encrypt(String m, int init) {
		// rearrange translation table according to initial index
		String key = ikey.substring(init, ikey.length()) + ikey.substring(0, init);
        String res = String.format("%02d", init);
        for (int i = 0; i < m.length(); i++) {
            res += String.format("%02X", m.charAt(i) ^ key.charAt(i % key.length()));
        }
        return res;
    }
 
    static String decrypt(String m) {
		// extract initial index from first two characters
		int init = Integer.parseInt(m.substring(0, 2));
		// rearrange translation table according to initial index
		String key = ikey.substring(init-1, ikey.length()) + ikey.substring(0, init-1);
        String res = "";
        for (int i = 1; i*2 < m.length(); i++) {
			int c = Integer.parseInt(m.substring(i*2, i*2+2), 16);
            res += (char)(c^key.charAt(i % key.length()));
        }
        return res;
    }
}
