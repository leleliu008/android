package com.leleliu008.util;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * CPU信息工具类
 * 
 * @author 792793182@qq.com
 * 
 */
public final class CPUInfo {
	
	private static final String TAG = CPUInfo.class.getName();
	
	/** 正常的CPU频率 - 1.1G */
    public static final int NORMAL_FREQUENCE = 1100000;
    
    /** CPU的核心数 */
    private static int mCoreCount = 0;
    
    /** CPU的最大频率 */
    private static int mMaxFrequency = 0;
    
    /** CPU的最小频率 */
    private static int mMinFrequency = 0;
    
    private CPUInfo() { }

    /**
     * 获取当前手机的CPU平台
     * 注意：此方法存在于2.2以上，调用之前先要调用Environment.getOSVersionCode()进行判断
     */
    public static String getCPUPlatform() {
		return Build.HARDWARE;
	}
    
    public static int getCoreCount() {
    	if (mCoreCount == 0) {
    		try {
                File file = new File("/sys/devices/system/cpu/");
                mCoreCount = file.listFiles(new FileFilter() {
    				
    				@Override
    				public boolean accept(File pFile) {
    					return Pattern.matches("cpu[0-9]", pFile.getName());
    				}
    			}).length;
            } catch (Exception e) {
                Log.e(TAG, "getCoreCount()", e);
                mCoreCount = 1;
            }
		}
        return mCoreCount;
    }

    public static int getMaxFrequency() {
    	if (mMaxFrequency == 0) {
    		try {
                mMaxFrequency = str2int(readDeviceFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"));
            } catch (Exception e) {
            	Log.e(TAG, "getMaxFrequency()", e);
            }
		}
        return mMaxFrequency;
    }

    public static int getMinFrequency() {
    	if (mMinFrequency == 0) {
    		try {
                mMinFrequency = str2int(readDeviceFile("/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"));
            } catch (Exception e) {
            	Log.e(TAG, "getMinFrequency()", e);
            }
		}
        return mMinFrequency;
    }

    /**
     * 获取当前CPU占用率
     */
    public static long getUsage() {
    	long m_lTotal = 0L;
    	long m_lIdle = 0L;
    	long m_lUsage = 0L; 
        
    	try{
    		String s = readDeviceFile("/proc/stat");
            String as[] = s.split(" ");
            long l = Long.parseLong(as[2]);
            long l1 = Long.parseLong(as[3]);
            long l2 = l + l1;
            long l3 = Long.parseLong(as[4]);
            long l4 = l2 + l3;
            long l5 = Long.parseLong(as[6]);
            long l6 = l4 + l5;
            long l7 = Long.parseLong(as[7]);
            long l8 = l6 + l7;
            long l9 = Long.parseLong(as[8]);
            long l10 = l8 + l9;
            long l11 = Long.parseLong(as[5]);
            long l12 = m_lTotal;
            float f = (l10 - l12) * 100F;
            long l13 = m_lTotal;
            long l14 = (l10 - l13) + l11;
            long l15 = m_lIdle;
            float f1 = l14 - l15;
            long l16 = (long) (f / f1);
            m_lUsage = l16;
            m_lTotal = l10;
            m_lIdle = l11;
        } catch (Exception e){
        	Log.e(TAG, "getUsage()", e);
        }
        
        if (m_lUsage < 0L) {
            m_lUsage = 0L;
        }
        if (m_lUsage > 100L) {
            m_lUsage = 100L;
        }
        return m_lUsage;
    }
    
    private static int str2int(String str) throws Exception {
    	if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
            	Log.e(TAG, "str2int()", e);
            }
        }
        return 0;
    }
    
    private static String readDeviceFile(String filePath) {
    	if (TextUtils.isEmpty(filePath)) {
			return "";
		}
    	
    	BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            StringBuilder stringBuilder = new StringBuilder();
            String text = null;
            while ((text = br.readLine()) != null) {
                stringBuilder.append(text);
            }
            return stringBuilder.toString();
        } catch (Exception e) {
        	Log.e(TAG, "readDeviceFile()", e);
        } finally {
        	if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					Log.e(TAG, "readDeviceFile()", e);
				}
			}
        }
        return "";
    }

}
