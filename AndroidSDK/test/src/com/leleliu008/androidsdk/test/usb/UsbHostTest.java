package com.leleliu008.androidsdk.test.usb;

import android.test.AndroidTestCase;

import com.leleliu008.androidsdk.usb.USBHost;

public class UsbHostTest extends AndroidTestCase {

	public void testUsbHost() throws Exception {
		new USBHost().xx(getContext());
	}
}
