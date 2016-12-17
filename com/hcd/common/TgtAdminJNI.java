package com.hcd.common;
public class TgtAdminJNI {
    native int execute(String[] argvs, byte[] bufin); /* (1) */
    static {
        System.load("/home/ceph/chaoqun/Workspace/tgtjni/libtgtadmjni.so"); /* (2) */
    }
    static public void main(String argv[]) {
        TgtAdminJNI tgtAdmin = new TgtAdminJNI();

        int buflen = 1024 * 1024; // 1M bytes

        String[] argvs = {"jcall", "-V"};
        byte[] bufin = new byte[buflen];
        tgtAdmin.execute(argvs, bufin); /* (3) */
        System.out.println("hello");
        String bufstr = new String(bufin);
        System.out.println("world " + bufstr);
    }
}
