package DRMSServices;

/**
* DRMSServices/nonReturnersHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idl/LibraryInterface.idl
* Sunday, November 30, 2014 5:55:36 PM EST
*/

public final class nonReturnersHolder implements org.omg.CORBA.portable.Streamable
{
  public DRMSServices.nonReturners value = null;

  public nonReturnersHolder ()
  {
  }

  public nonReturnersHolder (DRMSServices.nonReturners initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DRMSServices.nonReturnersHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DRMSServices.nonReturnersHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DRMSServices.nonReturnersHelper.type ();
  }

}
