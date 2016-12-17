package com.hcd.common;
public class TgtAdminJNI {
    native int execute(String[] argvs, byte[] bufin); /* (1) */
    static {
        System.load("/home/ceph/chaoqun/Workspace/tgtjni/libtgtadmjni.so"); /* (2) */
    }
    void helloworld() {}
    static public void main(String argv[]) {
        TgtAdminJNI tgtAdmin = new TgtAdminJNI();
        
		String[] argvs = {"jcall", "-h", "-V"};
        int buflen = 1024 * 1024; // 1M bytes
		byte[] bufin = new byte[buflen];

		tgtAdmin.execute(argvs, bufin); /* (3) */
		System.out.println("hello1");
		String bufstr = new String(bufin);
      System.out.println("world1 " + bufstr);

        String[] argvs2 = {"jcall", "-V"};
        byte[] bufin2 = new byte[buflen];
        tgtAdmin.execute(argvs2, bufin2); /* (3) */
        System.out.println("hello2");
        String bufstr2 = new String(bufin2);
        System.out.println("world2 " + bufstr2);

    }
}
