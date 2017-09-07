/**
 * 
 */
package crypt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.IOUtils;

/**
 * 
 *
 * @author Michael Massarelli
 */
public class HashingUtils {
    public static final String TAG = "HashingUtils";

    public static String encrypt(String msg, HashAlgorithm alg) {
	byte[] bytes = null;
	switch (alg) {
	case MD2:
	    bytes = DigestUtils.md2(msg.getBytes());
	    break;
	case MD5:
	    bytes = DigestUtils.md5(msg.getBytes());
	    break;
	case SHA1:
	    bytes = DigestUtils.sha1(msg.getBytes());
	    break;
	case SHA256:
	    bytes = DigestUtils.sha256(msg.getBytes());
	    break;
	case SHA384:
	    bytes = DigestUtils.sha384(msg.getBytes());
	    break;
	case SHA512:
	    bytes = DigestUtils.sha512(msg.getBytes());
	    break;
	default:
	    bytes = DigestUtils.sha512(msg.getBytes());
	    break;
	}
	StringBuffer sb = new StringBuffer();
	for (int i = 0; i < bytes.length; i++) {
	    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
	}
	return sb.toString();
    }
    
    public static String generateMD5Checksum(File file) {
	InputStream in;
	try {
	    in = new FileInputStream(file);
	    byte[] bytes = DigestUtils.md5(IOUtils.toByteArray(in));
	    in.close();
	    StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
		    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static String generateSHA1Checksum(File file) {
	InputStream in;
	try {
	    in = new FileInputStream(file);
	    byte[] bytes = DigestUtils.sha1(IOUtils.toByteArray(in));
	    in.close();
	    StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
		    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static String generateSHA256Checksum(File file) {
	InputStream in;
	try {
	    in = new FileInputStream(file);
	    byte[] bytes = DigestUtils.sha256(IOUtils.toByteArray(in));
	    in.close();
	    StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
		    sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static void generateChecksums(File file) {
	File md5 = new File(file.getParentFile().getPath() + "\\" + file.getName().substring(0, file.getName().lastIndexOf('.')) + ".md5");
	File sha1 = new File(file.getParentFile().getPath() + "\\" + file.getName().substring(0, file.getName().lastIndexOf('.')) + ".sha1");
	try {
	    OutputStream out = new FileOutputStream(md5);
	    for (byte b : generateMD5Checksum(file).getBytes()) {
		out.write(b);
	    }
	    out.flush();
	    out.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	try {
	    OutputStream out = new FileOutputStream(sha1);
	    for (byte b : generateSHA1Checksum(file).getBytes()) {
		out.write(b);
	    }
	    out.flush();
	    out.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static String CRC32(String msg) {
	CRC32 x = new CRC32();
	x.update(msg.getBytes());
	return Long.toHexString(x.getValue());
    }

    public static String CRC32(File file) {
	CRC32 x = new CRC32();
	InputStream in;
	try {
	    in = new FileInputStream(file);
	    x.update(IOUtils.toByteArray(in));
	    in.close();
	    return Long.toHexString(x.getValue());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
    
    public static String CRC64(File file) {
	CRC64 x = new CRC64();
	InputStream in;
	try {
	    in = new FileInputStream(file);
	    x.update(IOUtils.toByteArray(in));
	    in.close();
	    return Long.toHexString(x.getValue());
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }


    enum HashAlgorithm {
	MD2, MD5,
	SHA1, SHA256, SHA384, SHA512;
    }

    public static void main(String[] args) {
	generateChecksums(new File("M:/to_add/copssh_5.4.21_x86.zip"));
	//System.out.println(f.getParentFile().getPath() + "\\" + f.getName().substring(0, f.getName().lastIndexOf('.')));
    }
}
