/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /media/leleliu008/D/快盘/计算机/编程/Workspaces/AndroidSDK/src/com/leleliu008/androidsdk/service/AIDL.aidl
 */
package com.leleliu008.androidsdk.service;
public interface AIDL extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.leleliu008.androidsdk.service.AIDL
{
private static final java.lang.String DESCRIPTOR = "com.leleliu008.androidsdk.service.AIDL";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.leleliu008.androidsdk.service.AIDL interface,
 * generating a proxy if needed.
 */
public static com.leleliu008.androidsdk.service.AIDL asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.leleliu008.androidsdk.service.AIDL))) {
return ((com.leleliu008.androidsdk.service.AIDL)iin);
}
return new com.leleliu008.androidsdk.service.AIDL.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_a:
{
data.enforceInterface(DESCRIPTOR);
this.a();
reply.writeNoException();
return true;
}
case TRANSACTION_b:
{
data.enforceInterface(DESCRIPTOR);
this.b();
reply.writeNoException();
return true;
}
case TRANSACTION_c:
{
data.enforceInterface(DESCRIPTOR);
this.c();
reply.writeNoException();
return true;
}
case TRANSACTION_d:
{
data.enforceInterface(DESCRIPTOR);
this.d();
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.leleliu008.androidsdk.service.AIDL
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
@Override public void a() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_a, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void b() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_b, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void c() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_c, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
@Override public void d() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_d, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_a = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_b = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_c = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_d = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
}
public void a() throws android.os.RemoteException;
public void b() throws android.os.RemoteException;
public void c() throws android.os.RemoteException;
public void d() throws android.os.RemoteException;
}
