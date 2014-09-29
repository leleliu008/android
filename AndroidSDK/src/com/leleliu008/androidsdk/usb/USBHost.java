package com.leleliu008.androidsdk.usb;

import java.util.Map;

import android.content.Context;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.util.Log;

public class USBHost {

	public void xx(Context context) {
		UsbManager usbManager = (UsbManager) context.getSystemService(Context.USB_SERVICE);
		Map<String, UsbDevice> udbDevices = usbManager.getDeviceList();
		if (udbDevices != null) {
			for (String key : udbDevices.keySet()) {
				UsbDevice usbDevice = udbDevices.get(key);
				Log.d("USBHost", "DeviceId = " + usbDevice.getDeviceId());
				Log.d("USBHost", "DeviceClass = " + usbDevice.getDeviceClass());
				Log.d("USBHost", "DeviceName = " + usbDevice.getDeviceName());
				Log.d("USBHost", "DeviceProtocol = " + usbDevice.getDeviceProtocol());
				Log.d("USBHost", "DeviceSubclass = " + usbDevice.getDeviceSubclass());
				Log.d("USBHost", "InterfaceCount = " + usbDevice.getInterfaceCount());
				Log.d("USBHost", "ProductId = " + usbDevice.getProductId());
				Log.d("USBHost", "VendorId = " + usbDevice.getVendorId());
				
				if (usbDevice.getInterfaceCount() > 0) {
					UsbInterface usbInterface = usbDevice.getInterface(0);
					int endPointCount = usbInterface.getEndpointCount();
					if (endPointCount > 0) {
						UsbEndpoint usbEndpoint = usbInterface.getEndpoint(0);
					}
				}
			}
		}
	}
	
}
