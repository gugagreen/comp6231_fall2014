package DRMSServices;


/**
* DRMSServices/nonReturners.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idl/LibraryInterface.idl
* Sunday, November 30, 2014 5:55:36 PM EST
*/

public final class nonReturners implements org.omg.CORBA.portable.IDLEntity
{
  public String universityName = null;
  public DRMSServices.lateStudent studentList[] = null;

  public nonReturners ()
  {
  } // ctor

  public nonReturners (String _universityName, DRMSServices.lateStudent[] _studentList)
  {
    universityName = _universityName;
    studentList = _studentList;
  } // ctor

} // class nonReturners
