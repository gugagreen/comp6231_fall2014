package DRMSServices;

/**
* DRMSServices/lateStudentHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idl/LibraryInterface.idl
* Sunday, November 30, 2014 5:55:36 PM EST
*/

public final class lateStudentHolder implements org.omg.CORBA.portable.Streamable
{
  public DRMSServices.lateStudent value = null;

  public lateStudentHolder ()
  {
  }

  public lateStudentHolder (DRMSServices.lateStudent initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = DRMSServices.lateStudentHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    DRMSServices.lateStudentHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return DRMSServices.lateStudentHelper.type ();
  }

}
