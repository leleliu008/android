package com.leleliu008.test.util;

import com.leleliu008.util.CPUInfo;

import android.test.AndroidTestCase;
import android.util.Log;

public class CPUInfoTest extends AndroidTestCase {

	public void testCPUInfo() throws Exception {
		String cpuName = CPUInfo.getCPUPlatform();
		int count = CPUInfo.getCoreCount();
		int maxFreq = CPUInfo.getMaxFrequency();
		int minFreq = CPUInfo.getMinFrequency();
		long usage = CPUInfo.getUsage();
		
		Log.i("CPUInfo", "cpuName = " + cpuName);
		Log.i("CPUInfo", "count = " + count);
		Log.i("CPUInfo", "maxFreq = " + maxFreq);
		Log.i("CPUInfo", "minFreq = " + minFreq);
		Log.i("CPUInfo", "usage = " + usage);
		
		assertEquals(true, cpuName != null);
		assertEquals(true, count != 0);
		assertEquals(true, maxFreq != 0);
		assertEquals(true, minFreq != 0);
		assertEquals(true, usage != 0);
	}
}
