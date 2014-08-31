package com.leleliu008.androidsdk.sign;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;

/**
 * 签名和验证
 * 
 * @author leleliu008
 *
 */
public final class SignVerify {

	private SignVerify() {}
	
	/**
	 * 获取自身Apk的签名
	 * @param context 上下文
	 * @return
	 */
	public static Signature[] getSignatures(Context context) {
		if (context == null) {
			return null;
		}
		PackageManager pm = context.getPackageManager();
		try {
			PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
			if (packageInfo != null) {
				return packageInfo.signatures;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取单个签名中的公钥
	 * @param signature 签名
	 * @return
	 */
	public static PublicKey getPublicKey(byte[] signature) {
		if (signature != null) {
			try {
				CertificateFactory factory = CertificateFactory.getInstance("X.509");
				X509Certificate certificate = (X509Certificate) factory.generateCertificate(new ByteArrayInputStream(signature));
				return certificate.getPublicKey();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * Android中获取Apk获签名证书中的公钥
	 */
	public static PublicKey[] getPublicKeys(Signature[] signatures) {
		PublicKey[] publicKeys = null;
		if (signatures != null && signatures.length > 0) {
			publicKeys = new PublicKey[signatures.length];
			for (int i = 0; i < signatures.length; i++) {
				publicKeys[i] = getPublicKey(signatures[i].toByteArray());
			}
		}
		return publicKeys;
	}
	
	public static PublicKey[] getInstalledAppPublicKeys(Context context) {
		return getPublicKeys(getSignatures(context));
	}
	
	/**
	 * 通用的获取证书中的公钥
	 */
	public static PublicKey[] getPublicKeys(Certificate[] certificates) {
		PublicKey[] publicKeys = null;
		if (certificates != null && certificates.length > 0) {
			publicKeys = new PublicKey[certificates.length];
			for (int i = 0; i < certificates.length; i++) {
				publicKeys[i] = certificates[i].getPublicKey();
			}
		}
		return publicKeys;
	}
	
	/**
	 * 获取签名了的zip格式文件的证书
	 * @param filePath zip格式的文件的路径
	 * @return
	 */
	public static Certificate[] getZipFileCertificates(String filePath) {
		byte[] buffer = new byte[8192];
		try {
			JarFile jarFile = new JarFile(filePath);
			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry entry = entries.nextElement();
				if (entry.isDirectory()) {
					continue;
				}
				String name = entry.getName();
                if (name.startsWith("META-INF/")) {
                    continue;
                }
                InputStream is = jarFile.getInputStream(entry);
                while (is.read(buffer, 0, buffer.length) != -1);
                is.close();
                Certificate[] certificates = entry.getCertificates();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 比较组公钥是否相同
	 * @param keys1
	 * @param keys2
	 * @return
	 */
	public boolean compare(PublicKey[] keys1, PublicKey[] keys2) {
		if (keys1 == null) {
			return false;
		}
		if (keys2 == null) {
			return false;
		}
		
		StringBuilder sb1 = new StringBuilder();
        for (PublicKey key : keys1) {
            sb1.append(key.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        for (PublicKey key : keys2) {
            sb2.append(key.toString());
        }
		return sb1.toString().equals(sb2.toString());
	}
}
