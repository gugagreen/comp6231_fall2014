package LibraryInterfacePackage;


/**
* LibraryInterfacePackage/resultHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from LibraryInterface.idl
* Wednesday, November 5, 2014 2:29:08 o'clock AM EST
*/

public final class resultHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public resultHolder ()
  {
  }

  public resultHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = LibraryInterfacePackage.resultHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    LibraryInterfacePackage.resultHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return LibraryInterfacePackage.resultHelper.type ();
  }

}